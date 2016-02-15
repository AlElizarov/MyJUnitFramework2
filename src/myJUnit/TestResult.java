package myJUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestResult {

	private int runCount = 0;
	private int failedCount = 0;
	private int failureCount = 0;
	private SortedMap<String, String> testMethods = new TreeMap<>();

	public String summary() {
		String res = runCount + " run, " + failedCount + " failed, " + failureCount
				+ " failures\n";
		for(Map.Entry<String, String> entry : testMethods.entrySet()){
			res = res + entry.getKey() +": "+entry.getValue()+'\n';
		}
		return res;
	}

	public SortedMap<String, String> getTestMethods() {
		return testMethods;
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
