package di.pojo;

public class DIMain {

	public static void main(String[] args) {
		
		HankookTire hankook = new HankookTire();
		KumhoTire kumho = new KumhoTire();
		
//		Car c = new Car(hankook);
		Car c = new Car(kumho);
		c.printTireBrand();
		
		Car c2 = new Car();
		c2.setTire(hankook);
		c2.printTireBrand();
	}
}
