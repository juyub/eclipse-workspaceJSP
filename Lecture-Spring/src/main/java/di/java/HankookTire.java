package di.java;

import org.springframework.stereotype.Component;

@Component("hankook")
public class HankookTire implements Tire {

	public String getBrand() {
		return "�ѱ�Ÿ�̾�";
	}
}
