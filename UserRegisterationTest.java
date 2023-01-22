package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {
	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	
	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccessfully()
	{
		//Go to Home Page
		homeObject=new HomePage(driver);
		homeObject.openRegisterationPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Go to Register Page
		registerObject=new UserRegisterationPage(driver);
		registerObject.userRegistration("ahmedali","ahmedss70@gmail.com","01003331700","123456789");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Go to Profile Data
		loginObject=new LoginPage(driver);
		loginObject.clickProfileLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Verify Name from profile data is displayed
		Assert.assertTrue(loginObject.verifyName.getText().contains("ahmedali"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	// User can logout from web site
	@Test(dependsOnMethods= {"UserCanRegisterSuccessfully"})
	public void RegisteredUserCanLogout()
	{
		loginObject.userLogout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginObject.clickProfileLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
