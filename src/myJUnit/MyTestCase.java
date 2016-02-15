package myJUnit;

import java.lang.reflect.Method;

public class MyTestCase {

	public void testMethod() {
	}

	public void run() {
		setUp();
		testMethod();
	}

	public void setUp() {
	}

	public int getCountMethods(){
		Method[] methods = getClass().getMethods();
		int count = 0;
		for(int i = 0; i < methods.length; i++){
			if(methods[i].getName().startsWith("test")){
				count++;
			}
		}
		return count;
	}
}
