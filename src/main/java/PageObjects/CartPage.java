package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utility_Classess.Utility_Class;

public class CartPage extends Utility_Class{
	
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean checkproductaddedincart(String productname)
	{
		
		List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));

		boolean flag = cartproducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productname));
		
		return flag;
	}
	
	
	public CheckOut_Page checkout()
	{
		
		driver.findElement(By.cssSelector(".totalRow button")).click();
		CheckOut_Page CheckOut_Page = new CheckOut_Page(driver);
		return CheckOut_Page;
	}
	

}
