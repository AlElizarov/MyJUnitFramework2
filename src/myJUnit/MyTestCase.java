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
				try {
					setUp();
					methods[i].invoke(this);
					result.getTestMethods().put(methods[i].getName(), "OK");
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					if (e.getCause().toString()
							.equals(AssertionError.class.getName()+": "+e.getCause().getMessage())) {
						result.testFailure();
						result.getTestMethods().put(methods[i].getName(), "Failure");
					} else {
						result.testFailed();
						result.getTestMethods().put(methods[i].getName(), "Failed");
					}
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
