package myJUnit;

public class WasRun extends MyTestCase{

	public void testMethod() {
	}

	public void testBroken(){
		throw new RuntimeException();
	}

}
