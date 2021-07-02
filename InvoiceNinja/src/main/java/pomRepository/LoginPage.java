package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

/***
 * 
 * @author Sumanth
 *
 */
public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(id="email")
	private WebElement usernameTextField;
	
	@FindBy(id="password")
	private WebElement passwordTextField;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	@FindBy(linkText="SIGN UP NOW")
	private WebElement signUpNowButton;
	
	@FindBy(linkText="Got it!")
	private WebElement gotItButton;

	
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getSignUpNowButton() {
		return signUpNowButton;
	}

	public WebElement getGotItButton() {
		return gotItButton;
	}
	
	//Business Method
	public void login(String username,String password) {
		getUsernameTextField().clear();
		getUsernameTextField().sendKeys(username);
		Assert.assertEquals(getUsernameTextField().getAttribute("value"), username,"username is not entered properly");
		Reporter.log("Username is entered successfully",true);
		getPasswordTextField().clear();
		getPasswordTextField().sendKeys(password);
		Assert.assertEquals(getPasswordTextField().getAttribute("value"), password,"password is not entered properly");
		Reporter.log("Username is entered successfully",true);
		getLoginButton().click();
	}
	

}
