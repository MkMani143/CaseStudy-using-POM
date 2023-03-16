package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase{
	WebDriverWait wait;
	Alert alert;
	public String priceBefore;
	
	@FindBy(id = "login2")
	WebElement loginbtn;
	
	@FindBy(id="loginusername")
	WebElement name;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	WebElement submitloginbtn;
	
	@FindBy(id="nameofuser")
	public WebElement username;
	
	@FindBy(xpath="//a[text()='Home ']")
	WebElement home;
	
	@FindBy(xpath="//div/a[@class='btn btn-success btn-lg']")
	public WebElement addtocartbtn; 
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> ItemsInCart;
	
	@FindBy(id="cartur")
	WebElement cartBtn;
	
	@FindBy(id="totalp")
	WebElement priceAmt;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login() throws InterruptedException {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		loginbtn.click();
		wait.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys(prop.getProperty("Name"));
		password.sendKeys(prop.getProperty("pass"));
		submitloginbtn.click();
	}
	public void selectItems(String categories,String products) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement category = driver.findElement(By.partialLinkText(categories));
//		wait.until(ExpectedConditions.elementToBeClickable(category)).click();
		wait.until(ExpectedConditions.visibilityOf(category));
		category.click();
		WebElement product =driver.findElement(By.partialLinkText(products));
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn)).click();		
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		home.click();
	}
	
	public void cart() {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		cartBtn.click();
		home.click();
	}
}