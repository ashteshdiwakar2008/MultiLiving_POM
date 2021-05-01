package pages;

public class OR {

	
	
	//***************Multi Living **********************
	
	public static String sBasicDetailsLink = "//*[text()='Basic Details']";
	public static String sLandlordDetailsLink = "//*[text()='LandLord Details']";
	
	public static String sIAm_DD= "//select[@id='party_type']";
	public static String sAgreementCity_DD = "//select[@id='inputCity']";
	public static String sFirstName_Txtbx = "//input[@id='inputFirstName']";
	public static String sLastName_Txtbx = "//input[@id='inputLastName']";
	public static String sMobileNum_Txtbx = "//input[@id='inputMobile']";
	public static String sEmailID_Txtbx = "//input[@id='inputMailId']|//input[@id='inputEmail']";//"//input[contains(@id='inputEmail']";
	public static String sSaveAndContinue_Btn = "//*[text()='Save and Continue']";
	public static String sOTP_Txtbx = "//input[@name='otp']";
	public static String sLogin_Btn = "//button[text()='Login']";
	
	public static String sAge_Txtbx = "//input[@id='inputAge']";
	public static String sPAN_Txtbx = "//input[@id='inputPan']";
	public static String sAddressLine1_Txtbx = "//input[@id='inputAddress1']";
	public static String sAddressLine2_Txtbx = "//input[@id='inputAddress2']";
	public static String sCity_Txtbx = "//input[@id='inputCity']";
	public static String sPin_Txtbx = "//input[@id='inputPin']";
	public static String sState_Txtbx = "//input[@id='inputState']";
	public static String sCountryTxtbx = "//input[@id='inputCountry']";
	public static String sLandmark_Txtbx= "//input[@id='inputLandmark']";
	public static String sSubmit_Btn = "//*[text()='Submit']";
	
	public static String sTotalFees = "//*[contains(text(),'Total fees:')]";
	public static String sRegistration = "(//*[contains(text(),'Total fees')]/following::*[contains(text(),'Registration')])[1]/parent::*";
	public static String sStampDuty = "(//*[contains(text(),'Total fees')]/following::*[contains(text(),'Stamp Duty')])[1]/parent::*";
	public static String sDocumentHandlingCharges = "(//*[contains(text(),'Total fees')]/following::*[contains(text(),'Document Handling')])[1]/parent::*";
	public static String sDoorstepBiometricCharges = "(//*[contains(text(),'Total fees')]/following::*[contains(text(),'Doorstep')])[1]/parent::*";
	public static String sConvenienceFees = "(//*[contains(text(),'Total fees')]/following::*[contains(text(),'Convenience')])[1]/parent::*";
	public static String sDraftingFees = "(//*[contains(text(),'Total fees')]/following::*[contains(text(),'Drafting')])[1]/parent::*";

	public static String sPopUp1 = "//*[@alt='Rental Agreement Guide Popup']";
	public static String sPopUp1CloseBtn = "//*[@data-testid='close-icon']";
	
	public static String sPopUp2 = "//button[@data-testid='close-button']";
	
	
	
	
}
