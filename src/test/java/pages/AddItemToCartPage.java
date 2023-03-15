package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class AddItemToCartPage extends TestBase{
	Alert alert;
	WebDriverWait wait;
	Actions actions;
	
	@FindBy(xpath="//a[text()='Home ']")
	WebElement home;
	
	@FindBy(xpath="//div/a[@class='btn btn-success btn-lg']")
	public WebElement addtocartbtn; 
	
	public AddItemToCartPage() {
		PageFactory.initElements(driver, this);
	}
		
	public void select(String categories,String products) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement category = driver.findElement(By.partialLinkText(categories));
		wait.until(ExpectedConditions.elementToBeClickable(category)).click();
		WebElement product =driver.findElement(By.partialLinkText(products));
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn)).click();
//		addtocartbtn.click();		
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		home.click();
	}
	
}