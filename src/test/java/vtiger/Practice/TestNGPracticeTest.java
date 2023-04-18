package vtiger.Practice;

import org.testng.annotations.Test;

public class TestNGPracticeTest {
@Test(invocationCount=-2,priority=1)
public void createUserTest()
{
	System.out.println("user created");
}
@Test
public void modifyUserTest()
{
	System.out.println("user created");
}
public void deleteUserTest()
{
	System.out.println("user created");
}
}
