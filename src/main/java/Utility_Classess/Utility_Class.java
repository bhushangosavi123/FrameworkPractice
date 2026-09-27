package Utility_Classess;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CartPage;
import PageObjects.OrderPage;

public class Utility_Class {

	
	public static WebDriver driver;
	public Utility_Class(WebDriver driver)
	{
		
		this.driver= driver;
		
	}
	
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement OrderButton;
	
	public void visibilityOfElementLocated(By findby)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	
	
	public void invisibilityOfWebElement(WebElement ele)
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	
	public CartPage gotocartpage()
	{
		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
		
		CartPage CartPage = new CartPage(driver);
		return CartPage;
	}
	
	
	public OrderPage ordersbutton()
	{
		
		OrderButton.click();
		OrderPage OrderPage = new OrderPage(driver);
		return OrderPage;
		
	}
}
