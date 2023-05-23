package ex5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTestServlet2
 */
@WebServlet("/CookieTestServlet2")     // "/CookieTestServlet2" 값이 들어오면 아래의 클래스를 실행한다
public class CookieTestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTestServlet2() {            // 생성자 인스턴스 생성
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 출력 인코딩 디코딩 문자셋 설정
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		
		// 출력 html 파일 만들기 위한 out 인스턴스 생성
		PrintWriter out = response.getWriter();
		
		//  브라우저로부터 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		
		// 쿠키 있는지 확인
		if(cookies != null) {
			// 쿠키가 있으면
			for(Cookie cookie : cookies) {    //cookies != null 예외처러 구문
				// 출력
				out.println("cookie : " + cookie.getName() + " : " + cookie.getValue() + "</br>");
			}
		}
		
		// name과 value 입력받는 html 폼 생성
		out.println("<form method ='post' action='CookieTestServlet2'>");    // 폼을 제출할 때 post 생성
		out.println("name<input type='text' name='name'/>");
		out.println("value<input type='text' name='value'/>");
		out.println("<input type='submit'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 POST로 요청이 오면
		// request에서 name, value 추출
		String name = request.getParameter("name");
		String value = request.getParameter("value");

		// 쿠키로 저장
		Cookie c = new Cookie(name, value); 
		response.addCookie(c);
		
		// Servlet을 goGet으로 리다이렉션
		response.sendRedirect("CookieTestServlet2");
	}

}
