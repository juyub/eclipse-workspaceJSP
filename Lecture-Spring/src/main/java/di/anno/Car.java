package di.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	@Qualifier("hankook")
	private Tire tire;
	
	public Car() {
		System.out.println("Car() 생성자 호출...");
	}
	
	
//	@Autowired
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("생성자 주입...");
	}
	
	
//	@Autowired
	public Car(@Qualifier("hankook") Tire tire, @Qualifier("kumho") Tire tire2) {
		this.tire = tire;
		System.out.println("Car(Tire, Tire)");
		System.out.println("앞바퀴 :  " + tire.getBrand() 
							+ ", 뒷바퀴 : " + tire2.getBrand());
				
	}
	
	
//	@Autowired
//	@Qualifier("hankook")
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setter주입...");
	}

	public void printTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
}
