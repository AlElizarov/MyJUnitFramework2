package myJUnit;

public class TestCalc extends MyTestCase{
	
	int x;
	int y;
	
	@Override
	public void setUp(){
		x = 3;
		y = 4;
	}
	
	public void testPlus(){
		MyAssert.assertEquals(7, Calc.plus(x, y));
	}
	
	public void testMinus(){
		MyAssert.assertEquals(-1, Calc.minus(x, y));
	}
	
	public void testMult(){
		MyAssert.assertEquals(12, Calc.mult(x, y));
	}
	
	public void testDivide(){
		MyAssert.assertEquals(3/4, Calc.divide(x, y));
	}

}
