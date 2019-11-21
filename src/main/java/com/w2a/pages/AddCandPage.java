package com.w2a.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;
import com.w2a.utilities.ResumeUpload;

public class AddCandPage  extends Page{
	
	public void addBasicInfo(String fname, String lname, String gender , String Source ,String Ethnicity ,String Nationality) throws InterruptedException{

		Page.type("firstName_XPATH",fname);
		Page.type("lastName_XPATH",lname);
		Page.type("gender_XPATH",gender);
		Thread.sleep(5000);
		Page.type("ethnicity_XPATH",Ethnicity);
		Page.type("nationality_XPATH",Nationality);
		Page.type("source_XPATH",Source);
		
	}
	
	public void uploadResume() throws InterruptedException
	{
		click("fileDrop_XPATH");
		ResumeUpload ru = new ResumeUpload();
		ru.upload(OR.getProperty("CV_path"));
		Thread.sleep(4000);
		click("nextBtn_XPATH");
		Thread.sleep(1000);
		Page.click("noBtn_XPATH");
	}
	
	public void addContactInfo(String email, String phone, String city) throws Exception{
		
		click("contact_XPATH");
		Page.type("email_XPATH",email);
		Page.type("priphone_XPATH",phone);
		
		 Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException eR) {
				// TODO Auto-generated catch block
				eR.printStackTrace();
			}
			Thread.sleep(5000);
//			for(int i = 1 ; i< 29 ;i++)
//			{
//		    robot.keyPress(KeyEvent.VK_TAB);
//		    robot.keyRelease(KeyEvent.VK_TAB);
//			}
			Page.click("label_city_XPATH");
			Thread.sleep(5000);
			Page.click("city_XPATH");
		Page.type("city_XPATH",city);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException eR) {
			// TODO Auto-generated catch block
			eR.printStackTrace();
		}
	    
		robot.keyPress(KeyEvent.VK_DOWN);
	    robot.keyRelease(KeyEvent.VK_DOWN);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException eR) {
			// TODO Auto-generated catch block
			eR.printStackTrace();
		}
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    robot = null;
	    
		try {
			Thread.sleep(10000);
		} catch (InterruptedException eR) {
			// TODO Auto-generated catch block
			eR.printStackTrace();
		}
		
	}
	
	public void addWorkInfo(String company, String jobtitle){
		
		click("work_XPATH");
		Page.type("currentCompanyName_XPATH",company);
		Page.type("jobTitle_XPATH",jobtitle);
		
	}
	public void addWorkpermitInfo(String wrkpermit){
		
		click("workAuth_XPATH");
		Page.type("workpermit_XPATH",wrkpermit);

		
	}
	
	public void addEduInfo(String school, String degree){
		
		click("education_XPATH");
		Page.type("school_XPATH",school);
		Page.type("degress_XPATH",degree);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,500)", "");
		
	}
	
	public void addSkillnfo(String skills){
		
		click("skill_XPATH");
		Page.type("cv_XPATH",skills);
		Page.type("priskill_XPATH",skills);
	    JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("window.scrollBy(0,500)", "");	
		
	}
	
	public ViewCandPage saveCandInfo(){
		
		click("saveCandidate_XPATH");
		System.out.println("clicked");
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		return new ViewCandPage();
		
	}
	

}
