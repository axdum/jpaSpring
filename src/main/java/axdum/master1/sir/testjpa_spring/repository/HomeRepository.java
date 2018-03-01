package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HomeRepository extends JpaRepository<Home, Integer> {
    /**
     * Find homes by name.
     *
     * @param name the name
     * @return the matching homes list
     */
    List<Home> findByName(String name);

    /**
     * Find a home by Id.
     *
     * @param id the Id of the home to find
     * @return the matching home
     */
    Home findById(Long id);

    /**
     * Delete an home by Id.
     *
     * @param id the Id of the home to delete
     */
    void deleteById(Long id);
}
