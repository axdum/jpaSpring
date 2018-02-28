package axdum.master1.sir.testjpa_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "axdum.master1.sir.testjpa_spring.repository")
@SpringBootApplication
public class TestjpaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestjpaSpringApplication.class, args);
	}
}
