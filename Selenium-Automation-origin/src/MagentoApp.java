//Testing Magento.com
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagentoApp {
	public static void main (String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\SeleniumComponents\\chromedriver.exe");
		String url = "https://magento.com/";
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(5000);
		driver.manage().window().maximize();	//Maximize Window
		Thread.sleep(5000);
		driver.get(url);		//Opening WebPage
		Thread.sleep(5000);
		driver.findElement(By.linkText("My Account")).click();		
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys("subramanyaraj87@gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.id("pass")).sendKeys("Welcome123");
		Thread.sleep(5000);
		driver.findElement(By.id("send2")).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(7000);
		driver.close();


	}
}
