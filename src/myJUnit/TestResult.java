package myJUnit;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestResult {

	private int runCount = 0;
	private int failedCount = 0;
	private int failureCount = 0;
	private SortedMap<String, Messager> testMethods = new TreeMap<>();
	private SortedMap<String, SortedMap<String, Messager>> testClasses = new TreeMap<>();

	public String summary() {
		String res = runCount + " run, " + failedCount + " failed, "
				+ failureCount + " failures\n";
		for (Map.Entry<String, SortedMap<String, Messager>> entry : testClasses
				.entrySet()) {
			res = res + entry.getKey() + ":\n";
			for (Map.Entry<String, Messager> entry2 : entry.getValue().entrySet()) {
				res = res + entry2.getKey() + ": " + entry2.getValue().getMes() + '\n';
			}
		}
		return res;
	}
	
	public void setTestMethods(SortedMap<String, Messager> testMethods) {
		this.testMethods = testMethods;
	}

	public void setTestClasses(
			SortedMap<String, SortedMap<String, Messager>> testClasses) {
		this.testClasses = testClasses;
	}

	public String resSum(){
		String res = runCount + " run, " + failedCount + " failed, "
				+ failureCount + " failures\n";
		return res;
	}

	public SortedMap<String, Messager> getTestMethods() {
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

	public SortedMap<String, SortedMap<String, Messager>> getTestClasses() {
		return testClasses;
	}
	
	public boolean isAllTrue(){
		if(failedCount == 0 && failureCount == 0){
			return true;
		}
		return false;
	}

}
