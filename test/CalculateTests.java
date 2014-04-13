import servlet.Constants;
import controller.CalcController;
import calc.Calculator;
import junit.framework.TestCase;

public class CalculateTests extends TestCase {

	public void testBasicAddition() throws Exception {
		// setup
		Calculator calc = new Calculator();

		String displayResult = "1";
		String action = Constants.PLUS;

		// execute
		calc.setA(Double.parseDouble(displayResult));
		calc.setAction(action);
		String actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);

		// execute
		displayResult = "2";
		calc.setB(Double.parseDouble(displayResult));
		calc.setAction(Constants.EQUAL);
		actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);
	}
	
	public void testBasicSubtraction() throws Exception {
		// setup
		Calculator calc = new Calculator();
		
		String displayResult = "1";
		String action = Constants.MINUS;
		
		// execute
		calc.setA(Double.parseDouble(displayResult));
		calc.setAction(action);
		String actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);
		
		// execute
		displayResult = "1";
		calc.setB(Double.parseDouble(displayResult));
		calc.setAction(Constants.EQUAL);
		actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should be 0.0", "0.0", actualDisplayResult);
	}
	
	public void testBasicMultiplication() throws Exception {
		// setup
		Calculator calc = new Calculator();
		
		String displayResult = "2";
		String action = Constants.TIMES;
		
		// execute
		calc.setA(Double.parseDouble(displayResult));
		calc.setAction(action);
		String actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should  be 2.0", "2.0", actualDisplayResult);
		
		// execute
		displayResult = "3";
		calc.setB(Double.parseDouble(displayResult));
		calc.setAction(Constants.EQUAL);
		actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should be 6.0", "6.0", actualDisplayResult);
	}
	public void testBasicDivision() throws Exception {
		// setup
		Calculator calc = new Calculator();
		
		String displayResult = "100";
		String action = Constants.DIVIDE;
		
		// execute
		calc.setA(Double.parseDouble(displayResult));
		calc.setAction(action);
		String actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should  be 100.0", "100.0", actualDisplayResult);
		
		// execute
		displayResult = "2";
		calc.setB(Double.parseDouble(displayResult));
		calc.setAction(Constants.EQUAL);
		actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should be 50.0", "50.0", actualDisplayResult);
	}
	
	

	public void testAddition_PressEqualsTwice() throws Exception {
		// setup
		String displayResult = "1";
		String action = Constants.PLUS;

		CalcController cc = new CalcController();
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);

		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);

		// execute
		displayResult = "2";
		action = Constants.EQUAL;
		actualDisplayResult = cc.calculate(action, displayResult);

		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);

		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);

		// assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);

		// assert
		assertEquals("Display result should be 7.0", "7.0", actualDisplayResult);
	}
	public void testSubtraction_PressEqualsTwice() throws Exception {
		// setup
		String displayResult = "1";
		String action = Constants.MINUS;
		
		CalcController cc = new CalcController();
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);
		
		// execute
		displayResult = "1";
		action = Constants.EQUAL;
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 0.0", "0.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be -1.0", "-1.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be -2.0", "-2.0", actualDisplayResult);
	}
	public void testMultiplication_PressEqualsTwice() throws Exception {
		// setup
		String displayResult = "2";
		String action = Constants.TIMES;
		
		CalcController cc = new CalcController();
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 2.0", "2.0", actualDisplayResult);
		
		// execute
		displayResult = "3";
		action = Constants.EQUAL;
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 6.0", "6.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 18.0", "18.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 54.0", "54.0", actualDisplayResult);
	}
	public void testDivision_PressEqualsTwice() throws Exception {
		// setup
		String displayResult = "100";
		String action = Constants.DIVIDE;
		
		CalcController cc = new CalcController();
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 100.0", "100.0", actualDisplayResult);
	
		// execute
		displayResult = "2";
		action = Constants.EQUAL;
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 50.0", "50.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 25.0", "25.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 12.5", "12.5", actualDisplayResult);
	}

	public void testAddition_PressEqualsThenAdditionAgain() throws Exception {
		// setup
		CalcController cc = new CalcController();
		
		String displayResult = "1";
		String action = Constants.PLUS;
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);
		
		// execute
		displayResult = "2";
		action = Constants.EQUAL; 
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
		// execute
		action = Constants.PLUS;
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
	}

	public void testAddition_PressEqualsThenSubtraction() throws Exception {
		// setup
		CalcController cc = new CalcController();
		
		String displayResult = "1";
		String action = Constants.PLUS;
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);
		
		// execute
		displayResult = "2";
		action = Constants.EQUAL; 
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
		// execute
		action = Constants.MINUS;
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
	}
	public void testSubtraction_PressEqualsThenSubtractionAgain() throws Exception {
		// setup
		CalcController cc = new CalcController();
		
		String displayResult = "1";
		String action = Constants.MINUS;
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);
		
		// execute
		displayResult = "1";
		action = Constants.EQUAL; 
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 0.0", "0.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be -1.0", "-1.0", actualDisplayResult);
		
		// execute
		action = Constants.MINUS;
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be -1.0", "-1.0", actualDisplayResult);
		
	}
	public void testMultiplication_PressEqualsThenMultiplicationAgain() throws Exception {
		// setup
		CalcController cc = new CalcController();
		
		String displayResult = "2";
		String action = Constants.TIMES;
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 2.0", "2.0", actualDisplayResult);
		
		// execute
		displayResult = "3";
		action = Constants.EQUAL; 
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 6.0", "6.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 18.0", "18.0", actualDisplayResult);
		
		// execute
		action = Constants.TIMES;
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be 18.0", "18.0", actualDisplayResult);
		
	}
	public void testDivision_PressEqualsThenDivisionAgain() throws Exception {
		// setup
		CalcController cc = new CalcController();
		
		String displayResult = "100";
		String action = Constants.DIVIDE;
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 100.0", "100.0", actualDisplayResult);
		
		// execute
		displayResult = "2";
		action = Constants.EQUAL; 
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 50.0", "50.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 25.0", "25.0", actualDisplayResult);
		
		// execute
		action = Constants.DIVIDE;
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be 25.0", "25.0", actualDisplayResult);
		
	}

	public void testAddEqualEqualEqualEqualDivide() throws Exception {
		// setup
		CalcController cc = new CalcController();
		
		String displayResult = "1";
		String action = Constants.PLUS;
		
		// execute
		String actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);
		
		// execute
		displayResult = "2";
		action = Constants.EQUAL; 
		actualDisplayResult = cc.calculate(action, displayResult);
		
		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		// assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be 7.0", "7.0", actualDisplayResult);
		
		// execute
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be 9.0", "9.0", actualDisplayResult);
		
		// execute
		action = Constants.DIVIDE;
		actualDisplayResult = cc.calculate(action, actualDisplayResult);
		
		//assert
		assertEquals("Display result should be 9.0", "9.0", actualDisplayResult);

		// execute
		displayResult = "3";
		action = Constants.EQUAL;
		actualDisplayResult = cc.calculate(action, displayResult);
		
		//assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);
		
	}
}
