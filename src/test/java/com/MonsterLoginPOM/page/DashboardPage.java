package com.MonsterLoginPOM.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.MonsterLoginPOM.page.LoginPage;

public class DashboardPage
{
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) 
	{
		
		this.driver = driver;
		
	//	welcomeUser = driver.findElement(By.partialLinkText("Welcome"));
		
	}
	

	
	public LoginPage logoutSuccess() throws Exception
	{
		Thread.sleep(6000);
		Actions builder = new Actions(driver);
		WebElement img1 = driver.findElement(By.id("usrLoggedInUi"));
		org.openqa.selenium.interactions.Action mouseOver = builder.moveToElement(img1).build();
		mouseOver.perform();
		Thread.sleep(6000);
		WebElement hoverObj = driver.findElement(By.xpath("//*[@id=\"usrLoggedInUi\"]/div/ul/li[8]/a"));
		hoverObj.click();
		
		return new LoginPage(driver);
		
	}
	

}
