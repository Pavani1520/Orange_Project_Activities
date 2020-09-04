package batch.orangehrm;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Activity_12 {
	
	    public void employee(String firstName, String lastName, String user_name) throws InterruptedException {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("http://alchemy.hguy.co/orangehrm");
			WebElement txtUsername = driver.findElement(By.id("txtUsername"));
			WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	    txtUsername.sendKeys("orange");
	    txtPassword.sendKeys("orangepassword123");
	    driver.findElement(By.id("btnLogin")).click();
	        driver.findElement(By.xpath("//b[contains(.,'PIM')]")).click();
	        driver.findElement(By.xpath("//input[@value='Add']")).click();
	        driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys("E");
	        driver.findElement(By.xpath("//input[contains(@name,'lastName')]")).sendKeys("Pavani");
	        driver.findElement(By.xpath("//input[contains(@type,'checkbox')]")).click();
	        driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("user_name");
	        driver.findElement(By.xpath("//input[@value='Save']")).click();
	        //  Upload a CSV
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//a[contains(.,'Data Import')]")).click();
	        driver.findElement(By.xpath("//input[contains(@type,'file')]")).sendKeys("C:\\Users\\EemaniPavani\\Desktop\\Excel.xlsx");
	        driver.findElement(By.xpath("//input[@value='Upload']")).click();
	    }
	    @DataProvider(name = "orangeData")
	    public Object[][] passData() {
	        DataConfig config = new DataConfig( "C:\\Users\\EemaniPavani\\Desktop\\Activity_9.xlsx");
	        int rows = config.getRowCount(0);
	        Object[][] data = new Object[rows][3];
	        for (int i = 1; i < rows; i++) {
	            data[i][0] = config.getdata(0, i, 0);
	            data[i][1] = config.getdata(0, i, 1);
	            
	        }
	        return passData();
	    }
	}
 


