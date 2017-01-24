package com.onetrust.career;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.onetrust.pages.OneTrustCareerPage;
import com.onetrust.utility.Utilities;
import com.relevantcodes.extentreports.LogStatus;



public class VerifyJobRequirement extends Utilities{
	private int failCounter=1;
	
	@Test
	public void verifyRequirement(){
		do{
		
			try{
			
				OneTrustCareerPage career_home_page=PageFactory.initElements(driver, OneTrustCareerPage.class);
				
				launchURL();
				logger.log(LogStatus.PASS, "OneTrust career home pages up and running");
				System.out.println("excel reading:"+data.get("Location"));
				String _jobs=career_home_page.selectLocation(data.get("Location"));
				
				logger.log(LogStatus.PASS, "Number of vacancies available in location : "+data.get("Location")+": "+_jobs);
				failCounter+=2;
			
			}catch(Exception e){
				failCounter++;

				if(failCounter>2){

					logger.log(LogStatus.FAIL, "An Exception occurred after re-running this script."
							+ "Failing this test script!! "+e);
				}
				else{
					logger.log(LogStatus.FAIL, "An Exception occured for first time during this execution."
							+ "Re-running this script!! "+e);
				}
			}
		}while(failCounter==2);
		
	}


}
