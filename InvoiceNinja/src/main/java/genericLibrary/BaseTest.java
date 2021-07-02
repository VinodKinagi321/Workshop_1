package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pomRepository.HomePage;
import pomRepository.LoginPage;
/***
 * 
 * @author Sumanth
 *
 */
public class BaseTest implements IAutoConstants {

	public static WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public ExcelUtil readExcelData ;
	public WebDriverWait explicitWait;

	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void openApplication(@Optional("chrome")String browserName) {

		//pre-condition : Launching the browser
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty(CHROME_KEY,CHROME_PATH);
			driver=new ChromeDriver();
			Reporter.log("Successfully Launched Chrome Browser",true);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty(FIREFOX_KEY,FIREFOX_PATH);
			driver=new FirefoxDriver();
			Reporter.log("Successfully Launched Firefox Browser",true);
		}else {
			Reporter.log("Enter valid Browser name");
		}

		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized successfully",true);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 10);

		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		readExcelData = new ExcelUtil();		

		//Step1 : navigate to application
		driver.get(DEFAULT_URL);
		
		Reporter.log("Home page is displayed successfully",true);
	}

	@BeforeMethod(alwaysRun=true)
	public void loginToApplication() throws Exception {
		loginPage.getGotItButton().click();
		loginPage.getSignUpNowButton().click();	
		String expectedHomePageTitle = "Dashboard | Invoice Ninja";
		explicitWait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
		homePage.getCloseSignUpButton().click();
		homePage.getLogOutDeleteButton().click();		
		Assert.assertEquals(driver.getTitle(),expectedHomePageTitle,"Home Page is not displayed");
		Reporter.log("Homepage is displayed successfully",true);
	}

	@AfterMethod(alwaysRun=true)
	public void logoutFromApplication() {
		homePage.logOut();
		String expectedLoginPageTitle = "Invoice Ninja | Free Source-Available Online Invoicing";
		Assert.assertEquals(driver.getTitle(),expectedLoginPageTitle,"Login Page is not displayed successfully");
		Reporter.log("Logged out successfully",true);
	}

	@AfterClass(alwaysRun=true)
	public void CloseApp() {
		driver.quit();
	}
}


