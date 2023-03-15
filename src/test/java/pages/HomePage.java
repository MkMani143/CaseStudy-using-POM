package pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase{
	WebDriverWait wait;
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
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login() throws InterruptedException {
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		loginbtn.click();
		wait.until(ExpectedConditions.visibilityOf(name));
		name.sendKeys(prop.getProperty("Name"));
		password.sendKeys(prop.getProperty("pass"));
		submitloginbtn.click();
	}
}
