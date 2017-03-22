/**
 *       更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.batch;

import jp.co.misumi.model.OutptData;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 作成した出荷予定データを出力ファイルに出力処理を行う。
 *
 */
@Component("multiItemWriter")
@Scope("step")
public class FVQ_MultiItemWriter implements ItemWriter<OutptData>, ApplicationContextAware {

    private static Logger logger = LoggerFactory.getLogger(FVQ_MultiItemWriter.class);
    private List<ItemWriter<? super OutptData>> delegates;
    private ApplicationContext ctx = null;

    public void setDelegates(List<ItemWriter<? super OutptData>> delegates) {
        this.delegates = delegates;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void write(List<? extends OutptData> items) throws Exception {

        logger.info("The multiItemWriter is executing.");

        ItemWriter<OutptData> globalWriter = (ItemWriter<OutptData>) delegates.get(0);
        ItemWriter<OutptData> japanWriter = (ItemWriter<OutptData>) delegates.get(1);

        // グローバル共有ファイル出力
        logger.info("Start: Write item(s) to global file.");
        globalWriter.write(items);
        logger.info("Finished: Wrote {} item(s) to global file.", items.size());

        // 日本独自出力対象抽出
        List<OutptData> japanItems = getJapanItems((List<OutptData>) items);
        // 日本独自ファイル出力
        logger.info("Start: Write item(s) to japan-only file.");
        japanWriter.write(japanItems);
        logger.info("Finished: Wrote {} item(s) to japan-only file.", japanItems.size());

        ItemWriter<OutptData> updateWriter = (ItemWriter<OutptData>) ctx.getBean("updateWriter");
        // DB更新
        logger.info("Start: Update status for the table T_ONDEMAND_SHIPMENT.");
        updateWriter.write(items);
        logger.info("Finished: Update status for the table T_ONDEMAND_SHIPMENT.");

        logger.info("The multiItemWriter execution is complete.");
    }

    /**
     * 日本独立出力用データを取得する
     * 
     * @param items 出荷予定データ
     * @return 日本独立用出荷予定データ
     */
    public List<OutptData> getJapanItems(List<OutptData> items) {
        List<OutptData> japanList = new ArrayList<OutptData>();

        for (OutptData item : items) {
            if ("MJP".equals(item.getSubsidiaryCd())) {
                japanList.add(item);
            }
        }

        return japanList;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
}