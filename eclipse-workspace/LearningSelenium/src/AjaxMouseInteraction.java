import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AjaxMouseInteraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//Moves to a specific element
		//Right click - .contextClick()
		a.moveToElement(move).contextClick().build().perform();
		
		//Drag

		

	}

}
