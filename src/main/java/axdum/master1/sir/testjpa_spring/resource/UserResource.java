package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.*;
import axdum.master1.sir.testjpa_spring.repository.UserRepository;
import axdum.master1.sir.testjpa_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("rest/user")
public class UserResource {
    @Autowired
    UserService userService;

    /**
     * Get all users list.
     *
     * @return the list of all users
     */
    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    /**
     * Get the user matching the nickname.
     *
     * @param nickname the nickname of user
     * @return the user
     */
    @GetMapping("/{nickname}")
    public User getUser(@PathVariable("nickname") String nickname) {
        return userService.getUserByNickname(nickname);
    }

    /**
     * Get the user matching the id.
     *
     * @param id the id of user
     * @return the user
     */
    @GetMapping("/{id}")
    public User getId(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * Create a new User.
     *
     * @param user the new user
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addReservation(@RequestBody User user) {
        userService.addUser(user);
    }

    /**
     * Update the user.
     *
     * @param id   the id of the user to update
     * @param user the user to update
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateReservation(@RequestBody User user,@PathVariable("id") Long id) {
        userService.updateUser(id, user);
    }
}
