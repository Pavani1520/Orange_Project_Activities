package batch.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				WebDriver driver= new FirefoxDriver();
				driver.get("http://alchemy.hguy.co/orangehrm");
				WebElement txtUsername = driver.findElement(By.id("txtUsername"));
				WebElement txtPassword = driver.findElement(By.id("txtPassword"));
		        txtUsername.sendKeys("orange");
		        txtPassword.sendKeys("orangepassword123");
		        driver.findElement(By.xpath("//input[@id='btnLogin']")).submit();
		        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
		     

	             
		        String actualUrl="http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login";
		        String expectedUrl= driver.getCurrentUrl();
		        
		        Assert.assertEquals(actualUrl, expectedUrl);
		        System.out.println("expectedUrl is :" +expectedUrl);
		        
		    System.out.println("Activity_3 is done") ;
		    
		}

}
