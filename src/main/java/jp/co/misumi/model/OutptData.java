/**
 *       更新日     開発会社名     更新内容
 *    2017/03/06   misumi       新規追加
 *
 */
package jp.co.misumi.model;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * ファイル出力用データのjavaBean
 *
 */
@Component("outptData")
public class OutptData {

    /** 作成日 */
    private String crtDt;
    /** 現法コード */
    private String subsidiaryCd;
    /** MC・置場コード */
    private String mcPlantCd;
    /** 得意先コード */
    private String custCd;
    /** 仕入先コード */
    private String supplierCd;
    /** 置場 */
    private String plant;
    /** 直送先コード */
    private String shipToCd;
    /** 入荷予定日 */
    private String schdArrDt;
    /** 出荷予定日 */
    private String schdShipDt;
    /** 結合注番 */
    private String refStr;
    /** 親注番コード */
    private String custRefCd;
    /** 親注番 */
    private String custRef;
    /** 親注番（現地語） */
    private String cystRefNtv;
    /** 子注番 */
    private String custSubRef;
    /** グローバル番号 */
    private String globalNo;
    /** COMET紐付けSEQ */
    private String cometSeq;
    /** 商品コード */
    private String productCd;
    /** インナーコード */
    private String innerCd;
    /** 商品種別 */
    private String productAssort;
    /** 数量 */
    private String qty;
    /** 仕入単価 */
    private String purcPrice;
    /** 売単価 */
    private String excludeTaxSUPrice;
    /** 仕入先名(現地語) */
    private String purcCompanyName;
    /** 仕入先名(英語) */
    private String purcCompanyNameEn;
    /** 仕入先国コード */
    private String purcCountryCd;
    /** 仕入先国名（英語） */
    private String purcCountryName;
    /** 分析コード */
    private String classifyCd;
    /** 分析名称 */
    private String classifyName;
    /** バッチ区分 */
    private String bacthDiv;
    /** 在庫区分 */
    private String stkDiv;
    /** データ区分 */
    private String dataDiv;
    /** 納区 */
    private String deliDiv;
    /** 子商品SEQ */
    private String childSeq;
    /** MC指定伝票区分 */
    private String mcSpecifyVoucherDiv;
    /** 梱包ランク */
    private String packingRank;
    /** 納品書送付区分 */
    private String deliNoteSendFlg;
    /** 指定伝票区分 */
    private String specifyVoucherDiv;
    /** 現品添付票区分 */
    private String moveTicketDiv;
    /** 仮伝区分 */
    private String tempVoucherDiv;
    /** ピッキングラベル種別 */
    private String labelDiv;
    /** 納入担当部課コード */
    private String deliDeptCd;
    /** 納入担当者コード */
    private String deliAttentionCd;
    /** 納入者部課（現地語） */
    private String deliDept;
    /** 納入者氏名（現地語） */
    private String deliAttention;
    /** ブランドコード */
    private String brandCd;
    /** ブランド名（英語） */
    private String brandNameEn;
    /** 運賃エリアコード */
    private String frtAreaCd;
    /** ブランド名(現地語) */
    private String brandName;
    /** ミスミ商品コード */
    private String misumiProductCd;
    /** 発注入り数 */
    private String poQtyPerCase;
    /** 入荷ラベル発注番号 */
    private String barcodeGlobalNo;
    /** 納品書番号 */
    private String packingNo;
    /** 輸出フラグ */
    private String exportFlg;
    /** 箱番号 */
    private String boxNo;
    /** Commercial Invoiceフラグ */
    private String comInvFlg;
    /** Commercial Invoice出力枚数(オリジナル) */
    private String comInvPrintNumOrgn;
    /** Commercial Invoice出力枚数(控え) */
    private String comInvPrintNumCopy;
    /** Commercial Invoice保存フラグ */
    private String comInvRetainFlg;
    /** Delivery Orderフラグ */
    private String deliOrderFlg;
    /** Delivery Order出力枚数(オリジナル) */
    private String deliOrderPrintNumOrgn;
    /** Delivery Order出力枚数(控え) */
    private String deliInvPrintNumCopy;
    /** Delivery Order保存フラグ */
    private String deliOrderRetainFlg;
    /** Packing Listフラグ */
    private String packListFlg;
    /** Packing List出力枚数(オリジナル) */
    private String packListPrintNumOrgn;
    /** Packing List出力枚数(控え) */
    private String packListPrintNumCopy;
    /** Packing List保存フラグ */
    private String packListSaveFlg;
    /** Invoice&Packing Listフラグ */
    private String invPackFlg;
    /** Invoice&Packing List出力枚数(オリジナル) */
    private String invPackPrintNumOrgn;
    /** Invoice&Packing List出力枚数(控え) */
    private String invPackPrintNumCopy;
    /** Invoice&Packing List保存フラグ */
    private String invPackRetainFlg;
    /** HSコード */
    private String hsCd;
    /** 現法名称 */
    private String subsidiaryName;
    /** 現法住所1 */
    private String subsidiaryAddress_1;
    /** 現法住所2 */
    private String subsidiaryAddress_2;
    /** 現法住所3 */
    private String subsidiaryAddress_3;
    /** 現法住所4 */
    private String subsidiaryAddress_4;
    /** 現法電話番号 */
    private String subsidiaryTel;
    /** 現法FAX番号 */
    private String subsidiaryFax;
    /** 現法郵便番号 */
    private String subsidiaryPostalCd;
    /** 現法国コード */
    private String subsidiaryCountryCd;
    /** 現法国名 */
    private String subsidiaryCountryName;
    /** 現法登録番号 */
    private String subsidiaryLicenceNo;
    /** 現法税登録番号 */
    private String subsidiaryVatRegistrationNumber;
    /** エコール得意先コード */
    private String ecalCustCd;
    /** 得意先名称（現地語） */
    private String custName;
    /** 得意先名称（英語） */
    private String custNameEn;
    /** 得意先住所1 */
    private String custAddress_1;
    /** 得意先住所2 */
    private String custAddress_2;
    /** 得意先住所3 */
    private String custAddress_3;
    /** 得意先住所4 */
    private String custAddress_4;
    /** 得意先部署名 */
    private String custDeptName;
    /** 得意先郵便番号 */
    private String custPostalNo;
    /** 得意先国コード */
    private String custCountryCd;
    /** 得意先国コード(UPS) */
    private String custCountryCdUps;
    /** 得意先国名 */
    private String custCountryName;
    /** 得意先都市名 */
    private String custCityName;
    /** 得意先電話番号 */
    private String custTel;
    /** 得意先FAX番号 */
    private String custFax;
    /** 得意先担当者 */
    private String custAttention;
    /** 明細コメント */
    private String dtlComment;
    /** 事務指示１フラグ */
    private String businessinstruct1ShowFlg;
    /** 事務指示１ */
    private String ntvBusinessinstruct1;
    /** 事務指示２フラグ */
    private String businessinstruct2ShowFlg;
    /** 事務指示２ */
    private String ntvBusinessinstruct2;
    /** 梱包指示１フラグ */
    private String packingInstruct1ShowFlg;
    /** 梱包指示１ */
    private String ntvPackingInstruct1;
    /** 梱包指示２フラグ */
    private String packingInstruct2ShowFlg;
    /** 梱包指示２ */
    private String ntvPackingInstruct2;
    /** CS指示 */
    private String csInstruct;
    /** 企業ライセンス番号 */
    private String custOfficeLicenseNo;
    /** 売掛先コード */
    private String billToCd;
    /** 売掛先名 */
    private String billToName;
    /** 売掛先住所1 */
    private String billToAddress_1;
    /** 売掛先住所2 */
    private String billToAddress_2;
    /** 売掛先住所3 */
    private String billToAddress_3;
    /** 売掛先住所4 */
    private String billToAddress_4;
    /** 売掛先部署名 */
    private String billToNtvBillToDept;
    /** 売掛先郵便番号 */
    private String billToPostalCd;
    /** 売掛先国コード */
    private String billToCountryCd;
    /** 売掛先国名 */
    private String billToCountryName;
    /** 売掛先電話番号 */
    private String billToTel;
    /** 売掛先FAX番号 */
    private String billToFax;
    /** 売掛先担当者 */
    private String ntvBillToPerson;
    /** 売掛注釈1 */
    private String ntvReceivableRemarks_1;
    /** 売掛注釈2 */
    private String ntvReceivableRemarks_2;
    /** 直送先名 */
    private String shipToName;
    /** 直送先住所1 */
    private String shipToAddress_1;
    /** 直送先住所2 */
    private String shipToAddress_2;
    /** 直送先住所3 */
    private String shipToAddress_3;
    /** 直送先住所4 */
    private String shipToAddress_4;
    /** 直送先部署名 */
    private String shipToDeptName;
    /** 直送先郵便番号 */
    private String shipToPostalNo;
    /** 直送先国コード */
    private String shipToCountryCd;
    /** 直送先国コード(UPS) */
    private String shipUpsCountryCd;
    /** 直送先国名 */
    private String shipToCountryName;
    /** 直送先都市名 */
    private String shipToCityName;
    /** 直送先電話番号 */
    private String shipToTel;
    /** 直送先FAX番号 */
    private String shipToFax;
    /** 直送先担当者 */
    private String shipToAttention;
    /** Sub1置場 */
    private String sub1PlantCd;
    /** Sub1部門名 */
    private String sub1DeptName;
    /** Sub1住所1 */
    private String sub1DeptAddress_1;
    /** Sub1住所2 */
    private String sub1DeptAddress_2;
    /** Sub1住所3 */
    private String sub1DeptAddress_3;
    /** Sub1住所4 */
    private String sub1DeptAddress_4;
    /** Sub1郵便番号 */
    private String sub1DeptPostalCd;
    /** Sub1国コード */
    private String sub1DeptCountryCd;
    /** Sub1電話番号 */
    private String sub1DeptTel;
    /** Sub1ＦＡＸ番号 */
    private String sub1DeptFax;
    /** 扱い便区分 */
    private String shippingDestinationCd;
    /** 配送業者名 */
    private String carrierName;
    /** 配送業者名略称 */
    private String carrierNameKana;
    /** 支払い方法 */
    private String paymentTerms;
    /** インコタームズ */
    private String incoterms;
    /** 支払い形態 */
    private String settlementMethod;
    /** 商品総称フラグ */
    private String productGenericNameFlg;
    /** 伝票区分 */
    private String voucherDiv;
    /** 税金エリアコード */
    private String taxAreaCd;
    /** 非課税フラグ */
    private String taxFreeFlg;
    /** 統一発票タイプ */
    private String uniformInvType;
    /** 売掛金締め単位 */
    private String arCloseUnit;
    /** 売掛金締日 */
    private String arClosingDay;
    /** 最終得意先コード */
    private String finalCustsubCustCd;
    /** 最終得意先名(現地語） */
    private String finalCustName;
    /** 最終得意先名（英語） */
    private String finalCustNameEn;
    /** 最終直送先コード */
    private String finalCustsubShipToCd;
    /** 最終直送先名 */
    private String finalShipToName;
    /** 受注伝票番号 */
    private String soVoucherNo;
    /** 受注年月日 */
    private String soDate;
    /** 商品名 */
    private String productName;
    /** 単位重量 */
    private String weight;
    /** 重量単位 */
    private String weightUnit;
    /** 原産国名表示フラグ */
    private String countryOfOrignShowFlg;
    /** 原産国コード */
    private String countryOfOrigin;
    /** 原産国名 */
    private String countryNameOfOrigin;
    /** 寸法単位 */
    private String unitOfMeasure;
    /** 売通貨単位 */
    private String sUnitPriceCcyCd;
    /** 仕入通貨単位 */
    private String pUnitPriceCcyCd;
    /** 総重量 */
    private String totalOfWeight;
    /** 数量合計 */
    private String sumQty;
    /** 受注金額 */
    private String soAmt;
    /** 税込み売単価 */
    private String inTaxSPrice;
    /** 受注金額小計 */
    private String soAmtSum;
    /** 合計税金額 */
    private String totalTaxAmt;
    /** 割引費 */
    private String offAmt;
    /** その他値引額 */
    private String otherDsctAmount;
    /** 運賃値引フラグ */
    private String frtDiscountFlg;
    /** 総合計額 */
    private String totalAmt;
    /** オリジナルINVOICENO */
    private String originalInvoiceNo;
    /** ジャーナル日付 */
    private String journalDt;
    /** オリジナルInvoiceDate */
    private String originalInvoiceDt;
    /** オリジナルグローバル番号 */
    private String originalGlobalNo;
    /** オリジナル受注伝票番号 */
    private String originalSoVoucherNo;
    /** 理由コード */
    private String reasonCd;
    /** 理由内容 */
    private String reasonContent;
    /** 元請求書合計金額 */
    private String srcSumAmt;
    /** 修正額 */
    private String diffAmt;
    /** デビット/クレジット税金合計額 */
    private String creditTaxAmt;
    /** デビット/クレジット総金額 */
    private String creditSumAmt;
    /** 出荷不可フラグ */
    private String shipStopFlg;
    /** サプライヤーインボイス番号 */
    private String supplierInvNo;
    /** 顧客到着日 */
    private String crd;
    /** 所管部門コード */
    private String deptCd;
    /** 特別カスタマーBOX番号 */
    private String specialCustBoxNo;
    /** 特別カスタマーBOXグループ */
    private String specialCustBoxGrp;
    /** 輸送手段 */
    private String transportMeans;
    /** 危険品フラグ */
    private String hazardFlg;
    /** CS窓口 */
    private String csWindow;
    /** 値引表示フラグ */
    private String discountShowFlg;
    /** HSコード表示フラグ */
    private String hsCdShowFlg;
    /** NetWeight表示フラグ */
    private String netWeightShowFlg;
    /** 直送区分 */
    private String directShipFlg;
    /** 現法間取引フラグ */
    private String suppsubBusinessFlg;
    /** 配送業者顧客番号 */
    private String carrierAcctNo;
    /** サービス停止区分 */
    private String serviceStopDiv;
    /** 内税外税区分 */
    private String taxInExDiv;
    /** 指定ＶＳＤ */
    private String specifyVad;
    /** 該非区分 */
    private String ifDiv;
    /** 配達時間帯 */
    private String deliveryTime;
    /** 送り状№回答区分 */
    private String sendAnsDiv;
    /** 着日指示コメント */
    private String rdInstructComment;
    /** 配送日 */
    private String deliveryDate;
    /** SCコード名称（漢字） */
    private String scCodeName;
    /** 得意先名(カナ) */
    private String custNameKana;
    /** 着日指示フラグ */
    private String rdInstructFlg;
    /** 注文部課名(漢字) */
    private String ntvCustDept;
    /** 注文担当者(漢字) */
    private String ntvCustAttention;
    /** 商品名略称(カナ) */
    private String productNameKana;
    /** 別納区分 */
    private String otherDeliDiv;
    /** 消費税率 */
    private String ctaxRate;
    /** 置場区分 */
    private String plantDiv;
    /** セル */
    private String cellCd;
    /** 注文者部課名（英語） */
    private String custDeptEn;
    /** 注文担当者名（英語） */
    private String custAttentionEn;
    /** DMコード1 */
    private String dmCd_1;
    /** DMコード2 */
    private String dmCd_2;
    /** DMコード3 */
    private String dmCd_3;
    /** DMコード4 */
    private String dmCd_4;
    /** DMコード5 */
    private String dmCd_5;
    /** 得意先メールアドレス */
    private String custMailAddress;
    /** 直送先メールアドレス */
    private String shipToMailAddress;
    /** 輸出国仕入単価 */
    private String exportPurcUpri;
    /** 輸出国仕入単価通貨 */
    private String exportPurcUpriCur;
    /** フレイト単価 */
    private String freightUpri;
    /** 輸入諸掛単価 */
    private String importUpri;
    /** 輸入関税単価 */
    private String importTaxUpri;
    /** フレイト取引為替レート */
    private String freightXrate;
    /** 現法通貨為替レート */
    private String suppsubCurXrate;
    /** 仕入金額 */
    private String purcAmt;
    /** Supplier Invoice Date */
    private String supplierInvoiceDate;
    /** 発注日 */
    private String poDt;
    /** 税抜き受注金額小計 */
    private String sumSoAmt;
    /** インコタームス１ */
    private String incoterms_1;
    /** インコタームス２ */
    private String incoterms_2;
    /** インコタームス３ */
    private String incoterms_3;
    /** 出荷置場コード */
    private String shipPlantCd;
    /** 優先得意先フラグ */
    private String firstCustFlg;
    /** 更新区分 */
    private String updDiv;
    /** 作成日_日本用 */
    private String crtDtJp;
    /** MC・置場コード_日本用 */
    private String mcPlantCdJp;
    /** 得意先コード_日本用 */
    private String custCdJp;
    /** 置場_日本用 */
    private String mcPlantDivJp;
    /** グローバル番号_日本用 */
    private String globalNoJp;
    /** 子商品SEQ_日本用 */
    private String childSeqJp;
    /** データ区分_日本用 */
    private String dataDivJp;
    /** 商品コード用ブランド名 _日本用 */
    private String brandNameForProductCdJp;
    /** ブランド商品コード_日本用 */
    private String brandProductCdJp;
    /** 子発注SEQ_日本用 */
    private String subPoSeqJp;
    /** 拠点_日本用 */
    private String receivableMcCdJp;
    /** MC漢字名称_日本用 */
    private String ntvDeptNameAbbJp;
    /** MC電話番号_日本用 */
    private String ntvDeptTelAbbJp;
    /** 納品書印刷フラグ_日本用 */
    private String packingFlgJp;
    /** 納品書出力枚数（オリジナル）_日本用 */
    private String packingPrintNumOrgnJp;
    /** 納品書出力枚数（控え）_日本用 */
    private String packingPrintNumCopyJp;
    /** 納品書保存フラグ_日本用 */
    private String packingRetainFlgJp;
    /** 英文納品書印刷フラグ_日本用 */
    private String engPackingPrintFlgJp;
    /** 英文納品書出力枚数（オリジナル）_日本用 */
    private String engPackingPrintNumOrgnJp;
    /** 英文納品書出力枚数（控え）_日本用 */
    private String engPackingPrintNumCopyJp;
    /** 英文納品書保存フラグ_日本用 */
    private String engPackingRetainFlgJp;
    /** 仮納品書印刷フラグ_日本用 */
    private String tmpPackingPrintFlgJp;
    /** 仮納品書出力枚数（オリジナル）_日本用 */
    private String tmpPackingPrintNumOrgnJp;
    /** 仮納品書出力枚数（控え）_日本用 */
    private String tmpPackingPrintNumCopyJp;
    /** 仮納品書保存フラグ_日本用 */
    private String tmpPackingRetainFlgJp;
    /** 請求明細書印刷フラグ_日本用 */
    private String invoiceFlgJp;
    /** 請求明細書出力枚数（オリジナル）_日本用 */
    private String invoicePrintNumOrgnJp;
    /** 請求明細書出力枚数（控え）_日本用 */
    private String invoicePrintNumCopyJp;
    /** 請求明細書保存フラグ_日本用 */
    private String invoiceRetainFlgJp;
    /** ピッキングラベル早出しユーザー区分_日本用 */
    private String labelEarlyDivJp;
    /** ピッキングラベル早出し対象区分_日本用 */
    private String labelEarlyObjectDivJp;
    /** 納入部課区分_日本用 */
    private String arrDeptDivJp;
    /** 納入担当者区分_日本用 */
    private String arrUserDivJp;
    /** 仕入先名（カナ）_日本用 */
    private String companyNameKanaJp;
    /** ランク梱包SEQ_日本用 */
    private String rankFlgJp;
    /** 1得意先で複数配送先有無マーク_日本用 */
    private String mangShipToFlgJp;
    /** 巡回便区分_日本用 */
    private String patrolDivJp;
    /** 現法名（カナ）_日本用 */
    private String custNameKanaJp;
    /** 現法名２_日本用 */
    private String custName_2Jp;
    /** 梱包指示１_日本用 */
    private String ntvPackingInstruct1J;
    /** 梱包指示２_日本用 */
    private String ntvPackingInstruct2J;
    /** 梱包指示３_日本用 */
    private String ntvPackingInstruct3J;
    /** 梱包指示４_日本用 */
    private String ntvPackingInstruct4J;
    /** 梱包指示５_日本用 */
    private String ntvPackingInstruct5J;
    /** 事務指示１_日本用 */
    private String ntvBusinessInstruct1J;
    /** 事務指示２_日本用 */
    private String ntvBusinessInstruct2J;
    /** 事務指示３_日本用 */
    private String ntvBusinessInstruct3J;
    /** 事務指示４_日本用 */
    private String ntvBusinessInstruct4J;
    /** 事務指示５_日本用 */
    private String ntvBusinessInstruct5J;
    /** 直送先担当者（カナ）_日本用 */
    private String shipToAttentionKanaJp;
    /** 直送先部課（カナ）_日本用 */
    private String shipToDeptKanaJp;
    /** 得意先担当者（カナ）_日本用 */
    private String custDeliAttentionKanaJp;
    /** 得意先部課（カナ）_日本用 */
    private String custDeliDeptKanaJp;
    /** 注文者名（カナ）_日本用 */
    private String custAttentionKanaJp;
    /** 注文担当部課名（カナ）_日本用 */
    private String custDeptKanaJp;
    /** 直送先名称（カナ）_日本用 */
    private String shipToNameKanaJp;
    /** 納入者名（カナ）_日本用 */
    private String deliAttentionKanaJp;
    /** 納入担当部課名（カナ）_日本用 */
    private String deliDeptKanaJp;
    /** 地区コード_日本用 */
    private String cityCdJp;
    /** 備考(自動車規格コード)_日本用 */
    private String automobileStandardCdJp;
    /** 個口数SEQ_日本用 */
    private String unitQtySeqJp;
    /** 届先件数_日本用 */
    private String sendedQtyJp;
    /** ストーク料金適用区分_日本用 */
    private String storkChargeApplyDivJp;
    /** 納品書番号_MJP_日本用 */
    private String deliNoteNoMjp;
    /** 合計金額（日本納品書用）_日本用 */
    private String sumAmtJp;
    /** 元J納品書番号_日本用 */
    private String oldDeliNoteNoJp;
    /** 子SEQ_更新用*/
    private long childSeqKey;
    /** 受注日_更新用*/
    private Date soDateKey;
    /** Job名*/
    private String jobName;

    public OutptData() {

    }

    /** 子SEQ_更新用*/
    public long getChildSeqKey() {
        return childSeqKey;
    }

    /** 子SEQ_更新用*/
    public void setChildSeqKey(long childSeqKey) {
        this.childSeqKey = childSeqKey;
    }

    /** 受注日_更新用*/
    public Date getSoDateKey() {
        return soDateKey;
    }

    /** 受注日_更新用*/
    public void setSoDateKey(Date soDateKey) {
        this.soDateKey = soDateKey;
    }


    /** 作成日 */
    public String getCrtDt() {
        return crtDt;
    }

    /** 作成日 */
    public void setCrtDt(String crtDt) {
        this.crtDt = crtDt;
    }

    /** 現法コード */
    public String getSubsidiaryCd() {
        return subsidiaryCd;
    }

    /** 現法コード */
    public void setSubsidiaryCd(String subsidiaryCd) {
        this.subsidiaryCd = subsidiaryCd;
    }

    /** MC・置場コード */
    public String getMcPlantCd() {
        return mcPlantCd;
    }

    /** MC・置場コード */
    public void setMcPlantCd(String mcPlantCd) {
        this.mcPlantCd = mcPlantCd;
    }

    /** 得意先コード */
    public String getCustCd() {
        return custCd;
    }

    /** 得意先コード */
    public void setCustCd(String custCd) {
        this.custCd = custCd;
    }

    /** 仕入先コード */
    public String getSupplierCd() {
        return supplierCd;
    }

    /** 仕入先コード */
    public void setSupplierCd(String supplierCd) {
        this.supplierCd = supplierCd;
    }

    /** 置場 */
    public String getPlant() {
        return plant;
    }

    /** 置場 */
    public void setPlant(String plant) {
        this.plant = plant;
    }

    /** 直送先コード */
    public String getShipToCd() {
        return shipToCd;
    }

    /** 直送先コード */
    public void setShipToCd(String shipToCd) {
        this.shipToCd = shipToCd;
    }

    /** 入荷予定日 */
    public String getSchdArrDt() {
        return schdArrDt;
    }

    /** 入荷予定日 */
    public void setSchdArrDt(String schdArrDt) {
        this.schdArrDt = schdArrDt;
    }

    /** 出荷予定日 */
    public String getSchdShipDt() {
        return schdShipDt;
    }

    /** 出荷予定日 */
    public void setSchdShipDt(String schdShipDt) {
        this.schdShipDt = schdShipDt;
    }

    /** 結合注番 */
    public String getRefStr() {
        return refStr;
    }

    /** 結合注番 */
    public void setRefStr(String refStr) {
        this.refStr = refStr;
    }

    /** 親注番コード */
    public String getCustRefCd() {
        return custRefCd;
    }

    /** 親注番コード */
    public void setCustRefCd(String custRefCd) {
        this.custRefCd = custRefCd;
    }

    /** 親注番 */
    public String getCustRef() {
        return custRef;
    }

    /** 親注番 */
    public void setCustRef(String custRef) {
        this.custRef = custRef;
    }

    /** 親注番（現地語） */
    public String getCystRefNtv() {
        return cystRefNtv;
    }

    /** 親注番（現地語） */
    public void setCystRefNtv(String cystRefNtv) {
        this.cystRefNtv = cystRefNtv;
    }

    /** 子注番 */
    public String getCustSubRef() {
        return custSubRef;
    }

    /** 子注番 */
    public void setCustSubRef(String custSubRef) {
        this.custSubRef = custSubRef;
    }

    /** グローバル番号 */
    public String getGlobalNo() {
        return globalNo;
    }

    /** グローバル番号 */
    public void setGlobalNo(String globalNo) {
        this.globalNo = globalNo;
    }

    /** COMET紐付けSEQ */
    public String getCometSeq() {
        return cometSeq;
    }

    /** COMET紐付けSEQ */
    public void setCometSeq(String cometSeq) {
        this.cometSeq = cometSeq;
    }

    /** 商品コード */
    public String getProductCd() {
        return productCd;
    }

    /** 商品コード */
    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    /** インナーコード */
    public String getInnerCd() {
        return innerCd;
    }

    /** インナーコード */
    public void setInnerCd(String innerCd) {
        this.innerCd = innerCd;
    }

    /** 商品種別 */
    public String getProductAssort() {
        return productAssort;
    }

    /** 商品種別 */
    public void setProductAssort(String productAssort) {
        this.productAssort = productAssort;
    }

    /** 数量 */
    public String getQty() {
        return qty;
    }

    /** 数量 */
    public void setQty(String qty) {
        this.qty = qty;
    }

    /** 仕入単価 */
    public String getPurcPrice() {
        return purcPrice;
    }

    /** 仕入単価 */
    public void setPurcPrice(String purcPrice) {
        this.purcPrice = purcPrice;
    }

    /** 売単価 */
    public String getExcludeTaxSUPrice() {
        return excludeTaxSUPrice;
    }

    /** 売単価 */
    public void setExcludeTaxSUPrice(String excludeTaxSUPrice) {
        this.excludeTaxSUPrice = excludeTaxSUPrice;
    }

    /** 仕入先名(現地語) */
    public String getPurcCompanyName() {
        return purcCompanyName;
    }

    /** 仕入先名(現地語) */
    public void setPurcCompanyName(String purcCompanyName) {
        this.purcCompanyName = purcCompanyName;
    }

    /** 仕入先名(英語) */
    public String getPurcCompanyNameEn() {
        return purcCompanyNameEn;
    }

    /** 仕入先名(英語) */
    public void setPurcCompanyNameEn(String purcCompanyNameEn) {
        this.purcCompanyNameEn = purcCompanyNameEn;
    }

    /** 仕入先国コード */
    public String getPurcCountryCd() {
        return purcCountryCd;
    }

    /** 仕入先国コード */
    public void setPurcCountryCd(String purcCountryCd) {
        this.purcCountryCd = purcCountryCd;
    }

    /** 仕入先国名（英語） */
    public String getPurcCountryName() {
        return purcCountryName;
    }

    /** 仕入先国名（英語） */
    public void setPurcCountryName(String purcCountryName) {
        this.purcCountryName = purcCountryName;
    }

    /** 分析コード */
    public String getClassifyCd() {
        return classifyCd;
    }

    /** 分析コード */
    public void setClassifyCd(String classifyCd) {
        this.classifyCd = classifyCd;
    }

    /** 分析名称 */
    public String getClassifyName() {
        return classifyName;
    }

    /** 分析名称 */
    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    /** バッチ区分 */
    public String getBacthDiv() {
        return bacthDiv;
    }

    /** バッチ区分 */
    public void setBacthDiv(String bacthDiv) {
        this.bacthDiv = bacthDiv;
    }

    /** 在庫区分 */
    public String getStkDiv() {
        return stkDiv;
    }

    /** 在庫区分 */
    public void setStkDiv(String stkDiv) {
        this.stkDiv = stkDiv;
    }

    /** データ区分 */
    public String getDataDiv() {
        return dataDiv;
    }

    /** データ区分 */
    public void setDataDiv(String dataDiv) {
        this.dataDiv = dataDiv;
    }

    /** 納区 */
    public String getDeliDiv() {
        return deliDiv;
    }

    /** 納区 */
    public void setDeliDiv(String deliDiv) {
        this.deliDiv = deliDiv;
    }

    /** 子商品SEQ */
    public String getChildSeq() {
        return childSeq;
    }

    /** 子商品SEQ */
    public void setChildSeq(String childSeq) {
        this.childSeq = childSeq;
    }

    /** MC指定伝票区分 */
    public String getMcSpecifyVoucherDiv() {
        return mcSpecifyVoucherDiv;
    }

    /** MC指定伝票区分 */
    public void setMcSpecifyVoucherDiv(String mcSpecifyVoucherDiv) {
        this.mcSpecifyVoucherDiv = mcSpecifyVoucherDiv;
    }

    /** 梱包ランク */
    public String getPackingRank() {
        return packingRank;
    }

    /** 梱包ランク */
    public void setPackingRank(String packingRank) {
        this.packingRank = packingRank;
    }

    /** 納品書送付区分 */
    public String getDeliNoteSendFlg() {
        return deliNoteSendFlg;
    }

    /** 納品書送付区分 */
    public void setDeliNoteSendFlg(String deliNoteSendFlg) {
        this.deliNoteSendFlg = deliNoteSendFlg;
    }

    /** 指定伝票区分 */
    public String getSpecifyVoucherDiv() {
        return specifyVoucherDiv;
    }

    /** 指定伝票区分 */
    public void setSpecifyVoucherDiv(String specifyVoucherDiv) {
        this.specifyVoucherDiv = specifyVoucherDiv;
    }

    /** 現品添付票区分 */
    public String getMoveTicketDiv() {
        return moveTicketDiv;
    }

    /** 現品添付票区分 */
    public void setMoveTicketDiv(String moveTicketDiv) {
        this.moveTicketDiv = moveTicketDiv;
    }

    /** 仮伝区分 */
    public String getTempVoucherDiv() {
        return tempVoucherDiv;
    }

    /** 仮伝区分 */
    public void setTempVoucherDiv(String tempVoucherDiv) {
        this.tempVoucherDiv = tempVoucherDiv;
    }

    /** ピッキングラベル種別 */
    public String getLabelDiv() {
        return labelDiv;
    }

    /** ピッキングラベル種別 */
    public void setLabelDiv(String labelDiv) {
        this.labelDiv = labelDiv;
    }

    /** 納入担当部課コード */
    public String getDeliDeptCd() {
        return deliDeptCd;
    }

    /** 納入担当部課コード */
    public void setDeliDeptCd(String deliDeptCd) {
        this.deliDeptCd = deliDeptCd;
    }

    /** 納入担当者コード */
    public String getDeliAttentionCd() {
        return deliAttentionCd;
    }

    /** 納入担当者コード */
    public void setDeliAttentionCd(String deliAttentionCd) {
        this.deliAttentionCd = deliAttentionCd;
    }

    /** 納入者部課（現地語） */
    public String getDeliDept() {
        return deliDept;
    }

    /** 納入者部課（現地語） */
    public void setDeliDept(String deliDept) {
        this.deliDept = deliDept;
    }

    /** 納入者氏名（現地語） */
    public String getDeliAttention() {
        return deliAttention;
    }

    /** 納入者氏名（現地語） */
    public void setDeliAttention(String deliAttention) {
        this.deliAttention = deliAttention;
    }

    /** ブランドコード */
    public String getBrandCd() {
        return brandCd;
    }

    /** ブランドコード */
    public void setBrandCd(String brandCd) {
        this.brandCd = brandCd;
    }

    /** ブランド名（英語） */
    public String getBrandNameEn() {
        return brandNameEn;
    }

    /** ブランド名（英語） */
    public void setBrandNameEn(String brandNameEn) {
        this.brandNameEn = brandNameEn;
    }

    /** 運賃エリアコード */
    public String getFrtAreaCd() {
        return frtAreaCd;
    }

    /** 運賃エリアコード */
    public void setFrtAreaCd(String frtAreaCd) {
        this.frtAreaCd = frtAreaCd;
    }

    /** ブランド名(現地語) */
    public String getBrandName() {
        return brandName;
    }

    /** ブランド名(現地語) */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /** ミスミ商品コード */
    public String getMisumiProductCd() {
        return misumiProductCd;
    }

    /** ミスミ商品コード */
    public void setMisumiProductCd(String misumiProductCd) {
        this.misumiProductCd = misumiProductCd;
    }

    /** 発注入り数 */
    public String getPoQtyPerCase() {
        return poQtyPerCase;
    }

    /** 発注入り数 */
    public void setPoQtyPerCase(String poQtyPerCase) {
        this.poQtyPerCase = poQtyPerCase;
    }

    /** 入荷ラベル発注番号 */
    public String getBarcodeGlobalNo() {
        return barcodeGlobalNo;
    }

    /** 入荷ラベル発注番号 */
    public void setBarcodeGlobalNo(String barcodeGlobalNo) {
        this.barcodeGlobalNo = barcodeGlobalNo;
    }

    /** 納品書番号 */
    public String getPackingNo() {
        return packingNo;
    }

    /** 納品書番号 */
    public void setPackingNo(String packingNo) {
        this.packingNo = packingNo;
    }

    /** 輸出フラグ */
    public String getExportFlg() {
        return exportFlg;
    }

    /** 輸出フラグ */
    public void setExportFlg(String exportFlg) {
        this.exportFlg = exportFlg;
    }

    /** 箱番号 */
    public String getBoxNo() {
        return boxNo;
    }

    /** 箱番号 */
    public void setBoxNo(String boxNo) {
        this.boxNo = boxNo;
    }

    /** Commercial Invoiceフラグ */
    public String getComInvFlg() {
        return comInvFlg;
    }

    /** Commercial Invoiceフラグ */
    public void setComInvFlg(String comInvFlg) {
        this.comInvFlg = comInvFlg;
    }

    /** Commercial Invoice出力枚数(オリジナル) */
    public String getComInvPrintNumOrgn() {
        return comInvPrintNumOrgn;
    }

    /** Commercial Invoice出力枚数(オリジナル) */
    public void setComInvPrintNumOrgn(String comInvPrintNumOrgn) {
        this.comInvPrintNumOrgn = comInvPrintNumOrgn;
    }

    /** Commercial Invoice出力枚数(控え) */
    public String getComInvPrintNumCopy() {
        return comInvPrintNumCopy;
    }

    /** Commercial Invoice出力枚数(控え) */
    public void setComInvPrintNumCopy(String comInvPrintNumCopy) {
        this.comInvPrintNumCopy = comInvPrintNumCopy;
    }

    /** Commercial Invoice保存フラグ */
    public String getComInvRetainFlg() {
        return comInvRetainFlg;
    }

    /** Commercial Invoice保存フラグ */
    public void setComInvRetainFlg(String comInvRetainFlg) {
        this.comInvRetainFlg = comInvRetainFlg;
    }

    /** Delivery Orderフラグ */
    public String getDeliOrderFlg() {
        return deliOrderFlg;
    }

    /** Delivery Orderフラグ */
    public void setDeliOrderFlg(String deliOrderFlg) {
        this.deliOrderFlg = deliOrderFlg;
    }

    /** Delivery Order出力枚数(オリジナル) */
    public String getDeliOrderPrintNumOrgn() {
        return deliOrderPrintNumOrgn;
    }

    /** Delivery Order出力枚数(オリジナル) */
    public void setDeliOrderPrintNumOrgn(String deliOrderPrintNumOrgn) {
        this.deliOrderPrintNumOrgn = deliOrderPrintNumOrgn;
    }

    /** Delivery Order出力枚数(控え) */
    public String getDeliInvPrintNumCopy() {
        return deliInvPrintNumCopy;
    }

    /** Delivery Order出力枚数(控え) */
    public void setDeliInvPrintNumCopy(String deliInvPrintNumCopy) {
        this.deliInvPrintNumCopy = deliInvPrintNumCopy;
    }

    /** Delivery Order保存フラグ */
    public String getDeliOrderRetainFlg() {
        return deliOrderRetainFlg;
    }

    /** Delivery Order保存フラグ */
    public void setDeliOrderRetainFlg(String deliOrderRetainFlg) {
        this.deliOrderRetainFlg = deliOrderRetainFlg;
    }

    /** Packing Listフラグ */
    public String getPackListFlg() {
        return packListFlg;
    }

    /** Packing Listフラグ */
    public void setPackListFlg(String packListFlg) {
        this.packListFlg = packListFlg;
    }

    /** Packing List出力枚数(オリジナル) */
    public String getPackListPrintNumOrgn() {
        return packListPrintNumOrgn;
    }

    /** Packing List出力枚数(オリジナル) */
    public void setPackListPrintNumOrgn(String packListPrintNumOrgn) {
        this.packListPrintNumOrgn = packListPrintNumOrgn;
    }

    /** Packing List出力枚数(控え) */
    public String getPackListPrintNumCopy() {
        return packListPrintNumCopy;
    }

    /** Packing List出力枚数(控え) */
    public void setPackListPrintNumCopy(String packListPrintNumCopy) {
        this.packListPrintNumCopy = packListPrintNumCopy;
    }

    /** Packing List保存フラグ */
    public String getPackListSaveFlg() {
        return packListSaveFlg;
    }

    /** Packing List保存フラグ */
    public void setPackListSaveFlg(String packListSaveFlg) {
        this.packListSaveFlg = packListSaveFlg;
    }

    /** Invoice&Packing Listフラグ */
    public String getInvPackFlg() {
        return invPackFlg;
    }

    /** Invoice&Packing Listフラグ */
    public void setInvPackFlg(String invPackFlg) {
        this.invPackFlg = invPackFlg;
    }

    /** Invoice&Packing List出力枚数(オリジナル) */
    public String getInvPackPrintNumOrgn() {
        return invPackPrintNumOrgn;
    }

    /** Invoice&Packing List出力枚数(オリジナル) */
    public void setInvPackPrintNumOrgn(String invPackPrintNumOrgn) {
        this.invPackPrintNumOrgn = invPackPrintNumOrgn;
    }

    /** Invoice&Packing List出力枚数(控え) */
    public String getInvPackPrintNumCopy() {
        return invPackPrintNumCopy;
    }

    /** Invoice&Packing List出力枚数(控え) */
    public void setInvPackPrintNumCopy(String invPackPrintNumCopy) {
        this.invPackPrintNumCopy = invPackPrintNumCopy;
    }

    /** Invoice&Packing List保存フラグ */
    public String getInvPackRetainFlg() {
        return invPackRetainFlg;
    }

    /** Invoice&Packing List保存フラグ */
    public void setInvPackRetainFlg(String invPackRetainFlg) {
        this.invPackRetainFlg = invPackRetainFlg;
    }

    /** HSコード */
    public String getHsCd() {
        return hsCd;
    }

    /** HSコード */
    public void setHsCd(String hsCd) {
        this.hsCd = hsCd;
    }

    /** 現法名称 */
    public String getSubsidiaryName() {
        return subsidiaryName;
    }

    /** 現法名称 */
    public void setSubsidiaryName(String subsidiaryName) {
        this.subsidiaryName = subsidiaryName;
    }

    /** 現法住所1 */
    public String getSubsidiaryAddress_1() {
        return subsidiaryAddress_1;
    }

    /** 現法住所1 */
    public void setSubsidiaryAddress_1(String subsidiaryAddress_1) {
        this.subsidiaryAddress_1 = subsidiaryAddress_1;
    }

    /** 現法住所2 */
    public String getSubsidiaryAddress_2() {
        return subsidiaryAddress_2;
    }

    /** 現法住所2 */
    public void setSubsidiaryAddress_2(String subsidiaryAddress_2) {
        this.subsidiaryAddress_2 = subsidiaryAddress_2;
    }

    /** 現法住所3 */
    public String getSubsidiaryAddress_3() {
        return subsidiaryAddress_3;
    }

    /** 現法住所3 */
    public void setSubsidiaryAddress_3(String subsidiaryAddress_3) {
        this.subsidiaryAddress_3 = subsidiaryAddress_3;
    }

    /** 現法住所4 */
    public String getSubsidiaryAddress_4() {
        return subsidiaryAddress_4;
    }

    /** 現法住所4 */
    public void setSubsidiaryAddress_4(String subsidiaryAddress_4) {
        this.subsidiaryAddress_4 = subsidiaryAddress_4;
    }

    /** 現法電話番号 */
    public String getSubsidiaryTel() {
        return subsidiaryTel;
    }

    /** 現法電話番号 */
    public void setSubsidiaryTel(String subsidiaryTel) {
        this.subsidiaryTel = subsidiaryTel;
    }

    /** 現法FAX番号 */
    public String getSubsidiaryFax() {
        return subsidiaryFax;
    }

    /** 現法FAX番号 */
    public void setSubsidiaryFax(String subsidiaryFax) {
        this.subsidiaryFax = subsidiaryFax;
    }

    /** 現法郵便番号 */
    public String getSubsidiaryPostalCd() {
        return subsidiaryPostalCd;
    }

    /** 現法郵便番号 */
    public void setSubsidiaryPostalCd(String subsidiaryPostalCd) {
        this.subsidiaryPostalCd = subsidiaryPostalCd;
    }

    /** 現法国コード */
    public String getSubsidiaryCountryCd() {
        return subsidiaryCountryCd;
    }

    /** 現法国コード */
    public void setSubsidiaryCountryCd(String subsidiaryCountryCd) {
        this.subsidiaryCountryCd = subsidiaryCountryCd;
    }

    /** 現法国名 */
    public String getSubsidiaryCountryName() {
        return subsidiaryCountryName;
    }

    /** 現法国名 */
    public void setSubsidiaryCountryName(String subsidiaryCountryName) {
        this.subsidiaryCountryName = subsidiaryCountryName;
    }

    /** 現法登録番号 */
    public String getSubsidiaryLicenceNo() {
        return subsidiaryLicenceNo;
    }

    /** 現法登録番号 */
    public void setSubsidiaryLicenceNo(String subsidiaryLicenceNo) {
        this.subsidiaryLicenceNo = subsidiaryLicenceNo;
    }

    /** 現法税登録番号 */
    public String getSubsidiaryVatRegistrationNumber() {
        return subsidiaryVatRegistrationNumber;
    }

    /** 現法税登録番号 */
    public void setSubsidiaryVatRegistrationNumber(String subsidiaryVatRegistrationNumber) {
        this.subsidiaryVatRegistrationNumber = subsidiaryVatRegistrationNumber;
    }

    /** エコール得意先コード */
    public String getEcalCustCd() {
        return ecalCustCd;
    }

    /** エコール得意先コード */
    public void setEcalCustCd(String ecalCustCd) {
        this.ecalCustCd = ecalCustCd;
    }

    /** 得意先名称（現地語） */
    public String getCustName() {
        return custName;
    }

    /** 得意先名称（現地語） */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /** 得意先名称（英語） */
    public String getCustNameEn() {
        return custNameEn;
    }

    /** 得意先名称（英語） */
    public void setCustNameEn(String custNameEn) {
        this.custNameEn = custNameEn;
    }

    /** 得意先住所1 */
    public String getCustAddress_1() {
        return custAddress_1;
    }

    /** 得意先住所1 */
    public void setCustAddress_1(String custAddress_1) {
        this.custAddress_1 = custAddress_1;
    }

    /** 得意先住所2 */
    public String getCustAddress_2() {
        return custAddress_2;
    }

    /** 得意先住所2 */
    public void setCustAddress_2(String custAddress_2) {
        this.custAddress_2 = custAddress_2;
    }

    /** 得意先住所3 */
    public String getCustAddress_3() {
        return custAddress_3;
    }

    /** 得意先住所3 */
    public void setCustAddress_3(String custAddress_3) {
        this.custAddress_3 = custAddress_3;
    }

    /** 得意先住所4 */
    public String getCustAddress_4() {
        return custAddress_4;
    }

    /** 得意先住所4 */
    public void setCustAddress_4(String custAddress_4) {
        this.custAddress_4 = custAddress_4;
    }

    /** 得意先部署名 */
    public String getCustDeptName() {
        return custDeptName;
    }

    /** 得意先部署名 */
    public void setCustDeptName(String custDeptName) {
        this.custDeptName = custDeptName;
    }

    /** 得意先郵便番号 */
    public String getCustPostalNo() {
        return custPostalNo;
    }

    /** 得意先郵便番号 */
    public void setCustPostalNo(String custPostalNo) {
        this.custPostalNo = custPostalNo;
    }

    /** 得意先国コード */
    public String getCustCountryCd() {
        return custCountryCd;
    }

    /** 得意先国コード */
    public void setCustCountryCd(String custCountryCd) {
        this.custCountryCd = custCountryCd;
    }

    /** 得意先国コード(UPS) */
    public String getCustCountryCdUps() {
        return custCountryCdUps;
    }

    /** 得意先国コード(UPS) */
    public void setCustCountryCdUps(String custCountryCdUps) {
        this.custCountryCdUps = custCountryCdUps;
    }

    /** 得意先国名 */
    public String getCustCountryName() {
        return custCountryName;
    }

    /** 得意先国名 */
    public void setCustCountryName(String custCountryName) {
        this.custCountryName = custCountryName;
    }

    /** 得意先都市名 */
    public String getCustCityName() {
        return custCityName;
    }

    /** 得意先都市名 */
    public void setCustCityName(String custCityName) {
        this.custCityName = custCityName;
    }

    /** 得意先電話番号 */
    public String getCustTel() {
        return custTel;
    }

    /** 得意先電話番号 */
    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    /** 得意先FAX番号 */
    public String getCustFax() {
        return custFax;
    }

    /** 得意先FAX番号 */
    public void setCustFax(String custFax) {
        this.custFax = custFax;
    }

    /** 得意先担当者 */
    public String getCustAttention() {
        return custAttention;
    }

    /** 得意先担当者 */
    public void setCustAttention(String custAttention) {
        this.custAttention = custAttention;
    }

    /** 明細コメント */
    public String getDtlComment() {
        return dtlComment;
    }

    /** 明細コメント */
    public void setDtlComment(String dtlComment) {
        this.dtlComment = dtlComment;
    }

    /** 事務指示１フラグ */
    public String getBusinessinstruct1ShowFlg() {
        return businessinstruct1ShowFlg;
    }

    /** 事務指示１フラグ */
    public void setBusinessinstruct1ShowFlg(String businessinstruct1ShowFlg) {
        this.businessinstruct1ShowFlg = businessinstruct1ShowFlg;
    }

    /** 事務指示１ */
    public String getNtvBusinessinstruct1() {
        return ntvBusinessinstruct1;
    }

    /** 事務指示１ */
    public void setNtvBusinessinstruct1(String ntvBusinessinstruct1) {
        this.ntvBusinessinstruct1 = ntvBusinessinstruct1;
    }

    /** 事務指示２フラグ */
    public String getBusinessinstruct2ShowFlg() {
        return businessinstruct2ShowFlg;
    }

    /** 事務指示２フラグ */
    public void setBusinessinstruct2ShowFlg(String businessinstruct2ShowFlg) {
        this.businessinstruct2ShowFlg = businessinstruct2ShowFlg;
    }

    /** 事務指示２ */
    public String getNtvBusinessinstruct2() {
        return ntvBusinessinstruct2;
    }

    /** 事務指示２ */
    public void setNtvBusinessinstruct2(String ntvBusinessinstruct2) {
        this.ntvBusinessinstruct2 = ntvBusinessinstruct2;
    }

    /** 梱包指示１フラグ */
    public String getPackingInstruct1ShowFlg() {
        return packingInstruct1ShowFlg;
    }

    /** 梱包指示１フラグ */
    public void setPackingInstruct1ShowFlg(String packingInstruct1ShowFlg) {
        this.packingInstruct1ShowFlg = packingInstruct1ShowFlg;
    }

    /** 梱包指示１ */
    public String getNtvPackingInstruct1() {
        return ntvPackingInstruct1;
    }

    /** 梱包指示１ */
    public void setNtvPackingInstruct1(String ntvPackingInstruct1) {
        this.ntvPackingInstruct1 = ntvPackingInstruct1;
    }

    /** 梱包指示２フラグ */
    public String getPackingInstruct2ShowFlg() {
        return packingInstruct2ShowFlg;
    }

    /** 梱包指示２フラグ */
    public void setPackingInstruct2ShowFlg(String packingInstruct2ShowFlg) {
        this.packingInstruct2ShowFlg = packingInstruct2ShowFlg;
    }

    /** 梱包指示２ */
    public String getNtvPackingInstruct2() {
        return ntvPackingInstruct2;
    }

    /** 梱包指示２ */
    public void setNtvPackingInstruct2(String ntvPackingInstruct2) {
        this.ntvPackingInstruct2 = ntvPackingInstruct2;
    }

    /** CS指示 */
    public String getCsInstruct() {
        return csInstruct;
    }

    /** CS指示 */
    public void setCsInstruct(String csInstruct) {
        this.csInstruct = csInstruct;
    }

    /** 企業ライセンス番号 */
    public String getCustOfficeLicenseNo() {
        return custOfficeLicenseNo;
    }

    /** 企業ライセンス番号 */
    public void setCustOfficeLicenseNo(String custOfficeLicenseNo) {
        this.custOfficeLicenseNo = custOfficeLicenseNo;
    }

    /** 売掛先コード */
    public String getBillToCd() {
        return billToCd;
    }

    /** 売掛先コード */
    public void setBillToCd(String billToCd) {
        this.billToCd = billToCd;
    }

    /** 売掛先名 */
    public String getBillToName() {
        return billToName;
    }

    /** 売掛先名 */
    public void setBillToName(String billToName) {
        this.billToName = billToName;
    }

    /** 売掛先住所1 */
    public String getBillToAddress_1() {
        return billToAddress_1;
    }

    /** 売掛先住所1 */
    public void setBillToAddress_1(String billToAddress_1) {
        this.billToAddress_1 = billToAddress_1;
    }

    /** 売掛先住所2 */
    public String getBillToAddress_2() {
        return billToAddress_2;
    }

    /** 売掛先住所2 */
    public void setBillToAddress_2(String billToAddress_2) {
        this.billToAddress_2 = billToAddress_2;
    }

    /** 売掛先住所3 */
    public String getBillToAddress_3() {
        return billToAddress_3;
    }

    /** 売掛先住所3 */
    public void setBillToAddress_3(String billToAddress_3) {
        this.billToAddress_3 = billToAddress_3;
    }

    /** 売掛先住所4 */
    public String getBillToAddress_4() {
        return billToAddress_4;
    }

    /** 売掛先住所4 */
    public void setBillToAddress_4(String billToAddress_4) {
        this.billToAddress_4 = billToAddress_4;
    }

    /** 売掛先部署名 */
    public String getBillToNtvBillToDept() {
        return billToNtvBillToDept;
    }

    /** 売掛先部署名 */
    public void setBillToNtvBillToDept(String billToNtvBillToDept) {
        this.billToNtvBillToDept = billToNtvBillToDept;
    }

    /** 売掛先郵便番号 */
    public String getBillToPostalCd() {
        return billToPostalCd;
    }

    /** 売掛先郵便番号 */
    public void setBillToPostalCd(String billToPostalCd) {
        this.billToPostalCd = billToPostalCd;
    }

    /** 売掛先国コード */
    public String getBillToCountryCd() {
        return billToCountryCd;
    }

    /** 売掛先国コード */
    public void setBillToCountryCd(String billToCountryCd) {
        this.billToCountryCd = billToCountryCd;
    }

    /** 売掛先国名 */
    public String getBillToCountryName() {
        return billToCountryName;
    }

    /** 売掛先国名 */
    public void setBillToCountryName(String billToCountryName) {
        this.billToCountryName = billToCountryName;
    }

    /** 売掛先電話番号 */
    public String getBillToTel() {
        return billToTel;
    }

    /** 売掛先電話番号 */
    public void setBillToTel(String billToTel) {
        this.billToTel = billToTel;
    }

    /** 売掛先FAX番号 */
    public String getBillToFax() {
        return billToFax;
    }

    /** 売掛先FAX番号 */
    public void setBillToFax(String billToFax) {
        this.billToFax = billToFax;
    }

    /** 売掛先担当者 */
    public String getNtvBillToPerson() {
        return ntvBillToPerson;
    }

    /** 売掛先担当者 */
    public void setNtvBillToPerson(String ntvBillToPerson) {
        this.ntvBillToPerson = ntvBillToPerson;
    }

    /** 売掛注釈1 */
    public String getNtvReceivableRemarks_1() {
        return ntvReceivableRemarks_1;
    }

    /** 売掛注釈1 */
    public void setNtvReceivableRemarks_1(String ntvReceivableRemarks_1) {
        this.ntvReceivableRemarks_1 = ntvReceivableRemarks_1;
    }

    /** 売掛注釈2 */
    public String getNtvReceivableRemarks_2() {
        return ntvReceivableRemarks_2;
    }

    /** 売掛注釈2 */
    public void setNtvReceivableRemarks_2(String ntvReceivableRemarks_2) {
        this.ntvReceivableRemarks_2 = ntvReceivableRemarks_2;
    }

    /** 直送先名 */
    public String getShipToName() {
        return shipToName;
    }

    /** 直送先名 */
    public void setShipToName(String shipToName) {
        this.shipToName = shipToName;
    }

    /** 直送先住所1 */
    public String getShipToAddress_1() {
        return shipToAddress_1;
    }

    /** 直送先住所1 */
    public void setShipToAddress_1(String shipToAddress_1) {
        this.shipToAddress_1 = shipToAddress_1;
    }

    /** 直送先住所2 */
    public String getShipToAddress_2() {
        return shipToAddress_2;
    }

    /** 直送先住所2 */
    public void setShipToAddress_2(String shipToAddress_2) {
        this.shipToAddress_2 = shipToAddress_2;
    }

    /** 直送先住所3 */
    public String getShipToAddress_3() {
        return shipToAddress_3;
    }

    /** 直送先住所3 */
    public void setShipToAddress_3(String shipToAddress_3) {
        this.shipToAddress_3 = shipToAddress_3;
    }

    /** 直送先住所4 */
    public String getShipToAddress_4() {
        return shipToAddress_4;
    }

    /** 直送先住所4 */
    public void setShipToAddress_4(String shipToAddress_4) {
        this.shipToAddress_4 = shipToAddress_4;
    }

    /** 直送先部署名 */
    public String getShipToDeptName() {
        return shipToDeptName;
    }

    /** 直送先部署名 */
    public void setShipToDeptName(String shipToDeptName) {
        this.shipToDeptName = shipToDeptName;
    }

    /** 直送先郵便番号 */
    public String getShipToPostalNo() {
        return shipToPostalNo;
    }

    /** 直送先郵便番号 */
    public void setShipToPostalNo(String shipToPostalNo) {
        this.shipToPostalNo = shipToPostalNo;
    }

    /** 直送先国コード */
    public String getShipToCountryCd() {
        return shipToCountryCd;
    }

    /** 直送先国コード */
    public void setShipToCountryCd(String shipToCountryCd) {
        this.shipToCountryCd = shipToCountryCd;
    }

    /** 直送先国コード(UPS) */
    public String getShipUpsCountryCd() {
        return shipUpsCountryCd;
    }

    /** 直送先国コード(UPS) */
    public void setShipUpsCountryCd(String shipUpsCountryCd) {
        this.shipUpsCountryCd = shipUpsCountryCd;
    }

    /** 直送先国名 */
    public String getShipToCountryName() {
        return shipToCountryName;
    }

    /** 直送先国名 */
    public void setShipToCountryName(String shipToCountryName) {
        this.shipToCountryName = shipToCountryName;
    }

    /** 直送先都市名 */
    public String getShipToCityName() {
        return shipToCityName;
    }

    /** 直送先都市名 */
    public void setShipToCityName(String shipToCityName) {
        this.shipToCityName = shipToCityName;
    }

    /** 直送先電話番号 */
    public String getShipToTel() {
        return shipToTel;
    }

    /** 直送先電話番号 */
    public void setShipToTel(String shipToTel) {
        this.shipToTel = shipToTel;
    }

    /** 直送先FAX番号 */
    public String getShipToFax() {
        return shipToFax;
    }

    /** 直送先FAX番号 */
    public void setShipToFax(String shipToFax) {
        this.shipToFax = shipToFax;
    }

    /** 直送先担当者 */
    public String getShipToAttention() {
        return shipToAttention;
    }

    /** 直送先担当者 */
    public void setShipToAttention(String shipToAttention) {
        this.shipToAttention = shipToAttention;
    }

    /** Sub1置場 */
    public String getSub1PlantCd() {
        return sub1PlantCd;
    }

    /** Sub1置場 */
    public void setSub1PlantCd(String sub1PlantCd) {
        this.sub1PlantCd = sub1PlantCd;
    }

    /** Sub1部門名 */
    public String getSub1DeptName() {
        return sub1DeptName;
    }

    /** Sub1部門名 */
    public void setSub1DeptName(String sub1DeptName) {
        this.sub1DeptName = sub1DeptName;
    }

    /** Sub1住所1 */
    public String getSub1DeptAddress_1() {
        return sub1DeptAddress_1;
    }

    /** Sub1住所1 */
    public void setSub1DeptAddress_1(String sub1DeptAddress_1) {
        this.sub1DeptAddress_1 = sub1DeptAddress_1;
    }

    /** Sub1住所2 */
    public String getSub1DeptAddress_2() {
        return sub1DeptAddress_2;
    }

    /** Sub1住所2 */
    public void setSub1DeptAddress_2(String sub1DeptAddress_2) {
        this.sub1DeptAddress_2 = sub1DeptAddress_2;
    }

    /** Sub1住所3 */
    public String getSub1DeptAddress_3() {
        return sub1DeptAddress_3;
    }

    /** Sub1住所3 */
    public void setSub1DeptAddress_3(String sub1DeptAddress_3) {
        this.sub1DeptAddress_3 = sub1DeptAddress_3;
    }

    /** Sub1住所4 */
    public String getSub1DeptAddress_4() {
        return sub1DeptAddress_4;
    }

    /** Sub1住所4 */
    public void setSub1DeptAddress_4(String sub1DeptAddress_4) {
        this.sub1DeptAddress_4 = sub1DeptAddress_4;
    }

    /** Sub1郵便番号 */
    public String getSub1DeptPostalCd() {
        return sub1DeptPostalCd;
    }

    /** Sub1郵便番号 */
    public void setSub1DeptPostalCd(String sub1DeptPostalCd) {
        this.sub1DeptPostalCd = sub1DeptPostalCd;
    }

    /** Sub1国コード */
    public String getSub1DeptCountryCd() {
        return sub1DeptCountryCd;
    }

    /** Sub1国コード */
    public void setSub1DeptCountryCd(String sub1DeptCountryCd) {
        this.sub1DeptCountryCd = sub1DeptCountryCd;
    }

    /** Sub1電話番号 */
    public String getSub1DeptTel() {
        return sub1DeptTel;
    }

    /** Sub1電話番号 */
    public void setSub1DeptTel(String sub1DeptTel) {
        this.sub1DeptTel = sub1DeptTel;
    }

    /** Sub1ＦＡＸ番号 */
    public String getSub1DeptFax() {
        return sub1DeptFax;
    }

    /** Sub1ＦＡＸ番号 */
    public void setSub1DeptFax(String sub1DeptFax) {
        this.sub1DeptFax = sub1DeptFax;
    }

    /** 扱い便区分 */
    public String getShippingDestinationCd() {
        return shippingDestinationCd;
    }

    /** 扱い便区分 */
    public void setShippingDestinationCd(String shippingDestinationCd) {
        this.shippingDestinationCd = shippingDestinationCd;
    }

    /** 配送業者名 */
    public String getCarrierName() {
        return carrierName;
    }

    /** 配送業者名 */
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    /** 配送業者名略称 */
    public String getCarrierNameKana() {
        return carrierNameKana;
    }

    /** 配送業者名略称 */
    public void setCarrierNameKana(String carrierNameKana) {
        this.carrierNameKana = carrierNameKana;
    }

    /** 支払い方法 */
    public String getPaymentTerms() {
        return paymentTerms;
    }

    /** 支払い方法 */
    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    /** インコタームズ */
    public String getIncoterms() {
        return incoterms;
    }

    /** インコタームズ */
    public void setIncoterms(String incoterms) {
        this.incoterms = incoterms;
    }

    /** 支払い形態 */
    public String getSettlementMethod() {
        return settlementMethod;
    }

    /** 支払い形態 */
    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    /** 商品総称フラグ */
    public String getProductGenericNameFlg() {
        return productGenericNameFlg;
    }

    /** 商品総称フラグ */
    public void setProductGenericNameFlg(String productGenericNameFlg) {
        this.productGenericNameFlg = productGenericNameFlg;
    }

    /** 伝票区分 */
    public String getVoucherDiv() {
        return voucherDiv;
    }

    /** 伝票区分 */
    public void setVoucherDiv(String voucherDiv) {
        this.voucherDiv = voucherDiv;
    }

    /** 税金エリアコード */
    public String getTaxAreaCd() {
        return taxAreaCd;
    }

    /** 税金エリアコード */
    public void setTaxAreaCd(String taxAreaCd) {
        this.taxAreaCd = taxAreaCd;
    }

    /** 非課税フラグ */
    public String getTaxFreeFlg() {
        return taxFreeFlg;
    }

    /** 非課税フラグ */
    public void setTaxFreeFlg(String taxFreeFlg) {
        this.taxFreeFlg = taxFreeFlg;
    }

    /** 統一発票タイプ */
    public String getUniformInvType() {
        return uniformInvType;
    }

    /** 統一発票タイプ */
    public void setUniformInvType(String uniformInvType) {
        this.uniformInvType = uniformInvType;
    }

    /** 売掛金締め単位 */
    public String getArCloseUnit() {
        return arCloseUnit;
    }

    /** 売掛金締め単位 */
    public void setArCloseUnit(String arCloseUnit) {
        this.arCloseUnit = arCloseUnit;
    }

    /** 売掛金締日 */
    public String getArClosingDay() {
        return arClosingDay;
    }

    /** 売掛金締日 */
    public void setArClosingDay(String arClosingDay) {
        this.arClosingDay = arClosingDay;
    }

    /** 最終得意先コード */
    public String getFinalCustsubCustCd() {
        return finalCustsubCustCd;
    }

    /** 最終得意先コード */
    public void setFinalCustsubCustCd(String finalCustsubCustCd) {
        this.finalCustsubCustCd = finalCustsubCustCd;
    }

    /** 最終得意先名(現地語） */
    public String getFinalCustName() {
        return finalCustName;
    }

    /** 最終得意先名(現地語） */
    public void setFinalCustName(String finalCustName) {
        this.finalCustName = finalCustName;
    }

    /** 最終得意先名（英語） */
    public String getFinalCustNameEn() {
        return finalCustNameEn;
    }

    /** 最終得意先名（英語） */
    public void setFinalCustNameEn(String finalCustNameEn) {
        this.finalCustNameEn = finalCustNameEn;
    }

    /** 最終直送先コード */
    public String getFinalCustsubShipToCd() {
        return finalCustsubShipToCd;
    }

    /** 最終直送先コード */
    public void setFinalCustsubShipToCd(String finalCustsubShipToCd) {
        this.finalCustsubShipToCd = finalCustsubShipToCd;
    }

    /** 最終直送先名 */
    public String getFinalShipToName() {
        return finalShipToName;
    }

    /** 最終直送先名 */
    public void setFinalShipToName(String finalShipToName) {
        this.finalShipToName = finalShipToName;
    }

    /** 受注伝票番号 */
    public String getSoVoucherNo() {
        return soVoucherNo;
    }

    /** 受注伝票番号 */
    public void setSoVoucherNo(String soVoucherNo) {
        this.soVoucherNo = soVoucherNo;
    }

    /** 受注年月日 */
    public String getSoDate() {
        return soDate;
    }

    /** 受注年月日 */
    public void setSoDate(String soDate) {
        this.soDate = soDate;
    }

    /** 商品名 */
    public String getProductName() {
        return productName;
    }

    /** 商品名 */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /** 単位重量 */
    public String getWeight() {
        return weight;
    }

    /** 単位重量 */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /** 重量単位 */
    public String getWeightUnit() {
        return weightUnit;
    }

    /** 重量単位 */
    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    /** 原産国名表示フラグ */
    public String getCountryOfOrignShowFlg() {
        return countryOfOrignShowFlg;
    }

    /** 原産国名表示フラグ */
    public void setCountryOfOrignShowFlg(String countryOfOrignShowFlg) {
        this.countryOfOrignShowFlg = countryOfOrignShowFlg;
    }

    /** 原産国コード */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /** 原産国コード */
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    /** 原産国名 */
    public String getCountryNameOfOrigin() {
        return countryNameOfOrigin;
    }

    /** 原産国名 */
    public void setCountryNameOfOrigin(String countryNameOfOrigin) {
        this.countryNameOfOrigin = countryNameOfOrigin;
    }

    /** 寸法単位 */
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    /** 寸法単位 */
    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    /** 売通貨単位 */
    public String getSUnitPriceCcyCd() {
        return sUnitPriceCcyCd;
    }

    /** 売通貨単位 */
    public void setSUnitPriceCcyCd(String sUnitPriceCcyCd) {
        this.sUnitPriceCcyCd = sUnitPriceCcyCd;
    }

    /** 仕入通貨単位 */
    public String getPUnitPriceCcyCd() {
        return pUnitPriceCcyCd;
    }

    /** 仕入通貨単位 */
    public void setPUnitPriceCcyCd(String pUnitPriceCcyCd) {
        this.pUnitPriceCcyCd = pUnitPriceCcyCd;
    }

    /** 総重量 */
    public String getTotalOfWeight() {
        return totalOfWeight;
    }

    /** 総重量 */
    public void setTotalOfWeight(String totalOfWeight) {
        this.totalOfWeight = totalOfWeight;
    }

    /** 数量合計 */
    public String getSumQty() {
        return sumQty;
    }

    /** 数量合計 */
    public void setSumQty(String sumQty) {
        this.sumQty = sumQty;
    }

    /** 受注金額 */
    public String getSoAmt() {
        return soAmt;
    }

    /** 受注金額 */
    public void setSoAmt(String soAmt) {
        this.soAmt = soAmt;
    }

    /** 税込み売単価 */
    public String getInTaxSPrice() {
        return inTaxSPrice;
    }

    /** 税込み売単価 */
    public void setInTaxSPrice(String inTaxSPrice) {
        this.inTaxSPrice = inTaxSPrice;
    }

    /** 受注金額小計 */
    public String getSoAmtSum() {
        return soAmtSum;
    }

    /** 受注金額小計 */
    public void setSoAmtSum(String soAmtSum) {
        this.soAmtSum = soAmtSum;
    }

    /** 合計税金額 */
    public String getTotalTaxAmt() {
        return totalTaxAmt;
    }

    /** 合計税金額 */
    public void setTotalTaxAmt(String totalTaxAmt) {
        this.totalTaxAmt = totalTaxAmt;
    }

    /** 割引費 */
    public String getOffAmt() {
        return offAmt;
    }

    /** 割引費 */
    public void setOffAmt(String offAmt) {
        this.offAmt = offAmt;
    }

    /** その他値引額 */
    public String getOtherDsctAmount() {
        return otherDsctAmount;
    }

    /** その他値引額 */
    public void setOtherDsctAmount(String otherDsctAmount) {
        this.otherDsctAmount = otherDsctAmount;
    }

    /** 運賃値引フラグ */
    public String getFrtDiscountFlg() {
        return frtDiscountFlg;
    }

    /** 運賃値引フラグ */
    public void setFrtDiscountFlg(String frtDiscountFlg) {
        this.frtDiscountFlg = frtDiscountFlg;
    }

    /** 総合計額 */
    public String getTotalAmt() {
        return totalAmt;
    }

    /** 総合計額 */
    public void setTotalAmt(String totalAmt) {
        this.totalAmt = totalAmt;
    }

    /** オリジナルINVOICENO */
    public String getOriginalInvoiceNo() {
        return originalInvoiceNo;
    }

    /** オリジナルINVOICENO */
    public void setOriginalInvoiceNo(String originalInvoiceNo) {
        this.originalInvoiceNo = originalInvoiceNo;
    }

    /** ジャーナル日付 */
    public String getJournalDt() {
        return journalDt;
    }

    /** ジャーナル日付 */
    public void setJournalDt(String journalDt) {
        this.journalDt = journalDt;
    }

    /** オリジナルInvoiceDate */
    public String getOriginalInvoiceDt() {
        return originalInvoiceDt;
    }

    /** オリジナルInvoiceDate */
    public void setOriginalInvoiceDt(String originalInvoiceDt) {
        this.originalInvoiceDt = originalInvoiceDt;
    }

    /** オリジナルグローバル番号 */
    public String getOriginalGlobalNo() {
        return originalGlobalNo;
    }

    /** オリジナルグローバル番号 */
    public void setOriginalGlobalNo(String originalGlobalNo) {
        this.originalGlobalNo = originalGlobalNo;
    }

    /** オリジナル受注伝票番号 */
    public String getOriginalSoVoucherNo() {
        return originalSoVoucherNo;
    }

    /** オリジナル受注伝票番号 */
    public void setOriginalSoVoucherNo(String originalSoVoucherNo) {
        this.originalSoVoucherNo = originalSoVoucherNo;
    }

    /** 理由コード */
    public String getReasonCd() {
        return reasonCd;
    }

    /** 理由コード */
    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    /** 理由内容 */
    public String getReasonContent() {
        return reasonContent;
    }

    /** 理由内容 */
    public void setReasonContent(String reasonContent) {
        this.reasonContent = reasonContent;
    }

    /** 元請求書合計金額 */
    public String getSrcSumAmt() {
        return srcSumAmt;
    }

    /** 元請求書合計金額 */
    public void setSrcSumAmt(String srcSumAmt) {
        this.srcSumAmt = srcSumAmt;
    }

    /** 修正額 */
    public String getDiffAmt() {
        return diffAmt;
    }

    /** 修正額 */
    public void setDiffAmt(String diffAmt) {
        this.diffAmt = diffAmt;
    }

    /** デビット/クレジット税金合計額 */
    public String getCreditTaxAmt() {
        return creditTaxAmt;
    }

    /** デビット/クレジット税金合計額 */
    public void setCreditTaxAmt(String creditTaxAmt) {
        this.creditTaxAmt = creditTaxAmt;
    }

    /** デビット/クレジット総金額 */
    public String getCreditSumAmt() {
        return creditSumAmt;
    }

    /** デビット/クレジット総金額 */
    public void setCreditSumAmt(String creditSumAmt) {
        this.creditSumAmt = creditSumAmt;
    }

    /** 出荷不可フラグ */
    public String getShipStopFlg() {
        return shipStopFlg;
    }

    /** 出荷不可フラグ */
    public void setShipStopFlg(String shipStopFlg) {
        this.shipStopFlg = shipStopFlg;
    }

    /** サプライヤーインボイス番号 */
    public String getSupplierInvNo() {
        return supplierInvNo;
    }

    /** サプライヤーインボイス番号 */
    public void setSupplierInvNo(String supplierInvNo) {
        this.supplierInvNo = supplierInvNo;
    }

    /** 顧客到着日 */
    public String getCrd() {
        return crd;
    }

    /** 顧客到着日 */
    public void setCrd(String crd) {
        this.crd = crd;
    }

    /** 所管部門コード */
    public String getDeptCd() {
        return deptCd;
    }

    /** 所管部門コード */
    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    /** 特別カスタマーBOX番号 */
    public String getSpecialCustBoxNo() {
        return specialCustBoxNo;
    }

    /** 特別カスタマーBOX番号 */
    public void setSpecialCustBoxNo(String specialCustBoxNo) {
        this.specialCustBoxNo = specialCustBoxNo;
    }

    /** 特別カスタマーBOXグループ */
    public String getSpecialCustBoxGrp() {
        return specialCustBoxGrp;
    }

    /** 特別カスタマーBOXグループ */
    public void setSpecialCustBoxGrp(String specialCustBoxGrp) {
        this.specialCustBoxGrp = specialCustBoxGrp;
    }

    /** 輸送手段 */
    public String getTransportMeans() {
        return transportMeans;
    }

    /** 輸送手段 */
    public void setTransportMeans(String transportMeans) {
        this.transportMeans = transportMeans;
    }

    /** 危険品フラグ */
    public String getHazardFlg() {
        return hazardFlg;
    }

    /** 危険品フラグ */
    public void setHazardFlg(String hazardFlg) {
        this.hazardFlg = hazardFlg;
    }

    /** CS窓口 */
    public String getCsWindow() {
        return csWindow;
    }

    /** CS窓口 */
    public void setCsWindow(String csWindow) {
        this.csWindow = csWindow;
    }

    /** 値引表示フラグ */
    public String getDiscountShowFlg() {
        return discountShowFlg;
    }

    /** 値引表示フラグ */
    public void setDiscountShowFlg(String discountShowFlg) {
        this.discountShowFlg = discountShowFlg;
    }

    /** HSコード表示フラグ */
    public String getHsCdShowFlg() {
        return hsCdShowFlg;
    }

    /** HSコード表示フラグ */
    public void setHsCdShowFlg(String hsCdShowFlg) {
        this.hsCdShowFlg = hsCdShowFlg;
    }

    /** NetWeight表示フラグ */
    public String getNetWeightShowFlg() {
        return netWeightShowFlg;
    }

    /** NetWeight表示フラグ */
    public void setNetWeightShowFlg(String netWeightShowFlg) {
        this.netWeightShowFlg = netWeightShowFlg;
    }

    /** 直送区分 */
    public String getDirectShipFlg() {
        return directShipFlg;
    }

    /** 直送区分 */
    public void setDirectShipFlg(String directShipFlg) {
        this.directShipFlg = directShipFlg;
    }

    /** 現法間取引フラグ */
    public String getSuppsubBusinessFlg() {
        return suppsubBusinessFlg;
    }

    /** 現法間取引フラグ */
    public void setSuppsubBusinessFlg(String suppsubBusinessFlg) {
        this.suppsubBusinessFlg = suppsubBusinessFlg;
    }

    /** 配送業者顧客番号 */
    public String getCarrierAcctNo() {
        return carrierAcctNo;
    }

    /** 配送業者顧客番号 */
    public void setCarrierAcctNo(String carrierAcctNo) {
        this.carrierAcctNo = carrierAcctNo;
    }

    /** サービス停止区分 */
    public String getServiceStopDiv() {
        return serviceStopDiv;
    }

    /** サービス停止区分 */
    public void setServiceStopDiv(String serviceStopDiv) {
        this.serviceStopDiv = serviceStopDiv;
    }

    /** 内税外税区分 */
    public String getTaxInExDiv() {
        return taxInExDiv;
    }

    /** 内税外税区分 */
    public void setTaxInExDiv(String taxInExDiv) {
        this.taxInExDiv = taxInExDiv;
    }

    /** 指定ＶＳＤ */
    public String getSpecifyVad() {
        return specifyVad;
    }

    /** 指定ＶＳＤ */
    public void setSpecifyVad(String specifyVad) {
        this.specifyVad = specifyVad;
    }

    /** 該非区分 */
    public String getIfDiv() {
        return ifDiv;
    }

    /** 該非区分 */
    public void setIfDiv(String ifDiv) {
        this.ifDiv = ifDiv;
    }

    /** 配達時間帯 */
    public String getDeliveryTime() {
        return deliveryTime;
    }

    /** 配達時間帯 */
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /** 送り状№回答区分 */
    public String getSendAnsDiv() {
        return sendAnsDiv;
    }

    /** 送り状№回答区分 */
    public void setSendAnsDiv(String sendAnsDiv) {
        this.sendAnsDiv = sendAnsDiv;
    }

    /** 着日指示コメント */
    public String getRdInstructComment() {
        return rdInstructComment;
    }

    /** 着日指示コメント */
    public void setRdInstructComment(String rdInstructComment) {
        this.rdInstructComment = rdInstructComment;
    }

    /** 配送日 */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /** 配送日 */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /** SCコード名称（漢字） */
    public String getScCodeName() {
        return scCodeName;
    }

    /** SCコード名称（漢字） */
    public void setScCodeName(String scCodeName) {
        this.scCodeName = scCodeName;
    }

    /** 得意先名(カナ) */
    public String getCustNameKana() {
        return custNameKana;
    }

    /** 得意先名(カナ) */
    public void setCustNameKana(String custNameKana) {
        this.custNameKana = custNameKana;
    }

    /** 着日指示フラグ */
    public String getRdInstructFlg() {
        return rdInstructFlg;
    }

    /** 着日指示フラグ */
    public void setRdInstructFlg(String rdInstructFlg) {
        this.rdInstructFlg = rdInstructFlg;
    }

    /** 注文部課名(漢字) */
    public String getNtvCustDept() {
        return ntvCustDept;
    }

    /** 注文部課名(漢字) */
    public void setNtvCustDept(String ntvCustDept) {
        this.ntvCustDept = ntvCustDept;
    }

    /** 注文担当者(漢字) */
    public String getNtvCustAttention() {
        return ntvCustAttention;
    }

    /** 注文担当者(漢字) */
    public void setNtvCustAttention(String ntvCustAttention) {
        this.ntvCustAttention = ntvCustAttention;
    }

    /** 商品名略称(カナ) */
    public String getProductNameKana() {
        return productNameKana;
    }

    /** 商品名略称(カナ) */
    public void setProductNameKana(String productNameKana) {
        this.productNameKana = productNameKana;
    }

    /** 別納区分 */
    public String getOtherDeliDiv() {
        return otherDeliDiv;
    }

    /** 別納区分 */
    public void setOtherDeliDiv(String otherDeliDiv) {
        this.otherDeliDiv = otherDeliDiv;
    }

    /** 消費税率 */
    public String getCtaxRate() {
        return ctaxRate;
    }

    /** 消費税率 */
    public void setCtaxRate(String ctaxRate) {
        this.ctaxRate = ctaxRate;
    }

    /** 置場区分 */
    public String getPlantDiv() {
        return plantDiv;
    }

    /** 置場区分 */
    public void setPlantDiv(String plantDiv) {
        this.plantDiv = plantDiv;
    }

    /** セル */
    public String getCellCd() {
        return cellCd;
    }

    /** セル */
    public void setCellCd(String cellCd) {
        this.cellCd = cellCd;
    }

    /** 注文者部課名（英語） */
    public String getCustDeptEn() {
        return custDeptEn;
    }

    /** 注文者部課名（英語） */
    public void setCustDeptEn(String custDeptEn) {
        this.custDeptEn = custDeptEn;
    }

    /** 注文担当者名（英語） */
    public String getCustAttentionEn() {
        return custAttentionEn;
    }

    /** 注文担当者名（英語） */
    public void setCustAttentionEn(String custAttentionEn) {
        this.custAttentionEn = custAttentionEn;
    }

    /** DMコード1 */
    public String getDmCd_1() {
        return dmCd_1;
    }

    /** DMコード1 */
    public void setDmCd_1(String dmCd_1) {
        this.dmCd_1 = dmCd_1;
    }

    /** DMコード2 */
    public String getDmCd_2() {
        return dmCd_2;
    }

    /** DMコード2 */
    public void setDmCd_2(String dmCd_2) {
        this.dmCd_2 = dmCd_2;
    }

    /** DMコード3 */
    public String getDmCd_3() {
        return dmCd_3;
    }

    /** DMコード3 */
    public void setDmCd_3(String dmCd_3) {
        this.dmCd_3 = dmCd_3;
    }

    /** DMコード4 */
    public String getDmCd_4() {
        return dmCd_4;
    }

    /** DMコード4 */
    public void setDmCd_4(String dmCd_4) {
        this.dmCd_4 = dmCd_4;
    }

    /** DMコード5 */
    public String getDmCd_5() {
        return dmCd_5;
    }

    /** DMコード5 */
    public void setDmCd_5(String dmCd_5) {
        this.dmCd_5 = dmCd_5;
    }

    /** 得意先メールアドレス */
    public String getCustMailAddress() {
        return custMailAddress;
    }

    /** 得意先メールアドレス */
    public void setCustMailAddress(String custMailAddress) {
        this.custMailAddress = custMailAddress;
    }

    /** 直送先メールアドレス */
    public String getShipToMailAddress() {
        return shipToMailAddress;
    }

    /** 直送先メールアドレス */
    public void setShipToMailAddress(String shipToMailAddress) {
        this.shipToMailAddress = shipToMailAddress;
    }

    /** 輸出国仕入単価 */
    public String getExportPurcUpri() {
        return exportPurcUpri;
    }

    /** 輸出国仕入単価 */
    public void setExportPurcUpri(String exportPurcUpri) {
        this.exportPurcUpri = exportPurcUpri;
    }

    /** 輸出国仕入単価通貨 */
    public String getExportPurcUpriCur() {
        return exportPurcUpriCur;
    }

    /** 輸出国仕入単価通貨 */
    public void setExportPurcUpriCur(String exportPurcUpriCur) {
        this.exportPurcUpriCur = exportPurcUpriCur;
    }

    /** フレイト単価 */
    public String getFreightUpri() {
        return freightUpri;
    }

    /** フレイト単価 */
    public void setFreightUpri(String freightUpri) {
        this.freightUpri = freightUpri;
    }

    /** 輸入諸掛単価 */
    public String getImportUpri() {
        return importUpri;
    }

    /** 輸入諸掛単価 */
    public void setImportUpri(String importUpri) {
        this.importUpri = importUpri;
    }

    /** 輸入関税単価 */
    public String getImportTaxUpri() {
        return importTaxUpri;
    }

    /** 輸入関税単価 */
    public void setImportTaxUpri(String importTaxUpri) {
        this.importTaxUpri = importTaxUpri;
    }

    /** フレイト取引為替レート */
    public String getFreightXrate() {
        return freightXrate;
    }

    /** フレイト取引為替レート */
    public void setFreightXrate(String freightXrate) {
        this.freightXrate = freightXrate;
    }

    /** 現法通貨為替レート */
    public String getSuppsubCurXrate() {
        return suppsubCurXrate;
    }

    /** 現法通貨為替レート */
    public void setSuppsubCurXrate(String suppsubCurXrate) {
        this.suppsubCurXrate = suppsubCurXrate;
    }

    /** 仕入金額 */
    public String getPurcAmt() {
        return purcAmt;
    }

    /** 仕入金額 */
    public void setPurcAmt(String purcAmt) {
        this.purcAmt = purcAmt;
    }

    /** Supplier Invoice Date */
    public String getSupplierInvoiceDate() {
        return supplierInvoiceDate;
    }

    /** Supplier Invoice Date */
    public void setSupplierInvoiceDate(String supplierInvoiceDate) {
        this.supplierInvoiceDate = supplierInvoiceDate;
    }

    /** 発注日 */
    public String getPoDt() {
        return poDt;
    }

    /** 発注日 */
    public void setPoDt(String poDt) {
        this.poDt = poDt;
    }

    /** 税抜き受注金額小計 */
    public String getSumSoAmt() {
        return sumSoAmt;
    }

    /** 税抜き受注金額小計 */
    public void setSumSoAmt(String sumSoAmt) {
        this.sumSoAmt = sumSoAmt;
    }

    /** インコタームス１ */
    public String getIncoterms_1() {
        return incoterms_1;
    }

    /** インコタームス１ */
    public void setIncoterms_1(String incoterms_1) {
        this.incoterms_1 = incoterms_1;
    }

    /** インコタームス２ */
    public String getIncoterms_2() {
        return incoterms_2;
    }

    /** インコタームス２ */
    public void setIncoterms_2(String incoterms_2) {
        this.incoterms_2 = incoterms_2;
    }

    /** インコタームス３ */
    public String getIncoterms_3() {
        return incoterms_3;
    }

    /** インコタームス３ */
    public void setIncoterms_3(String incoterms_3) {
        this.incoterms_3 = incoterms_3;
    }

    /** 出荷置場コード */
    public String getShipPlantCd() {
        return shipPlantCd;
    }

    /** 出荷置場コード */
    public void setShipPlantCd(String shipPlantCd) {
        this.shipPlantCd = shipPlantCd;
    }

    /** 優先得意先フラグ */
    public String getFirstCustFlg() {
        return firstCustFlg;
    }

    /** 優先得意先フラグ */
    public void setFirstCustFlg(String firstCustFlg) {
        this.firstCustFlg = firstCustFlg;
    }

    /** 更新区分 */
    public String getUpdDiv() {
        return updDiv;
    }

    /** 更新区分 */
    public void setUpdDiv(String updDiv) {
        this.updDiv = updDiv;
    }

    /** 作成日_日本用 */
    public String getCrtDtJp() {
        return crtDtJp;
    }

    /** 作成日_日本用 */
    public void setCrtDtJp(String crtDtJp) {
        this.crtDtJp = crtDtJp;
    }

    /** MC・置場コード_日本用 */
    public String getMcPlantCdJp() {
        return mcPlantCdJp;
    }

    /** MC・置場コード_日本用 */
    public void setMcPlantCdJp(String mcPlantCdJp) {
        this.mcPlantCdJp = mcPlantCdJp;
    }

    /** 得意先コード_日本用 */
    public String getCustCdJp() {
        return custCdJp;
    }

    /** 得意先コード_日本用 */
    public void setCustCdJp(String custCdJp) {
        this.custCdJp = custCdJp;
    }

    /** 置場_日本用 */
    public String getMcPlantDivJp() {
        return mcPlantDivJp;
    }

    /** 置場_日本用 */
    public void setMcPlantDivJp(String mcPlantDivJp) {
        this.mcPlantDivJp = mcPlantDivJp;
    }

    /** グローバル番号_日本用 */
    public String getGlobalNoJp() {
        return globalNoJp;
    }

    /** グローバル番号_日本用 */
    public void setGlobalNoJp(String globalNoJp) {
        this.globalNoJp = globalNoJp;
    }

    /** 子商品SEQ_日本用 */
    public String getChildSeqJp() {
        return childSeqJp;
    }

    /** 子商品SEQ_日本用 */
    public void setChildSeqJp(String childSeqJp) {
        this.childSeqJp = childSeqJp;
    }

    /** データ区分_日本用 */
    public String getDataDivJp() {
        return dataDivJp;
    }

    /** データ区分_日本用 */
    public void setDataDivJp(String dataDivJp) {
        this.dataDivJp = dataDivJp;
    }

    /** 商品コード用ブランド名 _日本用 */
    public String getBrandNameForProductCdJp() {
        return brandNameForProductCdJp;
    }

    /** 商品コード用ブランド名 _日本用 */
    public void setBrandNameForProductCdJp(String brandNameForProductCdJp) {
        this.brandNameForProductCdJp = brandNameForProductCdJp;
    }

    /** ブランド商品コード_日本用 */
    public String getBrandProductCdJp() {
        return brandProductCdJp;
    }

    /** ブランド商品コード_日本用 */
    public void setBrandProductCdJp(String brandProductCdJp) {
        this.brandProductCdJp = brandProductCdJp;
    }

    /** 子発注SEQ_日本用 */
    public String getSubPoSeqJp() {
        return subPoSeqJp;
    }

    /** 子発注SEQ_日本用 */
    public void setSubPoSeqJp(String subPoSeqJp) {
        this.subPoSeqJp = subPoSeqJp;
    }

    /** 拠点_日本用 */
    public String getReceivableMcCdJp() {
        return receivableMcCdJp;
    }

    /** 拠点_日本用 */
    public void setReceivableMcCdJp(String receivableMcCdJp) {
        this.receivableMcCdJp = receivableMcCdJp;
    }

    /** MC漢字名称_日本用 */
    public String getNtvDeptNameAbbJp() {
        return ntvDeptNameAbbJp;
    }

    /** MC漢字名称_日本用 */
    public void setNtvDeptNameAbbJp(String ntvDeptNameAbbJp) {
        this.ntvDeptNameAbbJp = ntvDeptNameAbbJp;
    }

    /** MC電話番号_日本用 */
    public String getNtvDeptTelAbbJp() {
        return ntvDeptTelAbbJp;
    }

    /** MC電話番号_日本用 */
    public void setNtvDeptTelAbbJp(String ntvDeptTelAbbJp) {
        this.ntvDeptTelAbbJp = ntvDeptTelAbbJp;
    }

    /** 納品書印刷フラグ_日本用 */
    public String getPackingFlgJp() {
        return packingFlgJp;
    }

    /** 納品書印刷フラグ_日本用 */
    public void setPackingFlgJp(String packingFlgJp) {
        this.packingFlgJp = packingFlgJp;
    }

    /** 納品書出力枚数（オリジナル）_日本用 */
    public String getPackingPrintNumOrgnJp() {
        return packingPrintNumOrgnJp;
    }

    /** 納品書出力枚数（オリジナル）_日本用 */
    public void setPackingPrintNumOrgnJp(String packingPrintNumOrgnJp) {
        this.packingPrintNumOrgnJp = packingPrintNumOrgnJp;
    }

    /** 納品書出力枚数（控え）_日本用 */
    public String getPackingPrintNumCopyJp() {
        return packingPrintNumCopyJp;
    }

    /** 納品書出力枚数（控え）_日本用 */
    public void setPackingPrintNumCopyJp(String packingPrintNumCopyJp) {
        this.packingPrintNumCopyJp = packingPrintNumCopyJp;
    }

    /** 納品書保存フラグ_日本用 */
    public String getPackingRetainFlgJp() {
        return packingRetainFlgJp;
    }

    /** 納品書保存フラグ_日本用 */
    public void setPackingRetainFlgJp(String packingRetainFlgJp) {
        this.packingRetainFlgJp = packingRetainFlgJp;
    }

    /** 英文納品書印刷フラグ_日本用 */
    public String getEngPackingPrintFlgJp() {
        return engPackingPrintFlgJp;
    }

    /** 英文納品書印刷フラグ_日本用 */
    public void setEngPackingPrintFlgJp(String engPackingPrintFlgJp) {
        this.engPackingPrintFlgJp = engPackingPrintFlgJp;
    }

    /** 英文納品書出力枚数（オリジナル）_日本用 */
    public String getEngPackingPrintNumOrgnJp() {
        return engPackingPrintNumOrgnJp;
    }

    /** 英文納品書出力枚数（オリジナル）_日本用 */
    public void setEngPackingPrintNumOrgnJp(String engPackingPrintNumOrgnJp) {
        this.engPackingPrintNumOrgnJp = engPackingPrintNumOrgnJp;
    }

    /** 英文納品書出力枚数（控え）_日本用 */
    public String getEngPackingPrintNumCopyJp() {
        return engPackingPrintNumCopyJp;
    }

    /** 英文納品書出力枚数（控え）_日本用 */
    public void setEngPackingPrintNumCopyJp(String engPackingPrintNumCopyJp) {
        this.engPackingPrintNumCopyJp = engPackingPrintNumCopyJp;
    }

    /** 英文納品書保存フラグ_日本用 */
    public String getEngPackingRetainFlgJp() {
        return engPackingRetainFlgJp;
    }

    /** 英文納品書保存フラグ_日本用 */
    public void setEngPackingRetainFlgJp(String engPackingRetainFlgJp) {
        this.engPackingRetainFlgJp = engPackingRetainFlgJp;
    }

    /** 仮納品書印刷フラグ_日本用 */
    public String getTmpPackingPrintFlgJp() {
        return tmpPackingPrintFlgJp;
    }

    /** 仮納品書印刷フラグ_日本用 */
    public void setTmpPackingPrintFlgJp(String tmpPackingPrintFlgJp) {
        this.tmpPackingPrintFlgJp = tmpPackingPrintFlgJp;
    }

    /** 仮納品書出力枚数（オリジナル）_日本用 */
    public String getTmpPackingPrintNumOrgnJp() {
        return tmpPackingPrintNumOrgnJp;
    }

    /** 仮納品書出力枚数（オリジナル）_日本用 */
    public void setTmpPackingPrintNumOrgnJp(String tmpPackingPrintNumOrgnJp) {
        this.tmpPackingPrintNumOrgnJp = tmpPackingPrintNumOrgnJp;
    }

    /** 仮納品書出力枚数（控え）_日本用 */
    public String getTmpPackingPrintNumCopyJp() {
        return tmpPackingPrintNumCopyJp;
    }

    /** 仮納品書出力枚数（控え）_日本用 */
    public void setTmpPackingPrintNumCopyJp(String tmpPackingPrintNumCopyJp) {
        this.tmpPackingPrintNumCopyJp = tmpPackingPrintNumCopyJp;
    }

    /** 仮納品書保存フラグ_日本用 */
    public String getTmpPackingRetainFlgJp() {
        return tmpPackingRetainFlgJp;
    }

    /** 仮納品書保存フラグ_日本用 */
    public void setTmpPackingRetainFlgJp(String tmpPackingRetainFlgJp) {
        this.tmpPackingRetainFlgJp = tmpPackingRetainFlgJp;
    }

    /** 請求明細書印刷フラグ_日本用 */
    public String getInvoiceFlgJp() {
        return invoiceFlgJp;
    }

    /** 請求明細書印刷フラグ_日本用 */
    public void setInvoiceFlgJp(String invoiceFlgJp) {
        this.invoiceFlgJp = invoiceFlgJp;
    }

    /** 請求明細書出力枚数（オリジナル）_日本用 */
    public String getInvoicePrintNumOrgnJp() {
        return invoicePrintNumOrgnJp;
    }

    /** 請求明細書出力枚数（オリジナル）_日本用 */
    public void setInvoicePrintNumOrgnJp(String invoicePrintNumOrgnJp) {
        this.invoicePrintNumOrgnJp = invoicePrintNumOrgnJp;
    }

    /** 請求明細書出力枚数（控え）_日本用 */
    public String getInvoicePrintNumCopyJp() {
        return invoicePrintNumCopyJp;
    }

    /** 請求明細書出力枚数（控え）_日本用 */
    public void setInvoicePrintNumCopyJp(String invoicePrintNumCopyJp) {
        this.invoicePrintNumCopyJp = invoicePrintNumCopyJp;
    }

    /** 請求明細書保存フラグ_日本用 */
    public String getInvoiceRetainFlgJp() {
        return invoiceRetainFlgJp;
    }

    /** 請求明細書保存フラグ_日本用 */
    public void setInvoiceRetainFlgJp(String invoiceRetainFlgJp) {
        this.invoiceRetainFlgJp = invoiceRetainFlgJp;
    }

    /** ピッキングラベル早出しユーザー区分_日本用 */
    public String getLabelEarlyDivJp() {
        return labelEarlyDivJp;
    }

    /** ピッキングラベル早出しユーザー区分_日本用 */
    public void setLabelEarlyDivJp(String labelEarlyDivJp) {
        this.labelEarlyDivJp = labelEarlyDivJp;
    }

    /** ピッキングラベル早出し対象区分_日本用 */
    public String getLabelEarlyObjectDivJp() {
        return labelEarlyObjectDivJp;
    }

    /** ピッキングラベル早出し対象区分_日本用 */
    public void setLabelEarlyObjectDivJp(String labelEarlyObjectDivJp) {
        this.labelEarlyObjectDivJp = labelEarlyObjectDivJp;
    }

    /** 納入部課区分_日本用 */
    public String getArrDeptDivJp() {
        return arrDeptDivJp;
    }

    /** 納入部課区分_日本用 */
    public void setArrDeptDivJp(String arrDeptDivJp) {
        this.arrDeptDivJp = arrDeptDivJp;
    }

    /** 納入担当者区分_日本用 */
    public String getArrUserDivJp() {
        return arrUserDivJp;
    }

    /** 納入担当者区分_日本用 */
    public void setArrUserDivJp(String arrUserDivJp) {
        this.arrUserDivJp = arrUserDivJp;
    }

    /** 仕入先名（カナ）_日本用 */
    public String getCompanyNameKanaJp() {
        return companyNameKanaJp;
    }

    /** 仕入先名（カナ）_日本用 */
    public void setCompanyNameKanaJp(String companyNameKanaJp) {
        this.companyNameKanaJp = companyNameKanaJp;
    }

    /** ランク梱包SEQ_日本用 */
    public String getRankFlgJp() {
        return rankFlgJp;
    }

    /** ランク梱包SEQ_日本用 */
    public void setRankFlgJp(String rankFlgJp) {
        this.rankFlgJp = rankFlgJp;
    }

    /** 1得意先で複数配送先有無マーク_日本用 */
    public String getMangShipToFlgJp() {
        return mangShipToFlgJp;
    }

    /** 1得意先で複数配送先有無マーク_日本用 */
    public void setMangShipToFlgJp(String mangShipToFlgJp) {
        this.mangShipToFlgJp = mangShipToFlgJp;
    }

    /** 巡回便区分_日本用 */
    public String getPatrolDivJp() {
        return patrolDivJp;
    }

    /** 巡回便区分_日本用 */
    public void setPatrolDivJp(String patrolDivJp) {
        this.patrolDivJp = patrolDivJp;
    }

    /** 現法名（カナ）_日本用 */
    public String getCustNameKanaJp() {
        return custNameKanaJp;
    }

    /** 現法名（カナ）_日本用 */
    public void setCustNameKanaJp(String custNameKanaJp) {
        this.custNameKanaJp = custNameKanaJp;
    }

    /** 現法名２_日本用 */
    public String getCustName_2Jp() {
        return custName_2Jp;
    }

    /** 現法名２_日本用 */
    public void setCustName_2Jp(String custName_2Jp) {
        this.custName_2Jp = custName_2Jp;
    }

    /** 梱包指示１_日本用 */
    public String getNtvPackingInstruct1J() {
        return ntvPackingInstruct1J;
    }

    /** 梱包指示１_日本用 */
    public void setNtvPackingInstruct1J(String ntvPackingInstruct1J) {
        this.ntvPackingInstruct1J = ntvPackingInstruct1J;
    }

    /** 梱包指示２_日本用 */
    public String getNtvPackingInstruct2J() {
        return ntvPackingInstruct2J;
    }

    /** 梱包指示２_日本用 */
    public void setNtvPackingInstruct2J(String ntvPackingInstruct2J) {
        this.ntvPackingInstruct2J = ntvPackingInstruct2J;
    }

    /** 梱包指示３_日本用 */
    public String getNtvPackingInstruct3J() {
        return ntvPackingInstruct3J;
    }

    /** 梱包指示３_日本用 */
    public void setNtvPackingInstruct3J(String ntvPackingInstruct3J) {
        this.ntvPackingInstruct3J = ntvPackingInstruct3J;
    }

    /** 梱包指示４_日本用 */
    public String getNtvPackingInstruct4J() {
        return ntvPackingInstruct4J;
    }

    /** 梱包指示４_日本用 */
    public void setNtvPackingInstruct4J(String ntvPackingInstruct4J) {
        this.ntvPackingInstruct4J = ntvPackingInstruct4J;
    }

    /** 梱包指示５_日本用 */
    public String getNtvPackingInstruct5J() {
        return ntvPackingInstruct5J;
    }

    /** 梱包指示５_日本用 */
    public void setNtvPackingInstruct5J(String ntvPackingInstruct5J) {
        this.ntvPackingInstruct5J = ntvPackingInstruct5J;
    }

    /** 事務指示１_日本用 */
    public String getNtvBusinessInstruct1J() {
        return ntvBusinessInstruct1J;
    }

    /** 事務指示１_日本用 */
    public void setNtvBusinessInstruct1J(String ntvBusinessInstruct1J) {
        this.ntvBusinessInstruct1J = ntvBusinessInstruct1J;
    }

    /** 事務指示２_日本用 */
    public String getNtvBusinessInstruct2J() {
        return ntvBusinessInstruct2J;
    }

    /** 事務指示２_日本用 */
    public void setNtvBusinessInstruct2J(String ntvBusinessInstruct2J) {
        this.ntvBusinessInstruct2J = ntvBusinessInstruct2J;
    }

    /** 事務指示３_日本用 */
    public String getNtvBusinessInstruct3J() {
        return ntvBusinessInstruct3J;
    }

    /** 事務指示３_日本用 */
    public void setNtvBusinessInstruct3J(String ntvBusinessInstruct3J) {
        this.ntvBusinessInstruct3J = ntvBusinessInstruct3J;
    }

    /** 事務指示４_日本用 */
    public String getNtvBusinessInstruct4J() {
        return ntvBusinessInstruct4J;
    }

    /** 事務指示４_日本用 */
    public void setNtvBusinessInstruct4J(String ntvBusinessInstruct4J) {
        this.ntvBusinessInstruct4J = ntvBusinessInstruct4J;
    }

    /** 事務指示５_日本用 */
    public String getNtvBusinessInstruct5J() {
        return ntvBusinessInstruct5J;
    }

    /** 事務指示５_日本用 */
    public void setNtvBusinessInstruct5J(String ntvBusinessInstruct5J) {
        this.ntvBusinessInstruct5J = ntvBusinessInstruct5J;
    }

    /** 直送先担当者（カナ）_日本用 */
    public String getShipToAttentionKanaJp() {
        return shipToAttentionKanaJp;
    }

    /** 直送先担当者（カナ）_日本用 */
    public void setShipToAttentionKanaJp(String shipToAttentionKanaJp) {
        this.shipToAttentionKanaJp = shipToAttentionKanaJp;
    }

    /** 直送先部課（カナ）_日本用 */
    public String getShipToDeptKanaJp() {
        return shipToDeptKanaJp;
    }

    /** 直送先部課（カナ）_日本用 */
    public void setShipToDeptKanaJp(String shipToDeptKanaJp) {
        this.shipToDeptKanaJp = shipToDeptKanaJp;
    }

    /** 得意先担当者（カナ）_日本用 */
    public String getCustDeliAttentionKanaJp() {
        return custDeliAttentionKanaJp;
    }

    /** 得意先担当者（カナ）_日本用 */
    public void setCustDeliAttentionKanaJp(String custDeliAttentionKanaJp) {
        this.custDeliAttentionKanaJp = custDeliAttentionKanaJp;
    }

    /** 得意先部課（カナ）_日本用 */
    public String getCustDeliDeptKanaJp() {
        return custDeliDeptKanaJp;
    }

    /** 得意先部課（カナ）_日本用 */
    public void setCustDeliDeptKanaJp(String custDeliDeptKanaJp) {
        this.custDeliDeptKanaJp = custDeliDeptKanaJp;
    }

    /** 注文者名（カナ）_日本用 */
    public String getCustAttentionKanaJp() {
        return custAttentionKanaJp;
    }

    /** 注文者名（カナ）_日本用 */
    public void setCustAttentionKanaJp(String custAttentionKanaJp) {
        this.custAttentionKanaJp = custAttentionKanaJp;
    }

    /** 注文担当部課名（カナ）_日本用 */
    public String getCustDeptKanaJp() {
        return custDeptKanaJp;
    }

    /** 注文担当部課名（カナ）_日本用 */
    public void setCustDeptKanaJp(String custDeptKanaJp) {
        this.custDeptKanaJp = custDeptKanaJp;
    }

    /** 直送先名称（カナ）_日本用 */
    public String getShipToNameKanaJp() {
        return shipToNameKanaJp;
    }

    /** 直送先名称（カナ）_日本用 */
    public void setShipToNameKanaJp(String shipToNameKanaJp) {
        this.shipToNameKanaJp = shipToNameKanaJp;
    }

    /** 納入者名（カナ）_日本用 */
    public String getDeliAttentionKanaJp() {
        return deliAttentionKanaJp;
    }

    /** 納入者名（カナ）_日本用 */
    public void setDeliAttentionKanaJp(String deliAttentionKanaJp) {
        this.deliAttentionKanaJp = deliAttentionKanaJp;
    }

    /** 納入担当部課名（カナ）_日本用 */
    public String getDeliDeptKanaJp() {
        return deliDeptKanaJp;
    }

    /** 納入担当部課名（カナ）_日本用 */
    public void setDeliDeptKanaJp(String deliDeptKanaJp) {
        this.deliDeptKanaJp = deliDeptKanaJp;
    }

    /** 地区コード_日本用 */
    public String getCityCdJp() {
        return cityCdJp;
    }

    /** 地区コード_日本用 */
    public void setCityCdJp(String cityCdJp) {
        this.cityCdJp = cityCdJp;
    }

    /** 備考(自動車規格コード)_日本用 */
    public String getAutomobileStandardCdJp() {
        return automobileStandardCdJp;
    }

    /** 備考(自動車規格コード)_日本用 */
    public void setAutomobileStandardCdJp(String automobileStandardCdJp) {
        this.automobileStandardCdJp = automobileStandardCdJp;
    }

    /** 個口数SEQ_日本用 */
    public String getUnitQtySeqJp() {
        return unitQtySeqJp;
    }

    /** 個口数SEQ_日本用 */
    public void setUnitQtySeqJp(String unitQtySeqJp) {
        this.unitQtySeqJp = unitQtySeqJp;
    }

    /** 届先件数_日本用 */
    public String getSendedQtyJp() {
        return sendedQtyJp;
    }

    /** 届先件数_日本用 */
    public void setSendedQtyJp(String sendedQtyJp) {
        this.sendedQtyJp = sendedQtyJp;
    }

    /** ストーク料金適用区分_日本用 */
    public String getStorkChargeApplyDivJp() {
        return storkChargeApplyDivJp;
    }

    /** ストーク料金適用区分_日本用 */
    public void setStorkChargeApplyDivJp(String storkChargeApplyDivJp) {
        this.storkChargeApplyDivJp = storkChargeApplyDivJp;
    }

    /** 納品書番号_MJP_日本用 */
    public String getDeliNoteNoMjp() {
        return deliNoteNoMjp;
    }

    /** 納品書番号_MJP_日本用 */
    public void setDeliNoteNoMjp(String deliNoteNoMjp) {
        this.deliNoteNoMjp = deliNoteNoMjp;
    }

    /** 合計金額（日本納品書用）_日本用 */
    public String getSumAmtJp() {
        return sumAmtJp;
    }

    /** 合計金額（日本納品書用）_日本用 */
    public void setSumAmtJp(String sumAmtJp) {
        this.sumAmtJp = sumAmtJp;
    }

    /** 元J納品書番号_日本用 */
    public String getOldDeliNoteNoJp() {
        return oldDeliNoteNoJp;
    }

    /** 元J納品書番号_日本用 */
    public void setOldDeliNoteNoJp(String oldDeliNoteNoJp) {
        this.oldDeliNoteNoJp = oldDeliNoteNoJp;
    }

    /** Job名*/
    public String getJobName() {
        return jobName;
    }

    /** Job名*/
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

}
