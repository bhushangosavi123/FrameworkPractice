package FrameWork_Automation.FrameWork_Practice;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOut_Page;
import PageObjects.LandingPage;
import PageObjects.confirmationpage;
import PageObjects.products_Catalogue;
import TestComponents.Base_Class;

public class Errorvalidation extends Base_Class {

	// products_Catalogue products_Catalogue;
	@Test
	public void LoginErrorVal() throws InterruptedException, IOException {

		String productname = "ZARA COAT 3";

		// products_Catalogue products_Catalogue = LandingPage.login("bmg@gmail.com",
		// "Bhusfdgfghan123");
		LandingPage.login("bmg@gmail.com", "Bhusfdgfghan123");
		String errormsg = LandingPage.validate_error();

		System.out.println(errormsg);

		Assert.assertEquals(errormsg, "Incorrect email or password.######");
	}
	
	
	
	@Test
	public void producterrorvalidation() throws InterruptedException
	{
		
String productname = "ZARA COAT 3";
		

		// Go to URL and Login on landing Page
		//LandingPage LandingPage = launchurl();
		
		
		products_Catalogue products_Catalogue = LandingPage.login("bmg@gmail.com", "Bhushan123");
		
		//*********Add products to Cart
		//products_Catalogue products_Catalogue = new products_Catalogue(driver); //Declare Class object
		products_Catalogue.getproductbyname(productname); //Add products into list
		products_Catalogue.addproducttocart(productname);
		CartPage CartPage = products_Catalogue.gotocartpage();

		//**********cartPage
		
		//CartPage CartPage = new CartPage(driver);
		boolean flag = CartPage.checkproductaddedincart("ZARA COAT 3333333");
		Assert.assertTrue(flag);

		
	}

}
