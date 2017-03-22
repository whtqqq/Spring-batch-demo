/**
 *       更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * オンデマンド出荷管理テーブルの更新処理を行う。
 *
 */
public class FVQ_UpdShipMngTable implements Tasklet {

    private final Logger logger = LoggerFactory.getLogger(FVQ_UpdShipMngTable.class);
    private DataSource dataSource;
    private String sql;

    /**
     * データソースを取得する
     * 
     * @return データソース
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 指定するデータソースを設定するｓ
     * 
     * @param dataSource データソース
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * SQL文を取得する
     * 
     * @return SQL文
     */
    public String getSql() {
        return sql;
    }

    /**
     * 指定するSQL文を設定する
     * 
     * @param sql SQL文
     */
    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {

        StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();
        JobExecution jobExecution = stepExecution.getJobExecution();
        String stepName = stepExecution.getStepName();
        String jobName = jobExecution.getJobInstance().getJobName();

        JdbcTemplate jdbc = new JdbcTemplate(getDataSource());

        logger.info("Start: Update status for the table T_ONDEMAND_SHIPMENT_MNG.");
        jdbc.update(sql, jobName);
        logger.info("Finished: Update status for the table T_ONDEMAND_SHIPMENT_MNG.");

        writeEndLog(jobName, stepName);
        return RepeatStatus.FINISHED;
    }

    /**
     * 終了ログを出力する。
     */
    public void writeEndLog(String jobName, String stepName) {

        String status = "COMPLETED";
        if (stepName.startsWith("error")) {
            status = "FAILED";
        }

        if (stepName.startsWith("error") || stepName.startsWith("ondemand")) {
            logger.info("Job:{} completed with the following status: [{}].", jobName, status);
        }
    }

}