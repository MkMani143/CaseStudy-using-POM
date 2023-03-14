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

public class CartPageAfterDlt extends TestBase{
	public String priceAfter;
	public int deleteItem;
	WebDriverWait wait;
	
	@FindBy(xpath="(//a[text()='Delete'])[1]")
	WebElement deletebtn;
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> ItemsIncart;
	
	@FindBy(id="totalp")
	WebElement priceAmt;
	
	public CartPageAfterDlt() {
		PageFactory.initElements(driver, this);
	}

	public void delete() throws InterruptedException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(ItemsIncart));
		deletebtn.click();
		Thread.sleep(2000);
		deleteItem = ItemsIncart.size();
		System.out.println(deleteItem);
		wait.until(ExpectedConditions.visibilityOf(priceAmt));
		priceAfter = driver.findElement(By.id("totalp")).getText();
		System.out.println(priceAfter);
	}

}
