package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandle {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		Alert simple = driver.switchTo().alert();
		String info = simple.getText();
		System.out.println("Info on simple alert:"+ info);
		simple.accept();
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		Alert confirm = driver.switchTo().alert();
		String confirmInfo = confirm.getText();
		System.out.println("Info on confirm dialog" +confirmInfo);
		confirm.accept();
		String msg = driver.findElement(By.xpath("//span[text()='User Clicked : OK']")).getText();
		System.out.println(msg);
		driver.findElement(By.xpath("(//button[@name='j_idt88:j_idt104']//span)[2]")).click();
		Alert prompt = driver.switchTo().alert();
		prompt.sendKeys("Qspiders");
		String promptInfo = prompt.getText();
		System.out.println("Info on Prompt alert: " +promptInfo);
		prompt.accept();
		String pinfo = driver.findElement(By.xpath("//span[text()='User entered name as: Qspiders']")).getText();
		System.out.println(pinfo);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		
	}

}
