package Test.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ClickAllLinks {
	
	
	
	public List<String> switchToNewWindow(List<String> windowHandles, WebDriver driver) {
		
		Set<String> existingWindowHandles = driver.getWindowHandles();
		existingWindowHandles.removeAll(windowHandles);
		windowHandles.addAll(existingWindowHandles);
		driver.switchTo().window(windowHandles.get(windowHandles.size()-1));
		System.out.println(driver.getTitle());
		driver.close();	
		return windowHandles;
	}
	
	@Test
	public void clickLinks() {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<String> allWindowHandles = new ArrayList<>();
		String currentWindow = driver.getWindowHandle();
		allWindowHandles.add(currentWindow);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@id='pageFooterChildren']/ul/li/a"));
		wait.until(ExpectedConditions.visibilityOfAllElements(allElements));
		
		for(int index=1; index<allElements.size()-2; index++) {
			WebElement element = driver.findElement(By.xpath("(//div[@id='pageFooterChildren']/ul/li/a)[" + index + "]"));
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(driver.getWindowHandles().size() != 1) {				
				allWindowHandles = switchToNewWindow(allWindowHandles, driver);
				driver.switchTo().window(currentWindow);
			}
			else {
				System.out.println(driver.getTitle());
				driver.navigate().back();
			}
		}
		
		driver.quit();
		
	}
	

}
