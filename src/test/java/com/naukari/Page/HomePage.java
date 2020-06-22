package com.naukari.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH, using ="//div[text()='UPDATE PROFILE']")
	@CacheLookup
	WebElement Updateprofile;

	public void updtpr() {
		Updateprofile.click();
	}
}
