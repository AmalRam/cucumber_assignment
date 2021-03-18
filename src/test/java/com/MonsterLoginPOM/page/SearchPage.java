package com.MonsterLoginPOM.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
WebDriver driver;
	
	WebElement SE_home_autocomplete;
    WebElement lmy;
    WebElement searchForm;  
	WebElement spanMessage;
	

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public DashboardPage search(String course,String location ) {
		
		return new DashboardPage(driver);	
	}
	
	

	
	public SearchPage validSearch(String skill, String location) throws Exception
	{
		Thread.sleep(4000);
		SE_home_autocomplete.sendKeys(skill);
		//password.sendKeys(password1);
		SE_home_autocomplete.click();
		Thread.sleep(4000);
		lmy.sendKeys(location);
		lmy.click();
		Thread.sleep(4000);
		searchForm.submit();
		
		return new SearchPage(driver);
		
	}
	

}
