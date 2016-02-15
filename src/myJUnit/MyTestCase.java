package myJUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
					result.getSucsessNumbers().add(i);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					if (e.getCause().toString()
							.equals(AssertionError.class.getName())) {
						result.testFailure();
						result.getFailureNumbers().add(i);
					} else {
						result.testFailed();
						result.getFailedNumbers().add(i);
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
