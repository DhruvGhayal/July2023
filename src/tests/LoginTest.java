package tests;
import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
public class LoginTest {
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
//WebDriver driver; 
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  //driver = new FirefoxDriver();
	  //driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=sEfPOK2pIDQ&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5Ijoic0VmUE9LMnBJRFEiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY3NTAyNTExOCwiaWF0IjoxNjc1MDIzOTE4LCJqdGkiOiI0YmYzZDk3Ny1lNjBkLTQ2OWEtODgyMS03MjEyN2U3Yzg3MWMiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.BrNTbw2R5Kv5DRI5WDzZ5Wc1lyMaRzA7jjJRNlh7ITYhArwHagx0wjVkw89_TLB5lGr5n2EZ9_BmEBBYCeDjFyH5oBg8Ff5qvvrDDfBDg88OIyTBuzAsF3lugSIzabo45Hohkw9ltc0c5sAPyu5jk1lZxq5jZmTnr-ntvjAtkEEUdAbuIAQK2kf_qyhno4SM9cNgxeGfX5C_sCrykwhAHyKlnkTHT3dBLN29M30G7b9ttzLRr2Auc2oZV7cthmcve6merwPwiKRtYG6Rf9jDpUArrhqM-FlyDszyw-G_RYDK2vpXuxK023EQy8sn_OCwLzdPt8YwD9N52aaqMO2TkQ&preferred_environment=");  
	  lp.openBrowser();
	  lp.openLoginPage();
	  	//System.out.println(d.getCellData("Data1", "Name", 3));
		//String browser = d.getCellData("Data1", 7, 2);
  }
  @AfterMethod
  public void afterMethod() {
	 //driver.close();
	  lp.closeBrowser();
  }
  @Test(priority=1)
  public void loginWithSpecialCharEmailTest() throws InterruptedException { 
	  //driver.findElement(By.id("usernameInput-input")).sendKeys("sadgsdgasrharhgher@#$");
	//driver.findElement(By.name("password")).sendKeys("dasfasdgstras");
		//driver.findElement(By.id("signIn")).click();
		//Thread.sleep(3000);
	    lp.login(df.specialcharemail,df.password);
	   // String expectedErr = df.specialcharemailerr;
	   // String actualErr = lp.readEmailErr();
		Assert.assertEquals(df.specialcharemailerr,lp.readEmailErr());
  }
  @Test(priority=2)
  public void loginWithEmpyyCharEmailTest() throws InterruptedException { 
	//	driver.findElement(By.name("password")).sendKeys("dasfasdgstras");
	//	driver.findElement(By.id("signIn")).click();
	//	Thread.sleep(3000);
	  lp.login("",df.password);
	 // String expectedErr = df.emptyemailerr;
	 // String actualErr = lp.readEmailErr();//driver.findElement(By.id("UsernameTextField__errors-usernameInput")).getText();
	//	System.out.println(actualErr);
	  Assert.assertEquals(df.emptyemailerr, lp.readEmailErr());
  }
  @Test(priority=3)
  public void loginWithEmptyPassword() throws InterruptedException { 
	//  	driver.findElement(By.id("usernameInput-input")).sendKeys("sadgsdgasrharhgh");
	//	driver.findElement(By.id("signIn")).click();
	//	Thread.sleep(3000);
	  lp.login(df.wrongemail,"");
	//	String expectedErr = df.emptypassworderr;
	//	String actualErr = lp.readPasswordErr();//driver.findElement(By.id("PasswordTextField__errors-password")).getText();
	//	System.out.println(actualErr);
	  	Assert.assertEquals(df.emptypassworderr, lp.readPasswordErr());
  }
  	@Test(priority=4)
  public void loginWithWrongEmailPassword() throws InterruptedException { 
	  //driver.findElement(By.id("usernameInput-input")).sendKeys("sadgsdgasrharhgh");
	  //driver.findElement(By.name("password")).sendKeys("dasfasdgstras");
	  //driver.findElement(By.id("signIn")).click();
	//	Thread.sleep(3000);
	 lp.login(df.wrongemail,df.password);
	 //String expectedErr = df.wrongemailpassworderr;
	// String actualErr = lp.readGlobalErr();//driver.findElement(By.id("globalError")).getText();
	//	System.out.println(actualErr);
	 Assert.assertEquals(df.wrongemailpassworderr, lp.readGlobalErr());
}
}
