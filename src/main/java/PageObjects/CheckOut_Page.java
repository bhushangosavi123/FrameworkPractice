package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Utility_Classess.Utility_Class;

public class CheckOut_Page extends Utility_Class {
	
	
	WebDriver driver;

	public CheckOut_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectcountry()
	{
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");

		visibilityOfElementLocated(By.cssSelector(".ta-results"));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();

		
		
		
	}
	
	
	public confirmationpage placeorder()
	{
		
		driver.findElement(By.cssSelector(".btnn")).click();
		confirmationpage confirmationpage = new confirmationpage(driver);
		return confirmationpage;
		
	}

}
