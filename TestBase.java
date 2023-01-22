package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase 
{
public static WebDriver driver;
	
	@BeforeSuite
	public void startDriver()
	{
		String chromepath= System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.oscarstores.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}

}
