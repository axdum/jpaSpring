package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home, Integer> {
    List<Home> findByName(String name);

    Home findById(Long id);

    void deleteById(Long id);
}
