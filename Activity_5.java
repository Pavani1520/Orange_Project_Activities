package batch.orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity_5 {
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        txtUsername.sendKeys("orange");
        txtPassword.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS); 
        WebElement myinfo=driver.findElement(By.id("menu_pim_viewMyDetails"));
        myinfo.click(); 
        WebElement edit = driver.findElement(By.id("btnSave"));
	    edit.click();
        }
  @Test
  public void clear() {
		 driver.findElement(By.xpath("//input[@id=\"personal_txtEmpFirstName\"]")).clear(); 
		 driver.findElement(By.xpath("//input[@id=\"personal_txtEmpLastName\"]")).clear();
         driver.findElement(By.xpath("//input[@id=\"personal_DOB\"]")).clear();
         }
  @AfterMethod
  public void afterMethod()
        {
	    WebElement firstname= driver.findElement(By.xpath("//input[@id=\"personal_txtEmpFirstName\"]"));
		firstname.sendKeys("Eemani"); 
		WebElement lastname= driver.findElement(By.xpath("//input[@id=\"personal_txtEmpLastName\"]"));
		lastname.sendKeys("Pavani");
		WebElement gender= driver.findElement(By.xpath("//input[@id=\"personal_optGender_2\"]"));
		gender.sendKeys("Female");
		WebElement dob= driver.findElement(By.xpath("//input[@id=\"personal_DOB\"]"));
		dob.sendKeys("1995-10-15");
		WebElement edit = driver.findElement(By.xpath("//input[@id=\"btnSave\"]"));
		edit.click();
		System.out.println("Activity_5 is done");
		driver.close();
        }
        }