package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop=null;
	public static WebDriver driver=null;
	
	public static ExtentReports reports=null;
	public static ExtentSparkReporter spark=null;
	public static ExtentTest extentTest=null;
	//constructor
	public TestBase() {
		String path=System.getProperty("user.dir")+"//src//test//resources//configFiles//config.properties";
		prop=new Properties();
		FileInputStream fileIn;
		try {
			fileIn = new FileInputStream(path);
			try {
				prop.load(fileIn);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public static void initialize() {
		String strBrowser=prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options= new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
//			options.addArguments("-disable notifications");
			DesiredCapabilities cp= new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cp);
			driver=new ChromeDriver(options);
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));
	}
	public static void ExtentSetup() {
		reports=new ExtentReports();
		spark=new ExtentSparkReporter("target\\BlazeAppReport.html");
		reports.attachReporter(spark);
	}
	
	
}
