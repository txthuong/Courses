package Section11RealTimeExercises;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		// 1. Count of links on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());

		// 2. Count of links on the page footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));   //limiting webdriver scope
		List<WebElement> footerLinks = footerDriver.findElements(By.tagName("a"));
		System.out.println(footerLinks.size());
		
		// 3.
		WebElement columnDriver =  footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> columnLinks = columnDriver.findElements(By.tagName("a"));
		System.out.println(columnLinks.size());
		
		// 4. Click on each link in the column and check if the pages are opening
		String clickOnLinkTab =  Keys.chord(Keys.CONTROL, Keys.ENTER);
		for(int i=1; i<columnLinks.size(); i++)
		{
			
			columnLinks.get(i).sendKeys(clickOnLinkTab);
			//System.out.println(driver.getTitle());


		}
		Set<String> page = driver.getWindowHandles();
		Iterator<String> it = page.iterator();
		while (it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}

}
