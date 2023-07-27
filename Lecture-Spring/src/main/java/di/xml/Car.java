package di.xml;

public class Car {

	private Tire tire;
	
	public Car() {
		System.out.println("Car() ������ ȣ��...");
	}
	
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("������ ����...");
	}
	
	public Car(Tire tire, Tire tire2) {
		System.out.println("Car(Tire, Tire) ������ ����...");
		System.out.println(tire.getBrand());
		System.out.println(tire2.getBrand());
	}
	
	public Car(Tire tire, String msg) {
		System.out.println("Car(Tire, String) ������ ����...");
	}
	
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setter����...");
	}

	public void printTireBrand() {
		System.out.println("������ Ÿ�̾� : " + tire.getBrand());
	}
}
