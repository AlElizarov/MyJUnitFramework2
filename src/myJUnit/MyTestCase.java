package myJUnit;

public class MyTestCase {
	
	public void testMethod() {}
	
	public void run(){
		setUp();
		testMethod();
	}

	public void setUp() {
	}
	
	public int getCountMethods(){
		return 0;
	}

}
