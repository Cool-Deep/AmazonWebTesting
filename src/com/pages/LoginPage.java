package com.pages;

import org.openqa.selenium.By;

import com.utilities.TestBaseClass;

public class LoginPage extends TestBaseClass {
	
	public void loginPara(String username, String password){
		driver.findElement(By.id("ap_email")).sendKeys(username);
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
	}
	
	

}
