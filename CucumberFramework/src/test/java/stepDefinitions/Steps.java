package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Steps {
	 WebDriver driver;
	 HomePage homePage;
	 ProductListingPage productListingPage;
	 CartPage cartPage;
	 CheckoutPage checkoutPage;
	 PageObjectManager pageObjectManager;
	 ConfigFileReader configFileReader;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page()  {
	    // Write code here that turns the phrase above into concrete actions
		configFileReader= new ConfigFileReader();
		 System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		System.setProperty("webdriver.chrome.driver","E:\\priya\\software\\software\\Drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		 pageObjectManager = new PageObjectManager(driver);
		 homePage = pageObjectManager.getHomePage();
		 homePage.navigateTo_HomePage(); 
	}

	@When("^she searches for \"([^\"]*)\"$")
	public void she_searches_for(String product) throws Throwable {
		homePage.perform_Search(product);
	}

	@When("^choose to buy first product$")
	public void choose_to_buy_first_product() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		productListingPage = pageObjectManager.getProductListingPage();
		 productListingPage.select_Product(0);
		 productListingPage.clickOn_AddToCart();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 cartPage = pageObjectManager.getCartPage();
		 cartPage.clickOn_Cart();
		 cartPage.clickOn_ContinueToCheckout();   
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkoutPage = pageObjectManager.getCheckoutPage();
		 checkoutPage.fill_PersonalDetails(); 
	}



	@When("^place the order$")
	public void place_the_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkoutPage.check_TermsAndCondition(true);
		 checkoutPage.clickOn_PlaceOrder();
		 
		 driver.quit();
	}


}
