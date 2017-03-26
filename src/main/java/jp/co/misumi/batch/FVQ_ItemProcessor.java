/**
 *       更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.batch;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jp.co.misumi.model.InptData;
import jp.co.misumi.model.OutptData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * ItemReaderで取得した情報を元に出力用データを作成する。
 *
 */

@Component("itemProcessor")
@Scope("step")
public class FVQ_ItemProcessor implements ItemProcessor<InptData, OutptData> {

    /** ブランク  */
    private static final String BLANK = "";
    private static final String STRING_ZERO = "0";
    private static Logger logger = LoggerFactory.getLogger(FVQ_ItemProcessor.class);
    private StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public OutptData process(InptData item) throws Exception {

        logger.debug("The outptItemProcessor is executing.");
        logger.debug("Input data: {} ", item.toString());

        saveKeyValsToStepContext(item);

        OutptData result = new OutptData();

        // Job名
        result.setJobName(getJobName());
        // 作成日
        result.setCrtDt(getJSTtimeStr(new Date()));
        // 納入担当者区分_日本用
        result.setArrUserDivJp(item.getGrp());
        // 現法コード
        result.setSubsidiaryCd(item.getSubsidiaryCd());
        // MC・置場コード
        result.setMcPlantCd(item.getMcCd());
        // 得意先コード
        result.setCustCd(item.getCustCd());
        // 仕入先コード
        result.setSupplierCd(item.getSupplierCd());
        // 置場
        result.setPlant(subString(item.getMcPlantDiv(), 0, 2));
        // 直送先コード
        result.setShipToCd(item.getShipToCd());
        // 入荷予定日
        result.setSchdArrDt(dateToString(item.getVrd()));
        // 出荷予定日
        result.setSchdShipDt(dateToString(item.getVsd()));
        // 親注番コード
        result.setCustRefCd(String.valueOf(item.getCustRefLength()));
        // 親注番
        result.setCustRef(getCustRef(item.getSubsidiaryCd(), item.getCustRef()));
        // 親注番（現地語）
        result.setCystRefNtv(getCystRefNtv(result.getSubsidiaryCd(), item.getHeaderRef(),
                item.getEngHeaderRef(), item.getCustRef()));
        // 子注番
        result.setCustSubRef(item.getCustSubRef());
        // 結合注番
        result.setRefStr(getRefStr(result.getCustRef(), result.getCystRefNtv(),
                result.getCustSubRef(), item.getyPartNoDiv()));
        // グローバル番号
        result.setGlobalNo(item.getGlobalNo());
        // COMET紐付けSEQ
        //result.setCometSeq(result.getSchdShipDt() + item.getCometSeq());
        result.setCometSeq(item.getCometSeq());
        // 商品コード
        result.setProductCd(item.getProductCd());
        // インナーコード
        result.setInnerCd(item.getInnerCd());
        // 商品種別
        result.setProductAssort(item.getProductAssort());
        // 数量
        result.setQty(String.valueOf(item.getSoQty()));
        // 仕入単価
        result.setPurcPrice(dataToFourZero(item.getPurchaseUnitPrice() * 1000));
        // 売単価
        result.setExcludeTaxSUPrice(dataToFourZero(item.getExcludeTaxSUPrice() * 1000));
        // 輸出フラグ
        result.setExportFlg(getExportFlg(item.getCustsubSubsidiaryCd(), item.getShipToCd(),
                item.getCustCountryCd(), item.getSubsidiaryCountryCd(), item.getShipToCountryCd()));
        // 仕入先名(現地語)
        result.setPurcCompanyName(getInforName(result.getExportFlg(), item.getNtv1CompanyName(),
                item.getCompanyName()));
        // 仕入先名(英語)
        result.setPurcCompanyNameEn(item.getCompanyName());
        // 仕入先国コード
        result.setPurcCountryCd(item.getPurcCountryCd());
        // 仕入先国名（英語）
        result.setPurcCountryName(item.getPurcCountryName());
        // 分析コード
        result.setClassifyCd(item.getClassifyCd());
        // 分析名称
        result.setClassifyName(getClassifyName(result.getExportFlg(), item.getNtvClassifyCdName(),
                item.getClassifyCdName()));
        // バッチ区分
        result.setBacthDiv(getBacthDiv(item.getLaunchDiv(), item.getDeliDiv()));
        // 在庫区分
        //result.setStkDiv(item.getMcPlantDiv());
        result.setStkDiv(item.getStkDiv());
        // データ区分
        result.setDataDiv(item.getDataDiv());
        // 納区
        result.setDeliDiv(item.getDeliDiv());
        // 子商品SEQ
        result.setChildSeq(leftPad(String.valueOf(item.getChildSeq()), 6));
        // MC指定伝票区分
        result.setMcSpecifyVoucherDiv(item.getMcSpecifyVoucherDiv());
        // 梱包ランク
        result.setPackingRank(item.getPackingRank());
        // 納品書送付区分
        result.setDeliNoteSendFlg(item.getDeliNoteSendFlg());
        // 指定伝票区分
        result.setSpecifyVoucherDiv(item.getSpecifyVoucherDiv());
        // 現品添付票区分
        result.setMoveTicketDiv(item.getMoveTicketDiv());
        // 仮伝区分
        result.setTempVoucherDiv(item.getTempVoucherDiv());
        // ピッキングラベル種別
        result.setLabelDiv(nvl(item.getSoSubsidiaryCd(), "L002", "L001"));
        // 納入担当部課コード
        result.setDeliDeptCd(item.getDeliDeptCd());
        // 納入担当者コード
        result.setDeliAttentionCd(item.getDeliAttentionCd());
        // 納入者部課（現地語）
        result.setDeliDept(
                getDeliDept(item.getNtvDeliDept(), item.getSubsidiaryCd(), item.getGrp()));
        // 納入者氏名（現地語）
        result.setDeliAttention(
                getDeliDept(item.getNtvDeliAttention(), item.getSubsidiaryCd(), item.getGrp()));
        // ブランドコード
        result.setBrandCd(item.getBrandCd());
        // ブランド名（英語）
        result.setBrandNameEn(item.getBrandName());
        // 運賃エリアコード
        result.setFrtAreaCd(
                getFrtAreaCd(item.getShipToCd(), item.getShipToFrtAreaCd(), item.getCustFrtAreaCd()));
        // ブランド名(現地語)
        result.setBrandName(
                getInforName(result.getExportFlg(), item.getNtvBrandName(), item.getBrandName()));
        // ミスミ商品コード
        result.setMisumiProductCd(item.getProductCdMst());
        // 発注入り数
        result.setPoQtyPerCase(String.valueOf(item.getPoQtyPerCase()));
        // 入荷ラベル発注番号
        result.setBarcodeGlobalNo(item.getBarcodeGlobalNo());
        // 納品書番号
        result.setPackingNo(item.getDeliNoteNo());
        // 箱番号
        result.setBoxNo(BLANK);
        // Commercial Invoiceフラグ
        result.setComInvFlg(item.getComInvFlg());
        // Commercial Invoice出力枚数(オリジナル)
        result.setComInvPrintNumOrgn(String.valueOf(item.getComInvPrintNumOrgn()));
        // Commercial Invoice出力枚数(控え)
        result.setComInvPrintNumCopy(String.valueOf(item.getComInvPrintNumCopy()));
        // Commercial Invoice保存フラグ
        result.setComInvRetainFlg(item.getComInvRetainFlg());
        // Delivery Orderフラグ
        result.setDeliOrderFlg(item.getDeliOrderFlg());
        // Delivery Order出力枚数(オリジナル)
        result.setDeliOrderPrintNumOrgn(String.valueOf(item.getDeliOrderPrintNumOrgn()));
        // Delivery Order出力枚数(控え)
        result.setDeliInvPrintNumCopy(String.valueOf(item.getComInvPrintNumCopy()));
        // Delivery Order保存フラグ
        result.setDeliOrderRetainFlg(item.getDeliOrderRetainFlg());
        // Packing Listフラグ
        result.setPackListFlg(item.getPackListFlg());
        // Packing List出力枚数(オリジナル)
        result.setPackListPrintNumOrgn(String.valueOf(item.getPackListPrintNumOrgn()));
        // Packing List出力枚数(控え)
        result.setPackListPrintNumCopy(String.valueOf(item.getPackListPrintNumCopy()));
        // Packing List保存フラグ
        result.setPackListSaveFlg(item.getPackListRetainFlg());
        // Invoice&Packing Listフラグ
        result.setInvPackFlg(item.getInvPackFlg());
        // Invoice&Packing List出力枚数(オリジナル)
        result.setInvPackPrintNumOrgn(String.valueOf(item.getInvPackPrintNumOrgn()));
        // Invoice&Packing List出力枚数(控え)
        result.setInvPackPrintNumCopy(String.valueOf(item.getInvPackPrintNumCopy()));
        // Invoice&Packing List保存フラグ
        result.setInvPackRetainFlg(item.getInvPackRetainFlg());
        // HSコード
        result.setHsCd(item.getHsCd());
        // 現法名称
        result.setSubsidiaryName(getInforName(result.getExportFlg(), item.getNtvSubsidiaryName(),
                item.getSubsidiaryName()));
        // 現法住所1
        result.setSubsidiaryAddress_1(getInforName(result.getExportFlg(),
                item.getSubsidiaryNtvAddress_1(), item.getSubsidiaryAddress_1()));
        // 現法住所2
        result.setSubsidiaryAddress_2(getInforName(result.getExportFlg(),
                item.getSubsidiaryNtvAddress_2(), item.getSubsidiaryAddress_2()));
        // 現法住所3
        result.setSubsidiaryAddress_3(getInforName(result.getExportFlg(),
                item.getSubsidiaryNtvAddress_3(), item.getSubsidiaryAddress_3()));
        // 現法住所4
        result.setSubsidiaryAddress_4(getInforName(result.getExportFlg(),
                item.getSubsidiaryNtvAddress_4(), item.getSubsidiaryAddress_4()));
        // 現法電話番号
        result.setSubsidiaryTel(item.getSubsidiaryTel());
        // 現法FAX番号
        result.setSubsidiaryFax(item.getSubsidiaryFax());
        // 現法郵便番号
        result.setSubsidiaryPostalCd(item.getSubsidiaryPostalCd());
        // 現法国コード
        result.setSubsidiaryCountryCd(item.getSubsidiaryCountryCd());
        // 現法国名
        result.setSubsidiaryCountryName(getInforName(result.getExportFlg(),
                item.getNtvCountryName_1(), item.getCountryName()));
        // 現法登録番号
        result.setSubsidiaryLicenceNo(item.getSubsidiaryLicenceNo());
        // 現法税登録番号
        result.setSubsidiaryVatRegistrationNumber(item.getSubsidiaryVatRegistrationNumber());
        // エコール得意先コード
        result.setEcalCustCd(item.getEcalCustCd());
        // 得意先名称（現地語）
        result.setCustName(
                getInforName(result.getExportFlg(), item.getNtvCustName1(), item.getCustName()));
        // 得意先名称（英語）
        result.setCustNameEn(item.getCustName());
        // 得意先住所1
        result.setCustAddress_1(getInforName(result.getExportFlg(), item.getCustNtvAddress_1(),
                item.getCustHalfwidthAddress_1()));
        // 得意先住所2
        result.setCustAddress_2(getInforName(result.getExportFlg(), item.getCustNtvAddress_2(),
                item.getCustHalfwidthAddress_2()));
        // 得意先住所3
        result.setCustAddress_3(getInforName(result.getExportFlg(), item.getCustNtvAddress_3(),
                item.getCustHalfwidthAddress_3()));
        // 得意先住所4
        result.setCustAddress_4(getInforName(result.getExportFlg(), item.getCustNtvAddress_4(),
                item.getCustHalfwidthAddress_4()));
        // 得意先部署名
        result.setCustDeptName(item.getNtvCustDept());
        // 得意先郵便番号
        result.setCustPostalNo(item.getCustPostalCd());
        // 得意先国コード
        result.setCustCountryCd(item.getCustCountryCdMst());
        // 得意先国コード(UPS)
        result.setCustCountryCdUps(item.getCustUpsCountryCd());
        // 得意先国名
        result.setCustCountryName(getInforName(result.getExportFlg(),
                item.getCustNtvCountryName_1(), item.getCustCountryName()));
        // 得意先都市名
        result.setCustCityName(item.getCustCityName());
        // 得意先電話番号
        result.setCustTel(item.getCustTel());
        // 得意先FAX番号
        result.setCustFax(item.getCustFax());
        // 得意先担当者
        result.setCustAttention(item.getNtvCustAttention());
        // 明細コメント
        result.setDtlComment(item.getDtComment());
        // 事務指示１フラグ
        result.setBusinessinstruct1ShowFlg(nvl(result.getShipToCd(),
                item.getShipToBusinessinstruct1ShowFlg(), item.getCustBusinessinstruct1ShowFlg()));
        // 事務指示１
        result.setNtvBusinessinstruct1(nvl(result.getShipToCd(),
                item.getShipToNtvBusinessinstruct1(), item.getCustNtvBusinessinstruct1()));
        // 事務指示２フラグ
        result.setBusinessinstruct2ShowFlg(nvl(result.getShipToCd(),
                item.getShipToBusinessinstruct2ShowFlg(), item.getCustBusinessinstruct2ShowFlg()));
        // 事務指示２
        result.setNtvBusinessinstruct2(nvl(result.getShipToCd(),
                item.getShipToNtvBusinessinstruct2(), item.getCustNtvBusinessinstruct2()));
        // 梱包指示１フラグ
        result.setPackingInstruct1ShowFlg(nvl(result.getShipToCd(),
                item.getShipToPackingInstruct1ShowFlg(), item.getCustPackingInstruct1ShowFlg()));
        // 梱包指示１
        result.setNtvPackingInstruct1(nvl(result.getShipToCd(), item.getShipToNtvPackingInstruct1(),
                item.getCustNtvPackingInstruct1()));
        // 梱包指示２フラグ
        result.setPackingInstruct2ShowFlg(nvl(result.getShipToCd(),
                item.getShipToPackingInstruct2ShowFlg(), item.getCustPackingInstruct2ShowFlg()));
        // 梱包指示２
        result.setNtvPackingInstruct2(nvl(result.getShipToCd(), item.getShipToNtvPackingInstruct2(),
                item.getCustNtvPackingInstruct2()));
        // CS指示
        result.setCsInstruct(item.getHdCommentForLogistics());
        // 企業ライセンス番号
        result.setCustOfficeLicenseNo(item.getCustOfficeLicenseNo());
        // 売掛先コード
        result.setBillToCd(item.getCustBillToCd());
        // 売掛先名
        result.setBillToName(
                getInforName(result.getExportFlg(), item.getNtvBillToName(), item.getBillToName()));
        // 売掛先住所1
        result.setBillToAddress_1(getInforName(result.getExportFlg(), item.getBillToNtvAddress_1(),
                item.getBillToHalfwidthAddress_1()));
        // 売掛先住所2
        result.setBillToAddress_2(getInforName(result.getExportFlg(), item.getBillToNtvAddress_2(),
                item.getBillToHalfwidthAddress_2()));
        // 売掛先住所3
        result.setBillToAddress_3(getInforName(result.getExportFlg(), item.getBillToNtvAddress_3(),
                item.getBillToHalfwidthAddress_3()));
        // 売掛先住所4
        result.setBillToAddress_4(getInforName(result.getExportFlg(), item.getBillToNtvAddress_4(),
                item.getBillToHalfwidthAddress_4()));
        // 売掛先部署名
        result.setBillToNtvBillToDept(item.getBillToNtvBillToDept());
        // 売掛先郵便番号
        result.setBillToPostalCd(item.getBillToPostalCd());
        // 売掛先国コード
        result.setBillToCountryCd(item.getBillToCountryCd());
        // 売掛先国名
        result.setBillToCountryName(getInforName(result.getExportFlg(),
                item.getBillToNtvCountryName_1(), item.getBillToCountryName()));
        // 売掛先電話番号
        result.setBillToTel(item.getBillToTel());
        // 売掛先FAX番号
        result.setBillToFax(item.getFaxBillTo());
        // 売掛先担当者
        result.setNtvBillToPerson(item.getNtvBillToPerson());
        // 売掛注釈1
        result.setNtvReceivableRemarks_1(item.getNtvReceivableRemarks_1());
        // 売掛注釈2
        result.setNtvReceivableRemarks_2(item.getNtvReceivableRemarks_2());
        // 直送先名
        result.setShipToName(getShipToInfor(item.getShipToCd(), result.getExportFlg(),
                item.getNtvShipToName1(), item.getShipToName()));
        // 直送先住所1
        result.setShipToAddress_1(getShipToInfor(item.getShipToCd(), result.getExportFlg(),
                item.getShipToNtvAddress_1(), item.getShipToHalfwidthAddress_1()));
        // 直送先住所2
        result.setShipToAddress_2(getShipToInfor(item.getShipToCd(), result.getExportFlg(),
                item.getShipToNtvAddress_2(), item.getShipToHalfwidthAddress_2()));
        // 直送先住所3
        result.setShipToAddress_3(getShipToInfor(item.getShipToCd(), result.getExportFlg(),
                item.getShipToNtvAddress_3(), item.getShipToHalfwidthAddress_3()));
        // 直送先住所4
        result.setShipToAddress_4(getShipToInfor(item.getShipToCd(), result.getExportFlg(),
                item.getShipToNtvAddress_4(), item.getShipToHalfwidthAddress_4()));
        // 直送先部署名
        result.setShipToDeptName(item.getNtvDeliDept());
        // 直送先郵便番号
        result.setShipToPostalNo(item.getShipToPostalCd());
        // 直送先国コード
        result.setShipToCountryCd(item.getShipToCountryCdMst());
        // 直送先国コード(UPS)
        result.setShipUpsCountryCd(item.getShipToUpsCountryCd());
        // 直送先国名
        result.setShipToCountryName(getShipToInfor(item.getShipToCd(), result.getExportFlg(),
                item.getShipToNtvCountryName_1(), item.getShipToCountryName()));
        // 直送先都市名
        result.setShipToCityName(item.getShipToCityName());
        // 直送先電話番号
        result.setShipToTel(item.getShipToTel());
        // 直送先FAX番号
        result.setShipToFax(item.getShipToFax());
        // 直送先担当者
        result.setShipToAttention(item.getNtvDeliAttention());
        // Sub1置場
        result.setSub1PlantCd(item.getCustsubMcPlantCd());
        // Sub1部門名
        result.setSub1DeptName(item.getSubsidiaryPlantDeptName());
        // Sub1住所1
        result.setSub1DeptAddress_1(item.getSubsidiaryPlantAddress_1());
        // Sub1住所2
        result.setSub1DeptAddress_2(item.getSubsidiaryPlantAddress_2());
        // Sub1住所3
        result.setSub1DeptAddress_3(item.getSubsidiaryPlantAddress_3());
        // Sub1住所4
        result.setSub1DeptAddress_4(item.getSubsidiaryPlantAddress_4());
        // Sub1郵便番号
        result.setSub1DeptPostalCd(item.getSubsidiaryPlantPostalCd());
        // Sub1国コード
        result.setSub1DeptCountryCd(item.getDeptCountryCd());
        // Sub1電話番号
        result.setSub1DeptTel(item.getSubsidiaryPlantTel());
        // Sub1ＦＡＸ番号
        result.setSub1DeptFax(item.getSubsidiaryPlantFax());
        // 扱い便区分
        result.setShippingDestinationCd(item.getCustShipmode());
        // 配送業者名
        result.setCarrierName(item.getShippingCarrierName());
        // 配送業者名略称
        result.setCarrierNameKana(item.getShippingCarrierAbb());
        // 支払い方法
        result.setPaymentTerms(item.getPaymentTerms());
        // インコタームズ
        result.setIncoterms(item.getIncoterms());
        // 支払い形態
        result.setSettlementMethod(item.getSettlementMethod());
        // 商品総称フラグ
        result.setProductGenericNameFlg(item.getProductGenericNameFlg());
        // 伝票区分
        result.setVoucherDiv(item.getVoucherDiv());
        // 税金エリアコード
        result.setTaxAreaCd(item.getTaxAreaCd());
        // 非課税フラグ
        result.setTaxFreeFlg(item.getTaxFreeFlg());
        // 統一発票タイプ
        result.setUniformInvType(item.getUniformInvType());
        // 売掛金締め単位
        result.setArCloseUnit(item.getArCloseUnit());
        // 売掛金締日
        result.setArClosingDay(String.valueOf(item.getArClosingDay()));
        // 最終得意先コード
        result.setFinalCustsubCustCd(item.getCustsubCustCd());
        // 最終得意先名(現地語）
        result.setFinalCustName(getInforName(result.getExportFlg(), item.getCustomerNtvCustName1(),
                item.getCustomerCustName()));
        // 最終得意先名（英語）
        result.setFinalCustNameEn(getFinalCustNameEn(item.getSubsidiaryCd(),
                item.getCustsubSubsidiaryCd(), item.getSubsidiarySysDiv(),
                item.getCustomerMjpCustName(), item.getCustName()));
        // 最終直送先コード
        result.setFinalCustsubShipToCd(item.getCustsubShipToCd());
        // 最終直送先名
        result.setFinalShipToName(getInforName(result.getExportFlg(),
                item.getSubsidiaryNtvShipToName1(), item.getSubsidiaryShipToName()));
        // 受注伝票番号
        result.setSoVoucherNo(item.getSoVoucherno());
        // 受注年月日
        result.setSoDate(dateToString(item.getSoDate()));
        // 商品名
        result.setProductName(getInforName(result.getExportFlg(), item.getNtvProductName(),
                item.getProductName()));
        // 単位重量
        result.setWeight(dataFormat(item.getWeight()));
        // 重量単位
        result.setWeightUnit(item.getWeightUnit());
        // 原産国名表示フラグ
        result.setCountryOfOrignShowFlg(item.getCountryOfOrignShowFlg());
        // 原産国コード
        result.setCountryOfOrigin(item.getCountryOfOrigin());
        // 原産国名
        result.setCountryNameOfOrigin(getInforName(result.getExportFlg(),
                item.getOriginNtvCountryName_1(), item.getOriginCountryName()));
        // 寸法単位
        result.setUnitOfMeasure(item.getUnitOfMeasure());
        // 売通貨単位
        result.setSUnitPriceCcyCd(item.getsUnitPriceCcyCd());
        // 仕入通貨単位
        result.setPUnitPriceCcyCd(item.getpUnitPriceCcyCd());
        // 総重量
        result.setTotalOfWeight(dataFormat(item.getTotalWeight()));
        // 数量合計
        result.setSumQty(String.valueOf(item.getTotalQty()));
        // 受注金額
        result.setSoAmt(dataFormat(item.getSoAmount()));
        // 税込み売単価
        result.setInTaxSPrice(dataFormat(item.getIncludeTaxSUPrice()));
        // 受注金額小計
        result.setSoAmtSum(dataFormat(item.getSubtotalSoAmount()));
        // 合計税金額
        result.setTotalTaxAmt(dataFormat(item.getTaxAmount()));
        // 割引費
        result.setOffAmt(dataFormat(item.getTenthsDiscountedCost()));
        // その他値引額
        result.setOtherDsctAmount(dataFormat(item.getOtherDsctAmount()));
        // 運賃値引フラグ
        result.setFrtDiscountFlg(item.getFrtDiscountFlg());
        // 総合計額
        result.setTotalAmt(dataFormat(item.getTotalAmountPrice()));
        // オリジナルINVOICENO
        result.setOriginalInvoiceNo(BLANK);
        // ジャーナル日付
        result.setJournalDt(BLANK);
        // オリジナルInvoiceDate
        result.setOriginalInvoiceDt(BLANK);
        // オリジナルグローバル番号
        result.setOriginalGlobalNo(BLANK);
        // オリジナル受注伝票番号
        result.setOriginalSoVoucherNo(BLANK);
        // 理由コード
        result.setReasonCd(BLANK);
        // 理由内容
        result.setReasonContent(BLANK);
        // 元請求書合計金額
        result.setSrcSumAmt(STRING_ZERO);
        // 修正額
        result.setDiffAmt(STRING_ZERO);
        // デビット/クレジット税金合計額
        result.setCreditTaxAmt(STRING_ZERO);
        // デビット/クレジット総金額
        result.setCreditSumAmt(STRING_ZERO);
        // 出荷不可フラグ
        result.setShipStopFlg(BLANK);
        // サプライヤーインボイス番号
        result.setSupplierInvNo(item.getSupplierInvNo());
        // 顧客到着日
        result.setCrd(dateToString(item.getCrd()));
        // 所管部門コード
        result.setDeptCd(item.getProductControlDepCode());
        // 特別カスタマーBOX番号
        result.setSpecialCustBoxNo(item.getSpecialCustBoxNo());
        // 特別カスタマーBOXグループ
        result.setSpecialCustBoxGrp(item.getSpecialCustBoxGrp());
        // 輸送手段
        result.setTransportMeans(item.getTransportMeans());
        // 危険品フラグ
        result.setHazardFlg(item.getHazardFlg());
        // CS窓口
        result.setCsWindow(
                getInforName(result.getExportFlg(), item.getNtvCellName(), item.getCellName()));
        // 値引表示フラグ
        result.setDiscountShowFlg(item.getDiscountShowFlg());
        // HSコード表示フラグ
        result.setHsCdShowFlg(item.getHsCdShowFlg());
        // NetWeight表示フラグ
        result.setNetWeightShowFlg(item.getNetWeightShowFlg());
        // 直送区分
        result.setDirectShipFlg(item.getDirectShipFlg());
        // 現法間取引フラグ
        result.setSuppsubBusinessFlg(getSuppsubBusinessFlg(item.getCustCategoryCd()));
        // 配送業者顧客番号
        result.setCarrierAcctNo(item.getCarrierAcctNo());
        // サービス停止区分
        result.setServiceStopDiv(item.getServiceStopDiv());
        // 内税外税区分
        result.setTaxInExDiv(item.getTaxInExDiv());
        // 指定ＶＳＤ
        result.setSpecifyVad(BLANK);
        // 該非区分
        result.setIfDiv(getIfDiv(item.getOrderMsgCd()));
        // 配達時間帯
        result.setDeliveryTime(BLANK);
        // 送り状№回答区分
        result.setSendAnsDiv(BLANK);
        // 着日指示コメント
        result.setRdInstructComment(BLANK);
        // 配送日
        result.setDeliveryDate(BLANK);
        // SCコード名称（漢字）
        result.setScCodeName(item.getNtvMcPlantName());
        // 得意先名(カナ)
        result.setCustNameKana(item.getNtvCustName2());
        // 着日指示フラグ
        result.setRdInstructFlg(nvl(item.getSubsidiaryCdArrDt(), "1", BLANK));
        // 注文部課名(漢字)
        result.setNtvCustDept(setKanJi(result.getArrUserDivJp(), item.getNtvCustDept()));
        // 注文担当者(漢字)
        result.setNtvCustAttention(setKanJi(result.getArrUserDivJp(), item.getNtvCustAttention()));
        // 商品名略称(カナ)
        result.setProductNameKana(getInforName(result.getExportFlg(), item.getNtvProductName(),
                item.getProductName()));
        // 別納区分
        result.setOtherDeliDiv(STRING_ZERO);
        // 消費税率
        result.setCtaxRate(STRING_ZERO);
        // 置場区分
        //result.setPlantDiv(BLANK);
        result.setPlantDiv(item.getMcPlantDiv());
        // セル
        result.setCellCd(item.getCellCd());
        // 注文者部課名（英語）
        result.setCustDeptEn(BLANK);
        // 注文担当者名（英語）
        result.setCustAttentionEn(BLANK);
        // DMコード1
        result.setDmCd_1(BLANK);
        // DMコード2
        result.setDmCd_2(BLANK);
        // DMコード3
        result.setDmCd_3(BLANK);
        // DMコード4
        result.setDmCd_4(BLANK);
        // DMコード5
        result.setDmCd_5(BLANK);
        // 得意先メールアドレス
        result.setCustMailAddress(item.getCustMailAddress());
        // 直送先メールアドレス
        result.setShipToMailAddress(item.getShipToMailAddress());
        // 輸出国仕入単価
        result.setExportPurcUpri(STRING_ZERO);
        // 輸出国仕入単価通貨
        result.setExportPurcUpriCur(BLANK);
        // フレイト単価
        result.setFreightUpri(STRING_ZERO);
        // 輸入諸掛単価
        result.setImportUpri(STRING_ZERO);
        // 輸入関税単価
        result.setImportTaxUpri(STRING_ZERO);
        // フレイト取引為替レート
        result.setFreightXrate(STRING_ZERO);
        // 現法通貨為替レート
        result.setSuppsubCurXrate(STRING_ZERO);
        // 仕入金額
        result.setPurcAmt(STRING_ZERO);
        // Supplier Invoice Date
        result.setSupplierInvoiceDate(BLANK);
        // 発注日
        result.setPoDt(BLANK);
        // 税抜き受注金額小計
        result.setSumSoAmt(STRING_ZERO);
        // インコタームス１
        result.setIncoterms_1(BLANK);
        // インコタームス２
        result.setIncoterms_2(BLANK);
        // インコタームス３
        result.setIncoterms_3(BLANK);
        // 出荷置場コード
        result.setShipPlantCd(BLANK);
        // 優先得意先フラグ
        result.setFirstCustFlg(BLANK);
        // 更新区分
        result.setUpdDiv(BLANK);
        // 作成日_日本用
        result.setCrtDtJp(result.getCrtDt());
        // MC・置場コード_日本用
        result.setMcPlantCdJp(result.getMcPlantCd());
        // 得意先コード_日本用
        result.setCustCdJp(result.getCustCd());
        // 置場_日本用
        result.setMcPlantDivJp(result.getPlant());
        // グローバル番号_日本用
        result.setGlobalNoJp(result.getGlobalNo());
        // 子商品SEQ_日本用
        result.setChildSeqJp(result.getChildSeq());
        // データ区分_日本用
        result.setDataDivJp(result.getDataDiv());
        // 商品コード用ブランド名 _日本用
        result.setBrandNameForProductCdJp(getMcPlantDivJp(item.getBrandNameForProductCd()));
        // ブランド商品コード_日本用
        result.setBrandProductCdJp(
                getBrandProductCdJp(item.getProductCdMst(), item.getBrandNameForProductCd()));
        // 子発注SEQ_日本用
        result.setSubPoSeqJp(getGlobalNoPo(item.getChildSeq(), item.getDelFlg(), item.getGlobalNoPo()));
        // 拠点_日本用
        result.setReceivableMcCdJp(item.getReceivableMcCd());
        // MC漢字名称_日本用
        result.setNtvDeptNameAbbJp(item.getNtvDeptNameAbb());
        // MC電話番号_日本用
        result.setNtvDeptTelAbbJp(item.getPlantDeptTel());
        // 納品書印刷フラグ_日本用
        result.setPackingFlgJp(item.getPackingFlg());
        // 納品書出力枚数（オリジナル）_日本用
        result.setPackingPrintNumOrgnJp(String.valueOf(item.getPackingPrintNumOrgn()));
        // 納品書出力枚数（控え）_日本用
        result.setPackingPrintNumCopyJp(String.valueOf(item.getPackingPrintNumCopy()));
        // 納品書保存フラグ_日本用
        result.setPackingRetainFlgJp(item.getPackingRetainFlg());
        // 英文納品書印刷フラグ_日本用
        result.setEngPackingPrintFlgJp(getEngPackingPrintFlgJp(result.getExportFlg(),
                item.getEngPackingFlg(), result.getVoucherDiv(), result.getCustCountryCd()));
        // 英文納品書出力枚数（オリジナル）_日本用
        result.setEngPackingPrintNumOrgnJp(String.valueOf(item.getEngPackingPrintNumOrgn()));
        // 英文納品書出力枚数（控え）_日本用
        result.setEngPackingPrintNumCopyJp(String.valueOf(item.getEngPackingPrintNumCopy()));
        // 英文納品書保存フラグ_日本用
        result.setEngPackingRetainFlgJp(item.getEngPackingRetainFlg());
        // 仮納品書印刷フラグ_日本用
        result.setTmpPackingPrintFlgJp(getTmpPackingPrintFlgJp(item.getDirectShipFlg(),
                item.getTempVoucherDiv(), item.getTmpPackingFlg()));
        // 仮納品書出力枚数（オリジナル）_日本用
        result.setTmpPackingPrintNumOrgnJp(String.valueOf(item.getTmpPackingPrintNumOrgn()));
        // 仮納品書出力枚数（控え）_日本用
        result.setTmpPackingPrintNumCopyJp(String.valueOf(item.getTmpPackingPrintNumCopy()));
        // 仮納品書保存フラグ_日本用
        result.setTmpPackingRetainFlgJp(item.getTmpPackingRetainFlg());
        // 請求明細書印刷フラグ_日本用
        result.setInvoiceFlgJp(item.getInvoiceFlg());
        // 請求明細書出力枚数（オリジナル）_日本用
        result.setInvoicePrintNumOrgnJp(String.valueOf(item.getInvoicePrintNumOrgn()));
        // 請求明細書出力枚数（控え）_日本用
        result.setInvoicePrintNumCopyJp(String.valueOf(item.getInvoicePrintNumCopy()));
        // 請求明細書保存フラグ_日本用
        result.setInvoiceRetainFlgJp(item.getInvoiceRetainFlg());
        // ピッキングラベル早出しユーザー区分_日本用
        result.setLabelEarlyDivJp(item.getLabelEarlyDiv());
        // ピッキングラベル早出し対象区分_日本用
        result.setLabelEarlyObjectDivJp(getLabelEarlyObjectDivJp(result.getLabelEarlyDivJp(),
                result.getDeliDiv(), item.getMcPlantDiv()));
        // 納入部課区分_日本用
        result.setArrDeptDivJp(item.getGrp());
        // 仕入先名（カナ）_日本用
        result.setCompanyNameKanaJp(item.getNtv2CompanyName());
        // ランク梱包SEQ_日本用
        result.setRankFlgJp(STRING_ZERO);
        // 得意先で複数配送先有無マーク_日本用
        result.setMangShipToFlgJp(item.getW1DeliAttentionCd());
        // 巡回便区分_日本用
        result.setPatrolDivJp(BLANK);
        // 現法名（カナ）_日本用
        result.setCustNameKanaJp(getCustNameKanaJp(result.getExportFlg(), item.getCustName()));
        // 現法名２_日本用
        result.setCustName_2Jp(getCustName_2(result.getBillToCountryName(), result.getCustName()));
        // 梱包指示１_日本用
        result.setNtvPackingInstruct1J(item.getNtvPackingInstruct1J());
        // 梱包指示２_日本用
        result.setNtvPackingInstruct2J(item.getNtvPackingInstruct2J());
        // 梱包指示３_日本用
        result.setNtvPackingInstruct3J(item.getNtvPackingInstruct3J());
        // 梱包指示４_日本用
        result.setNtvPackingInstruct4J(item.getNtvPackingInstruct4J());
        // 梱包指示５_日本用
        result.setNtvPackingInstruct5J(item.getNtvPackingInstruct5J());
        // 事務指示１_日本用
        result.setNtvBusinessInstruct1J(item.getNtvBusinessInstruct1J());
        // 事務指示２_日本用
        result.setNtvBusinessInstruct2J(item.getNtvBusinessInstruct2J());
        // 事務指示３_日本用
        result.setNtvBusinessInstruct3J(item.getNtvBusinessInstruct3J());
        // 事務指示４_日本用
        result.setNtvBusinessInstruct4J(item.getNtvBusinessInstruct4J());
        // 事務指示５_日本用
        result.setNtvBusinessInstruct5J(item.getNtvBusinessInstruct5J());
        // 直送先担当者（カナ）_日本用
        result.setShipToAttentionKanaJp(item.getShipToDeliAttention());
        // 直送先部課（カナ）_日本用
        result.setShipToDeptKanaJp(item.getShipToDeliDept());
        // 得意先担当者（カナ）_日本用
        result.setCustDeliAttentionKanaJp(getCustInfor(result.getArrUserDivJp(), item.getShipToCd(),
                item.getCustCd(), item.getNtvDeliAttention(), item.getNtvCustAttention()));
        // 得意先部課（カナ）_日本用
        result.setCustDeliDeptKanaJp(getCustInfor(result.getArrUserDivJp(), item.getShipToCd(),
                item.getCustCd(), item.getNtvDeliDept(), item.getNtvCustDept()));
        // 注文者名（カナ）_日本用
        result.setCustAttentionKanaJp(
                setKanaJp(result.getArrUserDivJp(), item.getNtvCustAttention()));
        // 注文担当部課名（カナ）_日本用
        result.setCustDeptKanaJp(setKanaJp(result.getArrUserDivJp(), item.getNtvCustDept()));
        // 直送先名称（カナ）_日本用
        result.setShipToNameKanaJp(item.getNtvShipToName2());
        // 納入者名（カナ）_日本用
        result.setDeliAttentionKanaJp(
                setKanaJp(result.getArrUserDivJp(), item.getNtvDeliAttention()));
        // 納入担当部課名（カナ）_日本用
        result.setDeliDeptKanaJp(setKanaJp(result.getArrUserDivJp(), item.getNtvDeliDept()));
        // 地区コード_日本用
        result.setCityCdJp(nvl(item.getShipToCd(), item.getShipToCityCd(), item.getCustCityCd()));
        // 備考(自動車規格コード)_日本用
        result.setAutomobileStandardCdJp(item.getAutomobileStandardCd());
        // 個口数SEQ_日本用
        result.setUnitQtySeqJp(item.getBoxNumberSeq());
        // 届先件数_日本用
        result.setSendedQtyJp(String.valueOf(item.getShippingNumber()));
        // ストーク料金適用区分_日本用
        result.setStorkChargeApplyDivJp(item.getStorkChargeApplyDiv());
        // 納品書番号_MJP_日本用
        result.setDeliNoteNoMjp(String.valueOf(item.getDeliNoteNoMjp()));
        // 合計金額（日本納品書用）_日本用
        result.setSumAmtJp(String.valueOf(item.getTotalSAmountMjp()));
        // 元J納品書番号_日本用
        result.setOldDeliNoteNoJp(BLANK);
        // 受注日_更新用
        result.setSoDateKey(item.getSoDateKey());
        // 子SEQ_更新用
        result.setChildSeqKey(item.getChildSeqKey());

        logger.debug("The outptItemProcessor execution is complete.");
        logger.debug("Output data: {} ", result.toString());
        return result;
    }


    /**
     * 親注番を取得する
     * 
     * @param str1 現法コード
     * @param str2 注文番号(親)(明細) 
     * @return 親注番
     */
    public String getCustRef(String str1, String str2) {

        if ("MJP".equals(str1)) {
            return " ";
        } else {
            return str2;
        }
    }

    /**
     * 結合注番を取得する
     * 
     * @param custRef 親注番
     * @param cystRefNtv 親注番（現地語）
     * @param custSubRef 子注番
     * @param yType Ｙ品番区分
     * @return 結合注番
     */
    public String getRefStr(String custRef, String cystRefNtv, String custSubRef, String yType) {

        List<String> strList = new ArrayList<String>();
        strList.add(custRef);
        strList.add(cystRefNtv);
        strList.add(custSubRef);
        String finalStr = "";
 
        for (String str : strList) {
            if (!isEmpty(str) && !isEmpty(str.trim())) {
                if (!isEmpty(finalStr)) {
                    finalStr = finalStr.concat("/").concat(delBehindBlank(str));
                }
                else {
                    finalStr = finalStr.concat(delBehindBlank(str));
                }
            }
        }

        if (isEmpty(yType)) {
            return finalStr;
        }
        else {
            return finalStr.concat(delBehindBlank(yType));
        }
    }

    /**
     * 日付から文字列（YYYYMMDD）へ変換する
     * 
     * @param date 日付
     * @return 変換後日付
     */
    public String dateToString(Date date) {

        if (date == null) {
            return null;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 日付から文字列（YYYYMMDD）（JST）へ変換する
     * 
     * @param date
     * @return 変換後日付
     */
    public String getJSTtimeStr(Date date) {
        if (date == null) {
            return null;
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            format.setTimeZone(TimeZone.getTimeZone("JST"));
            return format.format(date);
        }
    }

    /**
     * 輸出フラグを取得する
     * 
     * @param custsubSubsidiaryCd 得意先現法コード
     * @param shipToCd 直送先コード
     * @param custCountryCd 得意先国コード
     * @param countryCd 現法国コード
     * @param shipToCountryCd 直送先国コード
     * @return 輸出フラグ
     */
    public String getExportFlg(String custsubSubsidiaryCd, String shipToCd, String custCountryCd,
            String countryCd, String shipToCountryCd) {

        if ((!isEmpty(custsubSubsidiaryCd) && !isEmpty(custsubSubsidiaryCd.trim()))
                || (isEmpty(shipToCd) && custCountryCd != countryCd)
                || (!isEmpty(shipToCd) && shipToCountryCd != countryCd)) {
            return "1";
        } else {
            return STRING_ZERO;
        }
    }

    /**
     * 名称を取得する
     * 
     * @param flg 輸出フラグ
     * @param infor1 名１（現地語）
     * @param infor2 名２（英字）
     * @return 名称
     */
    public String getInforName(String flg, String infor1, String infor2) {

        if (STRING_ZERO.equals(flg)) {
            if (!isEmpty(infor1)) {
                return infor1;
            } else {
                return infor2;
            }
        } else {
            return infor2;
        }
    }

    /**
     * 分析名称を取得する
     * 
     * @param flg 輸出フラグ
     * @param ntvClassifyCdName 製品分類マスタ.分析コード名（現地語）
     * @param classifyCdName 製品分類マスタ.分析コード名（前頭３２文字）
     * @return 分析名称
     */
    public String getClassifyName(String flg, String ntvClassifyCdName, String classifyCdName) {

        if (STRING_ZERO.equals(flg)) {
            if (!isEmpty(ntvClassifyCdName)) {
                return ntvClassifyCdName;
            } else {
                if (isEmpty(classifyCdName)) {
                    return BLANK;
                } else if (classifyCdName.length() >= 32) {
                    return classifyCdName.substring(0, 32);
                }
                return classifyCdName;
            }
        } else {
            if (isEmpty(classifyCdName)) {
                return BLANK;
            } else if (classifyCdName.length() >= 32) {
                return classifyCdName.substring(0, 32);
            }
            return classifyCdName;
        }
    }

    /**
     * 納入者部課（現地語）を取得する
     * 
     * @param ntvCustDept 納入者部課（現地語）
     * @param subsidiaryCd 現法コード
     * @param grp 受注明細履歴.グループ
     * @return 納入者部課（現地語）
     */
    public String getDeliDept(String ntvCustDept, String subsidiaryCd, String grp) {

        if ("MJP".equals(subsidiaryCd) && "2".equals(grp)) {
            return BLANK;
        } else {
            return ntvCustDept;
        }
    }

    /**
     * 運賃エリアコードを取得する
     * 
     * @param shipToCd 受注明細履歴.直送先コード
     * @param shipToFrtAreaCd 直送先マスタ.運賃エリアコード
     * @param frtAreaCd 得意先マスタ.運賃エリアコード
     * @return 運賃エリアコード
     */
    public String getFrtAreaCd(String shipToCd, String shipToFrtAreaCd, String frtAreaCd) {

        if (!isEmpty(shipToCd)) {
            return shipToFrtAreaCd;
        } else {
            return frtAreaCd;
        }
    }

    /**
     * 事務（梱包）指示を取得する
     * 
     * @param object 判断対象
     * @param result1 戻り値1
     * @param result2 戻り値2
     * @return 事務（梱包）指示
     */
    public String nvl(String object, String result1, String result2) {

        if (!isEmpty(object)) {
            return result1;
        } else {
            return result2;
        }
    }

    /**
     * 直送先について情報を取得する
     * 
     * @param shipToCd 直送先コード
     * @param flg 輸出フラグ
     * @param infor1 情報１
     * @param infor2 情報２
     * @return 直送先情報
     */
    public String getShipToInfor(String shipToCd, String flg, String infor1, String infor2) {
        if (isEmpty(shipToCd)) {
            return BLANK;
        } else {
            return getInforName(flg, infor1, infor2);
        }
    }

    /**
     * 商品コード用ブランド名を取得する
     * 
     * @param brandNameForProductCd 商品コード用ブランド名.商品コード用名
     * 
     * @return 商品コード用ブランド名
     */
    public String getMcPlantDivJp(String brandNameForProductCd) {
        if ("ﾐｽﾐ".equals(brandNameForProductCd) || "MISUMI".equals(brandNameForProductCd)) {
            return BLANK;
        } else {
            return brandNameForProductCd;
        }
    }

    /**
     * ブランド商品コードを取得する
     * 
     * @param productCdMst 商品マスタ.商品コード
     * @param branNmForProductCd ブランドマスタ.商品コード用ブランド名
     * 
     * @return ブランド商品コード
     */
    public String getBrandProductCdJp(String productCdMst, String branNmForProductCd) {

        String str = BLANK;
        if (!isEmpty(productCdMst) && !isEmpty(branNmForProductCd)) {
            str = productCdMst.concat("(").concat(branNmForProductCd).concat(")");
            if (str.length() > 56) {
                return productCdMst;
            } else {
                return str;
            }
        } else {
            str = productCdMst;
            return str;
        }

    }

    /**
     * 英文納品書印刷フラグを取得する
     * 
     * @param flg 輸出フラグ
     * @param engPackingRetain 得意先マスタ.英文納品書フラグ
     * @param shipTyp 伝票区分
     * @param custCountryCd 得意先国コード
     * @return 英文納品書印刷フラグ
     */
    public String getEngPackingPrintFlgJp(String flg, String engPackingRetain, String shipTyp,
            String custCountryCd) {

        if ("1".equals(flg) && ("110".equals(shipTyp) || "116".equals(shipTyp))
                && !"192".equals(custCountryCd)) {
            return engPackingRetain;
        } else {
            return STRING_ZERO;
        }
    }

    /**
     * 仮納品書印刷フラグを取得する
     * 
     * @param directShipFlg 受注明細履歴.直送フラグ
     * @param shipToTempVoucherDiv 直送先マスタ.仮伝区分
     * @param tmpFlg 得意先マスタ.仮納品書フラグ
     * @return 仮納品書印刷フラグ
     */
    public String getTmpPackingPrintFlgJp(String directShipFlg, String shipToTempVoucherDiv,
            String tmpFlg) {

        if ("1".equals(directShipFlg)) {
            return STRING_ZERO;
        } else {
            if (STRING_ZERO.equals(shipToTempVoucherDiv)) {
                return "1";
            } else {
                return tmpFlg;
            }
        }
    }

    /**
     * ピッキングラベル早出し対象区分を取得する
     * 
     * @param labelEarlyDivJp ピッキングラベル早出しユーザー区分
     * @param deliDiv 納区
     * @param mcPlantDiv 受注明細履歴.置場区分
     * @return ピッキングラベル早出し対象区分
     */
    public String getLabelEarlyObjectDivJp(String labelEarlyDivJp, String deliDiv,
            String mcPlantDiv) {

        if ("1".equals(labelEarlyDivJp) && !isEmpty(deliDiv) && deliDiv.substring(0, 1).equals(STRING_ZERO)
                && "532".equals(mcPlantDiv)) {
            return "1";
        } else {
            return BLANK;
        }
    }

    /**
     * 現法名（カナ）を取得する
     * 
     * @param flg 輸出フラグ
     * @param custName 得意先マスタ.得意先名（英字）を設定
     * 
     * @return 現法名（カナ）
     */
    public String getCustNameKanaJp(String flg, String custName) {

        if ("1".equals(flg)) {
            return custName;
        } else {
            return BLANK;
        }
    }

    /**
     * 現法名２を設定
     * 
     * @param billToCountryName 売掛先国名
     * @param custName 得意先名称（現地語）
     * 
     * @return 現法名２
     */
    public String getCustName_2(String billToCountryName, String custName) {

        if (!isEmpty(billToCountryName)) {
            if (!isEmpty(billToCountryName.trim()) && !isEmpty(custName)) {
                return billToCountryName.trim() + "/" + custName.trim();
            } else {
                return custName;
            }
        } else {
            return BLANK;
        }
    }

    /**
     * 得意先についての情報を取得する
     * 
     * @param arrUserDivJp 納入担当者区分
     * @param shipToCd 受注明細履歴.直送先コード
     * @param custCd 受注明細履歴.得意先
     * @param result1 値1
     * @param result2 値2
     * @return 得意先情報
     */
    public String getCustInfor(String arrUserDivJp, String shipToCd, String custCd, String result1,
            String result2) {

        if ("2".equals(arrUserDivJp)) {
            if (isEmpty(shipToCd) || shipToCd.equals(custCd)) {
                return result1;
            }

            if (!isEmpty(shipToCd) && !shipToCd.equals(custCd)) {
                return result2;
            }

            return BLANK;
        } else {
            return BLANK;
        }
    }

    /**
     * 名称（カナ）を取得する
     * 
     * @param arrUserDivJp 納入担当者区分
     * @param ntvName 名称（現地語）
     * 
     * @return 名称（カナ）
     */
    public String setKanaJp(String arrUserDivJp, String ntvName) {

        if ("2".equals(arrUserDivJp)) {
            return ntvName;
        } else {
            return BLANK;
        }
    }

    /**
     * 名称（漢字）を取得する
     * 
     * @param arrUserDivJp 納入担当者区分
     * @param ntvName 名称（現地語）
     * 
     * @return 名称（漢字）
     */
    public String setKanJi(String arrUserDivJp, String ntvName) {

        if ("1".equals(arrUserDivJp)) {
            return ntvName;
        } else {
            return BLANK;
        }
    }

    /**
     * 指定する文字列がNULLかどうかを判定する
     * 
     * @param str 文字列
     * 
     * @return 判定結果
     */
    public boolean isEmpty(String str) {

        if (str == null || str.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 親注番（現地語）を取得する
     * 
     * @param suppsubSubsidiaryCd 現法コード
     * @param headerRef 受注ヘッダ.ヘッダー注文番号
     * @param engHeaderRef 受注ヘッダ.ヘッダー注文番号(英数)
     * @param custRef 親注番
     * @return 親注番（現地語）
     */
    public String getCystRefNtv(String suppsubSubsidiaryCd, String headerRef, String engHeaderRef,
            String custRef) {

        if ("MJP".equals(suppsubSubsidiaryCd)) {
            if (!isEmpty(headerRef)) {
                return headerRef;
            } else if (!isEmpty(engHeaderRef)) {
                return engHeaderRef;
            } else if (!isEmpty(custRef)) {
                return custRef;
            }
            return BLANK;
        } else {
            if (!isEmpty(headerRef)) {
                return headerRef;
            } else if (!isEmpty(engHeaderRef)) {
                return engHeaderRef;
            }
            return BLANK;
        }
    }

    /**
     * 現法間取引フラグを取得する
     * 
     * @param custCategoryCd 受注明細履歴．得意先カテゴリコード
     * 
     * @return 現法間取引フラグ
     */
    public String getSuppsubBusinessFlg(String custCategoryCd) {

        if ("01".equals(custCategoryCd) || "02".equals(custCategoryCd)) {
            return "1";
        } else {
            return STRING_ZERO;
        }
    }

    /**
     * 指定する文字列をカットする
     * 
     * @param str 文字列
     * @param begin 始め位置
     * @param lenth 長さ
     * 
     * @return カット後文字列
     */
    public String subString(String str, int begin, int lenth) {

        if (isEmpty(str)) {
            return BLANK;
        } else {
            if (lenth > str.length() - begin - 1) {
                return str;
            } else {
                return str.substring(begin, lenth);
            }
        }
    }

    /**
     * 該非区分を取得する
     * 
     * @param orderMsgCd 輸出管理マスタ.受注メッセージコード
     * 
     * @return 該非区分
     */
    public String getIfDiv(String orderMsgCd) {

        if ("9001".equals(orderMsgCd)) {
            return "1";
        }
        if ("9002".equals(orderMsgCd)) {
            return "2";
        }
        return BLANK;

    }

    /**
     * 最終得意先名（英語）を取得する
     * 
     * @param subsidiaryCd 受注明細履歴.現法コード
     * @param custsubSubsidiaryCd 得意先現法コード
     * @param delFlsubsidiarySysDivg 現法マスタ（得意先現法）.現法システム区分
     * @param result1 得意先マスタ（得意先現法得意先_MJP）.得意先名（英字）
     * @param result2 得意先マスタ.得意先名（英字）     * @return 最終得意先名（英語）
     */
    public String getFinalCustNameEn(String subsidiaryCd, String custsubSubsidiaryCd,
            String delFlsubsidiarySysDivg, String result1, String result2) {

        if ("MJP".equals(subsidiaryCd) && !"MJP".equals(custsubSubsidiaryCd)
                && "M".equals(delFlsubsidiarySysDivg)) {
            return result1;
        } else {
            return result2;
        }
    }

    /**
     * バッチ区分を取得する
     * 
     * @param launchDiv 起動タイミング
     * @param deliDiv 受注明細履歴.納入区分
     * 
     * @return バッチ区分
     */
    public String getBacthDiv(String launchDiv, String deliDiv) {

        if ("1".equals(launchDiv)) {
            return STRING_ZERO;
        }
        if ("2".equals(launchDiv)) {
            if ("T0".equals(deliDiv)) {
                return "1";
            } else {
                return "2";
            }
        }
        if ("3".equals(launchDiv)) {
            return "3";
        } else {
            return "4";
        }
    }

    /**
     * 子発注SEQ_日本用を取得する
     * @param childSeq 部材品受注内訳ファイル.子ＳＥＱ
     * @param delFlg 部材品受注内訳ファイル.削除フラグ
     * @param globalNoPo 部材品受注内訳ファイル.グローバル番号（発注）
     * 
     * @return 子発注SEQ_日本用
     */
    public String getGlobalNoPo(String childSeq, String delFlg, String globalNoPo) {

        if (!isEmpty(childSeq) && !"1".equals(delFlg) 
                && !isEmpty(globalNoPo)) {
            if (globalNoPo.length() > 6) {
                return globalNoPo.substring(globalNoPo.length() - 6, globalNoPo.length());
            }
            else {
                return globalNoPo;
            }
        }
        else {
            return BLANK;
        }
    }

    /**
     *単価を取得する
     * @param data 数値
     * 
     * @return 単価
     */
    public String dataToFourZero(double data) {

        if (data == 0) {
            return "0000";
        }
        else {
            return String.format("%d", new Double(data).longValue());
        }
    }

    /**
     * データをフォーマットする
     * @param data 数値
     * 
     * @return 単価
     */
    public String dataFormat(double data) {

        if (data == 0) {
            return STRING_ZERO;
        }
        else {
            return String.valueOf(data);
        }
    }

    /**
     * ステップコンテキストに抽出対象の現法コードとＭＣ／置場コードを保持する。
     * @param inptData 抽出対象
     */
    @SuppressWarnings("unchecked")
    public void saveKeyValsToStepContext(InptData inptData) {

        if (stepExecution != null) {
            ExecutionContext stepContext = stepExecution.getExecutionContext();
            List<String> subsidiaryMcCdL = new ArrayList<String>();
            StringBuffer subsidiaryMcCdSb = new StringBuffer();

            String subsidiaryCd = inptData.getSubsidiaryCd();
            String mcPlantCd = inptData.getMcPlantCd();

            if (!isEmpty(mcPlantCd) && !isEmpty(subsidiaryCd)) {
                subsidiaryMcCdSb.append(subsidiaryCd);
                subsidiaryMcCdSb.append("_");
                subsidiaryMcCdSb.append(mcPlantCd);
            }

            if (stepContext.get("subsidiaryMcPlantCdL") != null) {
                subsidiaryMcCdL = (List<String>) stepContext.get("subsidiaryMcPlantCdL");
            }

            if (!subsidiaryMcCdL.contains(subsidiaryMcCdSb.toString())) {
                subsidiaryMcCdL.add(subsidiaryMcCdSb.toString());
            }
            stepContext.put("subsidiaryMcPlantCdL", subsidiaryMcCdL);
        }
    }

    /**
     * 値がある項目は後ろをTrimする
     * @param str 文字列
     * 
     * @return 文字列
     */
    private String delBehindBlank(String str) {

        String subStr = "";
        int len = str.length();
        for (int i = len; i > 0; i--) {
            if (str.substring(i - 1, i).equals(" ")) {
                subStr = str.substring(0, i - 1);
            }
            else {
                if (i == len) {
                    subStr = str;
                }
                break;
            }
        }
        return subStr;
    }

    /**
     * Job名を取得する
     * @return Job名
     */
    public String getJobName() {

        if (stepExecution == null) {
            return null;
        }
        JobExecution jobExecution = stepExecution.getJobExecution();
        return jobExecution.getJobInstance().getJobName();
    }

    /**
     * "0"を埋めする
     * @param str 文字列
     * @param lenth 長さ
     * @return 文字列
     */
    public String leftPad(String str, int lenth) {

        String leftPadStr = "";
        if (isEmpty(str)) {
            for (int i = 0; i < lenth; i++) {
                leftPadStr = leftPadStr.concat(STRING_ZERO);
            }
        }
        else {
            int len = str.length();
            for (int i = 0; i < lenth - len; i++) {
                leftPadStr = leftPadStr.concat(STRING_ZERO);
            }
            leftPadStr = leftPadStr.concat(str);
        }
        return leftPadStr;
    }
}
