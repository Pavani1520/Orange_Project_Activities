package batch.orangehrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create instance
		WebDriver driver= new FirefoxDriver();
		//open browser
		driver.get("http://alchemy.hguy.co/orangehrm");
      
		//Check the title of the page
        String title = driver.getTitle();
	
        //Print the title of the page
        System.out.println("Page title is: " + title);
      
		//Make sure it matches “OrangeHRM” exactly.
        String text= driver.getTitle();
       System.out.println("Activity_1 is done");
       
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
       Assert.assertEquals("OrangeHRM" , title);
       System.out.println("Matched text is found");
       driver.close();
       
	
		}
	}

