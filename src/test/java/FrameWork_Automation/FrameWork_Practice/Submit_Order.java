package FrameWork_Automation.FrameWork_Practice;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import PageObjects.CartPage;
import PageObjects.CheckOut_Page;
import PageObjects.LandingPage;
import PageObjects.OrderPage;
import PageObjects.confirmationpage;
import PageObjects.products_Catalogue;
import TestComponents.Base_Class;

public class Submit_Order extends Base_Class{

	String productname = "ZARA COAT 3";
	//products_Catalogue products_Catalogue;
	@Test(dataProvider = "getdatafromJsonFile")
	public void Test1(HashMap<String,String> input) throws InterruptedException, IOException {

		
		

		// Go to URL and Login on landing Page
		//LandingPage LandingPage = launchurl();
		
		
		products_Catalogue products_Catalogue = LandingPage.login(input.get("email"), input.get("password"));
		
		//*********Add products to Cart
		//products_Catalogue products_Catalogue = new products_Catalogue(driver); //Declare Class object
		products_Catalogue.getproductbyname(input.get("pname")); //Add products into list
		products_Catalogue.addproducttocart(input.get("pname"));
		CartPage CartPage = products_Catalogue.gotocartpage();

		//**********cartPage
		
		//CartPage CartPage = new CartPage(driver);
		boolean flag = CartPage.checkproductaddedincart(input.get("pname"));
		Assert.assertTrue(flag);

		CheckOut_Page CheckOut_Page = CartPage.checkout();
		
		
		//*********checkout Page ->add city and place order

		CheckOut_Page.selectcountry();
		confirmationpage confirmationpage = CheckOut_Page.placeorder();
        String confmsg = confirmationpage.confrmationMessage();

		Assert.assertEquals(confmsg, "THANKYOU FOR THE ORDER.");
	}
	
	
	@Test(dependsOnMethods={"Test1"})
	public void OrderHistory()
	{
		
		products_Catalogue products_Catalogue = LandingPage.login("bmg@gmail.com", "Bhushan123");
		OrderPage OrderPage = products_Catalogue.ordersbutton();
		
		//OrderPage.verifyOrderDisplay(productname);
		Assert.assertTrue(OrderPage.verifyOrderDisplay(productname));
	}
	
	
	
	
	
	
	
	//@DataProvider()
	public Object[][] getdata()
	{
		
		return new Object[][] {{"bmg@gmail.com","Bhushan123","ZARA COAT 3"},{"bmg@gmail.com","Bhushan123", "ADIDAS ORIGINAL"}};
		
	}
	
	
	@DataProvider()
	public Object[][] getdatafromHashmap()
	{
		
		HashMap<String,String> map= new HashMap<String,String>();
		map.put("email", "bmg@gmail.com");
		map.put("password", "Bhushan123");
		map.put("pname", "ZARA COAT 3");
		
		HashMap<String,String> map1= new HashMap<String,String>();
		map1.put("email", "bmg@gmail.com");
		map1.put("password", "Bhushan123");
		map1.put("pname", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
		
	}
	
	
	@DataProvider()
	public Object[][] getdatafromJsonFile() throws IOException
	{
		
		List<HashMap<String, String>> data = readjsonfile(); //Defined in BaseTest
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
	

}
