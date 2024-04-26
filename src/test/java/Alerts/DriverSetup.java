package Alerts;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {	
		
		public static  WebDriver driver;

		public static WebDriver getWebDriver() throws IOException, InterruptedException {
			
			System.out.println("Press '1' for CHROME\nPress '2' for EDGE");
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			
			int browser= sc.nextInt();
			
			switch(browser) {//opening the browser based on user input
			
			case 1:				
				System.out.println("Opening Chrome browser...");
				driver = new ChromeDriver();
				break;
				
			case 2:
				System.out.println("Opening Edge browser...");
				driver = new EdgeDriver();
				break;
			}
			//maximize the browser window
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			return driver;
			
		}

		
}
	
	


