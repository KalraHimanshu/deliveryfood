package kalra.polarisgrid.deliveryfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "kalra.polarisgrid.delivery")
public class DelieveryfoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelieveryfoodApplication.class, args);
	}

}
