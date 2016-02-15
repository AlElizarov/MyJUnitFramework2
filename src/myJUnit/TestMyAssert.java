package myJUnit;

public class TestMyAssert extends MyTestCase{
	
	public void testAssertEquals(){
		MyAssert.assertEquals(5, 7);
	}
	
	public void testAssertNotEquals(){
		MyAssert.assertNotEquals(7, 7);
	}
	
	public void testAssertTrue(){
		MyAssert.assertTrue(5 == 7);
	}

}
