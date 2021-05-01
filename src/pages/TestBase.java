package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static String xpathVariable="${variable}";
	public static String filepath=null;
	public static String resultfilepath=null;
	public static String testdatafilename=null;
	public static String testresultsfilename=null;
	
	public static void OpenBrowser() throws IOException
	{
		driver=null;
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Selenium Tests\\MultiLiving_POM\\src\\config\\config.properties");
		prop.load(fis);
		filepath=prop.getProperty("testdatapath");
		resultfilepath=prop.getProperty("testresultspath");
		testdatafilename=prop.getProperty("testdatafilename");
		testresultsfilename=prop.getProperty("testresultsfilename");
		
		if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("geckodriver.exe", "D:\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Running tests on firefox browser.");
			
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("chromedriver.exe", "D:\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Running tests on chrome Browser.");

		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
}
