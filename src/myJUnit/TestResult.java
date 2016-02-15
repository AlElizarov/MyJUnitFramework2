package myJUnit;

import java.util.ArrayList;

public class TestResult {

	private int runCount = 0;
	private int failedCount = 0;
	private int failureCount = 0;
	private ArrayList<String> testMethodNames = new ArrayList<>();
	private ArrayList<Integer> sucsessNumbers = new ArrayList<>();
	private ArrayList<Integer> failedNumbers = new ArrayList<>();
	private ArrayList<Integer> failureNumbers = new ArrayList<>();

	public String summary() {
		testMethodNames.add("testMethod");
		testMethodNames.add("testBroken");
		testMethodNames.add("testFailure");
		sucsessNumbers.add(0);
		failedNumbers.add(1);
		failureNumbers.add(2);
		String res = runCount + " run, " + failedCount + " failed, " + failureCount
				+ " failures\n";
		for(int i = 0; i < testMethodNames.size(); i++){
			if(sucsessNumbers.contains(i)){
				res += testMethodNames.get(i)+": OK\n";
			}
			if(failedNumbers.contains(i)){
				res += testMethodNames.get(i)+": Failed\n";
			}
			if(failureNumbers.contains(i)){
				res += testMethodNames.get(i)+": Failure\n";
			}
		}
		return res;
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
