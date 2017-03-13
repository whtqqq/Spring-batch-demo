/**
 *      更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.misumi.model.OutptData;

/**
 * ファイル出力用データのマップ
 *
 */
@Component("outptDataMapper")
public interface OutptDataMapper {

    public void updateTable(List<OutptData> list);
}