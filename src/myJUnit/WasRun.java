package myJUnit;

public class WasRun extends MyTestCase{

	private boolean wasRun;

	public boolean getWasRun() {
		return wasRun;
	}

	public void testMethod() {
		wasRun = true;
	}

}
