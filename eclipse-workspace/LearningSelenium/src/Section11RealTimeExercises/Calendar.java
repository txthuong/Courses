package Section11RealTimeExercises;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().window().maximize();
		
		String pickDay = "21";
		String pickMonth = "November";
		String pickYear = "2024";

		//driver.findElement(By.id("form-field-travel_comp_date")).click();
		WebElement calendar = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", calendar);
		Thread.sleep(500);
		calendar.click();
		
		
		while (!driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(0).getAttribute("aria-label").contains(pickYear))
		{
			driver.findElement(By.xpath("//span[@class='arrowUp']")).click();
		}
		
		while(!driver.findElement(By.xpath("//div[@class='flatpickr-current-month']")).getText().contains(pickMonth)) 
		{
			driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}

		List<WebElement> dates = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		
		for(int i=0; i<dates.size(); i++)
		{
			String text = dates.get(i).getText();
			//System.out.println(text);
			if (text.equalsIgnoreCase(pickDay))
			{
				dates.get(i).click();
				break;
			}
		}
		
	}

}
