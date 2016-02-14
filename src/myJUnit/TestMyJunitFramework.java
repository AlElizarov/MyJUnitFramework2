package myJUnit;

public class TestMyJunitFramework {
	
	public static void main(String[] args){
		WasRun test = new WasRun();
		System.out.println(test.getWasRun());
		test.testMethod();
		System.out.println(test.getWasRun());
	}

}
