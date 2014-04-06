import calc.Calculator;
import junit.framework.TestCase;

public class CalculateTests extends TestCase {

	public void testBasicAddition() throws Exception {
		// setup
		Calculator calc = new Calculator();

		String displayResult = "1";
		String action = "+";

		// execute
		calc.setA(Double.parseDouble(displayResult));
		calc.setAction(action);
		String actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);

		// execute
		displayResult = "2";
		calc.setB(Double.parseDouble(displayResult));
		calc.setAction("=");
		actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);
	}

	public void testAddition_PressEqualsTwice() throws Exception {
		// setup
		Calculator calc = new Calculator();

		String displayResult = "1";
		String action = "+";

		// execute
		calc.setA(Double.parseDouble(displayResult));
		calc.setAction(action);
		String actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);

		// execute
		displayResult = "2";
		calc.setB(Double.parseDouble(displayResult));
		calc.setAction("=");
		actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);

		// execute
		calc.setAction("=");
		actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
		// execute
		calc.setAction("=");
		actualDisplayResult = calc.run();

		// assert
		assertEquals("Display result should be 7.0", "7.0", actualDisplayResult);
	}

	public void testAddition_PressEqualsThenAdditionAgain() throws Exception {
		// setup
		Calculator calc = new Calculator();
		
		String displayResult = "1";
		String action = "+";
		
		// execute
		calc.setA(Double.parseDouble(displayResult));
		calc.setAction(action);
		String actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should  be 1.0", "1.0", actualDisplayResult);
		
		// execute
		displayResult = "2";
		calc.setB(Double.parseDouble(displayResult));
		calc.setAction("=");
		actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should be 3.0", "3.0", actualDisplayResult);
		
		// execute
		calc.setAction("=");
		actualDisplayResult = calc.run();
		
		// assert
		assertEquals("Display result should be 5.0", "5.0", actualDisplayResult);
		
		// execute
		calc.setAction("+");
		actualDisplayResult = calc.run();
		
		//assert
		assertEquals("Display result should be 5.0", 5.0, actualDisplayResult);
		
	}
}
