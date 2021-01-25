package TestNGClass;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestNGApplication {
	
	
	@Test
	public void startapp(){
		Assert.assertEquals(03, 03);
		System.out.println("stsrting App");
	}
	
	
	@Test(dependsOnMethods = "startapp")
	public void loginApp(){
		System.out.println("Login App");	
		
	}
	
	
	@Test(dependsOnMethods = "loginApp")
	public void logoutApp(){
		
		System.out.println("logout App");	
	}

}
