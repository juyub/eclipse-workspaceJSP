package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import vo.UserVO;

/**
 * Servlet implementation class UpdateUser
 */
//@WebServlet("/UpdateUserController")
@WebServlet(name = "UpdateUserController", urlPatterns = {"/update-user"})
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html;charset=UTF-8");

	        // 폼에서 전송된 회원 정보 가져오기
	        String id = request.getParameter("id");
	        String password = request.getParameter("password");
	        String name = request.getParameter("name");
	        String phone = request.getParameter("phone");

	        // 회원 정보 수정 로직 구현
	        // 데이터베이스와 연동하여 사용자 테이블의 정보를 수정합니다.
	        // DAO(데이터 액세스 오브젝트) 패턴을 사용하여 데이터베이스와의 상호작용을 처리하는 것을 추천합니다.
	        // UserDAO.updateUser(User User) 메소드를 호출하여 수정된 회원 정보를 데이터베이스에 저장해야 합니다.
	        // 예를 들어:
	        UserVO updatedUser = new UserVO(id, password, name,phone);
	        UserDAO userDAO = new UserDAO();
	        boolean updated = userDAO.updateUser(updatedUser);

	        // 수정 결과에 따라 적절한 응답 페이지로 리다이렉트합니다.
	        if (updated) {
	            response.sendRedirect("/MyLib/index.jsp"); // 수정 성공시에, success.jsp로 리다이렉트
	        } else {
	            response.sendRedirect("/MyLib/jsp/update/updateUser.jsp"); // 수정 실패시에, error.jsp로 리다이렉트
	        }
	}
	

}
