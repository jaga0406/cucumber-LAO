package com.lao.step_definitions;




import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;



import com.lao.page_objects.DirectoryPage;
import com.lao.page_objects.HomePage;

import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCEOName_Step_def {
	
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class); 
	
	@Given("User successfully logged in and is in Home page")
	public void user_successfully_logged_in_and_is_in_home_page() {
	
				
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

	@When("the user clicks on directory option from menu bar")
	public void the_user_clicks_on_directory_option_from_menu_bar() {
	
		try {
		HomePage.getInstance().clickDirectory();
		LOGGER.info("the user clicks on directory option from menu bar");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}
		

	@And("The user selects the job title as {string} from the dropdown using {string}")
	public void the_user_selects_the_job_title_as_from_the_dropdown(String jobTitle, String howTo) {

		try {
	   CommonUtils.getInstance().selectFromdropdown(DirectoryPage.getInstance().getJOB_TITLE(), howTo, jobTitle);
	   LOGGER.info("The user selects the job title as CEO from the dropdown");
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		} 
	}

	@And("clicks the search button")
	public void clicks_the_search_button() {
     try {
		DirectoryPage.getInstance().clicksearch();
		 LOGGER.info("clicks the search button");
     }catch (Exception e) {
    	 LOGGER.error(e);
		 CommonUtils.getInstance().TakeScreenshot();
	}
	}

	@Then("the user should see the CEO name as {string}")
	public void the_user_should_see_the_ceo_name_as(String expectedname) {
		try {
		    String actualname = DirectoryPage.getInstance().Getname();
			if (actualname.equalsIgnoreCase(expectedname)) {
				LOGGER.info("the user should see the CEO name as John Smith");
			}
		}catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
			}
		} 
      }
