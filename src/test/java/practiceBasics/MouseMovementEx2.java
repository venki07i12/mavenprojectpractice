package practiceBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseMovementEx2 {

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
	public static void m()
	{
		driver.findElement(By.xpath("//span[@class='close1 img_col']")).click();
		driver.findElement(By.xpath("//a[starts-with(text(),'Principal Employers')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'TRRN Query Search')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'eKYC Portal')]")).click();
	}
	
	@AfterMethod
	public static void handlingalert() throws Exception
	{
		Set<String> hw = driver.getWindowHandles();
		Iterator<String> itr = hw.iterator();
		String mainwindow = itr.next();
		String CAIUwindow = itr.next();
		String TRRNwindow = itr.next();
		String KYCwindow = itr.next();
		
		Thread.sleep(5000);
		driver.switchTo().window(mainwindow);
		System.out.println("MainWindow ID is:" +mainwindow);
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		driver.switchTo().window(CAIUwindow);
		System.out.println("CAIUWindow ID is:" +CAIUwindow);
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		driver.switchTo().window(TRRNwindow);
		System.out.println("TRRNWindow ID is:" +TRRNwindow);
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		driver.switchTo().window(KYCwindow);
		System.out.println("KYCWindow ID is:" +KYCwindow);
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		driver.switchTo().window(TRRNwindow);
		driver.findElement(By.xpath("//input[@id='txtTrrn']")).sendKeys("venki07i12");
		driver.findElement(By.xpath("//button[@id='btnFilter']")).click();
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(5000);
		alt.accept();
		driver.close();
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
