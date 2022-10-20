import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(3000);
				
		//String buttonName = driver.findElement(By.xpath("//header/div/button[1]/following-sibling:button[1]")).getText();
		String buttonName = driver.findElement(By.xpath("//header/div/button[1]")).getText();
		System.out.println(buttonName);
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/parent::header")).getText());
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}

}
