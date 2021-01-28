package TestNGClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMapplication {
	
	WebDriver driver;
	
	@Test
	public void startapp(){
		System.setProperty("webdriver.chrome.driver", "c:\\chromedriver.exe"); 
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://s2.demo.opensourcecms.com/orangehrm/symfony/web/index.php/auth/login");
		
	}
	
	
	@Test(dependsOnMethods = "startapp")
	public void loginApp(){
		driver.findElement(By.id("txtUsername")).sendKeys("opensourcecms");
		driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
		driver.findElement(By.id("btnLogin")).click();
		
		
	}
	
	
	@Test(dependsOnMethods = "loginApp")
	public void logoutApp(){
	
		
	
		
		
	}

}
