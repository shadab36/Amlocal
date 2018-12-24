package TestRunner.loginSteps;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ObjectRepository.FbandGP_Object;
import ObjectRepository.SignupObject;
import TestRunner.SetupClass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import webApp.PerformAction;

public class Facebook_signin_paid_user_stepDefinition extends SetupClass {
	PerformAction wait = new PerformAction();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Random rad = new Random();

	// Open web site URl
	@Given("^Open given the application URL$")
	public void navigates_to_website_url() throws InterruptedException  {
		// Maximize Windows
		driver.get("https://www.slideteam.net");
		 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		try {
			webelement = driver.findElement(SignupObject.close_add);
			webelement.click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} catch (NoSuchElementException popup) {
		}

		try {
			WebElement logout = driver.findElement(By.cssSelector("#header>div .header-minicart>a[title='Sign Out']"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	}

	@And("^go to Complete ppts$")
	public void click_most_download() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignupObject.Most));
		webelement = driver.findElement(SignupObject.Most);
		webelement.click();
		
	
	}

	@And("^product as Project Scoping Powerpoint$")
	public void select_product() throws InterruptedException {
		webelement = driver.findElement(SignupObject.Select_item);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(3000);
	}

	@And("^Click on download this presentation$")
	public void click_on_Download_thist_presentation_link() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SignupObject.Downloaded));
		webelement = driver.findElement(SignupObject.Downloaded);
		js.executeScript("arguments[0].click();", webelement);
		Thread.sleep(3000);
	}

	@And("^Click on test fblink$")
	public void fb_link() throws InterruptedException {
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		webelement = driver.findElement(FbandGP_Object.fbLink);
		webelement.click();
		Thread.sleep(4000);
	}

	@Then("^user email as$")
	public void enter_user_mail() throws InterruptedException {
		
		try {
	WebElement fbemail = driver.findElement(FbandGP_Object.Femai);
	fbemail.click();
		wait.implictywait(driver);
		fbemail.clear();
		wait.implictywait(driver);
		fbemail.sendKeys("sumit.kumar@slidetech.in");
		Thread.sleep(1000);
	

		} catch (NoSuchElementException nonemaillink) {

		}}

	@Then("^user password as$")
	public void enter_user_password() throws Throwable {
		try {
		webelement = driver.findElement(FbandGP_Object.Fpassword);
		webelement.click();
		wait.implictywait(driver);
		webelement.clear();
		wait.implictywait(driver);
		webelement.sendKeys("redhat2090");
		Thread.sleep(1000);
		wait.implictywait(driver);

	
} catch (NoSuchElementException password) {

}}

	@Then("^click on Login button$")
	public void click_on_Login_button() throws Throwable {
		try {
		webelement = driver.findElement(FbandGP_Object.FbLogin);
		wait.implictywait(driver);
		webelement.click();
		wait.implictywait(driver);
		Thread.sleep(2000);
		} catch (NoSuchElementException logincta) {
			
		}
		try {
			webelement = driver.findElement(FbandGP_Object.continue_as_QA);
			webelement.click();
			Thread.sleep(1000);
		} catch (NoSuchElementException qalink) {

		}
		try {
			WebElement close = driver.findElement(By.cssSelector(".fancybox-item.fancybox-close"));
			wait.implictywait(driver);
			close.click();
			Thread.sleep(500);
		} catch (NoSuchElementException nonpoptest) {

		}
		

	}
	@Then("^See the this link as download this presenetion link is appeared$")
	public void verify_uesr_validation_message_for_Email_Address() throws Throwable {

		try {
			String Email_test = driver.findElement(SignupObject.Downloaded).getText();
			Thread.sleep(1000);
			wait.implictywait(driver);
			String Expected_Cta = "Download this presentation";
			wait.implictywait(driver);
			Assert.assertEquals(Expected_Cta, Email_test);
			wait.implictywait(driver);
			Thread.sleep(1000);
			System.out.println(Email_test);
		} catch (NoSuchElementException er1) {

		}
	}

}

