import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prata\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemList = { "Brocolli", "Cauliflower", "Cucumber" };
		List cart = Arrays.asList(itemList);
		Thread.sleep(2000);
		List<WebElement> item = driver.findElements(By.cssSelector("h4[class='product-name']"));
		for (int i = 0; i < item.size(); i++) {
			String[] veg = item.get(i).getText().split("-");

			if (cart.contains(veg[0].trim())) {
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
