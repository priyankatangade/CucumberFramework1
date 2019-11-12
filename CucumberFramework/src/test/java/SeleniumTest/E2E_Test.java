package SeleniumTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2E_Test {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\priya\\software\\software\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("http://www.shop.demoqa.com");
		driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
		List<WebElement> item = driver.findElements(By.cssSelector(".noo-product-inner"));
		item.get(0).click();
		Select select=new Select(driver.findElement(By.id("pa_color")));
		select.selectByVisibleText("White");
		Select select1=new Select(driver.findElement(By.id("pa_size")));
		select1.selectByVisibleText("Small");
		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();
		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();
		WebElement ProceedToCheckout = driver.findElement(By.xpath("//div[@class='wc-proceed-to-checkout']//a"
				+ ""));
		ProceedToCheckout.click();
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");
		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");
		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("abc@gmail.com");
		WebElement phoneNumber = driver.findElement(By.cssSelector("#billing_phone"));
		phoneNumber.sendKeys("07438862327");
	
		WebDriverWait wait=new WebDriverWait(driver,30);
		
	  WebElement state=driver.findElement(By.id("billing_state_field"));
	  
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].click();", state);
	 //wait.until(ExpectedConditions.elementToBeClickable(state));
	 //state.click();
	  executor.executeScript("document.getElementById('billing_state_field').value='Goa';");
	  
	/*  List<WebElement>stateDropdown=driver.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
	  for(WebElement statedd:stateDropdown)
	  {
		  if(statedd.getText().equals("Bihar"))
		  { statedd.click();
		  Thread.sleep(2000);
		  break;
	  }
	  }*/
		
	
	
	WebElement city=driver.findElement(By.cssSelector("#billing_city"));
	city.sendKeys("Delhi");
	WebElement address=driver.findElement(By.cssSelector("#billing_address_1"));
	address.sendKeys("Shalimar Bag");
	WebElement postcode=driver.findElement(By.cssSelector("#billing_postcode"));
	postcode.sendKeys("110088");
/*WebElement shiftToDifferentAddress=driver.findElement(By.cssSelector("ship-to-different-address-checkbox"));
	shiftToDifferentAddress.click();
	Thread.sleep(3000);
	List<WebElement> paymentMethod=driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
	paymentMethod.get(0).click();*/
	WebElement acceptTC=driver.findElement(By.cssSelector("#terms.input-checkbox"));
	acceptTC.click();
	WebElement placeOrder=driver.findElement(By.cssSelector("#place_order"));
	//wait.until(ExpectedConditions.invisibilityOf(placeOrder));	
	Actions actions = new Actions(driver); 
	actions.moveToElement(placeOrder).click().perform();
	//placeOrder.click();
	driver.quit();
			
			
	}
}

