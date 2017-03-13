/**
 *      更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.mapper;

import jp.co.misumi.model.InptData;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * ＤＢから取得するデータ（出力用データの元データ）のマップ
 *
 */
@Component("inptDataMapper")
public interface InptDataMapper {

    public List<InptData> findInptData(@Param("name") String bind);
}