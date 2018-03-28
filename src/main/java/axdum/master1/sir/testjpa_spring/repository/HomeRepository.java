package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home, Long> {
  /**
   * Find homes by name.
   *
   * @param name the name
   * @return the matching homes list
   */
  List<Home> findByName(String name);

  /**
   * Find homes by owner pseudo.
   *
   * @param nickname owner pseudo.
   * @return the matching homes list.
   */
  List<Home> findHomesByOwner_Pseudo(String nickname);

  /**
   * Find a home by Id.
   *
   * @param id the Id of the home to find
   * @return the matching home
   */
  Home findOneById(Long id);

  /**
   * Check if home exists by Id.
   *
   * @param id the Id of the home
   */
  boolean existsById(Long id);
}
