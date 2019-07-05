package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetDrivers {
	public static WebDriver utilityDriver(String browser) {
		
		WebDriver driver;
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			return driver;
		}
		
		else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			return driver;
		} 
		
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Training_B8C.02.24\\Desktop\\Selenium With Java\\Selenium\\src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		}
		return null;
	}
}
