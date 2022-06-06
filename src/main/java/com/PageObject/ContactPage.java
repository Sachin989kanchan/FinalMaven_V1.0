package com.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public WebDriver ldriver;
	public ContactPage(WebDriver rdriver)
	{
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="name_contact")
	WebElement fname;
	
	@FindBy(id="lastname_contact")
	WebElement lname;
	
	@FindBy(id="email_contact")
	WebElement email;
	
	@FindBy(id="phone_contact")
	WebElement phone;
	
	@FindBy(id="message_contact")
	WebElement message;
	
	public void fname(String f_name)
	{
		fname.sendKeys(f_name);
		
	}
	public void lname(String l_name)
	{
		lname.sendKeys(l_name);
	}
	
	public void email(String e_email)
	{
		email.sendKeys(e_email);
	}
	public void message(String m_message)
	{
		message.sendKeys(m_message);
	}
	public void phone(String p_phone)
	{
		phone.sendKeys(p_phone);
	}
	
	
}
