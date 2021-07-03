package expenses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TC02_UpdateExpenses {

	public static void main(String[] args) {
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
		driver.findElement(By.xpath("//a[text()='vinod kinagi']")).click();
		driver.findElement(By.xpath("//a[text()='Jul 3, 2021']")).click();
		WebElement amount = driver.findElement(By.id("amount"));
		amount.clear();
		amount.sendKeys("456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("myAccountButton")).click();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();	
	}
}
