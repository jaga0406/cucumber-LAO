package com.lao.webdriver_manager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.lao.constants.Constants;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	private static WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);

	
	public static void launchBrowser() {
		try {
		switch (Constants.BROWSER) {
		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			LOGGER.info("Launching" +Constants.BROWSER); 
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
			break;
		case "edge":

			WebDriverManager.edgedriver().setup(); 
			LOGGER.info("Launching" +Constants.BROWSER); 
			driver = new EdgeDriver();
		    driver.manage().window().maximize();
			break;
		case "safari":
		
			WebDriverManager.safaridriver().setup();
			LOGGER.info("Launching" +Constants.BROWSER); 
			driver = new SafariDriver();
		    driver.manage().window().maximize();
			break;	
		case "firefox":

			WebDriverManager.firefoxdriver().setup();
			LOGGER.info("Launching" +Constants.BROWSER); 
			driver = new FirefoxDriver();
		    driver.manage().window().maximize();
			break;	
		default:
			 
			WebDriverManager.chromedriver().setup();
			LOGGER.info("Launching" +Constants.BROWSER); 
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
			break;
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static WebDriver getDriver() {
		return driver;
	}
}
