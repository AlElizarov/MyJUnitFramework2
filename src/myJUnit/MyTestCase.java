package myJUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.SwingUtilities;

public class MyTestCase {

	public TestResult run() {
		TestResult result = new TestResult();
		// Method[] methods = getClass().getDeclaredMethods();
		Method[] methods = getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("test")) {
				result.testRuned();
				if (methods[i].getParameters().length != 0) {
					setInitializationError(result, methods[i].getName(),
							"have no parameters");
					StackTraceElement[] ste = Thread.currentThread()
							.getStackTrace();
					for (int j = 0; j < ste.length; j++) {
						if (ste[j].getClassName().equals("myJUnit.MyTestSuite")) {
							return result;
						}
					}
					runGui(result);
					return result;
				}
				if (!methods[i].getReturnType().equals(Void.TYPE)) {
					setInitializationError(result, methods[i].getName(),
							"be void");
					StackTraceElement[] ste = Thread.currentThread()
							.getStackTrace();
					for (int j = 0; j < ste.length; j++) {
						if (ste[j].getClassName().equals("myJUnit.MyTestSuite")) {
							return result;
						}
					}
					runGui(result);
					return result;
				}
				if (Modifier.isPrivate(methods[i].getModifiers())) {
					setInitializationError(result, methods[i].getName(),
							"be public");
					StackTraceElement[] ste = Thread.currentThread()
							.getStackTrace();
					for (int j = 0; j < ste.length; j++) {
						if (ste[j].getClassName().equals("myJUnit.MyTestSuite")) {
							return result;
						}
					}
					runGui(result);
					return result;
				}
				try {
					setUp();
					methods[i].invoke(this);
					// methods[i].setAccessible(true);
					Messager messager = new Messager();
					messager.setOk(true);
					result.getTestMethods().put(methods[i].getName(), messager);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					String firstArg = e.getCause().toString();
					String secondArg = AssertionError.class.getName();
					if (e.getCause().getMessage() != null) {
						firstArg += ": " + e.getCause().getMessage();
						secondArg += ": " + e.getCause().getMessage() + ": "
								+ e.getCause().getMessage();
					}
					if (firstArg.equals(secondArg)) {
						Messager messager = new Messager();
						messager.setFailure(true);
						result.testFailure();
						createTestPrint(result, e, methods[i].getName(),
								messager);
					} else {
						Messager messager = new Messager();
						messager.setFailed(true);
						result.testFailed();
						createTestPrint(result, e, methods[i].getName(),
								messager);
					}
				}
				tearDown();
			}
		}
		result.getTestClasses().put(getClass().getSimpleName(),
				result.getTestMethods());
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		for (int i = 0; i < ste.length; i++) {
			if (ste[i].getClassName().equals("myJUnit.MyTestSuite")) {
				return result;
			}
		}
		runGui(result);
		return result;
	}

	private void createTestPrint(TestResult result, Exception e, String name,
			Messager messager) {
		String strForMessanger = "<html><b>"
				+ e.getCause().getClass().getName();
		if (e.getCause().getMessage() != null) {
			strForMessanger += ": " + e.getCause().getMessage() + "</b><br>";
		} else {
			strForMessanger += "</b><br>";
		}
		StackTraceElement[] ste = e.getCause().getStackTrace();
		for (int idx = 0; idx < ste.length; idx++) {
			if (!ste[idx].getClassName().startsWith("java")
					&& !ste[idx].getClassName().startsWith("sun")) {
				URL path = null;
				try {
					Class<?> clazz = Class.forName(ste[idx].getClassName());
					ClassLoader loader = clazz.getClassLoader();
					String cn = ste[idx].getClassName();
				    String rn = cn.replace('.', '/');
				    rn = rn.replace("bin", "src");
				    rn += ".class";
					path = loader.getResource(rn);
					String newPath = path.toString().replace("bin", "src");
					newPath = newPath.replace(".class", ".java");
					path = new URL(newPath);
					//path = new URL(URLEncoder.encode(path.toString(), "UTF-8"));
					//System.out.println(URLEncoder.encode(path.toString(), "WINDOWS-1251"));
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				strForMessanger += ste[idx].getClassName()
						+ "."
						+ ste[idx].getMethodName()
						+ "(<a href = "
						+ path + ">"
						+ ste[idx].getFileName() + "</a>:"
						+ ste[idx].getLineNumber() + ")<br>";
			}
		}
		messager.setMes(strForMessanger);
		result.getTestMethods().put(name, messager);
	}

	private void setInitializationError(TestResult result, String testName,
			String endOfMes) {
		result.setRunCount(1);
		result.setFailureCount(0);
		result.setFailedCount(1);
		SortedMap<String, Messager> testMethods = new TreeMap<>();
		String mes = "<html><b>" + new Exception().getClass().getName()
				+ ": Method " + testName + " should " + endOfMes + "</b>";
		Messager messager = new Messager(mes);
		messager.setFailed(true);
		testMethods.put("initialization error", messager);
		SortedMap<String, SortedMap<String, Messager>> testClasses = new TreeMap<>();
		testClasses.put(getClass().getSimpleName(), testMethods);
		result.setTestClasses(testClasses);
		result.setTestMethods(testMethods);
	}

	private void runGui(TestResult result) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				GuiForMyJUnit gui = new GuiForMyJUnit(result);
				gui.createAndShowGui();
			}
		});
	}

	public void setUp() {
	}

	public void tearDown() {
	}

}
