package day2exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorCookie2
 */
@WebServlet("/CalculatorCookie2")
public class CalculatorCookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatorCookie2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 입력 출력 인코딩 디코딩 문자셋 설정
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");

		// 출력 html 파일 만들기 위한 out 인스턴스 생성
		PrintWriter out = response.getWriter();

		// 브라우저로부터 쿠키 가져오기
		Cookie[] cookies = request.getCookies();

		// 쿠키 있는지 확인
		if (cookies != null) { // cookies != null 예외처러 구문
			// 쿠키가 있으면
			for (Cookie cookie : cookies) {
				// 출력
				out.println(cookie.getName() + " : " + cookie.getValue() + "</br>");
			}
		}

		out.println("<form method ='post' action='CalculatorCookie2'>"); // 폼을 제출할 때 post 생성
		out.println("<input type='number' name='num1'/></br>");
		out.println("<input type='number' name='num2'/></br>");
		out.println("<input type=\"radio\" name=\"operation\" value=\"add\" required>더하기");
		out.println("<input type=\"radio\" name=\"operation\" value=\"sub\" required>빼기");
		out.println("<input type=\"radio\" name=\"operation\" value=\"multi\" required>곱하기");
		out.println("<input type=\"radio\" name=\"operation\" value=\"divide\" required>나누기 </br>");
		out.println("<input type='submit'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		PrintWriter out = response.getWriter();

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

		String str1 = num1 + operation + num2;
		String str2 = String.valueOf(result);

		// 쿠키로 저장
		Cookie c = new Cookie(str1, str2);
		response.addCookie(c);

		// Servlet을 goGet으로 리다이렉션
		response.sendRedirect("CalculatorCookie2");
	}

}
