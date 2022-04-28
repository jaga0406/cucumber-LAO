package com.lao.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.lao.utilities.CommonUtils;

public class DirectoryPage {
	
	private static DirectoryPage directorypageInstance;
	
	private DirectoryPage() {
		
	}
	
	public static DirectoryPage getInstance() {
		
		if (directorypageInstance == null) {
			directorypageInstance = new DirectoryPage();
		}
		return directorypageInstance; 
	}
	
	@FindBy(id = "searchDirectory_job_title")
	private WebElement JOB_TITLE;
	
    @FindBy(id = "searchBtn")
	private WebElement SEARCH;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr/td/ul/li/b")
	private WebElement NAME;
	
	public WebElement getJOB_TITLE() {
		return JOB_TITLE;
	}
//
//	public WebElement getSEARCH() {
//		return SEARCH;
//	}
//
//	public WebElement getNAME() {
//		return NAME;
//	}

	
	public void clicksearch() {
		CommonUtils.getInstance().highlightElement(SEARCH);
		SEARCH.click();
	}
	
	public String Getname() {
		return NAME.getText();
	}
	
}
