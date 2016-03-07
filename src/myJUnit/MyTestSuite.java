package myJUnit;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class MyTestSuite {

	private ArrayList<MyTestCase> tests = new ArrayList<>();

	public void add(MyTestCase test) {
		tests.add(test);
	}

	public TestResult run() {
		
		TestResult result = new TestResult();
		for (int i = 0; i < tests.size(); i++) {
			tests.get(i).run().addResults(result);
			result.getTestClasses().put(
					tests.get(i).getClass().getSimpleName(),
					tests.get(i).run().getTestMethods());
		}
		String className = getClass().getName();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
//					try {
//						UIManager.setLookAndFeel(UIManager
//								.getSystemLookAndFeelClassName());
//					} catch (ClassNotFoundException | InstantiationException
//							| IllegalAccessException
//							| UnsupportedLookAndFeelException e) {
//						e.printStackTrace();
//					}
				GuiForMyJUnit gui = new GuiForMyJUnit(result);
				gui.setSuiteName(className);
				gui.createAndShowGui();
			}
		});
		return result;
	}

}
