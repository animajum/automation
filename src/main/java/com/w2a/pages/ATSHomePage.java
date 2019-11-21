package com.w2a.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ATSHomePage  extends Page{
	
	public WebElement loginValid() throws InterruptedException{
		
		//Get the current window handle
		//String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs.size());
		//Use the list of window handles to switch between windows
		driver.switchTo().window(tabs.get(1));
		System.out.println("Login Validation Start");
		Thread.sleep(4000);
		WebElement dd = find_element("dropdown_XPATH");
		System.out.println("Login Validation End");
		return dd;
		
	}

	
	public WebElement addCandidate(){
		click("dropdown_XPATH");
		click("addCand_XPATH");
		WebElement cv = find_element("addcv_XPATH");
		//WebElement fn = find_element("firstName_XPATH");
		return cv;
		
	}
	public WebElement viewCandidate(){
		click("menu_XPATH");
		click("candv_XPATH");
		WebElement fn = find_element("filter_XPATH");
		return fn;
		
	}
	
	public WebElement addJob(){
		
		click("dropdown_XPATH");
		
		click("addJob_XPATH");
		
		WebElement jt = find_element("jobtitle_XPATH");
		return jt;
		
	}
	
	public CRMHomePage gotoCRM(){
		
		click("crmlink_CSS");
		
		return new CRMHomePage();
	}
	
	
	public void gotoSalesIQ(){
		
		driver.findElement(By.cssSelector(".zicon-apps-salesiq.zicon-apps-96")).click();
		
	}

}
