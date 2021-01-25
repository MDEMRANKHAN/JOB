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
		String currentURL=driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("auth/login"));
	}
	
	
	@Test(dependsOnMethods = "startapp")
	public void loginApp(){
		driver.findElement(By.id("txtUsername")).sendKeys("opensourcecms");
		driver.findElement(By.id("txtPassword")).sendKeys("opensourcecms");
		driver.findElement(By.id("btnLogin")).click();
		
		boolean status=driver.findElement(By.xpath("//*[@id=\"admin\"]/a/span")).isDisplayed();
		Assert.assertTrue(status);
	}
	
	
	@Test(dependsOnMethods = "loginApp")
	public void logoutApp(){
		driver.findElement(By.xpath("//*[@id=\"option-menu\"]/li[3]/a")).click();
		Assert.assertTrue(driver.findElement(By.id("txtUsername")).isDisplayed());
		
	
		
		
	}

}
