package myJUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestCase {

	public TestResult run() {
		TestResult result = new TestResult();
		Method[] methods = getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("test")) {
				result.testRuned();
				result.getTestMethodNames().add(methods[i].getName());
				try {
					setUp();
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
		return result;
	}

	public void setUp() {
	}

	public void tearDown() {
	}

}
