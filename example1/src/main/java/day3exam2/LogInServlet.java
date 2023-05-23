package day3exam2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogInServlet")
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("EUC-KR");
        response.setContentType("text/html;charset=EUC-KR");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        if (id != null && pw != null) {
            if (validateCredentials(id, pw)) {
                // 로그인 성공 시 세션 설정
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("pw", pw);
                request.getSession().setAttribute("isValidCredentials", true);

                // 로그인 처리 후 리다이렉트
                response.sendRedirect("day3exam2/main.jsp");
            } else {
            	response.sendRedirect("day3exam2/error.jsp");
            }
        }
    }

    private boolean validateCredentials(String id, String pw) throws IOException {
        String filePath = "C:\\JSPSDK\\IDPW.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            if (parts.length == 2) {
                String storedId = parts[0];
                String storedPw = parts[1];
                if (storedId.equals(id) && storedPw.equals(pw)) {
                    br.close();
                    return true;
                }
            }
        }
        br.close();
        return false;
    }

}