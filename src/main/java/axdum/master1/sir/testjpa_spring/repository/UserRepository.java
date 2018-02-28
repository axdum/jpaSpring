package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    User findFirstByPseudo(String pseudo);

    User findById(Long id);

    void deleteById(Long id);
}
