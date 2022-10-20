import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment_02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.findElement(By.name("name")).sendKeys("txthuong");
		driver.findElement(By.name("email")).sendKeys("txthuong@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test123456");
		driver.findElement(By.id("exampleCheck1")).click();
		
		List<WebElement> genderOptions = driver.findElements(By.xpath("//div/select/option"));
		for (WebElement option :genderOptions)
		{
			System.out.println(option.getText());
		}
		
		WebElement genderDropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(genderDropdown);
		dropdown.selectByIndex(0);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Male");
		
		WebElement employmentStatus = driver.findElement(By.cssSelector("input[id='inlineRadio2']"));
		employmentStatus.click();
		List<WebElement> employmentStatusList = driver.findElements(By.cssSelector("input[type='radio']"));
		for(WebElement empStatus :employmentStatusList)
		{
			String employmentStatusID = empStatus.getAttribute("id");
			String employmentStatusLabel = driver.findElement(By.xpath("//div/label[@for='"+employmentStatusID+"']")).getText();
			System.out.println(employmentStatusLabel);
			if(employmentStatusLabel.equals("Employed"))
			{
				Assert.assertTrue(empStatus.isSelected());
			}
			else
			{
				Assert.assertFalse(empStatus.isSelected());
			}
		}
		
		driver.findElement(By.name("bday")).sendKeys("11");
		driver.findElement(By.name("bday")).sendKeys("21");
		driver.findElement(By.name("bday")).sendKeys("1988");
			
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		Thread.sleep(2000);
		WebElement successFlag = driver.findElement(By.cssSelector("div[class*='alert-success']"));
		if (successFlag.getText().contains("Success! The Form has been submitted successfully!."))
		{
			System.out.println("PASSED !!!");
		}
			
		
		
	}

}
