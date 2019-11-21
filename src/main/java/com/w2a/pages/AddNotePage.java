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

public class AddNotePage  extends Page{
	
	private String entity_id;
	private String entity;
	AddNotePage(String id , String ent){
		
		this.entity_id = id;
		this.entity =ent;
		
	}
	AddNotePage(){
		
		this.entity_id = null;
		this.entity = null;
		
	}
	public void addNote(String stage , String activity ){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement we = find_element("jobidType_XPATH");
		//System.out.println(we.getAttribute("class"));
		//System.out.println(we.getAttribute("text"));
		if(entity.contains("cand")) {
		type("jobidType_XPATH",this.entity_id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click("idSelect_XPATH");
		}
		else {
			type("candidType_XPATH",this.entity_id);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			click("idSelect_XPATH");
		}
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type("milestone_XPATH",stage);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type("noteType_XPATH",activity);
		type("noteCmnt_XPATH",stage);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		JavascriptExecutor js = (JavascriptExecutor)driver;
   		js.executeScript("window.scrollBy(0,2500)", "");
   		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		click("noteSave_XPATH");
   		System.out.println("Button Clicked");
   												
	}
public void saveThumbsUp( ){
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
   		JavascriptExecutor js = (JavascriptExecutor)driver;
   		js.executeScript("window.scrollBy(0,2500)", "");
		click("noteSave_XPATH");
		
	}
	
	
	

	

}
