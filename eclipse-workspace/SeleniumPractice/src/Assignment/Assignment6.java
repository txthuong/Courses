package Assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//WebElement checkBox = driver.findElement(By.id("checkBoxOption2"));
		WebElement checkBoxField = driver.findElement(By.id("checkbox-example"));
		List<WebElement> checkBoxList = checkBoxField.findElements(By.tagName("input"));
		//List<WebElement> checkBoxList = driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		
		for (WebElement checkBox: checkBoxList)
		{
			checkBox.click();
			String checkBoxValue = checkBox.getAttribute("value");
			System.out.println("Start testing checkbox: " + checkBoxValue);
			
			WebElement dropDown = driver.findElement(By.id("dropdown-class-example"));
			Select dropDownList = new Select(dropDown);
			dropDownList.selectByValue(checkBoxValue);
			
			driver.findElement(By.id("name")).sendKeys(checkBoxValue);
			driver.findElement(By.id("alertbtn")).click();
			
			String alertText = driver.switchTo().alert().getText();
			if (alertText.contains(checkBoxValue)) 
			{
				System.out.println(checkBoxValue + ": PASSED !!!");
			}
			else
			{
				System.out.println(checkBoxValue + ": FAILED !!!");
			}
			driver.switchTo().alert().accept();
			checkBox.click();
		}

		
	}

}
