package data_driven;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import test_Uitility.TestUtilLogin;
import test_Uitility.Test_Util;


@Listeners(data_driven.Listeners_test.class)
public class Login_User extends TestBase {

	WebElement element_actual;
	@BeforeMethod
	public void login()
	{
		prerequisite();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
	}
	
	@DataProvider
	public Iterator<Object[]> get_data_login() {
		ArrayList<Object[]> OBJ = TestUtilLogin.getting_data_from_excel_login();
		System.out.println("value of arraylist object" + OBJ);
		return OBJ.iterator();
	}

	@Test(dataProvider = "get_data_login")
	public void login_userdata(String E_Mail,String Password) {

		
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(E_Mail);
	

		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(Password);

		
		clicking_on_loginButton();
		searching_product();
		validation_of_product();
	}
      
	
	public void clicking_on_loginButton()
	{
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}
	
	
	public void searching_product()
	{
	    element_actual=driver.findElement(By.xpath("(//input[@name='search'])[1]"));
		element_actual.sendKeys("iphone"+Keys.ENTER);
		
	}
	
	
	public void validation_of_product()
	{
		WebElement element=driver.findElement(By.xpath("//a[contains(text(),'iPhone')]"));
		Assert.assertEquals(element, element_actual, "success");
	}
	
	
	
}
