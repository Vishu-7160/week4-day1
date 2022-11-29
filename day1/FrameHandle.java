package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().frame(0);
		WebElement clck = driver.findElement(By.xpath("//button[text()='Click Me']"));
		clck.click();
		String info = clck.getText();
		System.out.println(info);
		File snap = driver.getScreenshotAs(OutputType.FILE);
		File save = new File(".snap/framesnap.png");
		FileUtils.copyFile(snap, save);
		driver.switchTo().defaultContent();
		
		 WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
	     driver.switchTo().frame(outerFrame);
	     driver.switchTo().frame("frame2");
	     WebElement clck1 = driver.findElement(By.xpath("//button[text()='Click Me']"));
	     clck1.click();
		 String text = clck1.getText();
		 System.out.println(text);
		
	}

}
