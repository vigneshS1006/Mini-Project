package Alerts;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts extends DriverSetup {
	
	//static WebDriver driver;
	static String baseUrl;	
	
	public void setUpDriver() throws IOException, InterruptedException {
		driver=DriverSetup.getWebDriver();
	}
	
	public void navigation() {//navigating to baseUrl
		baseUrl=AccessProperties.getUrl();
		driver.get(baseUrl);
		System.out.println("Program Started...");
	}	
	
	public void close() {		
		driver.quit();
		System.out.println("Program exit successful.");
	}	
	
	@SuppressWarnings("unused")
	public String alertWithOk() throws IOException, AWTException, InterruptedException {
		
		WebDriverWait myWait=new WebDriverWait(driver,Duration.ofSeconds(10));//Explicitly wait
		
		//WebElement switchTo=driver.findElement(By.linkText("SwitchTo"));
		WebElement switchTo=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("SwitchTo")));
				
		Actions act=new Actions(driver);
		act.moveToElement(switchTo).build().perform();//Hovering to 'SwitchTo' element		
		
		List<WebElement> options=driver.findElements(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li"));
				
		for(int i=0;i<options.size();i++) {//clicking 'Alerts' from the drop-down
			String option=options.get(i).getText();
			if(option.equals("Alerts")) {
				options.get(i).click();
				break;
			}			
		}		
		
		//Locating and clicking on 'Alert with OK' link
		WebElement link=driver.findElement(By.xpath("//a[normalize-space()='Alert with OK']"));
		link.click();
		
		//Locating and clicking on 'click the button to display an alert box' button
		WebElement button=driver.findElement(By.xpath("//*[@id='OKTab']/button"));
		button.click();
		
		//Checking whether alert pop up appears or not and clicking on 'OK' in the alert
		Alert alertWin=myWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		
		//Taking Screenshot of the Alert
		RobotScreenshot.screenShot("screenshot1");
		
		//Alert alert=driver.switchTo().alert();
		
		alertWin.accept();
		
		return "Alert popup appears!\n";
		
	}
	
	@SuppressWarnings("unused")
	public String alertWithOkAndCancel() throws IOException, AWTException, InterruptedException {
		
		String res=null;
		WebDriverWait myWait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Locating and clicking on 'Alert with OK & Cancel' link
		WebElement link=driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
		link.click();
		
		//Locating and clicking on 'click the button to display a confirm box' button
		WebElement button=driver.findElement(By.xpath("//*[@id='CancelTab']/button"));
		button.click();
		
		//Checking whether alert pop up appears or not and clicking on 'OK' in the alert
		Alert alertWin=myWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		
		//Taking Screenshot of the Alert
		RobotScreenshot.screenShot("screenshot2");
				
		//Alert alert=driver.switchTo().alert();
		alertWin.dismiss();	
		Thread.sleep(2000);	
		//Screenshot after clicking on cancel
		RobotScreenshot.screenShot("screenshot3");
		
		String message=driver.findElement(By.id("demo")).getText();
		if(message.equals("You Pressed Cancel")) {
			res="Confirm box popup appears! and 'You Pressed Cancel' is displayed\n";
		}	
		
		return res;
	}
	
	@SuppressWarnings("unused")
	public String alertWithTextbox() throws Exception {
		
		String res = null;
		WebDriverWait myWait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//Locating and clicking on 'Alert with Textbox' link
		WebElement link=driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']"));
		link.click();
		
		//Locating and clicking on 'click the button to demonstrate the prompt box' button
		WebElement button=driver.findElement(By.xpath("//*[@id='Textbox']/button"));
		button.click();
		
		//Checking whether prompt box pop up appears or not 
		Alert alertWin=myWait.until(ExpectedConditions.alertIsPresent());	
			
		String name=AccessProperties.getName();
		alertWin.sendKeys(name);
		Thread.sleep(2000);
		
		//Taking Screenshot of the Alert
		RobotScreenshot.screenShot("screenshot4");
				
		//Alert alert=driver.switchTo().alert();
		alertWin.accept();
		
		WebElement message=driver.findElement(By.id("demo1"));
		String msgText=message.getText();		
		Thread.sleep(2000);
		//Screenshot after entering Name
		RobotScreenshot.screenShot("screenshot5");
		
		if(msgText.contains(name)) {
			res="Prompt box pop up appears! and \'Hello "+name+" How are you today\' is displayed";
		}
		
		return res;
	}
	
	
	

}
