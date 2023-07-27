package di.xml;

public class Car {

	private Tire tire;
	
	public Car() {
		System.out.println("Car() 생성자 호출...");
	}
	
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("생성자 주입...");
	}
	
	public Car(Tire tire, Tire tire2) {
		System.out.println("Car(Tire, Tire) 생성자 주입...");
		System.out.println(tire.getBrand());
		System.out.println(tire2.getBrand());
	}
	
	public Car(Tire tire, String msg) {
		System.out.println("Car(Tire, String) 생성자 주입...");
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setter주입...");
	}

	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}
