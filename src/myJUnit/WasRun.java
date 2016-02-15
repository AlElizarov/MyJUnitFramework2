package myJUnit;

public class WasRun extends MyTestCase{

	private boolean wasRun;
	private boolean wasSetup;
	
	public boolean getWasRun() {
		return wasRun;
	}

	public void testMethod() {
		wasRun = true;
	}

	public void setUp() {
		wasRun = false;
		wasSetup = true;
	}

	public boolean wasSetup() {
		return wasSetup;
	}
	
	public void testR(){
		
	}

}
