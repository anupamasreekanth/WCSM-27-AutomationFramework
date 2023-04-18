package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestNGPractice1 {


@Test()
public void createUserTest()
{
	Assert.fail();
	System.out.println("user created");//executed-fail
}

@Test(dependsOnMethods="createUserTest")
public void modifyUserTest()
{
	System.out.println("user modified");//should not executed
}

@Test(dependsOnMethods= {"createUserTest","modifyUserTest"})
public void deleteUserTest()
{
	System.out.println("user deleted");//should not executed
}
}



