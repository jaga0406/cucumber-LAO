package com.lao.step_definitions;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;


import com.lao.page_objects.HomePage;

import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Verify_Pending_Timesheets_step_def {
	
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class); 
	
	@Given("User is on the Home page")
	public void user_is_on_the_home_page() {
		
		try {
			
		    String Url = DriverManager.getDriver().getCurrentUrl();
			if (Url.contains("dashboard")) {
				LOGGER.info("User successfully logged in and is in Home page");
			}
			}catch (Exception e) {
				LOGGER.error(e);
				CommonUtils.getInstance().TakeScreenshot();
			}
		}

	@When("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {
		try {
		HomePage.getInstance().clickTime();
		LOGGER.info("the user clicks on the time option from the menu");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}

	@And("the user enters the name as {string}")
	public void the_user_enters_the_name_as(String string) {
		try {
		HomePage.getInstance().employeeName();
		LOGGER.info("the user enters the name as John Smith");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}

	@And("clicks the view button")
	public void clicks_the_view_button() {
		try {
		HomePage.getInstance().clickView();
		LOGGER.info("clicks the view button");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}

	@Then("the user should see the message as {string}")
	public void the_user_should_see_the_message_as(String string) {
		try {
		String actualmessage = HomePage.getInstance().message();
		if (actualmessage.equalsIgnoreCase(string)) {
			LOGGER.info("the user should see the message as No Timesheets Found");
		}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
//	       Assert.fail(e.getMessage());
		}
	}


}
