package di.java;

import org.springframework.stereotype.Component;

@Component("hankook")
public class HankookTire implements Tire {

	public String getBrand() {
		return "한국타이어";
	}
}
