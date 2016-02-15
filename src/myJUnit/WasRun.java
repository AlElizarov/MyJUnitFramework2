package myJUnit;

public class WasRun extends MyTestCase{

	private boolean wasRun;
	private String log;
	
	public boolean getWasRun() {
		return wasRun;
	}

	public void testMethod() {
		wasRun = true;
	}

	public void setUp() {
		wasRun = false;
		log = "setUp ";
	}

	public String getLog() {
		return log;
	}

}
