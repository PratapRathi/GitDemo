import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\prata\\OneDrive\\Documents\\chromedriver.exe");
		//WebDriver Driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prata\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Driver.findElement(By.id("inputUsername")).sendKeys("Pratap");
		Driver.findElement(By.name("inputPassword")).sendKeys("095011");
		Driver.findElement(By.className("signInBtn")).click();
		System.out.println(Driver.findElement(By.cssSelector("p.error")).getText());
		Driver.findElement(By.linkText("Forgot your password?")).click();
		Driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Pratap");
		Driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("pratap@gmail.com");
		Driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		Driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("pratap@gmail.com");
		Driver.findElement(By.xpath("//form/input[3]")).sendKeys("8171456687");
		Thread.sleep(1000);
		Driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(Driver.findElement(By.cssSelector("form p")).getText());
		Driver.findElement(By.xpath("//div[contains(@class,'forgot')]/button[1]")).click();
		Thread.sleep(1000);
		String password = getpassword(Driver);
		String name = "Pratap" ;
		Driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		Driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		Driver.findElement(By.id("chkboxOne")).click();
		Driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(3000);
		System.out.println(Driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(Driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(Driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
		Driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Driver.close();
		
		
	}
	public static String getpassword(WebDriver Driver) throws InterruptedException
	{
		Driver.get("https://rahulshettyacademy.com/locatorspractice/");
		Driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		Driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passtext = Driver.findElement(By.cssSelector("form p")).getText();
		String[] newpass= passtext.split("'");
		String pass =newpass[1].split("'")[0];
		Driver.findElement(By.className("go-to-login-btn")).click();
		Thread.sleep(1000);
		return pass;
		
	}

}
