package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class CartPageBeforeDlt extends TestBase{
	public String priceBefore;
	public String priceAfter;
    public int cart_size;
    WebDriverWait wait;
    
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(id="totalp")
	WebElement priceAmt;
	
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> ItemsInCart;
	
	public  CartPageBeforeDlt() {
		PageFactory.initElements(driver, this); 
	}
	
	public void cart() throws InterruptedException {
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		cart.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		cart_size = ItemsInCart.size();
		System.out.println(cart_size);
		wait.until(ExpectedConditions.visibilityOf(priceAmt));
		priceBefore = priceAmt.getText();
		System.out.println(priceBefore);
	}
}
