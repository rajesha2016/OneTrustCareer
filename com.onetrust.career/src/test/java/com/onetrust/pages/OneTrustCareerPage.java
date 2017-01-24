package com.onetrust.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.onetrust.utility.Utilities;

//Class to handle all webelements and support method

public class OneTrustCareerPage {
	
	WebDriver driver;
	Utilities _utility=new Utilities();
	private String _job;
	
	public OneTrustCareerPage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//*[@id='offices-select']")
	@CacheLookup
	WebElement location_dropdown;
	
	@FindBy(how=How.XPATH,using="//*[@id='filter-count']")
	@CacheLookup
	WebElement open_position_count;
	
	
	public String selectLocation(String _location){
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(location_dropdown));
		_utility.highLightElement(driver, location_dropdown);
		
		Select select=new Select(location_dropdown);
		select.selectByVisibleText(_location);
		
		_utility.highLightElement(driver, open_position_count);
		_job=open_position_count.getText().trim();
		
		return _job;
	}
	

}
