package com.MonsterLoginPOM.TestPage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.MonsterLoginPOM.page.DashboardPage;
import com.MonsterLoginPOM.page.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest 
{
static WebDriver wd;
LoginPage loginPage= null;
	
	@BeforeClass
	public static void init() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
		WebDriverManager.firefoxdriver().setup();
		wd = new FirefoxDriver();
		wd.manage().window().maximize();
		wd.get("https://www.monsterindia.com/");
		wd.findElement(By.xpath("//*[@id=\"seekerLoginBtn\"]/a/span[2]")).click();	
	}
	
	@Test
	public void validLoginTest() throws Exception
	{
		loginPage = new LoginPage(wd);
		PageFactory.initElements(wd, loginPage);
		DashboardPage dbPage = loginPage.validLogin("amalrammangalathoffical@gmail.com", "#Amal9876");
		PageFactory.initElements(wd, dbPage);
		//boolean loginstatus = dbPage.getWelcomeMessage().contains("AK");
		//assertTrue(loginstatus);
		Thread.sleep(6000);
		assertTrue(wd.getCurrentUrl().equals("https://www.monsterindia.com/?importProfile=check"));
	}
	


}