import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ParseString {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prata\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticdropdown = Driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		Driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		System.out.println(Driver.findElement(By.id("divpaxinfo")).getText());
		int i=1;
		while(i<5)
			{Driver.findElement(By.id("hrefIncAdt")).click();
			i++;}
		System.out.println(Driver.findElement(By.id("divpaxinfo")).getText());
		Driver.findElement(By.id("btnclosepaxoption")).click();
		Driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		Driver.findElement(By.cssSelector("a[value='DEL']")).click();
		Thread.sleep(1000);
		Driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='GOI'] ")).click();
		//Driver.findElement(By.xpath("(//a[@value='GOI'])[2]")).click();  -- Same above Xpath but with index 
		
		 
		
		
		
		
		

	}

}
