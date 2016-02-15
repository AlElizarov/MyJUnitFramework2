package myJUnit;

public class TestResult {
	
	private int runCount = 1;
	private int failedCount = 0;

	public String summary() {
		return runCount+ " run, "+failedCount+" failed";
	}

}
