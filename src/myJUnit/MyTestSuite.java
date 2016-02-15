package myJUnit;

import java.util.ArrayList;

public class MyTestSuite {
	
	private ArrayList<MyTestCase> tests = new ArrayList<>();

	public void add(MyTestCase test) {
		tests.add(test);
	}

	public TestResult run() {
		TestResult result = new TestResult();
		for(int i = 0; i < tests.size(); i++){
			tests.get(i).run().addResults(result);
		}
		return result;
	}

}
