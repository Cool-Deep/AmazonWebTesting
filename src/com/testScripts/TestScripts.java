package com.testScripts;

import static org.testng.Assert.assertTrue;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.FirstPage;
import com.pages.LoginPage;
import com.utilities.TestBaseClass;

import junit.framework.Assert;


public class TestScripts extends TestBaseClass{
	TestBaseClass testBaseClass;
	LoginPage loginPage;
	FirstPage firstpage;	
	
	@BeforeTest
	public void setup(){
		
		testBaseClass = new TestBaseClass();
		TestBaseClass.initialize();
		TestBaseClass.navigate();		
		/*loginPage = new LoginPage();
		loginPage.loginPara(prop.getProperty("username"), prop.getProperty("password"));*/
		
	}
	
	@Test
	public void mouseOverForSignIn() throws InterruptedException{
		
		firstpage = new FirstPage();
		firstpage.mouseOverForSignIn();
	
		//Add Details For Users, Username and Password---> Call this param from TestBase class to the Config
		loginPage = new LoginPage();
		loginPage.loginPara(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void assertionCheckForUser(){
		firstpage.assertionCheckForUser();
	}
	
	
	
	
	

}
