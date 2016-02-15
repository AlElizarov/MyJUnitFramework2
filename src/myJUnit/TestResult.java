package myJUnit;

public class TestResult {

	private int runCount = 0;
	private int failedCount = 0;
	private int failureCount = 0;

	public String summary() {
		return runCount + " run, " + failedCount + " failed, " + failureCount
				+ " failures";
	}

	public void testRuned() {
		runCount++;
	}

	public void testFailed() {
		failedCount++;
	}

	public void testFailure() {
		failureCount++;
	}

	public void addResults(TestResult run) {
		run.setRunCount(run.getRunCount() + this.getRunCount());
		run.setFailedCount(run.getFailedCount() + this.getFailedCount());
		run.setFailureCount(run.getFailureCount() + this.getFailureCount());
	}

	public int getRunCount() {
		return runCount;
	}

	public void setRunCount(int runCount) {
		this.runCount = runCount;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public int getFailureCount() {
		return failureCount;
	}

	public void setFailureCount(int failureCount) {
		this.failureCount = failureCount;
	}

}
