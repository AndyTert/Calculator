package calc;

public class Calculator {

	private String action;
	private String previousAction;
	private String displayResult = "";
	private Double a = null;
	private Double b = null;
	private Double c = new Double(0);

	public Calculator() {
	}

	public String run() throws Exception {
//		resetB();
		if (canCalculate()) {
			calculate(action);
		}
		return getDisplayResult();
	}

	// Reset B when action is the same as previous action
//	private void resetB() {
//		if (action.equals(previousAction)) {
//			b = null;
//		}
//	}

	private boolean canCalculate() {
		boolean calc = false;
		if (b == null || action == null) {
			setDisplayResult(a.toString());
			calc = false;
		} else {
			calc = true;
		}
		return calc;
	}

	private void calculate(String action) throws Exception {
		switch (action) {
		case "+":
			c = a + b;
			setDisplayResult(Double.toString(c));
			previousAction = "+";
			a = c;
			break;
		case "-":
//			c = a - b;
//			setDisplayResult(Double.toString(c));
//			previousAction = "-";
//			a = c;
			break;
		case "*":
//			c = a * b;
//			setDisplayResult(Double.toString(c));
//			previousAction = "*";
//			a = c;
			break;
		case "=":
			calculate(previousAction); // escape action is previousAction
			break;
		default:
			throw new Exception("Something Broke :s. Action is " + action);
		}
	}

	public void reset() {
		a = null;
		b = null;
		c = new Double(0);
		action = null;
		previousAction = null;
		setDisplayResult("");
	}

	public Double getC() {
		return c;
	}

	public void setC(Double ans) {
		this.c = ans;
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
		if(getPreviousAction() == null) {
			setPreviousAction(action);
		}
	}

	public String getPreviousAction() {
		return previousAction;
	}

	public void setPreviousAction(String previousAction) {
		this.previousAction = previousAction;
	}

	public String getDisplayResult() {
		return displayResult;
	}

	public void setDisplayResult(String displayResult) {
		this.displayResult = displayResult;
	}
}
