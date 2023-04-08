import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locator2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prata\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String name = "Pratap" ;
		Driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Driver.findElement(By.id("inputUsername")).sendKeys(name);
		Driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		Driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(Driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(Driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(Driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		Driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Driver.close();
		
	}

}
