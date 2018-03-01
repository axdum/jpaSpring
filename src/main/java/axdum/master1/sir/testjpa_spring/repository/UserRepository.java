package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
  /**
   * Find an user by his nickname.
   *
   * @param pseudo the nickname
   * @return the matching user
   */
  User findFirstByPseudo(String pseudo);

  /**
   * Find an user by Id.
   *
   * @param id the Id of the user to find
   * @return the matching user
   */
  User findById(Long id);

  /**
   * Find an user by Mail.
   *
   * @param mail the mail of the user to find
   * @return the matching user
   */
  User findUserByMail(String mail);

  /**
   * Check if user exists by Id.
   *
   * @param id the Id of the user
   */
  boolean existsById(Long id);
}
