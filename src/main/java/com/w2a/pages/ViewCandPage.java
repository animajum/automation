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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ViewCandPage  extends Page{
	
	public String getCandId(){
		WebDriverWait wait=new WebDriverWait(driver,300);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='blue-btn']")));
		String view_url = driver.getCurrentUrl();
		return view_url;
		
	}
	
	
	public void uploadResume(String resume){
		driver.navigate().refresh();
		click("file_XPATH");
		click("upload_XPATH");
	    StringSelection ss = new StringSelection("");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
 	    StringSelection sss = new StringSelection(resume);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sss, null);
		//System.out.println(getClipBoard());
		Robot robot = null;
		try {
				robot = new Robot();
		} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot = null;
		
	}
	
	public AddNotePage addNote(){
		
		String jobid = null;
		String jid = null;
		List<WebElement> listOfElements = driver.findElements(By.xpath("//*[@id]"));
		//System.out.println("Number of elements:" +listOfElements.size());
	    for (int i=0; i<listOfElements.size();i++){
	        //System.out.println( listOfElements.get(i).getAttribute("title"));
	        if(listOfElements.get(i).getAttribute("title").contains("Job #")) {
	        	jobid = listOfElements.get(i).getAttribute("title");
	        	String id[] = jobid.split(" ");
	        	int len = id[1].length();
	        	jid = id[1].substring(1, len);
	        	break;
	        }
	        	
	      }
	    
	    System.out.println(jid);
	    click("lastNote_XPATH");
		click("addNote_XPATH");
		AddNotePage anp = new AddNotePage(jid, "cand");
		return anp;
	}
	public AddNotePage thumbup(){
		

	    click("lastNote_XPATH");
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
