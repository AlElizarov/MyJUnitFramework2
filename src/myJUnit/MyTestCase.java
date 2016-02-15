package myJUnit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestCase {

	public void testMethod() {
	}

	public void run() {
		Method[] methods = getClass().getMethods();
		for(int i = 0; i < methods.length; i++){
			if(methods[i].getName().startsWith("test")){
				setUp();
				try {
					methods[i].invoke(this);
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
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
