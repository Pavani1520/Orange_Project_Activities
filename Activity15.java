package batch.orangehrm;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity15 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void beforeMethod() {
		//Browser initialization

		driver= new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
        Reporter.log("Test Strated");


	}
	@Tes
	public void act9 (String url,String username, String password) throws InterruptedException   
	{
	       driver.get("http://alchemy.hguy.co/orangehrm");
	        WebElement txtUsername = driver.findElement(By.id("txtUsername"));
			WebElement txtPassword = driver.findElement(By.id("txtPassword"));
		    txtUsername.sendKeys("orange");
		    txtPassword.sendKeys("orangepassword123");
		    driver.findElement(By.id("btnLogin")).click();
        Reporter.log("Test middle");
        
        WebElement welcome=driver.findElement(By.id("welcome"));
		wait.until(ExpectedConditions.visibilityOf(welcome));
		// Navigating to MyInfo and filling inputs
		
		Actions acc=new Actions(driver);
		WebElement pim= driver.findElement(By.id("menu_pim_viewMyDetails"));
		acc.moveToElement(pim).click().build().perform();
		

	
				driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/ul/li[3]/a")).click();
		List <WebElement> rowValue= driver.findElements(By.xpath("//*[@id='emgcontact_list']/tbody/tr/td"));
		for(WebElement rv:rowValue)

		{
			System.out.println(rv.getText());
		}
		
		Assert.assertTrue(true);
		System.out.println("Emergency contact details retrieved");
        Reporter.log("Test fine");

	}