package myJUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestCase {

	public String run() {
		TestResult result = new TestResult();
		Method[] methods = getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("test")) {
				setUp();
				result.testRuned();
				try {
					methods[i].invoke(this);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					if (e.getCause().toString()
							.equals(AssertionError.class.getName())) {
						result.testFailure();
						toString();
					} else
						result.testFailed();
				}
				tearDown();
			}
		}
		return result.summary();
	}

	public void setUp() {
	}

	public void tearDown() {
	}

}
