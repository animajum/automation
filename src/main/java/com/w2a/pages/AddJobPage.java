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

public class AddJobPage  extends Page{
	
	public WebElement addJob(){
		click("dropdown_XPATH");
		click("addJob_XPATH");
		WebElement jt = find_element("jobtitle_XPATH");
		return jt;
		
	}
	
	
	
	public String addGeneralInfo(String JobTitle,String ClientName,String ClientContact,String EmpType,String Function,String ProductType,String OppID,String NoOfOpen,String Status, String JobSkill) throws Exception{
		
		type("jobtitle_XPATH",JobTitle);
		type("clientname_XPATH",ClientName);
		 try {
  			Thread.sleep(10000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
		 
		click("selectclient_XPATH");
		
		Page.type("clientcontact_XPATH",ClientContact);
		try {
 			Thread.sleep(5000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		click("selectclientcontact_XPATH");
		type("employmenttype_XPATH",EmpType); 
		type("function_XPATH",Function);
		type("productType_XPATH",ProductType);
		type("opportunityId_XPATH",OppID);
		click("oppSelect_XPATH");
		type("noOfOpenings_XPATH",NoOfOpen);
		type("status_XPATH",Status);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		click("contactInfo_XPATH");

		click("sameLabel_XPATH");
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//click("address_XPATH");
		click("jd_XPATH");
		js.executeScript("window.scrollBy(0,1000)", "");
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		type("cv_XPATH","Test");
		type("jobskill_XPATH",JobSkill);
		click("saveJob_XPATH");
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String url = driver.getCurrentUrl();
		return url;
	}
	
	
	

}
