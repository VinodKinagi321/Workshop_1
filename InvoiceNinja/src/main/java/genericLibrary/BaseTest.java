package genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pomRepository.HomePage;
/***
 * 
 * @author Sumanth
 *
 */
public class BaseTest implements IAutoConstants {

	public static WebDriver driver;
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

		homePage=new HomePage(driver);
		readExcelData = new ExcelUtil();		

		//Step1 : navigate to application
		driver.get(DEFAULT_URL);
		driver.findElement(By.linkText("Got it!")).click();
		String expectedHomePageTitle = "Dashboard | Invoice Ninja";
		Assert.assertEquals(driver.getTitle(),expectedHomePageTitle,"Home Page is not displayed");
		Reporter.log("Home page is displayed successfully",true);
	}

	@BeforeMethod(alwaysRun=true)
	public void loginToApplication() throws Exception {
		Assert.assertEquals(driver.getTitle(),"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM","Homepage is not displayed successfully");
		Reporter.log("Homepage is displayed successfully",true);
	}

	@AfterMethod(alwaysRun=true)
	public void logoutFromApplication() {
		homePage.logOut();
		String expectedLoginPageTitle = "https://app.invoiceninja.com/login";
		Assert.assertEquals(driver.getTitle(),expectedLoginPageTitle,"Login Page is not displayed successfully");
		Reporter.log("Logged out successfully",true);
	}

	@AfterClass(alwaysRun=true)
	public void CloseApp() {
		driver.quit();
	}
}


