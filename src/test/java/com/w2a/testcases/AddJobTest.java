package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.ATSHomePage;
import com.w2a.pages.AddCandPage;
import com.w2a.pages.AddJobPage;
import com.w2a.pages.ViewCandPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;
import com.w2a.utilities.Utilities;

public class AddJobTest extends BaseTest {
	
	
	@Test()
	public void openAddJobPageTest(){
		
		ATSHomePage ahp = new ATSHomePage();
		Assert.assertEquals(true,ahp.addJob().isDisplayed());
		/*AddJobPage ajp = new AddJobPage();
		Assert.assertEquals(true,ajp.addJob().isDisplayed());*/
	}
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp",dependsOnMethods={"openAddJobPageTest"})
	public void AddJobInfoTest(Hashtable<String,String> data){
		
		AddJobPage ajp = new AddJobPage();
		try {
			String url = ajp.addGeneralInfo(data.get("JobTitle"),data.get("ClientName"),data.get("ClientContact"),data.get("EmpType"),data.get("Function"),data.get("ProductType"),data.get("OppID"),data.get("NoOfOpen"),data.get("Status"),data.get("JobSkill"));
			Assert.assertTrue(url.contains("viewJob"));
			System.out.println("Job ID : " + url.substring(38, url.length()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals(true,ahp.addJob().isDisplayed());
	}

/*	@Test(dataProviderClass=Utilities.class,dataProvider="dp",dependsOnMethods={"openAddCandidatePageTest"})
	public void AddCandidateInfoTest(Hashtable<String,String> data){
		
		AddCandPage acp = new AddCandPage();
		acp.addBasicInfo(data.get("FirstName"), data.get("LastName"),data.get("Gender"), data.get("Source"));
		try {
			acp.addContactInfo(data.get("Email"), data.get("Phone").replace(".", ""),data.get("City"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acp.addWorkInfo(data.get("Company"), data.get("JobTitle"));
		acp.addSkillnfo(data.get("Skills"));
		ViewCandPage vcp = acp.saveCandInfo();
		Assert.assertTrue(vcp.getCandId().contains("viewCandidate"));
		vcp.uploadResume(data.get("Resume"));
		//Assert.assertEquals(true,ahp.addCandidate().isDisplayed() );
	}*/
	

}
