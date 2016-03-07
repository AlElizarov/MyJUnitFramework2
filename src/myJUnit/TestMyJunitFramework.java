package myJUnit;

public class TestMyJunitFramework {

	public static void main(String[] args) {

		TestCalc test1 = new TestCalc();
		TestMyAssert test2 = new TestMyAssert();
		TestMyTestTimer test3 = new TestMyTestTimer(1000);

		MyTestSuite suite = new MyTestSuite();
		suite.add(test1);
		suite.add(test2);
		suite.add(test3);
		suite.run();
		//test2.run();
	}

}
