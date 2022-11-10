package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String inputChar = "vi";
		String targetCountry = "Vietnam";
		
		driver.findElement(By.id("autocomplete")).sendKeys(inputChar);
		Thread.sleep(1000);
		List<WebElement> displayedCountries = driver.findElements(By.className("ui-menu-item-wrapper"));
		for (WebElement country: displayedCountries)
		{
			if (country.getText().equals(targetCountry))
			{	
				country.click();
				break;
			}

		}
		
		Actions a = new Actions(driver);
		WebElement coutryField = driver.findElement(By.id("autocomplete"));
		a.moveToElement(coutryField).doubleClick().sendKeys(Keys.DELETE).sendKeys(inputChar).build().perform();
		Thread.sleep(1000);
		List<WebElement> displayedCountries2 = driver.findElements(By.className("ui-menu-item-wrapper"));
		for (WebElement country: displayedCountries2)
		{
			if (country.getText().equals(targetCountry))
			{	
				a.moveToElement(country).click().build().perform();
				break;
			}
		}
		System.out.println(coutryField.getAttribute("value"));

	}

}
