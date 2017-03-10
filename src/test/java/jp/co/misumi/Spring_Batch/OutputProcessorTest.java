package jp.co.misumi.Spring_Batch;

import jp.co.misumi.batch.OutptItemProcessor;
import jp.co.misumi.model.InptData;
import jp.co.misumi.model.OutptData;
import junit.framework.TestCase;
import org.junit.Assert;


public class OutputProcessorTest extends TestCase {

	public void testTransferProcessor() {

		InptData inptData = TestData.getTransferInData();
		OutptData expectedOutptData = TestData.getTransferOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testFixedValue() {

		OutptData expectedOutptData = TestData.getFixedOutData();

		assertEqualsCustomiz(new InptData(), expectedOutptData, true);
	}

	public void testPurcPrice() {

		InptData inptData = TestData.getInptDataPurcPrice();
		OutptData expectedOutptData = TestData.getOutptDataPurcPrice();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testExcludeTaxSUPrice() {

		InptData inptData = TestData.getInptDataExcludeTaxSUPrice();
		OutptData expectedOutptData = TestData.getOutptDataExcludeTaxSUPrice();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 作成日 */
	public void testCrtDt() {

		OutptData expectedOutptData = TestData.getOutptDataCrtDt();

		assertEqualsCustomiz(new InptData(), expectedOutptData, false);
	}
	/** 入荷予定日 */
	public void testSchdArrDt() {

		InptData inptData = TestData.getInptDataSchdArrDt();
		OutptData expectedOutptData = TestData.getOutptDataSchdArrDt();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 出荷予定日 */
	public void testSchdShipDt() {

		InptData inptData = TestData.getInptDataSchdShipDt();
		OutptData expectedOutptData = TestData.getOutptDataSchdShipDt();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 受注年月日 */
	public void testSoDate() {

		InptData inptData = TestData.getInptDataSoDate();
		OutptData expectedOutptData = TestData.getOutptDataSoDate();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}
	/** 顧客到着日 */
	public void testCrd() {

		InptData inptData = TestData.getInptDataCrd();
		OutptData expectedOutptData = TestData.getOutptDataCrd();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMcPlantDiv() {
		InptData inptData = TestData.getInptDataMcPlantDiv();
		OutptData expectedOutptData = TestData.getOutptDataMcPlantDiv();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testCometSeq() {
		InptData inptData = TestData.getInptCometSeq();
		OutptData expectedOutptData = TestData.getOutptCometSeq();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMJPWithHeaderGrp0() {

		InptData inptData = TestData.getInptDataMJPWithHeaderGrp0();
		OutptData expectedOutptData = TestData.getOutptDataMJPWithHeaderGrp0();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMJPWithEngHeaderGrp0() {

		InptData inptData = TestData.getInptDataMJPWithEngHeaderGrp0();
		OutptData expectedOutptData = TestData.getOutptDataMJPWithEngHeaderRefGrp0();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMJPWithcustRefGrp0() {

		InptData inptData = TestData.getInptDataMJPWithcustRefGrp0();
		OutptData expectedOutptData = TestData.getOutptDataMJPWithcustRefGrp0();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMJPWithHeaderGrp2() {

		InptData inptData = TestData.getInptDataMJPWithHeaderGrp2();
		OutptData expectedOutptData = TestData.getOutptDataMJPWithHeaderGrp2();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMJPWithEngHeaderGrp2() {

		InptData inptData = TestData.getInptDataMJPWithEngHeaderGrp2();
		OutptData expectedOutptData = TestData.getOutptDataMJPWithEngHeaderRefGrp2();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMJPWithCustRefGrp2() {

		InptData inptData = TestData.getInptDataMJPWithCustRefGrp2();
		OutptData expectedOutptData = TestData.getOutptDataMJPWithcustRefGrp2();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testNoMJPWithCustRefGrp0() {

		InptData inptData = TestData.getInptDataNoMJPHeaderRefGrp0();
		OutptData expectedOutptData = TestData.getOutptDataNoMJPHeaderRefGrp0();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testMJPWithCustRefGrp0() {

		InptData inptData = TestData.getInptDataNoMJPEngHeaderRefGrp0();
		OutptData expectedOutptData = TestData.getOutptDataNoMJPEngHeaderRefGrp0();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testChildSeq() {

		InptData inptData = TestData.getInptDataChildSeq();
		OutptData expectedOutptData = TestData.getOutptDataLabelL002();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testNoChildSeq() {

		InptData inptData = new InptData();
		OutptData expectedOutptData = TestData.getOutptDataLabelL001();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 着日指示データに対応するレコードが存在 */
	public void testSubsidiaryCdArrDt() {
		InptData inptData = TestData.getInptDataSubsidiaryCdArrDt();
		OutptData expectedOutptData = TestData.getOutptDataRdInstructFlg1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);

	}

	/** 着日指示データに対応するレコードが存在 */
	public void testNoSubsidiaryCdArrDt() {
		OutptData expectedOutptData = TestData.getOutptDataRdInstructFlg0();

		assertEqualsCustomiz(new InptData(), expectedOutptData, false);

	}
	/** 受注明細．得意先現法コード　≠　空白 */
	public void testcustsubSubsidiaryCd() {
		InptData inptData = TestData.getInptDataSubsidiaryCdArrDt();
		OutptData expectedOutptData = TestData.getOutptDataRdInstructFlg1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);

	}

	public void testOrderMsgCd9001() {
		InptData inptData = TestData.getInptOrderMsgCd9001();
		OutptData expectedOutptData = TestData.getOutptDataifDiv1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testOrderMsgCd9002() {
		InptData inptData = TestData.getInptOrderMsgCd9002();
		OutptData expectedOutptData = TestData.getOutptDataifDiv2();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testOrderMsgCd() {
		OutptData expectedOutptData = TestData.getOutptDataifDiv();

		assertEqualsCustomiz(new InptData(), expectedOutptData, false);
	}

	public void testCustCategoryCd01() {
		InptData inptData = TestData.getInptCustCategoryCd01();
		OutptData expectedOutptData = TestData.getOutptSuppsubBusinessFlg1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testCustCategoryCd02() {
		InptData inptData = TestData.getInptCustCategoryCd02();
		OutptData expectedOutptData = TestData.getOutptSuppsubBusinessFlg1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testCustCategoryCd() {
		OutptData expectedOutptData = TestData.getOutptSuppsubBusinessFlg0();

		assertEqualsCustomiz(new InptData(), expectedOutptData, false);
	}

	public void testGrp1() {
		InptData inptData = TestData.getInptGrp1();
		OutptData expectedOutptData = TestData.getOutptGrp1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testGrp() {
		OutptData expectedOutptData = TestData.getOutptGrp();

		assertEqualsCustomiz(new InptData(), expectedOutptData, false);
	}

	public void testShipTo() {
		InptData inptData = TestData.getInptShipToCd();
		OutptData expectedOutptData = TestData.getOutptShipToCd();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testNoShipToCd() {
		InptData inptData = TestData.getInptNoShipToCd();
		OutptData expectedOutptData = TestData.getOutptNoShipToCd();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 受注明細．得意先現法コード　≠　空白 */
	public void testCustsubSubsidiaryCd() {
		InptData inptData = TestData.getInptCustsubSubsidiaryCd();
		OutptData expectedOutptData = TestData.getOutptExportFlg1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 受注明細．直送先コード　＝　空白　 かつ　受注明細．得意先国コード　≠　現法マスタ．国コード */
	public void testCustNotEsSubsidiary() {
		InptData inptData = TestData.getInptCustNotEsSubsidiary();
		OutptData expectedOutptData = TestData.getOutptExportFlg1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 受注明細．直送先コード　≠　空白　かつ　受注明細．直送先国コード　≠　現法マスタ．国コード */
	public void testInptCustEsSubsidiary() {
		InptData inptData = TestData.getInptCustBNotEsSubsidiary();
		OutptData expectedOutptData = TestData.getOutptExportFlg1();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	/** 受注明細．直送先コード 上記以外の場合 */
	public void testExportFlg1() {
		OutptData expectedOutptData = TestData.getOutptExportFlg0();

		assertEqualsCustomiz(new InptData(), expectedOutptData, false);
	}

	public void testExportFlgFalse() {
		InptData inptData = TestData.getExportFlgFalseExisInData();
		OutptData expectedOutptData = TestData.getExportFlgFalseExisOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testExportFlgFalseNotExis() {
		InptData inptData = TestData.getExportFlgFalseNotExisInData();
		OutptData expectedOutptData = TestData.getExportFlgFalseNotExisOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testShipToCdTrueNotExistInfor() {
		InptData inptData = TestData.getInputShipToCdTrueNotExistInfor();
		OutptData expectedOutptData = TestData.getOutputShipToCdTrueNotExistInfor();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}
	
	public void testExportFlgTrueExis() {
		InptData inptData = TestData.getExportFlgTrueExisInData();
		OutptData expectedOutptData = TestData.getExportFlgTrueExisOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testShipToCdExistInfor() {
		InptData inptData = TestData.getInputShipToCdExistInfor();
		OutptData expectedOutptData = TestData.getOutputShipToCdExistInfor();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testShipToCdNotExistInfor() {
		InptData inptData = TestData.getInputShipToCdNotExistInfor();
		OutptData expectedOutptData = TestData.getOutputShipToCdNotExistInfor();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}


	public void testShipToCdBLANKInfor() {
		InptData inptData = TestData.getInputShipToCdBLANKInfor();
		OutptData expectedOutptData = TestData.getOutputShipToCdBlankInfor();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}


	public void testDirectInputInfor() {
		InptData inptData = TestData.getDirectInputInfor();
		OutptData expectedOutptData = TestData.getDirectOutputInfor();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testRankPatrolDiv() {
		OutptData expectedOutptData = TestData.getRankPatrolDivOutData();

		assertEqualsCustomiz(new InptData(), expectedOutptData, false);
	}

	public void testPlant() {
		InptData inptData = TestData.getMcPlantDivInData();
		OutptData expectedOutptData = TestData.getPlantOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testExportFlg1CustName() {
		InptData inptData = TestData.getExportFlg1InputData();
		OutptData expectedOutptData = TestData.getExportFlg1CustNameOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testExportFlg0CustName() {
		InptData inptData = new InptData();
		OutptData expectedOutptData = TestData.getExportFlg0CustNameOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testShipToCdExist() {
		InptData inptData = TestData.getShipToCdExistInputData();
		OutptData expectedOutptData = TestData.getShipToCdExistOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testShipToCdNotExist() {
		InptData inptData = TestData.getShipToCdNotExistInputData();
		OutptData expectedOutptData = TestData.getShipToCdNotExistOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testGrp2() {
		InptData inptData = TestData.getGrp2InputData();
		OutptData expectedOutptData = TestData.getGrp2OutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testGrpNot2() {
		InptData inptData = TestData.getGrpNot2InputData();
		OutptData expectedOutptData = TestData.getGrpNot2OutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testGrp2Deli() {
		InptData inptData = TestData.getGrp2DeliInputData();
		OutptData expectedOutptData = TestData.getGrpNot2DeliOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testGrp2ntvDeli() {
		InptData inptData = TestData.getGrp2ntvDeliInputData();
		OutptData expectedOutptData = TestData.getGrpNot2ntvDelOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testGrp2ntvDeliNotEuqal() {
		InptData inptData = TestData.getGrp2ntvDeliNotEuqalInputData();
		OutptData expectedOutptData = TestData.getGrpNot2ntvDelNotEuqalOutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}

	public void testGrp3() {
		InptData inptData = TestData.getGrp3inptData();
		OutptData expectedOutptData = TestData.getGrp3OutData();

		assertEqualsCustomiz(inptData, expectedOutptData, false);
	}
	// -------------------------------------------wu-----------------------------------------------------------
    public void testRefStr1() {
		String CustRef = "a a";
		String CystRefNtv = "bb";
		String CustSubRef = "cc";
		String yPartNoDiv = "dd";
		String expectedOutptData = "a a/bb/ccdd";
		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
	}

    public void testRefStr2() {
		String CustRef = "a a";
		String CystRefNtv = "";
		String CustSubRef = "cc";
		String yPartNoDiv = "dd";
		String expectedOutptData = "a a/ccdd";
		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
	}

    public void testRefStr3() {
  		String CustRef = "a a";
  		String CystRefNtv = "bb";
  		String CustSubRef = "";
  		String yPartNoDiv = "dd";
  		String expectedOutptData = "a a/bbdd";
  		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
  	}
    
    public void testRefStr4() {
  		String CustRef = "a a";
  		String CystRefNtv = "";
  		String CustSubRef = "";
  		String yPartNoDiv = "dd";
  		String expectedOutptData = "a add";
  		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
  	}

    public void testRefStr5() {
  		String CustRef = "";
  		String CystRefNtv = "bb";
  		String CustSubRef = "cc";
  		String yPartNoDiv = "dd";
  		String expectedOutptData = "bb/ccdd";
  		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
  	}
    
    public void testRefStr6() {
  		String CustRef = "";
  		String CystRefNtv = "bb";
  		String CustSubRef = "";
  		String yPartNoDiv = "dd";
  		String expectedOutptData = "bbdd";
  		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
  	}

    public void testRefStr7() {
  		String CustRef = "";
  		String CystRefNtv = "";
  		String CustSubRef = "cc";
  		String yPartNoDiv = "dd";
  		String expectedOutptData = "ccdd";
  		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
  	}

    public void testRefStr8() {
  		String CustRef = "";
  		String CystRefNtv = "";
  		String CustSubRef = "";
  		String yPartNoDiv = "dd";
  		String expectedOutptData = "dd";
  		assertEqualsRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv, expectedOutptData);
  	}
    
	private void assertEqualsRefStr(String CustRef, String CystRefNtv, String CustSubRef, String yPartNoDiv,
			String expectedOutptData) {
		try {
			OutptItemProcessor outptItemProcessor = new OutptItemProcessor();
			String actualOutptData = outptItemProcessor.getRefStr(CustRef, CystRefNtv, CustSubRef, yPartNoDiv);
			Assert.assertEquals(expectedOutptData, actualOutptData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//----------------------------------------ピッキングラベル早出し対象区分---------------------------------------------------
	public void testLabelEarlyObjectDivJp1() {
		String labelEarlyDivJp = "1";
		String deliDiv = "01";
		String mcPlantDiv = "532";
		String expectedOutptData = "1";
		assertEqualsLabelEarlyObjectDivJp(labelEarlyDivJp, deliDiv, mcPlantDiv, expectedOutptData);
	}

	public void testLabelEarlyObjectDivJp2() {
		String labelEarlyDivJp = "1";
		String deliDiv = "12";
		String mcPlantDiv = "532";
		String expectedOutptData = "";
		assertEqualsLabelEarlyObjectDivJp(labelEarlyDivJp, deliDiv, mcPlantDiv, expectedOutptData);
	}
	
	public void testLabelEarlyObjectDivJp3() {
		String labelEarlyDivJp = "2";
		String deliDiv = "012";
		String mcPlantDiv = "532";
		String expectedOutptData = "";
		assertEqualsLabelEarlyObjectDivJp(labelEarlyDivJp, deliDiv, mcPlantDiv, expectedOutptData);
	}
	
	public void testLabelEarlyObjectDivJp4() {
		String labelEarlyDivJp = "1";
		String deliDiv = "012";
		String mcPlantDiv = "432";
		String expectedOutptData = "";
		assertEqualsLabelEarlyObjectDivJp(labelEarlyDivJp, deliDiv, mcPlantDiv, expectedOutptData);
	}
	private void assertEqualsLabelEarlyObjectDivJp(String labelEarlyDivJp, String deliDiv, String mcPlantDiv,
			String expectedOutptData) {
		try {
			OutptItemProcessor outptItemProcessor = new OutptItemProcessor();
			String actualOutptData = outptItemProcessor.getLabelEarlyObjectDivJp(labelEarlyDivJp, deliDiv, mcPlantDiv);
			Assert.assertEquals(expectedOutptData, actualOutptData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------仮納品書印刷フラグ---------------------------------------------------
	public void testTmpPackingPrintFlgJp1() {
		String directShipFlg = "1";
		String shipToTempVoucherDiv = "1";
		String tmpFlg = "1";
		String expectedOutptData = "0";
		assertEqualsTmpPackingPrintFlgJp(directShipFlg, shipToTempVoucherDiv, tmpFlg, expectedOutptData);
	}

	public void testTmpPackingPrintFlgJp2() {
		String directShipFlg = "0";
		String shipToTempVoucherDiv = "0";
		String tmpFlg = "1";
		String expectedOutptData = "1";
		assertEqualsTmpPackingPrintFlgJp(directShipFlg, shipToTempVoucherDiv, tmpFlg, expectedOutptData);
	}

	public void testTmpPackingPrintFlgJp3() {
		String directShipFlg = "0";
		String shipToTempVoucherDiv = "1";
		String tmpFlg = "1";
		String expectedOutptData = "1";
		assertEqualsTmpPackingPrintFlgJp(directShipFlg, shipToTempVoucherDiv, tmpFlg, expectedOutptData);
	}
	
	public void testTmpPackingPrintFlgJp4() {
		String directShipFlg = "0";
		String shipToTempVoucherDiv = "1";
		String tmpFlg = "0";
		String expectedOutptData = "0";
		assertEqualsTmpPackingPrintFlgJp(directShipFlg, shipToTempVoucherDiv, tmpFlg, expectedOutptData);
	}
	private void assertEqualsTmpPackingPrintFlgJp(String directShipFlg, String shipToTempVoucherDiv, String tmpFlg,
			String expectedOutptData) {
		try {
			OutptItemProcessor outptItemProcessor = new OutptItemProcessor();
			String actualOutptData = outptItemProcessor.getTmpPackingPrintFlgJp(directShipFlg, shipToTempVoucherDiv,tmpFlg);
			Assert.assertEquals(expectedOutptData, actualOutptData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------ブランド商品コード---------------------------------------------------
	public void testBrandProductCdJp1() {
		String productCdMst = "123";
		String branNmForProductCd = "";

		String expectedOutptData = "123";
		assertEqualsBrandProductCdJp(productCdMst, branNmForProductCd, expectedOutptData);
	}

	// 現法名２
	public void testCustName_2JpNvl() {
		String billToCountryName = null;
		String expectedCustName = "";
		OutptItemProcessor outptItemProcessor = new OutptItemProcessor();

		String actualCustname = outptItemProcessor.getCustName_2(billToCountryName, "");

		Assert.assertEquals(expectedCustName, actualCustname);
	}

	public void testCustName_2JpNotSpace() {
		String billToCountryName = "billToCountryName";
		String expectedCustName = "custName";
		OutptItemProcessor outptItemProcessor = new OutptItemProcessor();

		String actualCustname = outptItemProcessor.getCustName_2(billToCountryName, "custName");

		Assert.assertEquals(billToCountryName.trim()+"/"+expectedCustName.trim(), actualCustname);
	}

	public void testCustName_2JpSpace() {
		String billToCountryName = " ";
		String expectedCustName = "custName";
		OutptItemProcessor outptItemProcessor = new OutptItemProcessor();

		String actualCustname = outptItemProcessor.getCustName_2(billToCountryName, "custName");

		Assert.assertEquals(expectedCustName, actualCustname);
	}

	public void testbrandNameForProductCd() {
		String brandNameForProductCd = "ﾐｽﾐ";
		String expected = "";
		OutptItemProcessor outptItemProcessor = new OutptItemProcessor();

		String actual = outptItemProcessor.getMcPlantDivJp(brandNameForProductCd);

		Assert.assertEquals(expected, actual);
	}

	public void testbrandNameForProductCdMISUMI() {
		String brandNameForProductCd = "MISUMI";
		String expected = "";
		OutptItemProcessor outptItemProcessor = new OutptItemProcessor();

		String actual = outptItemProcessor.getMcPlantDivJp(brandNameForProductCd);

		Assert.assertEquals(expected, actual);
	}

	public void testbrandNameForProductCdElse() {
		String brandNameForProductCd = "brandNameForProductCd";
		String expected = "brandNameForProductCd";
		OutptItemProcessor outptItemProcessor = new OutptItemProcessor();

		String actual = outptItemProcessor.getMcPlantDivJp(brandNameForProductCd);

		Assert.assertEquals(expected, actual);
	}

	public void testBrandProductCdJp2() {
		String productCdMst = "1234567890123456789012345678901234";
		String branNmForProductCd = "12345678901234567890";

		String expectedOutptData = "1234567890123456789012345678901234(12345678901234567890)";
		assertEqualsBrandProductCdJp(productCdMst, branNmForProductCd, expectedOutptData);
	}

	public void testBrandProductCdJp3() {
		String productCdMst = "12345678901234567890123456789012345";
		String branNmForProductCd = "12345678901234567890";

		String expectedOutptData = "12345678901234567890123456789012345";
		assertEqualsBrandProductCdJp(productCdMst, branNmForProductCd, expectedOutptData);
	}
	private void assertEqualsBrandProductCdJp(String productCdMst, String branNmForProductCd,
											  String expectedOutptData) {
		try {
			OutptItemProcessor outptItemProcessor = new OutptItemProcessor();
			String actualOutptData = outptItemProcessor.getBrandProductCdJp(productCdMst, branNmForProductCd);
			Assert.assertEquals(expectedOutptData, actualOutptData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void assertEqualsCustomiz(InptData inptData, OutptData expectedOutptData, boolean isJudgeZero) {
		try {
			OutptItemProcessor outptItemProcessor = new OutptItemProcessor();
			OutptData actualOutptData = outptItemProcessor.process(inptData);
			TestUtil.assertDataEquals(expectedOutptData, actualOutptData, isJudgeZero);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------最終得意先名（英語）---------------------------------------------------
	public void testFinalCustNameEn1() {

		String subsidiaryCd = "MJP";
		String custsubSubsidiaryCd = "MJP1";
		String delFlsubsidiarySysDivg = "M";
		String result1 = "result1";
		String result2 = "result2";
		
		String expectedOutptData = "result1";

		assertFinalCustNameEn(subsidiaryCd, custsubSubsidiaryCd, 
				delFlsubsidiarySysDivg, result1, result2, expectedOutptData);
	}

	public void testFinalCustNameEn2() {

		String subsidiaryCd = "MJP";
		String custsubSubsidiaryCd = "MJP";
		String delFlsubsidiarySysDivg = "M";
		String result1 = "result1";
		String result2 = "result2";
		
		String expectedOutptData = "result2";

		assertFinalCustNameEn(subsidiaryCd, custsubSubsidiaryCd, 
				delFlsubsidiarySysDivg, result1, result2, expectedOutptData);
	}

	public void testFinalCustNameEn3() {

		String subsidiaryCd = "MJP";
		String custsubSubsidiaryCd = "MJP1";
		String delFlsubsidiarySysDivg = "J";
		String result1 = "result1";
		String result2 = "result2";
		
		String expectedOutptData = "result2";

		assertFinalCustNameEn(subsidiaryCd, custsubSubsidiaryCd, 
				delFlsubsidiarySysDivg, result1, result2, expectedOutptData);
	}

	public void testFinalCustNameEn4() {

		String subsidiaryCd = "MJP1";
		String custsubSubsidiaryCd = "MJP1";
		String delFlsubsidiarySysDivg = "M";
		String result1 = "result1";
		String result2 = "result2";
		
		String expectedOutptData = "result2";

		assertFinalCustNameEn(subsidiaryCd, custsubSubsidiaryCd, 
				delFlsubsidiarySysDivg, result1, result2, expectedOutptData);
	}

	private void assertFinalCustNameEn(String subsidiaryCd, String custsubSubsidiaryCd, String delFlsubsidiarySysDivg,
			String result1, String result2, String expectedOutptData) {
		try {
			OutptItemProcessor outptItemProcessor = new OutptItemProcessor();
			String actualOutptData = outptItemProcessor.getFinalCustNameEn(subsidiaryCd, custsubSubsidiaryCd, 
					delFlsubsidiarySysDivg, result1, result2);
			Assert.assertEquals(expectedOutptData, actualOutptData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
