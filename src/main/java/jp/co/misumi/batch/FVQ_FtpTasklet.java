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
 * ＦＴＰで作成した出荷予定ファイルの転送処理を行う。
 *
 */
public class FVQ_FtpTasklet implements Tasklet {

    private static Logger logger = LoggerFactory.getLogger(FVQ_FtpTasklet.class);
    /** 出荷予定データ_グローボル共有ファイル名 */
    private String globalFileName;
    /** 出荷予定データ_日本独立ファイル名 */
    private String japanFileName;

    private MessageChannel ftpChannel;
    private DefaultFtpSessionFactory ftpSessionFactory;
    private int ftpRetryTimes;
    private List<String> subsidiaryMcCdL = new ArrayList<String>();

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
        boolean globaSendSuccess = false;
        boolean japanSendSuccess = false;

        if (subsidiaryMcCdL != null) {
            for (String subsidiaryMcCd : subsidiaryMcCdL) {
                Map<String, String> ftpConfMap = getFtpConfMap(subsidiaryMcCd);

                String port = ftpConfMap.get("port");
                String clientMode = ftpConfMap.get("clientMode");
                String host = ftpConfMap.get("host");

                ftpSessionFactory.setHost(host);
                if (port != null && port.length() != 0) {
                    ftpSessionFactory.setPort(Integer.valueOf(port));
                } else {
                    ftpSessionFactory.setPort(PORT_DEFAULT);
                }
                ftpSessionFactory.setUsername(ftpConfMap.get("username"));
                ftpSessionFactory.setPassword(ftpConfMap.get("password"));
                if (clientMode != null && clientMode.length() != 0) {
                    ftpSessionFactory.setClientMode(Integer.valueOf(clientMode));
                } else {
                    ftpSessionFactory.setClientMode(CLIENT_MODE_DEFAULT);
                }

                globaSendSuccess = sendFileToFtp(globalFileName, host);
                japanSendSuccess = sendFileToFtp(japanFileName, host);
            }
            if (globaSendSuccess && japanSendSuccess) {
                renameFile(globalFileName);
                renameFile(japanFileName);
            }
        } else {
            File globalFile = new File(globalFileName);
            File japanFile = new File(japanFileName);
            if (globalFile.exists()) {
                globalFile.delete();
            }
            if (japanFile.exists()) {
                japanFile.delete();
            }
            logger.info("File is not send to Ftp because there is no items.");
        }
        return RepeatStatus.FINISHED;
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

    /**
     * FTPにファイルを転送
     * @param fileName ファイル名
     */
    private boolean sendFileToFtp(String fileName, String host) {

        File file = new File(fileName);
        boolean sendSuccess = false;
        if (file.exists()) {
            Message<File> message = MessageBuilder.withPayload(file).build();
            int sendTimes = 0;
            while (sendTimes < ftpRetryTimes && !sendSuccess) {
                try {
                    if (sendTimes == 0) {
                        logger.info("Sending {} to {}.", fileName, host);
                    } else {
                        logger.info("Sending {} to {} (retry {}).", fileName, host, sendTimes);
                    }
                    ftpChannel.send(message);
                    logger.info("Succeed to send {} to {}.", fileName, host);
                    sendSuccess = true;
                } catch (Exception e) {
                    logger.info("Failed to send {} to {}.", fileName, host);
                    e.printStackTrace();
                }
                sendTimes++;
            }
        } else {
            logger.warn("File : {} does not exist.", fileName);
        }
        return sendSuccess;
    }

    /**
     * ファイル名を変更する。
     * 変更後ファイル名：ファイル名_yyyymmdd_hhmmss.TXT
     * @param filePath ファイルパス
     */
    private void renameFile(String filePath) {

        File file = new File(filePath);
        if (file.exists()) {
            String fileName = file.getName();

            int index = fileName.lastIndexOf('.');
            String baseName = fileName.substring(0, index);
            String fileType = fileName.substring(index, fileName.length());

            StringBuffer sb = new StringBuffer();
            sb.append(baseName);
            sb.append("_");
            sb.append(getTimestampStr());
            sb.append(fileType);

            if (file.renameTo(new File(file.getParent(), sb.toString()))) {
                logger.info("File : {} has renamed.", fileName);
            } else {
                logger.info("File : {} rename failed.", fileName);
            }
        }
    }

    /**
     * タイムスタンプの文字列を取得する
     * @return
     */
    private String getTimestampStr() {

        DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return format.format(new Date());
    }

    /**
     * ftpの情報を取得する
     * @param subsidiaryMcCd 現法コード & MCコード
     * @return
     * @throws IOException
     */
    private Map<String , String> getFtpConfMap(String subsidiaryMcCd) throws IOException {

        InputStream inputStream = null;
        Map<String , String> ftpConfMap = new HashMap<String, String>();
        try {
            Properties prop = new Properties();
            String propFileName = "META-INF/conf.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            String host = prop.getProperty(subsidiaryMcCd + ".ftp.host");
            String port = prop.getProperty(subsidiaryMcCd + ".ftp.port");
            String username = prop.getProperty(subsidiaryMcCd + ".ftp.username");
            String password = prop.getProperty(subsidiaryMcCd + ".ftp.password");
            String clientMode = prop.getProperty(subsidiaryMcCd + ".ftp.clientMode");

            ftpConfMap.put("host", host);
            ftpConfMap.put("port", port);
            ftpConfMap.put("username", username);
            ftpConfMap.put("password", password);
            ftpConfMap.put("clientMode", clientMode);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
        return ftpConfMap;
    }
}