import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parctise1 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\BhaktiZurunge\\Documents\\Eclipse\\Driver\\chromedriver.exe");
		//WebDriver d=new ChomeDriver();
		 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
            // Navigate to file upload page
            driver.get("https://demo.automationtesting.in/FileUpload.html");

            // Locate the file upload element
            driver.findElement(By.id("input-4")).
            sendKeys("C:\\Users\\BhaktiZurunge\\Downloads\\Upload.txt");

            // Submit the upload form if required
            driver.findElement(By.linkText("Upload")).click();

            System.out.println("File uploaded successfully!");
            System.out.println("Done");
        } finally {
            driver.quit();
        }
	}

}
