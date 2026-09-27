package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility_Classess.Utility_Class;

public class LandingPage extends Utility_Class{
	
	
	WebDriver driver;
	
	
	
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	@FindBy(id = "userEmail")
	WebElement useremail;
	
	@FindBy(id = "userPassword")
	WebElement Password;
	
	@FindBy(css = "input[type='submit']")
	WebElement submitButton;
	
	By errormsg = By.xpath("//div[@aria-label='Incorrect email or password.']");
	
	public products_Catalogue login(String email,String pass) 
	{
		//driver.findElement(By.id("userEmail")).sendKeys("bmg@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Bhushan123");
		//driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		useremail.sendKeys(email);
		Password.sendKeys(pass);
		submitButton.click();
		
		products_Catalogue products_Catalogue = new products_Catalogue(driver);
		return products_Catalogue;
	
	}
	
	public void gotourl()
	{
		
		driver.get("https://rahulshettyacademy.com/client");
		
		
	}
	
	public String validate_error()
	{
		visibilityOfElementLocated(errormsg);
		return driver.findElement(By.xpath("//div[@aria-label='Incorrect email or password.']")).getText();
		
	}
}
