package batch.orangehrm;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity_13 {
  WebDriver driver;
  
	@Test
  public void f() {
		driver= new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/orangehrm");
		WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	    txtUsername.sendKeys("orange");
	    txtPassword.sendKeys("orangepassword123");
	    driver.findElement(By.id("btnLogin")).click();
	    WebElement pim= driver.findElement(By.id("menu_pim_viewPimModule"));
		pim.click();
		
		WebElement config= driver.findElement(By.id("menu_pim_Configuration"));
		config.click();
		Thread.sleep(1000);
		WebElement export= driver.findElement(By.id("menu_admin_pimCsvImport"));
		action.moveToElement(pim).build().perform();
		action.moveToElement(config).build().perform();
		action.moveToElement(export).click().build().perform();
		//Upload CSV file
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		WebElement upload = driver.findElement(By.xpath("//*[@value='Upload']"));
		wait.until(ExpectedConditions.visibilityOf(upload));
		WebElement fileU=driver.findElement(By.xpath("//*[@name='pimCsvImport[csvFile]']"));
		fileU.sendKeys(file.getAbsolutePath());
		upload.click();
		WebElement h1=driver.findElement(By.id("pimCsvImportHeading"));
		System.out.println(h1.getText());

		//Reading CSV file for validation
		CSVReader reader= new CSVReader(new FileReader("C:\\Users\\EemaniPavani\\Desktop\\Excel.csv"));
		List<List<String>> data = new ArrayList<List<String>>();
		List<String[]> content =reader.readAll();
		Iterator<String[]> it= content.iterator();

		while(it.hasNext())
		{
			List<String> rowData = new ArrayList<String>();

			String[] values=it.next();
			for(int i=0;i<values.length;i++)
			{
				{
					rowData.add(values[i]);
				}
			}
			data.add(rowData);
		}
		
		
		// Validation in screen
		driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
		System.out.println(data.size());
		for(z=1;z<data.size();z++)
		{
			WebElement employeename= driver.findElement(By.id("empsearch_employee_name_empName"));
			employeename.clear();
			employeename.sendKeys(data.get(z).get(0));
			driver.findElement(By.id("searchBtn")).click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);			
			WebElement getText=driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[3]"));
			Assert.assertEquals(getText.getText(), data.get(z).get(0));
			
			Reporter.log(" Employee "+z+" Data Created and Retrieved with Name: "+data.get(z).get(0));

		}
	}
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
