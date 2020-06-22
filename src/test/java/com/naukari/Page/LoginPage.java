package com.naukari.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH, using ="//input[@placeholder='Enter your active Email ID / Username']")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(how=How.XPATH, using ="//input[@placeholder='Enter your password']")
	@CacheLookup
	WebElement Password;
	
	@FindBy(how=How.XPATH, using ="//button[@type='submit']")
	@CacheLookup
	WebElement Submit;
	
	@FindBy(how=How.XPATH, using ="//div[text()='UPDATE PROFILE']")
	@CacheLookup
	WebElement Updateprofile;
	
	@FindBy(how=How.ID, using="attachCV")
	@CacheLookup
	WebElement UploadResume;
	
	public void username() {
		UserName.sendKeys("vmegha30@gmail.com");
	}
	public void password() {
		Password.sendKeys("Change2$");
	}
	public void submitbtn() {
		Submit.click();
	}
	public void updtpr() {
		Updateprofile.click();
	}
	public void upload() {
		UploadResume.sendKeys("D:\\Testing\\Resume.doc");
	}
}
