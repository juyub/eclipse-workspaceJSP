package aop.java;

import org.springframework.stereotype.Component;

@Component
public class Designer implements Employee {

	public void work() {
		System.out.println("디자인 시안 및 수정합니다");
	}
}
