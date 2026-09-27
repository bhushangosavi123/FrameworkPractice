package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PageObjects.LandingPage;

public class Base_Class {

	public static WebDriver driver;
	public LandingPage LandingPage;

	public static WebDriver initializeBrowser() throws IOException {

		Properties prop = new Properties();
		// File filepath = new File
		// ("C:\\Users\\Bhushan\\eclipse-workspace\\FrameWork_Practice\\src\\main\\java\\TestResources\\test.properties");
		File filepath = new File(System.getProperty("user.dir") + "\\src\\main\\java\\TestResources\\test.properties");

		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);

		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		// String browsername = prop.getProperty("browser");
		System.out.println("Browsername is : " + browsername);

		if (browsername.contains("chrome")) {

			ChromeOptions options = new ChromeOptions();
			

			if (browsername.contains("headless")) {
				options.addArguments("headless");
				
			}

			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1920,1080));
			
		} 
		
		else if (browsername.contains("firefox")) {
			System.out.println("execute in firefox");

		} else if (browsername.contains("edge")) {
			System.out.println("execute in edge");
			driver = new EdgeDriver();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		

		//driver.manage().window().maximize();  
		return driver;

	}

	@BeforeMethod()
	public LandingPage launchurl() throws IOException {
		initializeBrowser();
		LandingPage = new LandingPage(driver);
		LandingPage.gotourl();
		return LandingPage;

	}

	@AfterMethod()
	public void teardown() {

		if (driver != null) {
			try {
				Thread.sleep(500); // small delay
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit(); // clean shutdown
		}
	}

	// Raed Json file and use in Main test using DataProvider
	public List<HashMap<String, String>> readjsonfile() throws IOException {
		// Read JSON file into String
		String jsonContent = FileUtils.readFileToString(new File(
				"C:\\Users\\Bhushan\\eclipse-workspace\\FrameWork_Practice" + "\\src\\test\\java\\Data\\data.json"),
				"UTF-8" // Always specify encoding
		);

		// Convert String to List of HashMaps
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		// Print to verify
		System.out.println(data);
		return data;

	}

	public String TakeScreenshot(String testcasname, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Dest = new File(
				"C:\\Users\\Bhushan\\eclipse-workspace\\FrameWork_Practice\\ScreenShots\\" + testcasname + ".png");
		FileUtils.copyFile(Source, Dest);
		return "C:\\Users\\Bhushan\\eclipse-workspace\\FrameWork_Practice\\ScreenShots\\" + testcasname + ".png";

	}

}
