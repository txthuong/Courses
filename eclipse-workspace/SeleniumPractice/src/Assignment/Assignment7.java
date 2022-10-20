package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		int testRowIndex = 2;
		
		WebElement table = driver.findElement(By.xpath("//table[@name='courses']"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<WebElement> testRow = rows.get(testRowIndex).findElements(By.tagName("td"));
		
		System.out.println("Number of rows: " + Integer.toString(rows.size()));
		System.out.println("Number of columns: " + Integer.toString(testRow.size()));

		for (WebElement element: testRow)
		{
			System.out.println(element.getText());
		}
		

	}

}
