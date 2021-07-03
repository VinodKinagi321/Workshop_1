package expenses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01_ExpenseTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://app.invoiceninja.com/");
		driver.findElement(By.id("email")).sendKeys("sumanth.l@testyantra.com");
		driver.findElement(By.id("password")).sendKeys("admin@123");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.xpath("//a[text()='Got it!']")).click();
		driver.findElement(By.id("search")).sendKeys("expenses",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Enter Expense ']")).click();
		driver.findElement(By.id("vendor_name")).sendKeys("vinod kinagi",Keys.ENTER);
		driver.findElement(By.id("expense_category_name")).sendKeys("silk",Keys.ENTER);
		driver.findElement(By.id("amount")).sendKeys("100");
		driver.findElement(By.xpath("//input[@placeholder='US Dollar']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='US Dollar']")).sendKeys("indian rupee",Keys.ENTER);
		driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-calendar']")).click();
		driver.findElement(By.xpath("//td[@class='today active day']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("myAccountButton")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	}

}
