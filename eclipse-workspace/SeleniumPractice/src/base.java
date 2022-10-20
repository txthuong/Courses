import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//String[] neededProducts = {"Cucumber", "Brocolli", "Brinjal"};
		//List<String> neededProductList = Arrays.asList(neededProducts);
		
		Map<String, Integer> myCart = new HashMap<String, Integer>();
		myCart.put("Cucumber", 3);
		myCart.put("Brocolli", 2);
		myCart.put("Tomato", 5);
		myCart.put("Raspberry", 8);
		myCart.put("Carrot", 7);
		
		String promoCode = "rahulshettyacademy";
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
 	
		AddItems(driver, myCart);
		
		Map<String, Integer> addedCart = GetCartItems(driver);
		
		if (myCart.equals(addedCart))
		{
			System.out.println("---> TEST PASSED !!!");
		}
		else
		{
			System.out.println("---> TEST FAILED !!!");
		}
		
		Assert.assertEquals(EnterPromoteCode(driver, "invalid code"), "Invalid code ..!");
		Assert.assertEquals(EnterPromoteCode(driver, promoCode), "Code applied ..!");


		
		/*
		for (String product :neededProductList)
		{
			//for(int i=0; i<myCart.get(product); i++)
			//{
			//	driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/following-sibling::div[@class='stepper-input']/a[@class='increment']")).click();
			//}
			//driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/following-sibling::div[@class='product-action']/button")).click();
			System.out.println(product);
			//System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]")).getText());
			//System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/parent::div/div[@class='product-action']")).getText());
			//System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/parent::div/div[@class='product-action']/button[text()='ADD TO CART']")).getText());
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/parent::div/div[@class='product-action']/button[text()='ADD TO CART']")).click();
			WebElement addToCart = driver.findElement(By.xpath("//h4[contains(text(),'"+product+"')]/parent::div/div[@class='product-action']"));
			System.out.println(addToCart.getText());
			addToCart.click();
			System.out.println(product + " was added to cart !");
			Thread.sleep(5000);
		}
		*/

	}
	public static void AddItems(WebDriver driver, Map<String, Integer> myCart) {
		int itemCount=0;
		List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));
		List<String> neededProductList = new ArrayList<> (myCart.keySet());
		for (int i=0; i<products.size(); i++)
		{
			String productName = products.get(i).getText().split("-")[0].trim();							

			if (neededProductList.contains(productName))
			{	
				itemCount++;
				for (int j=0; j<(myCart.get(productName)-1); j++)
				{
					driver.findElements(By.cssSelector(".increment")).get(i).click();
				}
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();	
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				System.out.println(productName + " was added to cart !");
				//Thread.sleep(5000);
			}
			if (itemCount==neededProductList.size())
			{
				System.out.println("---> All products were added to the cart !!!");
				break;
			}
		}
	}
	
	public static void CheckCart(WebDriver driver, Map<String, Integer> myCart) {
		
	}
	
	public static Map<String, Integer> GetCartItems(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button")).click();
		Thread.sleep(5000);
		List<WebElement> addedItems = driver.findElements(By.className("product-name"));
		List<WebElement> addedQuantity = driver.findElements(By.className("quantity"));
		Map<String, Integer> myCart = new HashMap<String, Integer>();
		System.out.println("Items added in cart:");
		/*
		for (WebElement item :addedItems) {
			String productName = item.getText().split("-")[0].trim();
			System.out.println(item.getText());
		}
		*/
		for (int i=0; i<addedItems.size(); i++) {
			String productName = addedItems.get(i).getText().split("-")[0].trim();
			//System.out.println(productName);
			String productQuantity = addedQuantity.get(i).getText();
			//System.out.println(productQuantity);
			myCart.put(productName, Integer.parseInt(productQuantity));
			System.out.println(productName+": "+productQuantity);
		}
		return myCart;
	}
	
	public static String EnterPromoteCode(WebDriver driver, String code) throws InterruptedException {
		driver.findElement(By.className("promoCode")).clear();
		driver.findElement(By.className("promoCode")).sendKeys(code);
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		//w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.promoBtn")));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span[class='button.promo-btn-loader']")));
		String result =  driver.findElement(By.cssSelector("span.promoInfo")).getText();
		return result;
	}

}
