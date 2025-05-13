import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BhaktiZurunge\\Documents\\Eclipse\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		driver.findElement(By.xpath("//span[normalize-space()='Nested Frames']")).click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
		
		System.out.println(driver.findElement(By.xpath("//p[normalize-space()='Child Iframe']")).getText());
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));
		System.out.println(driver.findElement(By.linkText("Parent frame")).getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Nested Frames']")).getText());
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(30));
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(null));
		
		
		
		
		
		driver.quit();

	}

}
