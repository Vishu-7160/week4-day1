package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String windowH = driver.getWindowHandle();
		System.out.println(windowH);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		Set<String> secondWindow = driver.getWindowHandles();
		System.out.println("How many windows are there:"+ secondWindow.size());
		List<String>lstwindow =new ArrayList<String>(secondWindow);
		driver.switchTo().window(lstwindow.get(1));
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		driver.switchTo().window(lstwindow.get(0));
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();

		
	}

}
