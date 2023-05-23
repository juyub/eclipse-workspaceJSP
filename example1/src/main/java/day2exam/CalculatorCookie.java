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
 * Servlet implementation class CalculatorCookie
 */
@WebServlet("/CalculatorCookie")
public class CalculatorCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculatorCookie() {
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
				out.println("cookie : " + cookie.getName().equals("num1") + " : " + cookie.getValue().equals("num2")
						+ "</br>");
			}
		}

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

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

//        String num1Str = String.valueOf(num1);
//        String num2Str = String.valueOf(num2);
		// 쿠키로 저장
//		Cookie c = new Cookie(num1, num2); 
//		response.addCookie(c);
		Cookie cookie = new Cookie("numValues", num1 + "," + num2);
		response.addCookie(cookie);

		// Servlet을 goGet으로 리다이렉션
		response.sendRedirect("CalculatorCookie");
	}

}
