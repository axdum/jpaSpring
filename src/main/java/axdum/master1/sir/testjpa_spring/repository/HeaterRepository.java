package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaterRepository extends JpaRepository<Heater, Long> {
  /**
   * Find heater devices by name.
   *
   * @param name the name
   * @return the matching heaters list
   */
  List<Heater> findByName(String name);

  /**
   * Find a heater by Id.
   *
   * @param id the Id of the heater to find
   * @return the matching heater
   */
  Heater findOne(Long id);

  /**
   * Delete a heater by Id.
   *
   * @param id the Id of the heater to delete
   */
  void deleteById(Long id);

  /**
   * Check if heater exists by Id.
   *
   * @param id the Id of the home
   */
  boolean existsById(Long id);
}
