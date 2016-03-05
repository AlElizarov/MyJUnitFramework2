package myJUnit;

public class WasRun extends MyTestCase{

	public void testMethod() {
	}

	public void testBroken(){
		throw new RuntimeException();
	}
	
	public void testFailure(){
		MyAssert.assertEquals(7, 5);
		//throw new AssertionError();
	}

}
