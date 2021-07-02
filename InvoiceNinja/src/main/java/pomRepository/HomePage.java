package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/***
 * 
 * @author Sumanth
 *
 */
public class HomePage extends BasePage {

	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(id="myAccountButton")
	private WebElement guestDropDown;
	
	@FindBy(linkText="Log Out")
	private WebElement logOut;
	
	@FindBy(xpath="//button[contains(text(),'Delete Account')]")
	private WebElement logOutDeleteButton;

	@FindBy(id="closeSignUpButton")
	private WebElement closeSignUpButton;
	
	public WebElement getGuestDropDown() {
		return guestDropDown;
	}

	public WebElement getLogOut() {
		return logOut;
	}

	public WebElement getLogOutDeleteButton() {
		return logOutDeleteButton;
	}
	
	public WebElement getCloseSignUpButton() {
		return closeSignUpButton;
	}

	//Business Logics
	public void logOut() {
		getGuestDropDown().click();
		getLogOut().click();
	}
}

	

