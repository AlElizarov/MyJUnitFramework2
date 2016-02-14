package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	public void testRunning(){
		WasRun test = new WasRun();
		System.out.println(test.getWasRun());
		test.testMethod();
		System.out.println(test.getWasRun());
	}

}
