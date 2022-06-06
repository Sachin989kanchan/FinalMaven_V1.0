package com.BaseClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Utilities.ReadConfig;
public class BaseClass {
public BaseClass() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	ReadConfig readconfig=new ReadConfig();
	public  static WebDriver driver;
	public static Logger logger;
	public String baseurl=readconfig.baseurl();
	public String username=readconfig.username();
	public String password=readconfig.password();
	public String path;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup( String br)
	{
		logger =Logger.getLogger("Live");
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/log4j/log4j.properties");
		if(br.equals("chrome"))
		{
			
		System.setProperty("webdriver.chrome.driver",readconfig.chromedriver());
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseurl);
		driver.manage().deleteAllCookies();
		logger.info("Cookies Deleted");
		
		logger.info("********************************************************************************************************************************");
		logger.info("********************************************************************************************************************************");
		logger.info("********************************************************************************************************************************");

		}
	else if(br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	else
	{
		System.out.print("Please Select Borwser no value passed to the Browser");
	}

}
	
	

	@AfterClass
	public void TearDown()
	{
		driver.close();
		logger.info("Test Completed Successfully");
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
	    String screenshotBase64 = ((TakesScreenshot) ts).getScreenshotAs(OutputType.BASE64);

		File target=new File(System.getProperty("user.dir")+"/screenshots/"+tname+".png");
		FileUtils.copyFile(source,target);
		System.out.print("Screenshot taken");
	}

	
}
