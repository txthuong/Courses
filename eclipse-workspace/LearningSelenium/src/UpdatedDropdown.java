import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		
		dropdown.selectByIndex(1);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int i=1;
		while(i<2)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		
		for(int j=0; j<3; j++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "2 Adult, 3 Infant");
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		/*
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@value='AMD']")).click();
		//driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='AIP'])[2]")).click();
		*/
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='KQH']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BHO']")).click();

		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("selectedvalue"));
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).getAttribute("value"));
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("selectedvalue"));
		System.out.println(driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).getAttribute("value"));
		
		//WebElement returnDateBox = driver.findElement(By.name("ctl00$mainContent$view_date2"));
		WebElement returnDateBox = driver.findElement(By.cssSelector("div[id='Div1']"));
		System.out.println(returnDateBox.getAttribute("style"));
		
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		//Thread.sleep(2000);
		//System.out.println(returnDateBox.isEnabled());
		System.out.println(returnDateBox.getAttribute("style"));
		if (returnDateBox.getAttribute("style").contains("opacity: 0.5"))
		{
			System.out.println("PASSED !!!");
		}
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//Thread.sleep(2000);
		//System.out.println(returnDateBox.isEnabled());
		//System.out.println(returnDateBox.getAttribute("style"));
		Assert.assertTrue(returnDateBox.getAttribute("style").contains("opacity: 1"));
		
		
		
		
		WebElement dateHighlight = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
		System.out.println(dateHighlight.getText());
		
		dateHighlight.click();
		
		
		
		//driver.findElements(By.cssSelector(".[c]"))
		
		
		/*
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).getText());
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		if (driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected())
		{
			System.out.println("FAILED !!!");
		}
		else
		{
			System.out.println("PASSED !!!");
		}
		//Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		List<WebElement> checkBoxList = driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(checkBoxList.size());
		for (WebElement checkBox :checkBoxList)
		{	
			System.out.println(checkBox.getAttribute("id"));
			//checkBox.click();
			Thread.sleep(2000);
			//System.out.println(checkBox.getAttribute("id"));
		}
		*/
		
		
		
	}

}
