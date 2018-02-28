package axdum.master1.sir.testjpa_spring;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import axdum.master1.sir.testjpa_spring.model.Heater;
import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.model.User;
import axdum.master1.sir.testjpa_spring.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@EnableJpaRepositories(basePackages = "axdum.master1.sir.testjpa_spring.repository")
@SpringBootApplication
public class TestjpaSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestjpaSpringApplication.class, args);
    }
}
