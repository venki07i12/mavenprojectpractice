package practiceBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseMovementEx1 {

	public static WebDriver driver;
	
	@BeforeMethod
	public static void launch()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\venkatesh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.epfindia.gov.in/site_en/index.php");
		
	}
	
	@Test
	public static void mousemovement()
	{
		driver.findElement(By.xpath("//span[@class='close1 img_col']")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Our Services']"))).build().perform();
		driver.findElement(By.xpath("//a[text()='Locate an EPFO Office']")).click();
	}
	
}
