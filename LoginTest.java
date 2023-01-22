package tests;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class LoginTest extends TestBase {

	HomePage homeObject;
	UserRegisterationPage registerObject;
	LoginPage loginObject;
	
	// fill required fields data

	String email ="ahmedsssa870@gmail.com";
	String Password ="123456789";

	@Test(priority=1,alwaysRun=true)
	public void UserLoginSuccessfully()
	{
		// Go to home page in oscar website
		homeObject=new HomePage(driver);
		homeObject.ClickLoginLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Go to login page in oscar website
		loginObject=new LoginPage(driver);
		loginObject.UserLogin(email, Password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Go to your profile page
		loginObject.clickProfileLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Verify Name from profile data is displayed
		Assert.assertTrue(loginObject.verifyName.getText().contains("ahmedali"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	
	// logout from profile page
	@Test(priority = 2,dependsOnMethods= {"UserLoginSuccessfully"})
	public void LoginedUserCanLogout()
	{
		loginObject.userLogout();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		loginObject.clickProfileLink();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
