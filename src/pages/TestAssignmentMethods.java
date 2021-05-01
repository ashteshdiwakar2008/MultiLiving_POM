package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import testutil.TestUtil;

public class TestAssignmentMethods extends TestBase {
	
	public static HashMap hmobj=null;
	
	
	public static void writeDataToExcel(List<String> listCharges) throws Exception {
		boolean flag=false;
		
		FileInputStream fis=new FileInputStream("D:\\Selenium Tests\\MultiLiving_POM\\src\\testdata\\TestResults.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Results");
		int rowCount=sheet.getLastRowNum();
		
		//Row row = sheet.createRow(rowCount+1);
		Row row=sheet.createRow(rowCount+1);
		
		Cell cell1,cell2; 
		
		cell1=row.createCell(0);
		cell1.setCellType(Cell.CELL_TYPE_STRING);
		cell1.setCellValue("New Test Run Results dated: " +rowCount);
		rowCount++;
		
		for(int i=0;i<listCharges.size();i++) {
			
			Row row1 = sheet.createRow(rowCount+1);
			cell1 = row1.createCell(0);
			
			cell1.setCellType(Cell.CELL_TYPE_STRING);
			
			cell1.setCellValue(listCharges.get(i));
			
			rowCount++;
		}
			
		
		FileOutputStream fos = new FileOutputStream("D:\\Selenium Tests\\MultiLiving_POM\\src\\testdata\\TestResults.xlsx");
		wb.write(fos);
		fos.close();
		System.out.println("END OF WRITING DATA IN EXCEL");
		
		
		//return true;
	}

	public static void printExcelData() throws Exception {
		hmobj=new HashMap<String,String>();
		hmobj=TestUtil.excelReader("TestData", "HeaderSelection");
	}
	
	public static boolean fillBasicDetails() throws Exception {
		
		boolean flag= false;
		hmobj = TestUtil.excelReader("TestData", "BasicDetails");
		
		String sIAm = hmobj.get("Iam").toString().trim();
		String sAgreementCity = hmobj.get("AgreementCity").toString().trim();
		String sFirstName = hmobj.get("FirstName").toString().trim();
		String sLastName = hmobj.get("LastName").toString().trim();
		String sMobileNumber = hmobj.get("MobileNumber").toString().trim();
		String sEmailID = hmobj.get("EmailID").toString().trim();
		
		if(!TestUtil.click(OR.sBasicDetailsLink))
			return flag;
		if(!TestUtil.SelectDropDown(OR.sIAm_DD, sIAm))
			return flag;
		if(!TestUtil.SelectDropDown(OR.sAgreementCity_DD, sAgreementCity))
			return flag;
		if(!TestUtil.sendKeys(OR.sFirstName_Txtbx, sFirstName))
			return flag;
		if(!TestUtil.sendKeys(OR.sLastName_Txtbx, sLastName))
			return flag;
		if(!TestUtil.sendKeys(OR.sMobileNum_Txtbx, sMobileNumber))
			return flag;
		if(!TestUtil.sendKeys(OR.sEmailID_Txtbx, sEmailID))
			return flag;
		if(!TestUtil.jsClick(OR.sSaveAndContinue_Btn))
			return flag;
		if(!TestUtil.enterOTP(OR.sOTP_Txtbx))
			return flag;
		if(TestUtil.waitForObject(OR.sLogin_Btn))
			TestUtil.click(OR.sLogin_Btn);
		if(TestUtil.waitForObject(OR.sPopUp1))
			TestUtil.click(OR.sPopUp1CloseBtn);
		if(!TestUtil.click(OR.sLandlordDetailsLink))
			return flag;
		
		return true;
	}
	
	public static boolean fillLandlordDetails() throws Exception {
		
		boolean flag = false;
		hmobj = TestUtil.excelReader("TestData", "LandlordDetails");
		
		String sFirstName = hmobj.get("FirstName").toString().trim();
		String sLastName = hmobj.get("LastName").toString().trim();
		String sAge = hmobj.get("Age").toString().trim();
		String sPAN = hmobj.get("PAN").toString().trim();
		String sMobileNumber = hmobj.get("MobileNumber").toString().trim();
		String sEmailID = hmobj.get("EmailID").toString().trim();
		String sAddressLine1 = hmobj.get("AddressLine1").toString().trim();
		String sAddressLine2 = hmobj.get("AddressLine2").toString().trim();
		String sCity = hmobj.get("City").toString().trim();
		String sPin = hmobj.get("PinCode").toString().trim();
		String sState = hmobj.get("State").toString().trim();
		String sCountry = hmobj.get("Country").toString().trim();
		String sLandmark = hmobj.get("LandMark").toString().trim();
		
		if(!TestUtil.sendKeys(OR.sFirstName_Txtbx, sFirstName))
			return flag;
		if(!TestUtil.sendKeys(OR.sLastName_Txtbx, sLastName))
			return flag;
		if(!TestUtil.sendKeys(OR.sAge_Txtbx, sAge))
			return flag;
		if(!TestUtil.sendKeys(OR.sPAN_Txtbx, sPAN))
			return flag;
		if(!TestUtil.sendKeys(OR.sMobileNum_Txtbx, sMobileNumber))
			return flag;
		if(!TestUtil.sendKeys(OR.sEmailID_Txtbx, sEmailID))
			return flag;
		if(!TestUtil.sendKeys(OR.sAddressLine1_Txtbx, sAddressLine1))
			return flag;
		if(!TestUtil.sendKeys(OR.sAddressLine2_Txtbx, sAddressLine2))
			return flag;
		if(!TestUtil.sendKeys(OR.sCity_Txtbx, sCity))
			return flag;
		if(!TestUtil.sendKeys(OR.sPin_Txtbx, sPin))
			return flag;
		if(!TestUtil.sendKeys(OR.sState_Txtbx, sState))
			return flag;
		if(!TestUtil.sendKeys(OR.sCountryTxtbx, sCountry))
			return flag;
		if(!TestUtil.sendKeys(OR.sLandmark_Txtbx, sLandmark))
			return flag;
		if(!TestUtil.jsClick(OR.sSaveAndContinue_Btn))
			return flag;
		if(TestUtil.waitForObject(OR.sPopUp2))
			TestUtil.click(OR.sPopUp2);
		
		
		return true;
	}
	
public static boolean fillTenantDetails() throws Exception {
		
		boolean flag = false;
		hmobj = TestUtil.excelReader("TestData", "TenantDetails");
		
		String sFirstName = hmobj.get("FirstName").toString().trim();
		String sLastName = hmobj.get("LastName").toString().trim();
		String sAge = hmobj.get("Age").toString().trim();
		String sPAN = hmobj.get("PAN").toString().trim();
		String sMobileNumber = hmobj.get("MobileNumber").toString().trim();
		String sEmailID = hmobj.get("EmailID").toString().trim();
		String sAddressLine1 = hmobj.get("AddressLine1").toString().trim();
		String sAddressLine2 = hmobj.get("AddressLine2").toString().trim();
		String sCity = hmobj.get("City").toString().trim();
		String sPin = hmobj.get("PinCode").toString().trim();
		String sState = hmobj.get("State").toString().trim();
		String sCountry = hmobj.get("Country").toString().trim();
		String sLandmark = hmobj.get("LandMark").toString().trim();
		
		if(!TestUtil.sendKeys(OR.sFirstName_Txtbx, sFirstName))
			return flag;
		if(!TestUtil.sendKeys(OR.sLastName_Txtbx, sLastName))
			return flag;
		if(!TestUtil.sendKeys(OR.sAge_Txtbx, sAge))
			return flag;
		if(!TestUtil.sendKeys(OR.sPAN_Txtbx, sPAN))
			return flag;
		if(!TestUtil.sendKeys(OR.sMobileNum_Txtbx, sMobileNumber))
			return flag;
		if(!TestUtil.sendKeys(OR.sEmailID_Txtbx, sEmailID))
			return flag;
		if(!TestUtil.sendKeys(OR.sAddressLine1_Txtbx, sAddressLine1))
			return flag;
		if(!TestUtil.sendKeys(OR.sAddressLine2_Txtbx, sAddressLine2))
			return flag;
		if(!TestUtil.sendKeys(OR.sCity_Txtbx, sCity))
			return flag;
		if(!TestUtil.sendKeys(OR.sPin_Txtbx, sPin))
			return flag;
		if(!TestUtil.sendKeys(OR.sState_Txtbx, sState))
			return flag;
		if(!TestUtil.sendKeys(OR.sCountryTxtbx, sCountry))
			return flag;
		if(!TestUtil.sendKeys(OR.sLandmark_Txtbx, sLandmark))
			return flag;
		if(!TestUtil.jsClick(OR.sSaveAndContinue_Btn))
			return flag;
		
		
		
		return true;
	}
	
	public static boolean fillItemsDetails() {
		
		boolean flag = false;
		
		if(!TestUtil.jsClick(OR.sSaveAndContinue_Btn))
			return flag;
		
		if(!TestUtil.jsClick(OR.sSubmit_Btn))
			return flag;
		
		return true;
		
	}
	
	public static String extractCharges(String xpath) {
		
		WebElement ele = driver.findElement(By.xpath(xpath));
		
		String charges = ele.getText().trim();
		
		return charges;
		
	}
	
	public static boolean extractFees() throws Exception {
		
		boolean flag = false;
		
		String sTotalfees;
		String sRegistration;
		String sStampDuty;
		String sDocumentHandling;
		String sDoorStepBiometric;
		String sConvenienceFees;
		String sDraftingAssistance;
		
		WebElement totalfees = driver.findElement(By.xpath(OR.sTotalFees));
		
		sTotalfees = totalfees.getText().split("Total fees:")[1].trim();
		
		sRegistration = extractCharges(OR.sRegistration);
		sStampDuty = extractCharges(OR.sStampDuty);
		sDocumentHandling = extractCharges(OR.sDocumentHandlingCharges);
		sDoorStepBiometric = extractCharges(OR.sDoorstepBiometricCharges);
		sConvenienceFees = extractCharges(OR.sConvenienceFees);
		sDraftingAssistance = extractCharges(OR.sDraftingFees);
		
		List<String> listCharges = new ArrayList();
		
		listCharges.add(sTotalfees);
		listCharges.add(sRegistration);
		listCharges.add(sStampDuty);
		listCharges.add(sDocumentHandling);
		listCharges.add(sDoorStepBiometric);
		listCharges.add(sConvenienceFees);
		listCharges.add(sDraftingAssistance);
		
		writeDataToExcel(listCharges);
		
		return true;
		
	}
	
}
