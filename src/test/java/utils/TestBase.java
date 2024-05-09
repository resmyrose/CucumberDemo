package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException  {
		
	/*	// convert the properties files to fileInputStream
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		 
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		if(driver == null) {
			if(prop.getProperty("browser") == "chrome") {
				driver = new ChromeDriver();
				//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
				driver.get(url);
			}
			if(prop.getProperty("browser") == "firefox") {
				driver = new FirefoxDriver();
				//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
				driver.get(url);
			}
		}
		*/
		// convert the properties files to fileInputStream
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
				 
				Properties prop = new Properties();
				prop.load(fis);
				String url = prop.getProperty("QAUrl");
		if(driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		
		return driver;
	}

}
