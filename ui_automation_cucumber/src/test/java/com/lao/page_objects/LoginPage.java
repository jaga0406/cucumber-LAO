package com.lao.page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lao.utilities.CommonUtils;
import com.lao.webdriver_manager.DriverManager;

public class LoginPage {
	
    WebDriver driver = DriverManager.getDriver();
	
	private static LoginPage loginInstance;
	
	private LoginPage() {
	  // this private constructor doesnot allow users to create object	
	}
	
	public static LoginPage getInstance() {
		if (loginInstance == null) {
			loginInstance = new LoginPage();
		}
		return loginInstance;
	}
	
	
	By USERNAME = By.id("txtUsername");
	By PASSWORD = By.id("txtPassword");
	By LOGIN_BUTTON = By.id("btnLogin");
	
//    @FindBy(id = "txtUsername")
//    private WebElement USERNAME;
//	
//	@FindBy(id = "txtPassword")
//	private WebElement PASSWORD;
//	
//	@FindBy(id = "btnLogin")
//	private WebElement LOGIN_BUTTON;

//	public WebElement getUSERNAME() {
//		return USERNAME;
//	}
//
//	public WebElement getPASSWORD() {
//		return PASSWORD;
//	}
//
//	public WebElement getLOGIN_BUTTON() {
//		return LOGIN_BUTTON;
//	}
	
	//Defining methods for performing actions in this class itself 
	
	public void enterUsername(String username)  {
		
		try {
		CommonUtils.getInstance().highlightElement(driver.findElement(USERNAME));
		driver.findElement(USERNAME).sendKeys(username);
		}catch (NoSuchElementException e) {
			System.out.println("Element not found. Trying to find it using explicit wait");
			
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME));
			}catch (Exception e2) {
				System.out.println("Element still not found. There is some problem in locator");
			}
		}
	}
	public void enterPassword(String password)  {
		CommonUtils.getInstance().highlightElement(driver.findElement(PASSWORD));
		driver.findElement(PASSWORD).sendKeys(password);
	}
	public void clickLogin()  {
		CommonUtils.getInstance().highlightElement(driver.findElement(LOGIN_BUTTON));
		driver.findElement(LOGIN_BUTTON).click();
	}
	
}
