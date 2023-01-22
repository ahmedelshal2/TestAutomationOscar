package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase 
{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class='form-group']/input[1]")
	WebElement email ;

	@FindBy(xpath="//div[@class='form-group']/input[2]")
	WebElement password ;
	
	@FindBy(xpath="//div[@class='form']//div/button[1]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div/span[1]/a[1]")
	public WebElement profileLink;
	
	@FindBy(xpath = "//div/h4")
	public WebElement verifyName;
	
	@FindBy(xpath= "/html/body/div[7]/div/div/div[2]/div/ul/li[9]/form/button")
	WebElement logoutButton ;
	
	public void UserLogin(String emailBox,String pass)
	{
		setTextElementText(email, emailBox);
		setTextElementText(password, pass);
		clickButton(loginBtn);
	}
	public void clickProfileLink()
	{
		clickButton(profileLink);
	}
	public void userLogout()
	{
		clickButton(logoutButton);
	}

}
