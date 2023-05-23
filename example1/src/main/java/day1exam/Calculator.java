
package day1exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex5
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=EUC-KR");

		PrintWriter out = response.getWriter();

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		String operation = request.getParameter("operation");

		double result = 0;
		String operationName = "";

		switch (operation) {
		case "add":
			result = num1 + num2;
			operationName = "더하기";
			break;
		case "sub":
			result = num1 - num2;
			operationName = "빼기";
			break;
		case "multi":
			result = num1 * num2;
			operationName = "곱하기";
			break;
		case "divide":
			if (num2 != 0) {
				result = (double) num1 / num2;
				operationName = "나누기";
			} else {
				out.println("0으로 나눌 수 없습니다.<br>");
				return;
			}
			break;
		}

		out.println(operationName + " 결과: " + String.format("%.2f", result) + "<br>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
