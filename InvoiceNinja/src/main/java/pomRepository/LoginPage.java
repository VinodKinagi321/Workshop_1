package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/***
 * 
 * @author Sumanth
 *
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(linkText="SIGN UP NOW")
	private WebElement signUpNowButton;
	
	

}
