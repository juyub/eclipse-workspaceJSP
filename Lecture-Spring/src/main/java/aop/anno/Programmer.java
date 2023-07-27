package aop.anno;

public class Programmer implements Employee {

	@Override
	public void work() {
		System.out.println("소프트웨어 개발을 합니다");
	}
}
