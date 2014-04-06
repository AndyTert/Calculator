package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calc.Calculator;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Calculator calc = new Calculator();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");

			String action = request.getParameter("action");
			String num = request.getParameter("display");

			calc.setAction(action);
			if (action.equals("C")) {
				calc.reset();
			} else {
				setCalcValues(num);

				String displayResult = calc.run();

				request.setAttribute(Constants.DISPLAY_RESULT, displayResult);
				request.setAttribute(Constants.CLEAR, Constants.CLEAR);
			}

			rd.forward(request, response);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void setCalcValues(String num) {
		if(calc.getAction().equals(calc.getPreviousAction())) {
			calc.setB(null);
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
