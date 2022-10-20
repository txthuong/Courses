import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "D:\\\\Course\\\\Selenium\\\\Drivers\\\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.edge.driver", "D:\\Course\\Selenium\\Drivers\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String userName = "txthuong";
		//String password = "rahulshettyacademy";
		String password = getPassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//<input type="text" placeholder="Username" id="inputUsername" value="">
		//id
		driver.findElement(By.id("inputUsername")).sendKeys(userName);
		
		//<input type="password" placeholder="Password" name="inputPassword" value="">
		//name
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		
		//<button class="submit signInBtn" type="submit">Sign In</button>
		//class name
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(1000);
		String s = driver.findElement(By.tagName("p")).getText();
		System.out.println(s);
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		
		//driver.findElement(By.cssSelector("div[class='login-container'] h2"));
		
		String displayedUserName = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
		System.out.println(displayedUserName);
		
		Assert.assertEquals(displayedUserName, "Hello "+userName+",");
		//<p class="error" xpath="1">* Incorrect username or password </p>
		//cssSelector
		//String s = driver.findElement(By.cssSelector("p.error")).getText();
		//System.out.println(s);
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector("button[class='logout-btn']")).click();
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(1000);
		driver.close();
		
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
		String passwordText = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String password = passwordText.split("'")[1];
		System.out.println(password);
		
		String[] passwordArray = passwordText.split("'");
		String pass = passwordArray[1].split("'")[0];
		System.out.println(pass);
		//driver.close();
		
		return password;
	}

}
