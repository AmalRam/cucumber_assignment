package com.monster.cucumber;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import 	org.openqa.selenium.interactions.Action;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MonsterIndiaFeature {
	
	
	static WebDriver wd;

	@Before
	public static void init()
	{
		WebDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		wd.manage().window().maximize();
	}	
	
	  @Given("the user is on Monster login page")
	  public void the_user_is_on_Monster_login_page()
	  {
		  wd.get("https://www.monsterindia.com/");
	  }
	  @When("the user enters into login page")
	  public void the_user_enters_into_login_page()
	  {
		  wd.findElement(By.xpath("//*[@id=\"seekerLoginBtn\"]/a/span[2]")).click();
	   }
	  @And("enters the email id")
	  public void enters_the_email_id()
	  {
		  wd.findElement(By.id("signInName")).sendKeys("amalrammangalathoffical@gmail.com");
	  }
	  @And("enters the password")
	  public void enters_the_password()
	  {
		  wd.findElement(By.name("password")).sendKeys("#Amal9876");
	  }
	  @And("clicks the login button")
	  public void clicks_the_login_button()
	  {
		  wd.findElement(By.xpath("//*[@id=\"signInbtn\"]")).click();
	  }
	  @Then("the dashboard page should be displayed")
	  public void the_dashboard_page_should_be_displayed() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  assertTrue(wd.getCurrentUrl().contains("https://www.monsterindia.com/?importProfile=check"));	 
	  }
	  
	  @When("the user enters a search keyword")
	  public void the_user_enters_a_search_keyword()
	  {
		  wd.findElement(By.id("SE_home_autocomplete")).sendKeys("java"); 
	  }
	  
	  @And("click the search icon")
	  public void click_the_search_icon()
	  {
		  wd.findElement(By.xpath("//*[@id=\"searchForm\"]/div/div[2]")).click();	 
		 
	  }
	  
	  @Then("the search result should be displayed")
	  public void the_search_result_should_be_displayed() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  assertTrue(wd.getCurrentUrl().contains("https://www.monsterindia.com/srp/results?"));
	   }
	  
	  @When("the user hover on to the icon")
	  public void the_user_hover_on_to_the_icon() throws InterruptedException
	  {
		Actions builder = new Actions(wd);
		WebElement img1 = wd.findElement(By.id("usrLoggedInUi"));
		org.openqa.selenium.interactions.Action mouseOver = builder.moveToElement(img1).build();
		mouseOver.perform();
		Thread.sleep(8000);
	  }
	  @And("click on the logout button")
	  public void click_on_the_logout_button() throws InterruptedException
	  {
		  WebElement hoverObj = wd.findElement(By.xpath("//*[@id=\"usrLoggedInUi\"]/div/ul/li[8]/a"));
		  hoverObj.click();
		  Thread.sleep(8000);
	  }
	  @Then("the user is able to logout from the page")
	  public void the_user_is_able_to_logout_from_the_page() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  assertTrue(wd.getCurrentUrl().equals("https://www.monsterindia.com/rio/sign-out"));
	  }
	  
}
