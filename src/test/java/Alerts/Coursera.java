package Alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Coursera {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.coursera.org/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement search=driver.findElement(By.className("react-autosuggest__input"));
		search.sendKeys("data analytics");
		
		//react-autowhatever-1
		WebElement searchButton=driver.findElement(By.id("react-autowhatever-1"));
		searchButton.click();
		
//		driver.navigate().refresh();
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", search);
				
		Actions act=new Actions(driver);
		while(true)
		{
			try {
			search.click();
			break;
			}
			catch(StaleElementReferenceException e)
			{
				
			}
		}
		
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		act.sendKeys(Keys.DELETE).perform();
		
		search.sendKeys("Python");
		searchButton.click();
		
		
		
		
	}

}
