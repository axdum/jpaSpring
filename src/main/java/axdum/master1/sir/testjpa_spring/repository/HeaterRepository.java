package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaterRepository extends JpaRepository<Heater, Integer> {
    List<Heater> findByName(String name);

    Heater findById(Long id);

    void deleteById(Long id);
}
