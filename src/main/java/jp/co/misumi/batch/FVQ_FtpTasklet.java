/**
 *       更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.batch;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
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
    private int ftpRetryTimes;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {

        sendFileToFtp(globalFileName);
        sendFileToFtp(japanFileName);

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

    /**
     * FTPにファイルを転送
     * @param fileName ファイル名
     */
    private void sendFileToFtp(String fileName) {

        File file = new File(fileName);
        if (file.exists()) {
            Message<File> message = MessageBuilder.withPayload(file).build();
            int sendTimes = 0;
            boolean sendSuccess = false;
            while (sendTimes < ftpRetryTimes && !sendSuccess) {
                try {
                    logger.info("File : {} is sending to Ftp.", fileName);
                    ftpChannel.send(message);
                    logger.info("File : {} has sent to Ftp.", fileName);
                    sendSuccess = true;
                    if (renameFile(file)) {
                        logger.info("File : {} has renamed.", fileName);
                    } else {
                        logger.info("File : {} rename failed.", fileName);
                    }
                } catch (Exception e) {
                    logger.error("Could not send file:{} to Ftp.", fileName);
                }
                sendTimes++;
            }
        } else {
            logger.warn("File : {} does not exist.", fileName);
        }
    }

    /**
     * ファイル名を変更する。
     * 変更後ファイル名：ファイル名_yyyymmdd_hhmmss.TXT
     * @param file ファイル
     */
    private boolean renameFile(File file) {

        String path = file.getAbsolutePath();
        String basePath = path.substring(0, path.lastIndexOf('/') + 1);

        String fileName = file.getName();
        int index = fileName.lastIndexOf('.');
        String baseName = fileName.substring(0, index);
        String fileType = fileName.substring(index, fileName.length());

        StringBuffer sb = new StringBuffer(basePath);
        sb.append(baseName);
        sb.append("_");
        sb.append(getTimestampStr());
        sb.append(fileType);

        return file.renameTo(new File(sb.toString()));
    }

    /**
     * タイムスタンプの文字列を取得する
     * @return
     */
    private String getTimestampStr() {

        DateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        return format.format(new Date());
    }
}