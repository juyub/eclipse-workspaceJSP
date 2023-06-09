package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import dao.UserDAO;
import vo.UserVO;


public class CheckDuplicateController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");

        // 중복 확인 로직 수행
        boolean isDuplicate = checkDuplicate(id);

        // 중복 여부에 따라 결과 반환
        try {
            PrintWriter out = response.getWriter();
            if (isDuplicate) {
                out.print("duplicate");
            } else {
                out.print("unique");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean checkDuplicate(String id) {

    	UserDAO dao = new UserDAO();
        UserVO user = dao.getUserByID(id);
        
        return user != null;
    }
}
