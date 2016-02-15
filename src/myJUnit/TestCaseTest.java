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
		assert("setUp ".equals(test.getLog()));
	}
	
	

}
