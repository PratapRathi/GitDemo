import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class webTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver", "C:\\Users\\prata\\OneDrive\\Documents\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> names= driver.findElements(By.xpath("//tr/td[1]"));
		List<String> product =names.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> newproduct =product.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(newproduct.equals(product));
		// Scan the name column with getText -> Rice -> print the price of the rice, on any page
		List<Object> price;
		do
		{	List<WebElement> rows= driver.findElements(By.xpath("//tr/td[1]"));
			price= rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeg(s)).collect(Collectors.toList());
			price.forEach(a->System.out.println(a));
			if(price.size()<1)
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		
		} while (price.size()<1);
		// Apply filter in list and check filter is working or not 
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> rice= driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredRice =rice.stream().filter(b->b.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(rice.size(), filteredRice.size());
	}

	private static Object getPriceVeg(WebElement s) {
		// TODO Auto-generated method stub
		String cost =s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return cost;
	}
}

