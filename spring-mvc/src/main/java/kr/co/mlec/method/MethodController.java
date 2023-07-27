package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/method/method.do")
@Controller
public class MethodController {

	@RequestMapping(method = RequestMethod.GET)
	public String callGet() {
		return "method/methodForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String callPost() {
		return "method/methodProcess";
	}
}
