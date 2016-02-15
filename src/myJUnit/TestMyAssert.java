package myJUnit;

public class TestMyAssert extends MyTestCase{
	
	public void testAssertEquals(){
		MyAssert.assertEquals(7, 7);
	}
	
	public void testAssertNotEquals(){
		MyAssert.assertNotEquals(5, 7);
	}
	
	public void testAssertTrue(){
		MyAssert.assertTrue(7 == 7);
	}
	
	public void testAssertFalse(){
		MyAssert.assertFalse(5 == 7);
	}

}
