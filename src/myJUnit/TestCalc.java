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
		assert(7 == Calc.plus(x, y));
	}
	
	public void testMinus(){
		assert(-1 == Calc.minus(x, y));
	}
	
	public void testMult(){
		assert(12 == Calc.mult(x, y));
	}

}
