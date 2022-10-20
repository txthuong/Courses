import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Practice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id='checkBoxOption1']")).isSelected());
		
		List<WebElement> checkboxList = driver.findElements(By.cssSelector("input[type='checkbox']"));
		
		System.out.println(checkboxList.size());
		
		for (WebElement checkbox :checkboxList)
		{
			String checkboxName = checkbox.getAttribute("name");
			System.out.println(driver.findElement(By.xpath("//input[@name='"+checkboxName+"']/parent::label")).getAttribute("for"));
			
			checkbox.click();
			Assert.assertTrue(checkbox.isSelected());
			
			checkbox.click();
			Assert.assertFalse(checkbox.isSelected());
			
		}
		
		
		
	}

}
