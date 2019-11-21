package com.w2a.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class AddPlacementPage  extends Page{

	public WebElement addplacement(){

		
		click("dropdown_XPATH");
		click("addplace_XPATH");
		WebElement jt = find_element("jobID_XPATH");
		return jt;
		
	}
	
	
	
	public void addGeneralInfo(String jid, String sts, String strtdt, String duration , String JobTitle) throws Exception{
		String jobid = null;
		String j_id = null;
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id]"));
		System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i<listOfElements.size();i++){
	        System.out.println( listOfElements.get(i).getAttribute("title"));
	        if(listOfElements.get(i).getAttribute("title").contains("Job #")) {
	        	jobid = listOfElements.get(i).getAttribute("title");
	        	String id[] = jobid.split(" ");
	        	int len = id[1].length();
	        	j_id = id[1].substring(1, len);
	        	break;
	        }
	        	
	      }
	    
	    System.out.println(j_id);
	    int job_id;
		if(j_id != null) {
			job_id = Integer.parseInt(j_id);
		}
		else {
		
		job_id = (int) (Double.parseDouble(jid));
		}
		type("jobID_XPATH",Integer.toString(job_id));
		
		 try {
  			Thread.sleep(5000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
		driver.findElement(By.xpath("//li[contains(text(),'"+ Integer.toString(job_id)+" : "+JobTitle+"')]")).click();
		//click("job_XPATH"); 
		
		 try {
	  			Thread.sleep(1000);
	  		} catch (InterruptedException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
	    Select dropdown = new Select(driver.findElement(By.id("candidateName")));

	    //Get all options
	    List<WebElement> dd = dropdown.getOptions();
	    System.out.println(dd.size());
	    //Get the length
	    if (dd.size() > 1) 
	    {
	    	System.out.println(dd.get(1).getText());
	    Page.type("cand_XPATH",dd.get(1).getText());
	    	
	    	
	    }
	    
		
		
		type("status_XPATH",sts);
		type("jobDuration_XPATH",duration);
		 try {
	  			Thread.sleep(1000);
	  		} catch (InterruptedException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
		type("startDate_XPATH",strtdt);

		/*try {
 			Thread.sleep(5000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
		click("selectclientcontact_XPATH");
		type("employmenttype_XPATH","Direct Hire"); 
		type("function_XPATH","IT");
		type("productType_XPATH","Staffing");
		type("opportunityId_XPATH","1234567");
		type("noOfOpenings_XPATH","1");
		type("status_XPATH","Open");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}*/
		
	}
	
	
	public void addFinInfo(String curr, String hr, String br, String pr , String pu , String bro , String pro , String roc , String cnd , String edt) throws Exception{
		click("staffing_XPATH"); 
		type("currencyStaffing_XPATH",curr);
		type("hoursPerDay_XPATH",hr);
		type("billRate_XPATH",br);
		type("payRate_XPATH",pr);
		type("payUnit_XPATH",pu);
		type("billRateOverTime_XPATH",bro);
		type("payRateOverTime_XPATH",pro);
		type("rateOnCall_XPATH",roc);
		type("durationContract_XPATH",cnd);
		type("planEndDate_XPATH",edt);
		
		click("btn_XPATH");
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		
		
	}

}
