package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseClass {

	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBaseClass(){
		try{
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/com/config/Config.Properties");		
		prop.load(ip);
		}catch (FileNotFoundException e) {
			   e.printStackTrace();
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
	}
	public static void initialize() {

		  if (prop.getProperty("browser").equals("chrome")) {
		   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/com/drivers/chromedriver.exe");
		   driver = new ChromeDriver();
		  } else if (prop.getProperty("browser").equals("FF")) {
		   System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/src/com/drivers/geckodriver.exe");
		   driver = new FirefoxDriver();
		  }

		  driver.manage().window().maximize();
		  driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		  
	}
	public static void navigate(){
		  driver.get(prop.getProperty("url"));
		  driver.manage().deleteAllCookies();
	
	}
}
