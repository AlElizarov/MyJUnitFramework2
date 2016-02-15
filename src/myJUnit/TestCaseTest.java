package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	WasRun test;
	
	@Override
	public void setUp(){
		System.out.println("yes");
		test = new WasRun();
	}
	
	public void testRunning(){
		test.run();
		assert(test.getWasRun());
	}
	
	public void testSetUp(){
		test.run();
		assert(test.wasSetup());
	}

}
