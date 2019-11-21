package com.w2a.testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

import com.w2a.base.Page;

public class BaseTest {
	
	
	@AfterSuite
	public void tearDown(){
		
		//Page.quit();

		/*Page.quit();
	    System.out.println("After Suite");
	    try {
			Runtime.getRuntime().exec("TASKKILL /IM chromedriver.exe /F");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
