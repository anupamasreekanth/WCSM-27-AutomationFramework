package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPractice2 {

@Test()
public void createUserTest()
{
	
	System.out.println("user created");
}

@Test()
public void modifyUserTest()
{
	System.out.println("user modified");
}

@Test()
public void deleteUserTest()
{
	System.out.println("user deleted");
}
}
