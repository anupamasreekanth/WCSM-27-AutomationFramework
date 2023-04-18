package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGPractice {
@Test()
public void createUserTest()
{
	Assert.fail();
	System.out.println("user created");//should fail
}
@Test(enabled=false)
public void modifyUserTest()
{
	System.out.println("user modified");//should not executed
}
public void deleteUserTest()
{
	System.out.println("user deleted");
}
}

