package Login_PageTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class loginPageTest {
	
	@Test()
	public void toLogin() throws InterruptedException
		
	{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.goodreads.com/"); 	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.findElement(By.linkText("Sign In")).click();
	 driver.findElement(By.xpath("//button[@class=\"gr-button gr-button--dark gr-button--auth authPortalConnectButton authPortalSignInButton\"]")).click();
	 driver.findElement(By.id("ap_email")).sendKeys("govindregas@gmail.com");
	  driver.findElement(By.id("ap_password")).sendKeys("Welcome@1");
	  driver.findElement(By.id("signInSubmit")).click();
	 WebElement search= driver.findElement(By.xpath("//input[@class=\"searchBox__input searchBox__input--navbar\"]"));
	 search.sendKeys("Selenium Testing Tools Cookbook");
	 search.sendKeys(Keys.ENTER);
	 List<WebElement> bookTitleEle=driver.findElements(By.xpath("//a[@class=\"bookTitle\"]"));
	 for(WebElement ele:bookTitleEle)
	 {
	 	 if(ele.getText().contains("Selenium Testing Tools Cookbook"))
	 {
		 ele.click();
		 break;
	 }
	 }
	 driver.findElement(By.xpath("(//span[text()='Want to read'])[1]")).click();
	 driver.findElement(By.linkText("My Books")).click();
	 Thread.sleep(2000);
	 driver.navigate().refresh();
	 List<WebElement> booksTitle = driver.findElements(By.xpath("//td[@class=\"field title\"]"));
	 int count=1;
	 for(WebElement ele:booksTitle)
	 {
		 if(ele.getText().contains("Selenium Testing Tools Cookbook"))
		 {
			 Assert.assertTrue(true);
			 System.out.println("book has been added to My Books Shelves ");
			 break;
		 }
		count=count+1;
		 
	 }
	 driver.findElement(By.xpath("(//a[@class=\"actionLinkLite smallText deleteLink\"])["+count+"]")).click();
	 driver.switchTo().alert().accept();
	 List<WebElement> booksTitleAfterRemoval = driver.findElements(By.xpath("//td[@class=\"field title\"]"));
		 for(WebElement ele:booksTitleAfterRemoval)
	 {
		 if(ele.getText().contains("Selenium Testing Tools Cookbook"))
		 {
			 Assert.assertTrue(false);
			
		 }
		
		 
	 }
		 Assert.assertTrue(true);
		 System.out.println("book has been successfully removed");
		 
		 driver.findElement(By.xpath("//div[@class=\"dropdown dropdown--profileMenu\"]")).click();
		 driver.findElement(By.linkText("Sign out")).click();
		 System.out.println("user has been signed out");
		 driver.quit();

		
	}
	

}
