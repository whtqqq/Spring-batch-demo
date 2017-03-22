/**
 *       更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.batch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.integration.ftp.session.DefaultFtpSessionFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ＦＴＰで作成した出荷予定ファイルの転送処理、リネーム処理を行う。
 *
 */
public class FVQ_FileProcessor implements Tasklet {

    private static Logger logger = LoggerFactory.getLogger(FVQ_FileProcessor.class);
    /** 出荷予定データ_グローボル共有ファイル名 */
    private String globalFileName;
    /** 出荷予定データ_日本独立ファイル名 */
    private String japanFileName;

    private MessageChannel ftpChannel;
    private DefaultFtpSessionFactory ftpSessionFactory;
    private int ftpRetryTimes;
    private List<String> subsidiaryMcCdL = new ArrayList<String>();
    private boolean errFlg = false;

    private static final int PORT_DEFAULT = 21;
    private static final int CLIENT_MODE_DEFAULT = 0;

    @Override
    @SuppressWarnings("unchecked")
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {

        StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();
        JobExecution jobExecution = stepExecution.getJobExecution();
        ExecutionContext jobContext = jobExecution.getExecutionContext();

        this.subsidiaryMcCdL = (List<String>) jobContext.get("subsidiaryMcCdL");

        checkFilesExists();

        if (!errFlg) {
            if (subsidiaryMcCdL != null) {
                for (String subsidiaryMcCd : subsidiaryMcCdL) {

                    Map<String, String> ftpConfMap = getFtpConfMap(subsidiaryMcCd);

                    if (errFlg) {
                        break;
                    }

                    setFtpSessaion(ftpConfMap);

                    sendFiles(ftpConfMap.get("host"));
                }
                if (!errFlg) {
                    renameFiles();
                }
            } else {
                logger.info("File is not send to Ftp because there is no items.");
                deleteFiles();
            }
        }

        writeEndLog(jobExecution.getJobInstance().getJobName());

        return RepeatStatus.FINISHED;
    }

    /**
     * 終了ログを出力する。
     */
    public void writeEndLog(String jobName) {

        String status = "COMPLETED";
        if (errFlg) {
            status = "FAILED";
        }

        logger.info("Job:{} completed with the following status: [{}].", jobName, status);
    }

    /**
     * 出荷予定ファイル_グローバル共有の存在チェックを行う。
     */
    public void checkFilesExists() {
        File globalFile = new File(getGlobalFileName());
        if (!globalFile.exists()) {
            errFlg = true;
            logger.error("The file :{} does not exist.", getGlobalFileName());
        }

        File japanFile = new File(getJapanFileName());
        if (!japanFile.exists()) {
            errFlg = true;
            logger.error("The file :{} does not exist.", getJapanFileName());
        }
    }

    /**
     * 現法コード、ＭＣ／置場コードによりＦＴＰサーバ情報を取得する
     * 
     * @param subsidiaryMcCd 現法コード &MCコード
     * @return 取得したＦＴＰサーバ情報
     * @throws IOException
     */
    public Map<String, String> getFtpConfMap(String subsidiaryMcCd) throws IOException {

        InputStream inputStream = null;
        Map<String, String> ftpConfMap = new HashMap<String, String>();
        try {
            Properties prop = new Properties();
            String propFileName = "META-INF/conf.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException(
                        "The property file '" + propFileName + "' not found in the classpath.");
            }

            String host = getHost(prop, subsidiaryMcCd);
            String port = getPort(prop, subsidiaryMcCd);
            String username = getUsername(prop, subsidiaryMcCd);
            String password = getPassword(prop, subsidiaryMcCd);
            String clientMode = getClientMode(prop, subsidiaryMcCd);

            ftpConfMap.put("host", host);
            ftpConfMap.put("port", port);
            ftpConfMap.put("username", username);
            ftpConfMap.put("password", password);
            ftpConfMap.put("clientMode", clientMode);

        } catch (Exception e) {
            errFlg = true;
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return ftpConfMap;
    }

    /**
     * 指定するＦＴＰサーバ情報をFTPSessionに設定する
     * 
     * @param ftpConfMap コンフィグファイルから取得するＦＴＰサーバ情報
     */
    public void setFtpSessaion(Map<String, String> ftpConfMap) {
        String host = ftpConfMap.get("host");

        int port = PORT_DEFAULT;
        String portStr = ftpConfMap.get("port");
        if (portStr != null && portStr.length() != 0) {
            port = Integer.valueOf(portStr);
        }

        int clientMode = CLIENT_MODE_DEFAULT;
        String clientModeStr = ftpConfMap.get("clientMode");
        if (clientModeStr != null && clientModeStr.length() != 0) {
            clientMode = Integer.valueOf(clientModeStr);
        }

        ftpSessionFactory.setHost(host);
        ftpSessionFactory.setPort(port);
        ftpSessionFactory.setUsername(ftpConfMap.get("username"));
        ftpSessionFactory.setPassword(ftpConfMap.get("password"));
        ftpSessionFactory.setClientMode(clientMode);
    }

    /**
     * 出荷予定ファイルをＦＴＰサーバへ転送する
     * 
     * @param host ＦＴＰサーバのホスト
     */
    public void sendFiles(String host) {

        sendFileToFtp(getGlobalFileName(), host);
        sendFileToFtp(getJapanFileName(), host);
    }

    /**
     * 作成した出荷予定ファイルをリネームする。
     */
    public void renameFiles() {

        renameFile(getGlobalFileName());
        renameFile(getJapanFileName());
    }

    /**
     * 作成した出荷予定ファイルを削除する。
     */
    public void deleteFiles() {
        File globalFile = new File(getGlobalFileName());
        if (globalFile.exists()) {
            globalFile.delete();
        }

        File japanFile = new File(getJapanFileName());
        if (japanFile.exists()) {
            japanFile.delete();
        }
    }

    /**
     * 指定するファイルをＦＴＰサーバへ転送する。
     * 
     * @param fileName 指定するファイル名
     * @param host ＦＴＰサーバのホスト
     */
    public void sendFileToFtp(String fileName, String host) {
        File file = new File(fileName);
        Message<File> message = MessageBuilder.withPayload(file).build();
        int sendRetryTimes = 0;
        boolean sendSuccssFlg = false;
        while (sendRetryTimes < ftpRetryTimes) {
            try {
                if (sendRetryTimes == 0) {
                    logger.info("Sending {} to {}", fileName, host);
                } else {
                    logger.info("Sending {} to {} (retry {}).", fileName, host, sendRetryTimes);
                }
                if (ftpChannel.send(message)) {
                    logger.info("Succeed to send {} to {}", fileName, host);
                    sendSuccssFlg = true;
                    break;
                }
            } catch (Exception e) {
                logger.info("Failed to send {} to {}", fileName, host);
                e.printStackTrace();
            }
            sendRetryTimes++;
        }

        if (!sendSuccssFlg) {
            errFlg = true;
        }
    }

    /**
     * 指定するファイルをリネームする。
     * 
     * @param filePath ファイルパス
     */
    public void renameFile(String filePath) {
        File file = new File(filePath);

        String fileName = file.getName();
        int index = fileName.lastIndexOf('.');
        String baseName = fileName.substring(0, index);
        String fileType = fileName.substring(index, fileName.length());

        StringBuffer newName = new StringBuffer();
        newName.append(baseName);
        newName.append("_");
        newName.append(getTimestampStr());
        newName.append(fileType);

        if (file.renameTo(new File(file.getParent(), newName.toString()))) {
            logger.info("The file :{} has renamed to {}.", fileName, newName);
        } else {
            errFlg = true;
            logger.info("The file :{} rename failed.", fileName);
        }
    }

    /**
     * コンフィグファイルより指定する現法コード&ＭＣ／置場コードに対してホストを取得する。
     * 
     * @param prop コンフィグ
     * @param subsidiaryMcCd 現法コード&ＭＣ／置場コード
     * @return ホスト
     */
    public String getHost(Properties prop, String subsidiaryMcCd) {
        String keyName = subsidiaryMcCd.concat(".ftp.host");
        return getPropertyWithCheck(prop, keyName);
    }

    /**
     * コンフィグファイルより指定する現法コード&ＭＣ／置場コードに対してポートを取得する。
     * 
     * @param prop コンフィグ
     * @param subsidiaryMcCd 現法コード&ＭＣ／置場コード
     * @return ポート
     */
    public String getPort(Properties prop, String subsidiaryMcCd) {
        String keyName = subsidiaryMcCd.concat(".ftp.port");
        return getProperty(prop, keyName);
    }

    /**
     * コンフィグファイルより指定する現法コード&ＭＣ／置場コードに対してユーザ名を取得する。
     * 
     * @param prop コンフィグ
     * @param subsidiaryMcCd 現法コード&ＭＣ／置場コード
     * @return ユーザ名
     */
    public String getUsername(Properties prop, String subsidiaryMcCd) {
        String keyName = subsidiaryMcCd.concat(".ftp.username");
        return getPropertyWithCheck(prop, keyName);
    }

    /**
     * コンフィグファイルより指定する現法コード&ＭＣ／置場コードに対してパスワードを取得する。
     * 
     * @param prop コンフィグ
     * @param subsidiaryMcCd 現法コード&ＭＣ／置場コード
     * @return パスワード
     */
    public String getPassword(Properties prop, String subsidiaryMcCd) {
        String keyName = subsidiaryMcCd.concat(".ftp.password");
        return getPropertyWithCheck(prop, keyName);
    }

    /**
     * コンフィグファイルより指定する現法コード&ＭＣ／置場コードに対してクライアントモードを取得する。
     * 
     * @param prop コンフィグ
     * @param subsidiaryMcCd 現法コード&ＭＣ／置場コード
     * @return クライアントモード
     */
    public String getClientMode(Properties prop, String subsidiaryMcCd) {
        String keyName = subsidiaryMcCd.concat(".ftp.clientmode");
        return getProperty(prop, keyName);
    }

    /**
     * コンフィグファイルより指定するキーに対して値を取得し、取得した値をチェックする
     * 
     * @param prop コンフィグ
     * @param keyName キー
     * @return 指定するキーに対して値
     */
    public String getPropertyWithCheck(Properties prop, String keyName) {
        String value = getProperty(prop, keyName);
        if (value == null || value.isEmpty()) {
            errFlg = true;
            logger.error("The value of key :{} is required in property file.", keyName);
        }
        return value;
    }

    /**
     * コンフィグファイルより指定するキーに対して値を取得する。
     * 
     * @param prop コンフィグ
     * @param keyName キー
     * @return 指定するキーに対して値
     */
    public String getProperty(Properties prop, String keyName) {
        return prop.getProperty(keyName);
    }

    /**
     * タイムスタンプの文字列を取得する
     */
    public String getTimestampStr() {

        DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return format.format(new Date());
    }

    public String getGlobalFileName() {

        return globalFileName;
    }

    public void setGlobalFileName(String fileName) {

        this.globalFileName = fileName;
    }

    public String getJapanFileName() {

        return japanFileName;
    }

    public void setJapanFileName(String fileName) {

        this.japanFileName = fileName;
    }

    public MessageChannel getFtpChannel() {

        return ftpChannel;
    }

    public void setFtpChannel(MessageChannel ftpChannel) {

        this.ftpChannel = ftpChannel;
    }

    public int getFtpRetryTimes() {

        return ftpRetryTimes;
    }

    public void setFtpRetryTimes(int ftpRetryTimes) {

        this.ftpRetryTimes = ftpRetryTimes;
    }

    public DefaultFtpSessionFactory getFtpSessionFactory() {

        return ftpSessionFactory;
    }

    public void setFtpSessionFactory(DefaultFtpSessionFactory ftpSessionFactory) {

        this.ftpSessionFactory = ftpSessionFactory;
    }
}