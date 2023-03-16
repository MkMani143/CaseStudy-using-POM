package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CartPage extends TestBase{
	public String priceBefore;
	public String priceAfter;
    public int cart_size;
    public int deleteItem;
    WebDriverWait wait;
    
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(id="totalp")
	WebElement priceAmt;
	
	@FindBy(xpath="(//a[text()='Delete'])[1]")
	WebElement deletebtn;
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> ItemsInCart;
	
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeorder;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	public WebElement purchase;
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	public WebElement message;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okBtn;
	
	public  CartPage() {
		PageFactory.initElements(driver, this); 
	}
	
	public void cart() throws InterruptedException {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		cart.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ItemsInCart));
		cart_size = ItemsInCart.size();
		System.out.println(cart_size);
		wait.until(ExpectedConditions.visibilityOf(priceAmt));
		priceBefore = priceAmt.getText();
		System.out.println(priceBefore);
		
		
	}
	public void delete() throws InterruptedException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElements(ItemsInCart));
		deletebtn.click();
		Thread.sleep(2000);
		deleteItem = ItemsInCart.size();
		System.out.println(deleteItem);
		wait.until(ExpectedConditions.visibilityOf(priceAmt));
		priceAfter = driver.findElement(By.id("totalp")).getText();
		System.out.println(priceAfter);
	}
	
	public void orderDetails() throws InterruptedException{
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		placeorder.click();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys(prop.getProperty("name"));
//		wait.until(ExpectedConditions.visibilityOf(country));
		country.sendKeys(prop.getProperty("country"));
//		wait.until(ExpectedConditions.visibilityOf(city));
		city.sendKeys(prop.getProperty("city"));
//		wait.until(ExpectedConditions.visibilityOf(card));
		card.sendKeys(prop.getProperty("creditcard"));
//		wait.until(ExpectedConditions.visibilityOf(month));
		month.sendKeys(prop.getProperty("month"));
//		wait.until(ExpectedConditions.visibilityOf(year));
		year.sendKeys(prop.getProperty("year"));
//		wait.until(ExpectedConditions.visibilityOf(purchase));
		wait.until(ExpectedConditions.elementToBeClickable(purchase));
		purchase.click();
		
	}
	public void clickOk() {
		okBtn.click();
	}
}
