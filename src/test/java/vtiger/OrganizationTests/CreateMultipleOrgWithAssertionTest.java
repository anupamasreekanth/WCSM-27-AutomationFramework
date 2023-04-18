package vtiger.OrganizationTests;

import static org.testng.Assert.fail;

import java.io.IOException;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Vtiger.GenericUtilities.BaseClass;
import Vtiger.GenericUtilities.ExcelFileUtility;
import Vtiger.GenericUtilities.JavaUtility;

import Vtiger.ObjectRepository.CreateNewOrganizationPage;
import Vtiger.ObjectRepository.HomePage;

import Vtiger.ObjectRepository.OrganizationInfoPage;
import Vtiger.ObjectRepository.OrganizationPage;

@Listeners(Vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateMultipleOrgWithAssertionTest extends BaseClass {
	
	ExcelFileUtility eUtil=new ExcelFileUtility();
	JavaUtility jUtil=new JavaUtility();
	
	@Test(dataProvider="OrgWithIndustry")
	
	public void CreateOrgTest(String ORG,String INDUSTRY) throws IOException {
	
		String ORGNAME = ORG+jUtil.getRandomNumber();
			
		//step5:navigate to organization tab
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganizationLink();

			//step6:click on create organization lookup image
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOnCreateOrganizationLookupImage();
			
			//step7:create organization with mandatory field
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.CreateNewOrganization(ORGNAME);
			Assert.fail();
			
			//step8:validate for organization for organization
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String OrgHeader=oip.getOrganizationHeader();
			Assert.assertTrue(OrgHeader.contains(ORGNAME));
			
			
	}	
			
	@DataProvider(name="OrgWithIndustry")
	public Object[][] getData() throws IOException {
	Object[][]data=eUtil.readDatafromExcelToDataProvider("dataProviderOrg");
	
	
	return data;
	
}	
		}





