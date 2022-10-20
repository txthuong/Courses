import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "txthuong";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.cssSelector("#alertbtn")).click();
				
		String notification = driver.switchTo().alert().getText();
		System.out.println(notification);
		if (notification.contains(name))
		{
			driver.switchTo().alert().accept();
			System.out.println("Test Passed #1 !!!");
		}
		else
		{
			System.out.println("Test Failed #1 !!!");
		}

		driver.findElement(By.id("name")).sendKeys("testName");
		driver.findElement(By.cssSelector("#confirmbtn")).click();
		
		String confirmNotification = driver.switchTo().alert().getText();
		System.out.println(confirmNotification);
		if (confirmNotification.contains(name))
		{
			driver.switchTo().alert().accept();
			System.out.println("Test Passed #2 !!!");
		}
		else
		{
			driver.switchTo().alert().dismiss();
			System.out.println("Test Failed #2 !!!");
		}
		
		
	}

}
