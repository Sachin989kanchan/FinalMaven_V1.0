package com.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	public ReadConfig() throws IOException
	{
		String File=System.getProperty("user.dir")+"/configuration/config.properties/";
		FileInputStream fis=new FileInputStream(File);
		pro=new Properties();
		pro.load(fis);
				
	}
	public String baseurl()
	{
		String baseurl=pro.getProperty("baseurl");
		return baseurl;
	}
	public String username()
	{
		String username=pro.getProperty("username");
		return username;
		
	}
	public String password()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String chromedriver()
	{
		String chromedriver=pro.getProperty("chromedriver");
		return chromedriver;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
