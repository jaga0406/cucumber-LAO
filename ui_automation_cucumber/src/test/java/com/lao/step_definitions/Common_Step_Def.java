package com.lao.step_definitions;

import org.apache.logging.log4j.LogManager;

import com.lao.constants.Constants;
import com.lao.page_objects.LoginPage;
import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;

import org.apache.logging.log4j.Logger;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Common_Step_Def {
	
    
	private static final Logger LOGGER = LogManager.getLogger(Common_Step_Def.class);
	
	 private static String scenarioname = null;
	 
	 public static String getscnearioname() {
		 return scenarioname;
	 }
	 
@Before	
public void beforescenario(Scenario scenario) {
	
	LOGGER.info("Execution Started");   
	
	try {
		scenarioname = scenario.getName();
	    LOGGER.info("Instantiation of common Utils");
	    
		
		LOGGER.info("Loading the properties file"); 
		
		CommonUtils.getInstance().loadproperties();
		
		LOGGER.info("Checking the driver is null or not");
		
    if (DriverManager.getDriver() == null) {
    	
    	LOGGER.info("Driver is NULL. Instantiating it");
 
	    DriverManager.launchBrowser();
	    
        CommonUtils.getInstance().initwebElements();
        
        String Url = DriverManager.getDriver().getCurrentUrl();
       if (!Url.contains("dashboard")) {
    	   login();
	} 
  }
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void login() {
	DriverManager.getDriver().get(Constants.APP_URL);
	LoginPage.getInstance().enterUsername(Constants.UserName);
	LoginPage.getInstance().enterPassword(Constants.Password);
	LoginPage.getInstance().clickLogin();
}



}
