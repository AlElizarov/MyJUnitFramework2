package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	//WasRun test;
	
	@Override
	public void setUp(){
		//test = new WasRun();
	}
	
	public void testRunning(){
		WasRun test = new WasRun();
		test.run();
		assert(test.getWasRun());
	}
	
	public void testSetUp(){
		WasRun test = new WasRun();
		test.run();
		assert(test.wasSetup());
	}
	
	public void testRef(){
		WasRun test = new WasRun();
		test.run();
		assert(2 == test.getCountMethods());
	}

}
