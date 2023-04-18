package vtiger.ContactsTests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;

import Vtiger.ObjectRepository.ContactsInfoPage;
import Vtiger.ObjectRepository.ContactsPage;
import Vtiger.ObjectRepository.CreateNewContactPage;
import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;

import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

@Listeners(Vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationWithListenersTest extends BaseClass{
	
		@Test(groups="RegressionSuite")
		public void createContactWithOrgTest() throws IOException {
		
	    String LASTNAME = eUtil.readDataFromExcel("Contacts",4,3);
	    String ORGNAME = eUtil.readDataFromExcel("Contacts",4,2);
	   
       //step5:navigate to organization link
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganizationLink();

			//step6:click on create organization lookup image
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOnCreateOrganizationLookupImage();
			
			//step7:create organization with mandatory field
			
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.CreateNewOrganization(ORGNAME);
			
			
			
			//step8:validate for organization
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String OrgHeader=oip.getOrganizationHeader();
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
			//step9:navigate to contacts link
			hp.clickOnContactsLink();
			
			//step10:click on create contact lookup image
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateContactLookUpImg();
			
			//step11:create contact
			CreateNewContactPage cncp=new CreateNewContactPage(driver);
			cncp.CreateNewContact(LASTNAME,ORGNAME,driver);
			
			
			//step12:Validate for contacts
			
			ContactsInfoPage cip=new ContactsInfoPage(driver);
			String ContactHeader=cip.getContactHeader();
			Assert.assertTrue(ContactHeader.contains(ORGNAME));
			
		
		
		}
		}

