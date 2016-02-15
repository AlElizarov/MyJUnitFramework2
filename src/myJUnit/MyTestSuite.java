package myJUnit;

import java.util.ArrayList;

public class MyTestSuite {
	
	private ArrayList<MyTestCase> tests = new ArrayList<>();

	public void add(MyTestCase test) {
		tests.add(test);
	}

	public String run() {
		String result = "";
		for(int i = 0; i < tests.size(); i++){
			result += tests.get(i).run();
		}
		return result;
	}

}
