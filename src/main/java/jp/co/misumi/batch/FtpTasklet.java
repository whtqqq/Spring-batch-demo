package jp.co.misumi.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class FtpTasklet implements Tasklet {

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
				ftpChannel.send(message);
			} catch (Exception e) {
				
				System.out.println("Could not send file per SFTP: " + e);
			}
		} else {
			System.out.println("The global file does not exist.");
		}

		if (japanFile.exists()) {
			Message<File> message = MessageBuilder.withPayload(japanFile).build();
			try {
				ftpChannel.send(message);
			} catch (Exception e) {
				
				System.out.println("Could not send file per SFTP: " + e);
			}
		} else {
			System.out.println("The japan file does not exist.");
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