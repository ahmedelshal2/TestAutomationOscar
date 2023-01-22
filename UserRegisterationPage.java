package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase 
{
	public UserRegisterationPage(WebDriver driver) 
	{
		super(driver);
		
	}
	@FindBy(xpath= "//div[@class='form-group']//input[1]")
	WebElement typeName;

	@FindBy(xpath= "//div[@class='form-group']//input[2]")
	WebElement typeEmail;

	@FindBy(xpath= "//div[@class='form-group']//input[3]")
	WebElement typePhone ;

	@FindBy(xpath= "//div[@class='form-group']//input[4]")
	WebElement typePassword ;

	@FindBy(xpath= "//div[@class='form-group']//input[5]")
	WebElement confirmPassword ;

	@FindBy(xpath= "//div[@class='form']//div[2]/button")
	WebElement registerButton ;
	
	public void userRegistration(String Name,String Email,String Phone, String Password)
	{
		setTextElementText(typeName, Name);
		setTextElementText(typeEmail, Email);
		setTextElementText(typePhone, Phone);
		setTextElementText(typePassword, Password);
		setTextElementText(confirmPassword, Password);
		clickButton(registerButton);
	}

}
