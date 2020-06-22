package com.naukari.Test;


import java.util.Iterator;
import java.util.Set;

import org.apache.commons.math3.analysis.function.StepFunction;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.naukari.Page.HomePage;
import com.naukari.Page.LoginPage;

public class LoginTest extends BaseTest{
	@Test
	public void login() throws InterruptedException {
	//It will return parent window id as a string 
		String mainwindow = driver.getWindowHandle();
		System.out.println("Main window id = "+mainwindow);
		Set<String> childwindows=driver.getWindowHandles();
		Iterator<String> tr=childwindows.iterator();
		while(tr.hasNext()) {
			String child1= tr.next();
			if(!mainwindow.equals(child1)) {
				System.out.println(child1);
				System.out.println(driver.switchTo().window(child1).getTitle());
				driver.close();
			}

		}
		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		LoginPage logpg = new LoginPage(driver);
		logpg.username();
		logpg.password();
		logpg.submitbtn();
		Thread.sleep(5000);
		String HomePgTitle= driver.getTitle();
		
		if(HomePgTitle.equals("Home | Mynaukri")) {
			System.out.println(HomePgTitle);
			logpg.updtpr();
			Thread.sleep(5000);
		}
		
		if(driver.getTitle().equals("Profile | Mynaukri")) {
			logpg.upload();
			Thread.sleep(5000);
		}
	}
}
