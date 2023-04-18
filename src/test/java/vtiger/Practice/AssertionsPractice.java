package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	@Test
	public void practice() 
	{
	System.out.println("step1");
	System.out.println("step2");
	Assert.assertEquals(false,true);
	System.out.println("step3");
	System.out.println("step4");
	}
	@Test
	public void practice1() 
	{
		SoftAssert sa=new SoftAssert();
	
	System.out.println("step1-Practice");
	sa.assertEquals("A","C");//pass
	
	System.out.println("step2-Practice");
	sa.assertEquals("A","W");//pass
	
	
	System.out.println("step3-Practice");
	sa.assertTrue(false);//fail
	
	System.out.println("step4-Practice");
	sa.assertEquals("A","b");//pass
	
	sa.assertAll();//failures will be logged
	
	}

}
