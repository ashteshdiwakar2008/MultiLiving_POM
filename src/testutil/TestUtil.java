package testutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.TestBase;

public class TestUtil extends TestBase {

	static String filePath = "D:\\Selenium Tests\\MultiLiving_POM\\Screenshots\\";
	static boolean flag;
	public static boolean click(String xpath) {
		flag = false;
		WebElement ele = driver.findElement(By.xpath(xpath));

		if (ele.isDisplayed()) {
			ele.click();
			System.out.println("Clicked on WebELement: " + xpath);
			flag = true;

		} else
			System.out.println("Element not clickable");

		return flag;
	}
	
	public static boolean jsClick(String xpath) {
		flag = false;
		WebElement ele = driver.findElement(By.xpath(xpath));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
		System.out.println("Clicked on WebELement: " + xpath);
		flag = true;

		return flag;
	}

	public static boolean sendKeys(String xpath, String data) {
		flag = false;
		WebElement ele = driver.findElement(By.xpath(xpath));

		if (ele.isDisplayed()) {
			if (data.equals(""))
				System.out.println("Skipped element: " + xpath);
			else {
				ele.clear();
				ele.sendKeys(data);
			}
			System.out.println("Entered data to WebELement: " + xpath);
			flag = true;

		} else
			System.out.println("Element not displayed");

		return flag;
	}

	public static boolean enterOTP(String xpath) {

		flag = false;
		WebElement ele = driver.findElement(By.xpath(xpath));

		if (ele.isDisplayed()) {

			System.out.println("Enter OTP received on Mobile Number: ");
			Scanner sc = new Scanner(System.in);
			ele.sendKeys(sc.nextLine().toString().trim());
			System.out.println("OTP Entered successfully!");
			flag = true;
		} else
			System.out.println("Element not displayed");

		return flag;
	}

	public static boolean SelectDropDown(String xpath, String data) {
		flag = false;
		WebElement ele = driver.findElement(By.xpath(xpath));

		if (ele.isDisplayed()) {
			Select oSelect = new Select(ele);
			oSelect.selectByVisibleText(data);
			System.out.println("Dropdown data selected for WebELement: " + xpath);
			flag = true;

		} else
			System.out.println("Element not displayed");

		return flag;
	}

	public static boolean waitForObject(String xpath) throws InterruptedException {
		flag = false;

		for (int i = 0; i < 3; i++) {
			try {
				WebElement ele = driver.findElement(By.xpath(xpath));
				if (ele.isDisplayed()) {
					System.out.println("Element found in wait for object method: "+xpath);
					flag = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("Wait for Element in progress: " +xpath);
				Thread.sleep(1000);
			}
			
		}

		return flag;
	}

	public static boolean mouseHover(String xpath) {

		boolean flag = false;

		WebElement ele = driver.findElement(By.xpath(xpath));

		Actions action = new Actions(driver);

		if (ele.isDisplayed()) {
			action.moveToElement(ele).build().perform();

			System.out.println("Action builder to mouse Hover around element: " + xpath);
			flag = true;
		} else
			System.out.println("Failed to mouse hover: " + xpath);

		return flag;
	}

	public static boolean alertHandler(String option) {
		boolean flag = false;
		Alert alert = driver.switchTo().alert();

		if (option.equalsIgnoreCase("Accept")) {
			alert.accept();
			flag = true;
		} else if (option.equalsIgnoreCase("Dismiss")) {
			alert.dismiss();
			flag = true;
		} else
			System.out.println("Failed to operate Alert function: ");

		return flag;
	}

	public static HashMap<String, String> excelReader(String ExcelName, String SheetName) throws Exception {
		HashMap<String, String> data = new HashMap<String, String>();
		File file = new File(filepath + "\\" + testdatafilename);

		// Create an object of FileInputStream class to read excel file

		FileInputStream inputStream = new FileInputStream(file);

		// Read sheet inside the workbook by its name
		Workbook wb = new XSSFWorkbook(inputStream);

		Sheet excelsheet = wb.getSheet(SheetName);
		String cellvalueI = null;
		String cellvalueJ = null;

		// Find number of rows in excel file

		int rowCount = excelsheet.getLastRowNum() - excelsheet.getFirstRowNum();

		Object obj[][] = new Object[rowCount][1];
		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i < rowCount + 1; i++) {

			Row row = excelsheet.getRow(i);

			// Create a loop to print cell values in a row

			for (int j = 0; j < row.getLastCellNum(); j++) {

				// Print Excel data in console
				cellvalueI = excelsheet.getRow(0).getCell(j).toString();
				cellvalueJ = excelsheet.getRow(i).getCell(j).toString();
				data.put(cellvalueI, cellvalueJ);

				// System.out.print(row.getCell(j).getStringCellValue()+"|| ");

			}

		}
		System.out.println("Data in HashMap: " + data);
		return data;
	}

	public static void takeScreenShot(String methodName, WebDriver odriver) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test method name
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
