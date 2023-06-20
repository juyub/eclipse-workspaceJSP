package account;

import java.util.Random;

public class AccountNumberGenerator {

	public static String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder("2042");
        for (int i = 0; i < 6; i++) {
            accountNumber.append(random.nextInt(10)); // 0 to 9의 숫자를 생성하여 추가
        }
        return accountNumber.toString();
    }
	
}
