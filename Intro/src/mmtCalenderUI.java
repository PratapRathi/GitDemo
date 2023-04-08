import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class mmtCalenderUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\prata\\OneDrive\\Documents\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.get("https://www.makemytrip.com/");
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.className("ic_circularclose_grey"))).click().build().perform();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//String year = "2023";
		String month = "November";
		String day = "16";
		String name = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[@class='DayPicker-Month'][1]/div[@class='DayPicker-Caption']")).getText();
		while(!driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[@class='DayPicker-Month'][1]/div[@class='DayPicker-Caption']")).getText().contains(month))
		{
			a.moveToElement(driver.findElement(By.cssSelector("span[aria-label='Next Month']"))).click().build().perform();
		}
		List<WebElement> date = driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]/div[@class='DayPicker-Body']//div[@class='DayPicker-Day']/div[@class='dateInnerCell']/p[1]"));
		for(int i=0; i<date.size(); i++)
		{
			if(date.get(i).getText().contains(day))
			{
				date.get(i).click();
				break;
			}
		}
				
	}
}

