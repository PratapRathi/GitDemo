import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\prata\\OneDrive\\Documents\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemList = { "Brocolli", "Cauliflower", "Cucumber" };
		additems(driver,itemList);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());

	}
	public static void additems(WebDriver driver, String[] itemList)
	{
		List<WebElement> item = driver.findElements(By.cssSelector("h4[class='product-name']"));
		for (int i = 0; i < item.size(); i++) 
		{
			String[] veg = item.get(i).getText().split("-");
			List cart = Arrays.asList(itemList);
			
			if (cart.contains(veg[0].trim())) 
			{
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				int j = 1;
				j++;
				if (j == itemList.length) {
					break;
					
				}
			}
		}	
	}
}
