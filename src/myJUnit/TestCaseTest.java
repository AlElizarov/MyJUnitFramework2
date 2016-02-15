package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	public void testRunning(){
		WasRun test = new WasRun();
		assert(!test.getWasRun());
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
