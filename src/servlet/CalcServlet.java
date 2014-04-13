package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CalcController;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/CalcServlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CalcController cc = new CalcController();
	

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

			String displayResult = cc.calculate(action, num);
			
			request.setAttribute(Constants.DISPLAY_RESULT, displayResult);
			request.setAttribute(Constants.CLEAR, Constants.CLEAR);

			rd.forward(request, response);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	
}
