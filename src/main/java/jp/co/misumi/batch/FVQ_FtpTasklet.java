package jp.co.misumi.batch;

import java.io.File;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FVQ_FtpTasklet implements Tasklet {

	private static Logger logger = LoggerFactory.getLogger(FVQ_FtpTasklet.class);
	private String globalFileName;
	private String japanFileName;
	private MessageChannel ftpChannel;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

		File globalFile = new File(globalFileName);
		File japanFile = new File(japanFileName);

		if (globalFile.exists()) {
			Message<File> message = MessageBuilder.withPayload(globalFile).build();
			try {
				logger.info("File : {} is sending to Ftp.", globalFileName);
				ftpChannel.send(message);
				logger.info("File : {} has sent to Ftp.", globalFileName);
			} catch (Exception e) {

				logger.error("Could not send file:{} to Ftp.", globalFileName);
			}
		} else {
			logger.warn("File : {} does not exist.", globalFileName);
		}

		if (japanFile.exists()) {
			Message<File> message = MessageBuilder.withPayload(japanFile).build();
			try {
				logger.info("File : {} is sending to Ftp.", japanFileName);
				ftpChannel.send(message);
				logger.info("File : {} has sent to Ftp.", japanFileName);
			} catch (Exception e) {

				logger.error("Could not send file:{} to Ftp.", japanFileName);
			}
		} else {
			logger.warn("File : {} does not exist.", japanFileName);
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
}