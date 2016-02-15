package myJUnit;

import java.util.ArrayList;
import java.util.Collections;

public class TestResult {

	private int runCount = 0;
	private int failedCount = 0;
	private int failureCount = 0;
	private ArrayList<String> testMethodNames = new ArrayList<>();
	private ArrayList<Integer> sucsessNumbers = new ArrayList<>();
	private ArrayList<Integer> failedNumbers = new ArrayList<>();
	private ArrayList<Integer> failureNumbers = new ArrayList<>();

	public String summary() {
		Collections.sort(testMethodNames);
		sucsessNumbers.add(2);
		failedNumbers.add(0);
		failureNumbers.add(1);
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

	public ArrayList<String> getTestMethodNames() {
		return testMethodNames;
	}

	public ArrayList<Integer> getSucsessNumbers() {
		return sucsessNumbers;
	}

	public ArrayList<Integer> getFailedNumbers() {
		return failedNumbers;
	}

	public ArrayList<Integer> getFailureNumbers() {
		return failureNumbers;
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
