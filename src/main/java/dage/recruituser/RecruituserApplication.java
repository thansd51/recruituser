package dage.recruituser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RecruituserApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruituserApplication.class, args);
	}

}
