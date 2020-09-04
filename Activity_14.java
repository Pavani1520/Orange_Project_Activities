package batch.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Activity_14 {
    @Test
    public void vacancies(int index, String Name, String Manager) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement txtUsername = driver.findElement(By.id("txtUsername"));
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
	    txtUsername.sendKeys("orange");
	    txtPassword.sendKeys("orangepassword123");
	    driver.findElement(By.id("btnLogin")).click();
        driver.findElement(By.xpath("//b[contains(.,'Recruitment')]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Vacancies')]")).click();
        driver.findElement(By.xpath("//input[@value='Add']")).click();
        Select JobTitle = new Select(
                driver.findElement(By.xpath("//select[@name='addJobVacancy[jobTitle]'][contains(@id,'jobTitle')]")));
        JobTitle.selectByIndex(index);
        driver.findElement(By.xpath("//input[@name='addJobVacancy[name]']")).sendKeys(Name);
        driver.findElement(By.xpath("//input[@type='text'][contains(@id,'hiringManager')]")).sendKeys(Manager);
        driver.findElement(By.xpath("//input[@name='btnSave']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(.,'Vacancies')]")).click();
        Thread.sleep(3000);
        Select Vacancy = new Select(driver.findElement(By.xpath("//select[@name='vacancySearch[jobVacancy]']")));
        Vacancy.selectByVisibleText(Name);
        driver.findElement(By.xpath("//input[contains(@value,'Search')]")).click();
    }
    @DataProvider(name = "orangeData")
    public Object[][] passData() {
        ExcelDataConfig config = new ExcelDataConfig(
                "C:\\Users\\PadmarajSana\\eclipse-workspace\\OrangeProject\\src\\main\\java\\com\\excell\\multiple vacancies.xlsx");
        int rows = config.getRowCount(0);
        Object[][] data = new Object[rows][3];
        for (int i = 1; i < rows; i++) {
            data[i][0] = config.getdata(0, i, 0);
            data[i][1] = config.getdata(0, i, 1);
            data[i][2] = config.getdata(0, i, 2);
        }
        return passData();
    }
}

