package com.ashu.cucumber.stepfiles;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Login {
	WebDriver driver;
	
	/**
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/skadthan/Documents/Jars/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}
	**/
	
	@Before
	public void setup_firefox() {
		System.setProperty("webdriver.gecko.driver", "/Users/skadthan/Documents/Jars/geckodriver");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setCapability("marionette", true);
		this.driver = new FirefoxDriver(firefoxOptions);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		this.driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws InterruptedException {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
		this.driver = null;
	}
	
	@Given("^User navigates to stackoverflow website$")
	public void user_navigates_to_stackoverflow_website() throws Throwable {
		driver.get("https://stackoverflow.com/");
	}

	@And("^User clicks on the login button on homepage$")
	public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
	}

	@And("^User enters a valid username$")
	public void user_enters_a_valid_username() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("autotestudemy@mail.com");
	}

	@And("^User enters a valid password$")
	public void user_enters_a_valid_password() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Password321!");
	}

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='submit-button']")).click();
	}

	@Then("^User should be taken to the successful login page$")
	public void user_should_be_taken_to_the_successful_login_page() throws Throwable {
		Thread.sleep(3000);
		WebElement askQuestionButton = driver.findElement(By.xpath("//a[contains(text(), 'Ask Question')]"));
		Assert.assertEquals(true, askQuestionButton.isDisplayed());
	}
	
	
	@When("^User clicks on the selector button$")
	public void user_clicks_on_the_selector_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@aria-label='Site switcher']")).click();
	}

	@When("^User clicks on the log out on model$")
	public void user_clicks_on_the_log_out_on_model() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='log out']")).click();
	}

	@Then("^User should be taken to the successful log out page$")
	public void user_should_be_taken_to_the_successful_log_out_page() throws Throwable {
		Thread.sleep(3000);
	}

	@When("^User clicks on the Log out button$")
	public void user_clicks_on_the_Log_out_button() throws Throwable {
		
		driver.findElement(By.xpath("//button[contains(text(),'Log out')]")).click();
	}

	@When("^User should be taken to the successful home page$")
	public void user_should_be_taken_to_the_successful_home_page() throws Throwable {
		Thread.sleep(3000);
	}


	
}