package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.pages.ATSHomePage;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.crmHomePage;
import com.w2a.utilities.Utilities;

public class LoginTest extends BaseTest{
	
	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void loginTest(Hashtable<String,String> data) throws InterruptedException{
		
		//HomePage home = new HomePage();
		LoginPage lp = new LoginPage();
		//LoginPage lp = home.goToLogin();
		//System.out.println(data.get("username") + "---"+ data.get("password"));
		ATSHomePage ahp =lp.doLoginATS(data.get("username"), data.get("password"));
		//crmHomePage chp =lp.doLoginCRM(data.get("username"), data.get("password"));
		Assert.assertEquals(true,ahp.loginValid().isDisplayed() );
		//Assert.assertEquals(true,ahp.addCandidate().isDisplayed() );
		
		//Assert.fail("Login test failed");
	
		
	}

}
