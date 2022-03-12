package data_driven;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import test_Uitility.Test_Util;

public class Tutorial_Ninja extends TestBase{

	

	@BeforeMethod
	public void setup() {
		
		prerequisite();
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
	}

	@DataProvider
	public Iterator<Object[]> get_data() {
		ArrayList<Object[]> OBJ = Test_Util.getting_data_from_excel();
		System.out.println("value of arraylist object" + OBJ);
		return OBJ.iterator();
	}

	@Test(dataProvider = "get_data")
	public void register(String First_Name, String last_Name, String E_Mail, String Telephone, String Password,
			String Password_Confirm) {

		
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys(First_Name);
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys(last_Name);
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys(E_Mail);
		driver.findElement(By.xpath("//input[@name='telephone']")).clear();
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys(Telephone);

		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys(Password);

		driver.findElement(By.xpath("(//input[@type='password'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(Password_Confirm);

		click();
		
	}

	
	public void click() {
		// clicking on agree
		driver.findElement(By.xpath("//input[@name='agree']")).click();

		// Continue
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		validating_registration();

	}


	
	public void validating_registration() {
		String title=driver.getTitle();
		Assert.assertEquals(title, "Your Account Has Been Created!");
	}
	
	
	
	
	  @AfterMethod
	  public void closing_Browser()
	  {
		  driver.close(); 
	  }
	 
}
