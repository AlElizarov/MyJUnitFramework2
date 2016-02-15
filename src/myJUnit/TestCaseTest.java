package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	WasRun test;
	
	@Override
	public void setUp(){
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
	
	public void testRef(){
		test.run();
		assert(2 == test.getCountMethods());
	}

}
