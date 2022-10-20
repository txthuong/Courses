import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Course\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		WebElement fromLocation = driver
				.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[@value='DEL']"));
		fromLocation.click();
		Thread.sleep(2000);
		WebElement toLocation = driver
				.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"));
		toLocation.click();
		System.out.println(fromLocation.getAttribute("value"));
		System.out.println(toLocation.getAttribute("value"));

		WebElement dateHighlight = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
		System.out.println(dateHighlight.getText());
		dateHighlight.click();

		// WebElement returnDay = driver.findElement(By.id("div1"));
		WebElement returnDay = driver.findElement(By.xpath("//div[@id='Div1']"));
		// String returnDayStatus = returnDay.getAttribute("style");
		if (returnDay.getAttribute("style").contains("opacity: 1")) {
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		}
		Assert.assertTrue(returnDay.getAttribute("style").contains("opacity: 0.5"));

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		WebElement passenger = driver.findElement(By.id("divpaxinfo"));
		System.out.println(passenger.getText());
		Assert.assertEquals(passenger.getText(), "6 Adult, 3 Child");

		WebElement currencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(currencyDropdown);
		List<WebElement> options = dropdown.getOptions();

		for (WebElement option : options) {
			if (!option.getText().equals("Select")) {
				dropdown.selectByValue(option.getText());
				System.out.println(dropdown.getFirstSelectedOption().getText());
			}
		}

		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		List<WebElement> checkBoxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement checkbox : checkBoxList) {
			if (driver.findElement(By.xpath("//label[@for='" + checkbox.getAttribute("id") + "']")).getText()
					.contains("Senior Citizen")) {
				Assert.assertTrue(checkbox.isSelected());
			} else {
				Assert.assertFalse(checkbox.isSelected());
			}

		}

		// driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();

	}

}