package myJUnit;

public class TestMyTestTimer extends MyTimeTester{

	public TestMyTestTimer(long timeout) {
		super(timeout);
	}
	
	@Override
	public void doSomething(){
		//int i = 2 + 3;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
