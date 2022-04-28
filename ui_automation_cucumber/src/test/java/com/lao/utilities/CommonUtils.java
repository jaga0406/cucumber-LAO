package com.lao.utilities;




import java.io.File;
import java.time.Duration;
import java.util.Properties;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lao.constants.Constants;
import com.lao.page_objects.DirectoryPage;
import com.lao.page_objects.HomePage;
import com.lao.page_objects.LoginPage;
import com.lao.step_definitions.Common_Step_Def;
import com.lao.webdriver_manager.DriverManager;

public class CommonUtils {
	
	private static final Logger LOGGER = LogManager.getLogger(CommonUtils.class);
	
	private static CommonUtils commonutilsInstance;
	
	private CommonUtils() {
		
	}

	public static CommonUtils getInstance() {
		if (commonutilsInstance == null) {
			commonutilsInstance = new CommonUtils();
		}
		return commonutilsInstance; 
	}
	
	public void loadproperties() {
	
		Properties properties = new Properties();
		try {
	      properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	 
	
	Constants.APP_URL =	properties.getProperty("APP_URL");
	Constants.BROWSER =	properties.getProperty("BROWSER");
	Constants.UserName = properties.getProperty("UserName");
	Constants.Password = properties.getProperty("Password");
		
}
	public void initwebElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
	}
	
	public void TakeScreenshot() {
	File screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	try {
	   FileUtils.copyFile(screenshot, new File(Common_Step_Def.getscnearioname()+".png"));
	}catch (Exception e) {
       System.out.println(e.getMessage());
	}
  }
	 
		public void highlightElement(WebElement element)  {
			 JavascriptExecutor executor = (JavascriptExecutor)DriverManager.getDriver();
			 executor.executeScript("arguments[0].style.border = '6px groove green'" ,element);
			 DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			 executor.executeScript("arguments[0].style.border = ''" ,element);
			 executor.executeScript("arguments[0].click();", element);
	    }
		
		public void selectFromdropdown(WebElement dropdown, String howTo, String value) {
			Select select = new Select(dropdown);
			switch (howTo) {
			case "index":
				select.selectByIndex(Integer.parseInt(value));
				break;
			case "value":
				select.selectByValue(value);
				break;
			case "text":
				select.selectByVisibleText(value);
				break;
			default:
				LOGGER.info("please provide a valid selection. valid selections are: text, value, index");
				break;
			}
		}
}