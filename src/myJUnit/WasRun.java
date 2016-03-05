package myJUnit;

public class WasRun extends MyTestCase{

	public void testMethod() {
	}

	public void testBroken(){
		int [] arr = new int[10];
		arr[10] = 10;
	}
	
	public void testFailure(){
		MyAssert.assertEquals(7, 5);
		//throw new AssertionError();
	}

}
