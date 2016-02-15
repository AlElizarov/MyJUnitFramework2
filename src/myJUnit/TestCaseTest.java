package myJUnit;

public class TestCaseTest extends MyTestCase {
	
	WasRun test;
	
	@Override
	public void setUp(){
		test = new WasRun();
	}
	
	public void testSetUp(){
		test.run();
		assert("setUp testMethod ".equals(test.getLog()));
	}
	
	

}
