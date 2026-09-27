package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility_Classess.Utility_Class;

public class products_Catalogue extends Utility_Class {

	WebDriver driver;

	public products_Catalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsby = By.cssSelector(".mb-3");

	By producstby = By.cssSelector("#toast-container");

	public List<WebElement> getproductlist() {

		// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		visibilityOfElementLocated(productsby);
		return products;

	}

	public WebElement getproductbyname(String productname) {
		WebElement prod = getproductlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname))
				.findFirst().orElse(null);

		return prod;
	}

	public void addproducttocart(String productname) throws InterruptedException {

		WebElement prod = getproductbyname(productname);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		visibilityOfElementLocated(producstby);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		Thread.sleep(2000);
		//invisibilityOfWebElement(spinner);
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		gotocartpage();
		
	}

}
