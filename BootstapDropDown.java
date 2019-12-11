package seleniumproject123;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstapDropDown {
	
	
	
	WebDriver driver=null;
	
	
	@BeforeMethod
	public void setUp() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\nischala\\Downloads\\chromedriver_win32\\chromedriver.exe" );
		 driver= new ChromeDriver();

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//driver.get("https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_dropdown-header&stacked=h");

	}
	
	@Test(enabled= false)
	public void testbootstrapdropdown() {
		
		
		driver.switchTo().frame(1);
		driver.findElement(By.cssSelector("button[data-toggle=\"dropdown\"]")).click();
		
	List<WebElement>ele=	driver.findElements(By.xpath("//ul[@class=\"dropdown-menu\"]//li"));
	int size=ele.size();
	
	for(int i=0;i<size;i++) {
		
		System.out.println(ele.get(i).getText());
		
		if(ele.get(i).getText().equals("About Us")) {
			ele.get(i).click();
			
		}
		
		
		
	}
		
	}
	
	
	@Test
	public void testDropdowm() {
		driver.get("https://www.amazon.com/?tag=amazusnavi-20&hvadid=381855514732&hvpos=1t1&hvnetw=g&hvrand=8550169634767566389&hvpone=&hvptwo=&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9012114&hvtargid=kwd-12712441&ref=pd_sl_48s8op24vs_e&hydadcr=15239_11283441&gclid=EAIaIQobChMI9KyA6Mfx5AIVD4vICh1mMwt3EAAYASAAEgI36_D_BwE");
	
WebElement ele=	driver.findElement(By.cssSelector("select[name=\"url\"]"));
	ele.click();
	
	Select s =new Select(ele);
	s.selectByVisibleText("Beauty & Personal Care");
	
	}
	
	
	
}
