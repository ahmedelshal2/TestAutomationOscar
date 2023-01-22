package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase 
{
	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText="Register")
	WebElement registerLink;
	
	@FindBy(xpath = "//div/span[1]/a[1]")
	public WebElement loginlink;
	
	public void openRegisterationPage()
	{
		clickButton(registerLink);
	}
	
	public void ClickLoginLink()
	{
		clickButton(loginlink);
	}


}
