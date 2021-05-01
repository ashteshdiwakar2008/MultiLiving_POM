package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.TestAssignmentMethods;
import pages.TestBase;
import testutil.TestUtil;

public class RunTestAssignment extends TestBase {

	@BeforeClass
	public void initializeBrowser() throws Exception {
		OpenBrowser();
	}

	@Test
	public void runTest() throws Exception {
		Assert.assertTrue(TestAssignmentMethods.fillBasicDetails());
		Assert.assertTrue(TestAssignmentMethods.fillLandlordDetails());
		Assert.assertTrue(TestAssignmentMethods.fillTenantDetails());
		Assert.assertTrue(TestAssignmentMethods.fillItemsDetails());
		Assert.assertTrue(TestAssignmentMethods.extractFees());

	}

	@AfterMethod
	public void onTestFailure(ITestResult result) {
		if(result.FAILURE==ITestResult.FAILURE) {
		System.out.println("***** Error in Method " + result.getName() + " test has failed *****");
		String methodName = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		//driver = (WebDriver) context.getAttribute("driver");
		TestUtil.takeScreenShot(methodName, driver);
		}
		else if(result.SUCCESS==ITestResult.SUCCESS){
			System.out.println("***** Method " + result.getName() + " executed successfully *****");
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("End of Tests:");
	}

}
