package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.User;
import axdum.master1.sir.testjpa_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    /**
     * Get all users list.
     *
     * @return the list of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Get the user matching the nickname.
     *
     * @param nickname the nickname of user
     * @return the user
     */
    public User getUserByNickname(String nickname) {
        return userRepository.findFirstByPseudo(nickname);
    }

    /**
     * Get the user matching the id.
     *
     * @param id the id of user
     * @return the user
     */
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Create a new User.
     *
     * @param user the new user
     */
    public void addUser(User user) {
        userRepository.save(user);
    }

    /**
     * Update the user.
     *
     * @param id   the id of the user to update
     * @param user the user to update
     */
    public void updateUser(Long id, User user) {
        userRepository.save(user);
    }

    /**
     * Delete the user.
     *
     * @param id the id of the user to delete
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
