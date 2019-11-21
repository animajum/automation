package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.w2a.base.Page;

public class AddLeadPage extends Page{
	public void addBasicInfo(String fname, String lname, String account , String jobTitle ,String Source ) throws InterruptedException{
	    driver.navigate().refresh();
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Page.type("firstNameLead_XPATH",fname);
		Page.type("lastNameLead_XPATH",lname);
		Page.type("AccountLead_XPATH",account);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[contains(text(),'"+account+"')]")).click();;
		
		Page.type("JobTitleLead_XPATH",jobTitle);
		
		Page.select("SourceLead_XPATH", Source);
		
	}
	
	public void saveLeadInfo()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Page.click("SaveLead_XPATH");
		System.out.println("Saved");
	}
}
