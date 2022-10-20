import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPagePractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	
		String userCredential = driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();
		Pattern p = Pattern.compile("\\(username is (.*?) and Password is (.*?)\\)");
		Matcher matcher = p.matcher(userCredential);
		Assert.assertTrue(matcher.find());
		String userName = matcher.group(1);
		String password = matcher.group(2);
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.cssSelector("input[id='usertype'][value='user']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-body']")));
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement userDropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropDown = new Select(userDropDown);
		dropDown.selectByVisibleText("Consultant");		
	
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-card-list")));
		driver.manage().window().maximize();
		
		List<WebElement> listItems = driver.findElements(By.cssSelector("app-card"));
		for (int i=0; i < listItems.size(); i++)
		{
			driver.findElements(By.cssSelector("button[class='btn btn-info']")).get(i).click();
		}

		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='col-sm-8 col-md-6']")));
		
		List<WebElement> listAddedItems = driver.findElements(By.xpath("//td[@class='col-sm-8 col-md-6']"));
		Assert.assertEquals(listAddedItems.size(), listItems.size());
		for (int i=0; i < listItems.size(); i++)
		{
			System.out.print(driver.findElements(By.xpath("//h4[@class='media-heading']")).get(i).getText());
			System.out.print(": ");
			System.out.println(driver.findElements(By.xpath("//td[@class='col-sm-1 col-md-1 text-center']")).get(i*2+1).getText());
		}
		
		System.out.println("Total: " + driver.findElement(By.xpath("//td[@class='text-right']/h3")).getText());
		
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
	}

}
