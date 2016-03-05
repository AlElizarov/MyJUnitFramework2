package myJUnit;

public class TestMyJunitFramework {
	
	public static void main(String[] args){
		TestCalc test1 = new TestCalc();
		TestMyAssert test2 = new TestMyAssert();
		TestCaseTest test3 = new TestCaseTest();
		WasRun test4 = new WasRun();
		System.out.println("TestCalc: "+test1.run().summary());
		System.out.println("TestMyAssert: "+test2.run().summary());
		System.out.println("TestCaseTest: "+test3.run().summary());
		System.out.println("WasRun: "+test4.run().summary());
		
	}

}
