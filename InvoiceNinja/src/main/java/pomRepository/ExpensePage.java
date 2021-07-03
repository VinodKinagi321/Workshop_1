package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExpensePage extends BasePage{

	public ExpensePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="search") private WebElement searchTextField;
	@FindBy(xpath="//a[text()='Enter Expense ']") private WebElement ExpenseLink;
	@FindBy(id="vendor_name") private WebElement vendorNamaeTextField;
	@FindBy(id="expense_category_name") private WebElement CatogariTextField;
	@FindBy(id="amount") private WebElement amountTextField;
	@FindBy(xpath="//input[@placeholder='US Dollar']") private WebElement USDollarTextField;
	@FindBy(xpath="//i[@class='glyphicon glyphicon-calendar']") private WebElement SelectCalender;
	@FindBy(xpath="//a[text()='Jul 3, 2021']") private WebElement SelectDate;
	@FindBy(xpath="//a[text()='vinod kinagi'") private WebElement SelectExpenses;
	public WebElement getVendorNamaeTextField() {
		return vendorNamaeTextField;
	}
	public WebElement getSelectExpenses() {
		return SelectExpenses;
	}
	public WebElement getSelectDate1() {
		return SelectDate1;
	}
	@FindBy(xpath="//td[@class='today active day']") private WebElement SelectDate1;
	@FindBy(xpath="//button[@type='submit']") private WebElement SaveButton;
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getExpenseLink() {
		return ExpenseLink;
	}
	public WebElement getVendorNmaeTextField() {
		return vendorNamaeTextField;
	}
	public WebElement getCatogariTextField() {
		return CatogariTextField;
	}
	public WebElement getAmountTextField() {
		return amountTextField;
	}
	public WebElement getUSDollarTextField() {
		return USDollarTextField;
	}
	public WebElement getSelectCalender() {
		return SelectCalender;
	}
	public WebElement getSelectDate() {
		return SelectDate;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}

	
	
}


