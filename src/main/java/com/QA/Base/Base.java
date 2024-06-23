package com.QA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;
	public static Properties property;
	public static ChromeOptions option;
	
	public Base() {
		
		String path = System.getProperty("user.dir"+ "\\src\\main\\java\\properties"+"config.properties");
		try {
			FileInputStream file = new FileInputStream(path);
			property=new Properties();
			property.load(file);
		} 
		 catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		catch (IOException e) {
				e.printStackTrace();
			}}
	
	public void initialisebrowser() {
		
		String browsername = System.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver  = new ChromeDriver();
		}
		else if(browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browsername.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(System.getProperty("url"));
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	}
	
	
	
	
}
