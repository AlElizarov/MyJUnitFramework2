package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	public void testRunning(){
		WasRun test = new WasRun();
		assert(!test.getWasRun());
		test.run();
		assert(test.getWasRun());
	}

}
