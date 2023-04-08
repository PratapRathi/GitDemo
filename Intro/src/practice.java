import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class practice {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\prata\\OneDrive\\Documents\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> tab =driver.getWindowHandles();
		Iterator<String> it =tab.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		String name = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindow);
		System.out.println(name);
		WebElement sc = driver.findElement(By.xpath("//input[@name='name']"));
		//driver.findElement(with(By.tagName("input")).above(By.xpath("//div[@class='form-group'][2]"))).sendKeys(name);
		sc.sendKeys(name);
		File pic = sc.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(pic, new File("logo.png"));
		System.out.println(sc.getRect().getDimension().getHeight());
		System.out.println(sc.getRect().getDimension().getWidth());
		System.out.println(sc.getRect().getDimension().height);
		System.out.println(sc.getRect().height);
	}
}

