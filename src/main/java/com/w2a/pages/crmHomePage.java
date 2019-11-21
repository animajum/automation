package com.w2a.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class crmHomePage extends Page{

public WebElement loginValid() throws InterruptedException{
		
		//Get the current window handle
		String windowHandle = driver.getWindowHandle();

		//Get the list of window handles
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(tabs.size());
		//Use the list of window handles to switch between windows
		driver.switchTo().window(tabs.get(1));
		System.out.println("Login Validation Start");
		Thread.sleep(4000);
		WebElement dd = find_element("loginDropdown_XPATH");
		System.out.println("Login Validation End");
		return dd;
		
	}
	
	public WebElement addLead(){
		click("addDropdown_XPATH");
		click("addLead_XPATH");
		WebElement fn = find_element("firstNameLead_XPATH");
		return fn;
		
	}
	public WebElement viewLead(){
		click("menu_XPATH");
		click("candv_XPATH");
		WebElement fn = find_element("filter_XPATH");
		return fn;
		
	}
	
	public WebElement addJob(){
		
		click("addDropdown_XPATH");
		
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
