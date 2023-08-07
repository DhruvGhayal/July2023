package pages;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
	WebDriver driver;
	
	@FindBy(id = "usernameInput-input")
    public WebElement email;
	
	@FindBy(name = "password")
    public WebElement password;
	
	@FindBy(id = "signIn")
    public WebElement signinButton;
	
	@FindBy(id = "globalError")
    public WebElement globalErr;
	
	@FindBy(id = "UsernameTextField__errors-usernameInput")
    public WebElement emailErr;
	
	@FindBy(id = "PasswordTextField__errors-password")
    public WebElement passwordErr;
	
	public void openBrowser() throws IOException {
		FileInputStream fn	= new FileInputStream("D:\\QA\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fn);
		String browser = prop.getProperty("browser");
		//WebDriver driver;
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver(); 
		}else if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}else {
			driver = new SafariDriver();
		}
		PageFactory.initElements(driver,this);
	}
	
	public void openLoginPage() {
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=sEfPOK2pIDQ&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5Ijoic0VmUE9LMnBJRFEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY3NTAyNTExOCwiaWF0IjoxNjc1MDIzOTE4LCJqdGkiOiI0YmYzZDk3Ny1lNjBkLTQ2OWEtODgyMS03MjEyN2U3Yzg3MWMiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.BrNTbw2R5Kv5DRI5WDzZ5Wc1lyMaRzA7jjJRNlh7ITYhArwHagx0wjVkw89_TLB5lGr5n2EZ9_BmEBBYCeDjFyH5oBg8Ff5qvvrDDfBDg88OIyTBuzAsF3lugSIzabo45Hohkw9ltc0c5sAPyu5jk1lZxq5jZmTnr-ntvjAtkEEUdAbuIAQK2kf_qyhno4SM9cNgxeGfX5C_sCrykwhAHyKlnkTHT3dBLN29M30G7b9ttzLRr2Auc2oZV7cthmcve6merwPwiKRtYG6Rf9jDpUArrhqM-FlyDszyw-G_RYDK2vpXuxK023EQy8sn_OCwLzdPt8YwD9N52aaqMO2TkQ&preferred_environment=");
	 }
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		signinButton.click();		
		Thread.sleep(2000);
	}
	
	public String readEmailErr() {
		String actualErr = emailErr.getText();
		//System.out.println(actualErr);
		return actualErr;
	}
	
	public String readPasswordErr() {
		String actualErr = passwordErr.getText();
		//System.out.println(actualErr);
		return actualErr;
	}
	
	public String readGlobalErr() {
		String actualErr = globalErr.getText();
		//System.out.println(actualErr);
		return actualErr;
	}

}
