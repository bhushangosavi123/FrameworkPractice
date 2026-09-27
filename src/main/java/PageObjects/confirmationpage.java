package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utility_Classess.Utility_Class;

public class confirmationpage extends Utility_Class{

	
	
	WebDriver driver;

	public confirmationpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String confrmationMessage()
	{
		String confmsg = driver.findElement(By.cssSelector("td h1")).getText();
	
		return confmsg;
	}
	
}
