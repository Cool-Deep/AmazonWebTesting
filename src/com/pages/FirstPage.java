package com.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.utilities.TestBaseClass;

public class FirstPage extends TestBaseClass {

	
	public void mouseOverForSignIn() throws InterruptedException{
		
		//MouseOver option, It will expand and will open SignIn button
		WebElement element = driver.findElement(By.id("nav-link-accountList"));			
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        
        // Sign in Button click
        Thread.sleep(2000);
        driver.findElement(By.id("nav-flyout-ya-signin")).click(); 
        
        //Assertion for Checking that we are on right page or not. If not than it will failed that class
        String URL = driver.getTitle();
        assertEquals(URL, "Amazon Sign In");
        
	}
	
		
	public void assertionCheckForUser(){
		
		String Text = driver.findElement(By.xpath(".//*[@id='nav-link-accountList']/span[1]")).getText();
        System.out.println(Text);
        Assert.assertEquals("Hello, Kuldeep", Text);
        System.out.println("Successfully SignIn");
		
	}

}
