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
					System.out.println("first arg: " + e.getCause().toString()
							+ ": " + e.getCause().getMessage());
					String firstArg = e.getCause().toString();
					String secondArg = AssertionError.class.getName();
					if (e.getCause().getMessage() != null) {
						firstArg += ": " + e.getCause().getMessage();
						secondArg += ": " + e.getCause().getMessage() + ": "+ e.getCause().getMessage();
					}
					if (firstArg.equals(secondArg)) {
						result.testFailure();
						result.getTestMethods().put(methods[i].getName(),
								"Failure");
					} else {
						result.testFailed();
						result.getTestMethods().put(methods[i].getName(),
								"Failed");
					}
				}
				tearDown();
			}
		}
		result.getTestClasses().put(getClass().getSimpleName(),
				result.getTestMethods());
		return result;
	}

	public void setUp() {
	}

	public void tearDown() {
	}

}
