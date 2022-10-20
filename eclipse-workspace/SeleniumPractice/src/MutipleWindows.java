import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MutipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.cssSelector("[target='_blank']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		driver.switchTo().window(childId);
		WebElement childText =  driver.findElement(By.cssSelector("h3"));
		System.out.println(childText.getText());
		
		driver.switchTo().window(parentId);
		WebElement parentText = driver.findElement(By.cssSelector("h3"));
		System.out.println(parentText.getText());
		
		
	}

}
