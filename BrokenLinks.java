package seleniumproject123;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {

			System.setProperty("webdriver.chrome.driver","C:\\Users\\nischala\\Downloads\\chromedriver_win32\\chromedriver.exe" );
			WebDriver driver= new ChromeDriver();

			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


driver.get("https://www.amazon.com");
Thread.sleep(2000);

List <WebElement> list= driver.findElements(By.tagName("a"));
list.addAll(driver.findElements(By.tagName("img")));

int amazonlinksAvailable=list.size();
System.out.println("the no links available in amazon are"+amazonlinksAvailable);


List<WebElement>amazonlinks=new ArrayList<>();


for(int i=0;i<amazonlinksAvailable;i++) {
if( (list.get(i).getAttribute("href")!=null) &&  !(list.get(i) .getAttribute("href")).contains("javascript")&&  !list.get(i) .getAttribute("href").isEmpty()){
	amazonlinks.add(list.get(i));
}
		
}
System.out.println("no of active links"+amazonlinks.size());
for(int j=0;j<amazonlinks.size();j++) {
	

	HttpURLConnection connection=(HttpURLConnection) new URL(amazonlinks.get(j).getAttribute("href")).openConnection();
	
	connection.connect();
	String Response_msg =connection.getResponseMessage();
	
	connection.disconnect();
	
	System.out.println(j);
	System.out.println(amazonlinks.get(j).getAttribute("href")+"--------->"+Response_msg);

	
}
			

		
		
}

}
