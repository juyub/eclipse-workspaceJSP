package aop.pojo;

public class Designer implements Employee {

	public void work() {
		Action.gotoOffice();
		System.out.println("������ �þ� �� �����մϴ�");
		Action.getoffOffice();
	}
}
