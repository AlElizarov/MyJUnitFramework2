package myJUnit;

public class WasRun extends MyTestCase{

	private String log;

	public void testMethod() {
		log += "testMethod ";
	}

	public void setUp() {
		log = "setUp ";
	}

	public String getLog() {
		return log;
	}

}
