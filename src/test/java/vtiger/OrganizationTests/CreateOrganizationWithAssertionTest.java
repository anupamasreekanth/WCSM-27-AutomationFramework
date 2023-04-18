package vtiger.OrganizationTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;

import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;

import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;


public class CreateOrganizationWithAssertionTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void CreateOrganizationTest() throws IOException, Throwable {
		
		//STEP1:CREATE OBJECT OF GENERIC UTILITIES
				
		        String ORGNAME = eUtil.readDataFromExcel("Organization",1,3)+jUtil.getRandomNumber();
		        
		        //step5:navigate to organization tab
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationLink();
				Reporter.log("navigate to organization link",true);

				//step6:click on create organization lookup image
				OrganizationPage op=new OrganizationPage(driver);
				op.clickOnCreateOrganizationLookupImage();
				Reporter.log("click on create organization look up image");
				//Assert.fail();
				Thread.sleep(2000);
				//step7:create organization with mandatory field
				CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
				cnop.CreateNewOrganization(ORGNAME);
				Reporter.log("new organization created");
				
				//step8:validate for organization for organization
				OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				String OrgHeader=oip.getOrganizationHeader();
				Assert.assertTrue(OrgHeader.contains(ORGNAME));
				
				
	}


}
