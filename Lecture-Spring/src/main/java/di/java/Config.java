package di.java;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"di.java"})
@Configuration
public class Config {
/*
	@Bean
	public Car car() {
		return new Car();
	}

	@Bean
	@Qualifier("hankook")
	public Tire hankookTire() {
		return new HankookTire();
	}
	
	@Bean(name="kumho")
	public Tire kumhoTire() {
		return new KumhoTire();
	}
*/	
}








