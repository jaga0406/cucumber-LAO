package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.lao.utilities.CommonUtils;

public class HomePage {
	
	private static HomePage homepageInstance;
	
	private HomePage() {
		
	}
	
	public static HomePage getInstance() {
		
		if (homepageInstance == null) {
			homepageInstance = new HomePage();
		}
		return homepageInstance;
	}
	

	
	@FindBy(linkText = "Directory")
	private WebElement DIRECTORY;
	
	@FindBy(xpath = "//*[@id='menu_time_viewTimeModule']/b")
    private WebElement TIME;
	
	@FindBy(id = "employee")
	private WebElement EMPLOYEENAME;
	
	@FindBy(id = "btnView")
	private WebElement VIEW;
	
	@FindBy(xpath = "//*[@class='inner']/div")
	private WebElement MESSAGE;
	
//	public WebElement getDIRECTORY() {
//		return DIRECTORY;
//	}
	
	public void clickDirectory()  {
		CommonUtils.getInstance().highlightElement(DIRECTORY);
		DIRECTORY.click();
	}
	
	public void clickTime() {
		CommonUtils.getInstance().highlightElement(TIME);
		TIME.click();
	}
	
	public void employeeName()  {
		CommonUtils.getInstance().highlightElement(EMPLOYEENAME);
		EMPLOYEENAME.sendKeys("John Smith");
	}
	
	public void clickView()  {
		CommonUtils.getInstance().highlightElement(VIEW);
		VIEW.click();
	}
	
	public String message()  {
		CommonUtils.getInstance().highlightElement(MESSAGE);
		return MESSAGE.getText();
	}
	
}
