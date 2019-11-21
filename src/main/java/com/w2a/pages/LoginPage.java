package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class LoginPage  extends Page{

	
	
	public ATSHomePage doLoginATS(String username,String password){
		
		Page.type("user_XPATH",username);
		Page.type("password_XPATH",password);
		Page.click("signbtn_XPATH");
		Page.click("atsbutton_XPATH");
		
		System.out.println("Logged ID");
		return new ATSHomePage();
	}
	
      public crmHomePage doLoginCRM(String username,String password){
		
		Page.type("user_XPATH",username);
		Page.type("password_XPATH",password);
		Page.click("signbtn_XPATH");
		//Page.click("atsbutton_XPATH");
		Page.click("crmbutton_XPATH");
		System.out.println("Logged ID");
		return new crmHomePage();
	}
	public void downloaddocx(){
		
		driver.get("https://mshincloud-my.sharepoint.com/personal/balakrishna_tokala_talentmsh_com/Documents/Test%20Candidate%202/abhinandanshukla%5b10_0%5d.docx");
		
	}
	
	public void gotoFinance(){
		
		
	}
	
}
