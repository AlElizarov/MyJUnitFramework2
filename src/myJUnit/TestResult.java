package myJUnit;

public class TestResult {
	
	private int runCount = 0;
	private int failedCount = 0;
	private int failureCount = 0;

	public String summary() {
		return runCount+ " run, "+failedCount+" failed, "+failureCount+" failures";
	}
	
	public void testRuned(){
		runCount++;
	}
	
	public void testFailed(){
		failedCount++;
	}
	
	public void testFailure(){
		failureCount++;
	}

}
