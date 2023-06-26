package product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class UpdateProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

		int pd_number = Integer.parseInt(request.getParameter("pd_number"));
		String pd_name = request.getParameter("pd_name");
		String pd_content = request.getParameter("pd_content");
		
		ProductVO vo = new ProductVO();
		vo.setPd_number(pd_number);
		vo.setPd_name(pd_name);
		vo.setPd_content(pd_content);
		
		ProductDAO dao = new ProductDAO();
		dao.updateProduct(vo);
		
		return "redirect:getProduct.do?pd_number=" + pd_number;
	}

}
