package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.User;
import axdum.master1.sir.testjpa_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserResource {
  @Autowired
  UserService userService;

  /**
   * Populate the database.
   */
  @GetMapping("/populate")
  public void populate() {
    userService.populate();
  }

  /**
   * Get all users list.
   *
   * @return the list of all users
   */
  @GetMapping("/all")
  public List<User> getAllUsers() {
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
   * Retrieve the id for the user with the passed nickname.
   */
  @RequestMapping(
          value = "/get-by-nickname",
          method = RequestMethod.GET,
          params = {"nickname"})
  @ResponseBody
  public String getByNickname(String nickname) {
    String userId;
    try {
      User user = userService.getUserByNickname(nickname);
      userId = String.valueOf(user.getId());
    } catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }

  /**
   * Retrieve the id for the user with the passed mail.
   */
  @RequestMapping(
          value = "/get-by-mail",
          method = RequestMethod.GET,
          params = {"mail"})
  @ResponseBody
  public String getByMail(String mail) {
    String userId;
    try {
      User user = userService.getUserByMail(mail);
      userId = String.valueOf(user.getId());
    } catch (Exception ex) {
      return "User not found: " + ex.toString();
    }
    return "The user id is: " + userId;
  }

  /**
   * Get the user matching the id.
   *
   * @param id the id of user
   * @return the user
   */
  @GetMapping("/id/{id}")
  public User getId(@PathVariable("id") Long id) {
    return userService.getUserById(id);
  }

  @RequestMapping(
          value = "/create",
          method = RequestMethod.POST,
          params = {"pseudo", "firstname", "name", "mail"})
  @ResponseBody
  public void createUser(String pseudo, String firstname, String name, String mail) {
    userService.createUser(pseudo, firstname, name, mail);
  }

  /**
   * Update the user withe the passed Id.
   *
   * @param id        user Id
   * @param pseudo    the new pseudo
   * @param firstname the new firstname
   * @param name      the new name
   */
  @RequestMapping(value = "/update",
          method = RequestMethod.PUT,
          params = {"id", "pseudo", "firstname", "name", "mail"})
  @ResponseBody
  public void updateUserInfos(long id, String pseudo, String firstname, String name, String mail) {
    userService.updateUser(id, pseudo, firstname, name, mail);
  }

  /**
   * Delete the user with the passed id.
   *
   * @param id the Id of the user to delete
   */
  @RequestMapping(
          value = "/delete",
          method = RequestMethod.DELETE,
          params = {"id"})
  @ResponseBody
  public void deleteUser(long id) {
    String res = userService.deleteUser(id);
  }
}
