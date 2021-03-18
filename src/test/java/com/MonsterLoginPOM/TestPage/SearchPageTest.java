package com.MonsterLoginPOM.TestPage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.MonsterLoginPOM.page.DashboardPage;
import com.MonsterLoginPOM.page.LoginPage;
import com.MonsterLoginPOM.page.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPageTest {
	
	static WebDriver wd;
	 
	LoginPage loginPage= null;
	
		
		@BeforeClass
		public static void init()
		{
			
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
						
			wd.manage().window().maximize();
			wd.get("https://www.monsterindia.com/rio/login");
			
		}
		

		@Test
		public void searchPage () throws Exception
		{
			loginPage = new LoginPage(wd);
			
			PageFactory.initElements(wd, loginPage);
			SearchPage scPage = loginPage.validLogin1("amalrammangalathoffical@gmail.com", "#Amal9876");
			
			PageFactory.initElements(wd, scPage);		
			scPage = scPage.validSearch("CPP","Calicut");
			Thread.sleep(3000);
			assertTrue(wd.getCurrentUrl().contains("https://www.monsterindia.com/srp/results?query=CPP&locations=Calicut"));
		}
}
