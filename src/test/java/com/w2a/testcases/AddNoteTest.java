package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.ATSHomePage;
import com.w2a.pages.AddCandPage;
import com.w2a.pages.AddNotePage;
import com.w2a.pages.ViewCandPage;
import com.w2a.pages.ViewJobPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;
import com.w2a.utilities.Utilities;

public class AddNoteTest extends BaseTest {
	
	
	/*@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void AddCandidateNoteTest(Hashtable<String,String> data){
		
		ViewCandPage vcp = new  ViewCandPage();
		AddNotePage anp =vcp.addNote();
		anp.addNote(data.get("MileStone"), data.get("NoteType"));
		anp = vcp.thumbup();
		anp.saveThumbsUp();
		//int i = vcp.getmileStone();
		
	}*/

	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void AddJobNoteTest(Hashtable<String,String> data){
		
		ViewJobPage vjp = new  ViewJobPage();
		System.out.println(data.get("MileStone") + data.get("NoteType"));
		
		AddNotePage anp =vjp.addNote();
		anp.addNote(data.get("MileStone"), data.get("NoteType"));
		anp = vjp.thumbup();
		anp.saveThumbsUp();
		int i = vjp.getmileStone();
		
	}
}
