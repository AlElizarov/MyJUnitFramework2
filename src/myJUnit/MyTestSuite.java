package myJUnit;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public final class MyTestSuite implements Test{

	private ArrayList<Test> tests = new ArrayList<>();

	/*
	 * Не смог по хорошему реализовать добавление в TestSuite других TestSui
	 */
	public void add(Test test) {
		tests.add(test);
	}

	@Override
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
	
	public void removeTest(Test test){
		tests.remove(test);
	}

}
