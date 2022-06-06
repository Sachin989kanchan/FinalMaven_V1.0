package com.TestCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BaseClass.BaseClass;
import com.PageObject.LoginPage;
import com.Utilities.ReadExcel;
public class DataDriventest_TC01 extends BaseClass {
public DataDriventest_TC01() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(dataProvider="LoginData")
	public void TC_DDT1(String param_username,String param_password)
	 {
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(param_username);
	logger.info("Username Provided");
	lp.setPassword(param_password);
	logger.info("Password provided");
	lp.ClickSubmit();
	logger.info("Submit");
	
	if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
	{
		
		Assert.assertTrue(true);
		logger.info("Title Passed -Test Passed");
	}
	else 
	{
		Assert.assertTrue(false);
		logger.info("Not Expected Title-Failed");
	}
}
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
	String path=System.getProperty("user.dir")+"/src/main/java/com/Utilities/Exceldata.xlsx";
	int rowcounts=ReadExcel.getrowcount(path,"Sheet1");
	int colcounts=ReadExcel.getcellcount(path, "Sheet1",1);
	
	String logindata[][]=new String[rowcounts][colcounts];
		
	for(int i=1; i<rowcounts; i++)
	{
		for(int j=0; j<colcounts; j++)
		{
			logindata[i-1][j]=ReadExcel.getCellData(path, "Sheet1",i,j);
		}
	}
	return logindata;
	
	
	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

