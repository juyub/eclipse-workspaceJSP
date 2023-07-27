package aop.pojo;

public class Designer implements Employee {

	public void work() {
		Action.gotoOffice();
		System.out.println("디자인 시안 및 수정합니다");
		Action.getoffOffice();
	}
}
