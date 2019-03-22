package faceBookTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class FabeBookLogin {
	
	public WebDriver driver;
	
  @Test
  @Parameters({"user", "password"})
  public void Login(String user, String password) {
	  driver.findElement(By.name("email")).sendKeys(user);
	  driver.findElement(By.name("pass")).sendKeys(password);
	  driver.findElement(By.xpath("//html[@id='facebook']//label[@id='loginbutton']/input[@value='Iniciar sesión']")).click();
	  
	  driver.findElement(By.id("logoutMenu")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.findElement(By .xpath("(//span[@class ='_54nh'])[9]")).click();
	  
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("pass")).clear();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions ops = new ChromeOptions();
	  ops.addArguments("--disable-notifications");
	  driver = new ChromeDriver(ops);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to("https://facebook.com");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
