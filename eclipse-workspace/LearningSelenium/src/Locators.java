import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		//<input type="text" placeholder="Username" id="inputUsername" value="">
		//id
		driver.findElement(By.id("inputUsername")).sendKeys("txthuong");
		
		//<input type="password" placeholder="Password" name="inputPassword" value="">
		//name
		driver.findElement(By.name("inputPassword")).sendKeys("123");
		
		//<button class="submit signInBtn" type="submit">Sign In</button>
		//class name
		driver.findElement(By.className("signInBtn")).click();
		
		//<p class="error" xpath="1">* Incorrect username or password </p>
		//cssSelector
		String s = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(s);
		
		//<a href="#">Forgot your password?</a>
		//linkText
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);

		//<input type="text" placeholder="Name">
		//xpath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("txthuong");

		//<input type="text" placeholder="Email">
		//cssSelector
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("txthuong@outlook.com");
		//xpath
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		//cssSelector
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("txthuong@gmail.com");
		

		//xpath - Phone number
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("123456");
		
		//Thread.sleep(1000);
		
		//<button class="reset-pwd-btn" xpath="1">Reset Login</button>
		//driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[2]")).click();
		
		//Thread.sleep(1000);
		//<p class="infoMsg" xpath="1">Please use temporary password 'rahulshettyacademy' to Login. </p>
		String s1 = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		System.out.println(s1);
		String tempPasswd = s1.toString().split("'")[1];
		
		//<button class="go-to-login-btn" xpath="1">Go to Login</button>
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		
		//id/name
		//driver.findElement(By.id("inputUsername")).sendKeys("txthuong");
		//driver.findElement(By.name("inputPassword")).sendKeys(tempPasswd);
		//cssSelector
		//driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("txthuong");
		//driver.findElement(By.cssSelector("input[placeholder='Password'")).sendKeys(tempPasswd);
		
		String userName = "txthuong";
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(tempPasswd);
		
		driver.findElement(By.id("chkboxOne")).click();
		
		Thread.sleep(1000);
		//driver.findElement(By.className("signInBtn")).click();
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(1000);
		//<p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;" xpath="1">You are successfully logged in.</p>
		String s3 = driver.findElement(By.cssSelector("p")).getText();
		System.out.println(s3);
		
		if (s3.equals("You are successfully logged in."))
		{
			System.out.println("WONDERFUL !!!");
			//<button class="logout-btn" xpath="1">Log Out</button>
			driver.findElement(By.cssSelector(".logout-btn")).click();
			System.out.println("Finished !!!");
		}
		else
		{
			System.out.println("FAILED");
		}
		
		
	}

}
