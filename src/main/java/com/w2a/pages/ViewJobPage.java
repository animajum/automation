package com.w2a.pages;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ViewJobPage  extends Page{
	
	public String getCandId(){
		
		String view_url = driver.getCurrentUrl();
		return view_url;
		
	}
	
	
	
	public AddNotePage addNote(){
		
		String candId = null;
		String cid = null;
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id]"));
		System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i<listOfElements.size();i++){
	        
	       // System.out.println( listOfElements.get(i).getAttribute("title"));
	    	String str =  listOfElements.get(i).getAttribute("href");
	    	if(str == null)
	    	{
	    		str = "";
	    	}
	        if(str.contains("viewCandidate")) {
	        	System.out.println( listOfElements.get(i).getAttribute("href"));
	        	candId = listOfElements.get(i).getAttribute("href").toString();
				int st = candId.lastIndexOf("/") + 1;
			    int en = candId.length() ;
			    cid = candId.substring(st,en);
	        	break;
	        }
	        	
	      }
	    
	    System.out.println(cid);
	    click("joblastNote_XPATH");
		click("addNote_XPATH");
		AddNotePage anp = new AddNotePage(cid , "job");
		return anp;
	}
	public AddNotePage thumbup(){
		

	    click("joblastNote_XPATH");
		click("noteThumbsUp_XPATH");
		AddNotePage anp = new AddNotePage();
		return anp;
	}
	
	public int getmileStone(){
		
		List<WebElement> listOfElements = driver.findElements(By.xpath("//span[@class='milestoneName']"));
		System.out.println(listOfElements.get(listOfElements.size()-1).getAttribute("text"));
		return listOfElements.size();
		
	}

	public String getClipBoard(){
	    try {
	        return (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
	    } catch (HeadlessException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();            
	    } catch (UnsupportedFlavorException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();            
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    return "";
	}

}
