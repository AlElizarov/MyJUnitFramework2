package myJUnit;

public class TestResult {
	
	private int runCount = 0;
	private int failedCount = 0;

	public String summary() {
		return runCount+ " run, "+failedCount+" failed";
	}
	
	public void testRuned(){
		runCount++;
	}
	
	public void testFailed(){
		failedCount++;
	}

}
