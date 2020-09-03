package batch.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {
	public static void main(String[] args) {
		
		WebDriver driver= new FirefoxDriver();
		 System.out.println("Activity_2 is done");
		driver.get("http://alchemy.hguy.co/orangehrm");
		String currentpageurl = driver.getCurrentUrl();
		System.out.println("Current page URL is : " +currentpageurl);
         driver.close();

	}
}
