package ac_record;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jdi.request.InvalidRequestStateException;

import controller.Controller;

public class GetAc_recordListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int ac_number = Integer.parseInt(request.getParameter("ac_number"));
		
		Ac_recordDAO dao = new Ac_recordDAO();
		List<Ac_recordVO> recordList = dao.getAc_recordList(ac_number);
		
		request.setAttribute("recordList", recordList);
		
		return "/account/getAc_recordList.jsp";
	}

}
