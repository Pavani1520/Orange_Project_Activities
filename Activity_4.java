package batch.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
        txtUsername.sendKeys("orange");
        txtPassword.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); 
      driver.findElement(By.id("menu_pim_viewPimModule")).click();
    driver.findElement(By.id("menu_pim_addEmployee")).click();
    driver.findElement(By.id("firstName")).sendKeys("Eemani");
    driver.findElement(By.id("lastName")).sendKeys("pavani");
    WebElement chkLogin=driver.findElement(By.id("chkLogin"));
    chkLogin.click();
    driver.findElement(By.id("user_name")).sendKeys("Pavani");
   driver.findElement(By.id("btnSave")).click();
   
 driver.findElement(By.id("menu_admin_viewAdminModule")).click();
driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Pavani");
    driver.findElement(By.id("searchBtn")).click();
   
   System.out.println("Activity_4 is done");
    
   driver.close();
      		
	}

}
