package com.naukari.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.Logger;

public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public static Logger log;
	@BeforeMethod
	public WebDriver setup() throws IOException {
		log = LogManager.getLogger(BaseTest.class.getName());
		//Data file loading 
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\naukari\\Data\\Data.Properties");
			prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
		
		//get Browser Name from Data file
		String BrowserName=prop.getProperty("Browser");
		
		if(BrowserName.equals("Chrome")) {
			
			
			System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromePath"));
			driver = new ChromeDriver();
			log.info("Charome Browser is Opened");
		}
		else if(BrowserName.equals("FireFox")){
			System.setProperty("webdriver.gecko.driver",prop.getProperty("FireFoxPath"));
			driver = new FirefoxDriver();
			log.info("FireFox Browser is Opened");
		}
//		else {
//			System.setProperty("","");
//			driver = new InternetExplorerDriver();
//		}
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
		driver = null;
	}
}
