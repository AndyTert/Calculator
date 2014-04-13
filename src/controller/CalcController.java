package controller;

import servlet.Constants;
import calc.Calculator;

public class CalcController {

	private Calculator calc = new Calculator();
	
	
	public CalcController() {
	}

	public String calculate(String action, String num) throws Exception {
		calc.setAction(action);
		String displayResult = null;
		if (action.equals(Constants.C)) {
			calc.reset();
			displayResult = "";
		} else {
			setCalcValues(num);
			displayResult = calc.run();
		}
		return displayResult;
	}
	
	private void setCalcValues(String num) {
		if(!calc.getAction().equals(Constants.EQUAL)) {
			calc.setB(null);
			calc.setPreviousAction(calc.getAction());
		}

		if (num.isEmpty() || num.equals(calc.getC().toString())) {
			return;
		}
		if (calc.getA() == null) {
			calc.setA(Double.parseDouble(num));
		} else {
			calc.setB(Double.parseDouble(num)); // technically b=c
		}
		
	}
}
