package myJUnit;

import java.util.ArrayList;

public class WasRun extends MyTestCase{

	public void testMethod() {
	}

	public void testBroken(){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.get(2);
	}
	
	public void testFailure(){
		MyAssert.assertEquals(7, 5);
	}

}
