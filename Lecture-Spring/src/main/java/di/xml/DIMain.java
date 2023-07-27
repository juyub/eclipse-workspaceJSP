package di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di-xml.xml");
		
		Car car = context.getBean("car", Car.class);
		car.printTireBrand();
		
		/*
		 	Tire tire = new HankookTire();
		 	Car c = new Car();
		 	c.setTire(tire)
		 */
	}
}
