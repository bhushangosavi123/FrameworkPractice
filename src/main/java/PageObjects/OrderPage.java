package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utility_Classess.Utility_Class;

public class OrderPage extends Utility_Class{

	
	
WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	public boolean verifyOrderDisplay(String productname)
	{
		
		List<WebElement> OrderList = driver.findElements(By.xpath("//tr/td[2]"));

		boolean flag = OrderList.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productname));
		
		return flag;
	}
	
	
	public CheckOut_Page checkout()
	{
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		CheckOut_Page CheckOut_Page = new CheckOut_Page(driver);
		return CheckOut_Page;
	}
	

	
}
