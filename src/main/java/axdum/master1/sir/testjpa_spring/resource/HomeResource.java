package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/home")
public class HomeResource {
  @Autowired
  HomeService homeService;

  /**
   * Get all homes list.
   *
   * @return the list of all homes
   */
  @GetMapping("/all")
  public List<Home> getAllHomes() {
    return homeService.getAllHomes();
  }

  /**
   * Get the home matching the id.
   *
   * @param id home id
   * @return the home
   */
  @GetMapping("/id/{id}")
  public Home getHomeById(@PathVariable("id") Long id) {
    return homeService.getHomeById(id);
  }

  /**
   * Get homes by name.
   *
   * @param name home name.
   * @return the home
   */
  @GetMapping("/{name}")
  public List<Home> getHome(@PathVariable("name") String name) {
    return homeService.getHomeByName(name);
  }

  /**
   * Create a new home.
   *
   * @param name          home name
   * @param size          home surface (m3)
   * @param nbRooms       home number of rooms
   * @param ownerNickname home owner nickname
   */
  @RequestMapping(
          value = "/create",
          method = RequestMethod.POST,
          params = {"name", "size", "nbRooms", "ownerNickname"})
  @ResponseBody
  public void createHome(String name, int size, int nbRooms, String ownerNickname) {
    homeService.createHome(name, size, nbRooms, ownerNickname);
  }

  /**
   * Update the home with the passed Id.
   *
   * @param id            Id of the home to update
   * @param name          new name
   * @param size          new surface (m3)
   * @param nbRooms       new number of rooms
   * @param ownerNickname new owner nickname
   */
  @RequestMapping(value = "/update",
          method = RequestMethod.PUT,
          params = {"id", "name", "size", "nbRooms", "ownerNickname"})
  @ResponseBody
  public void updateHome(Long id, String name, int size, int nbRooms, String ownerNickname) {
    homeService.updateHome(id, name, size, nbRooms, ownerNickname);
  }

  /**
   * Delete the home with the passed id.
   *
   * @param id the Id of the home to delete
   */
  @RequestMapping(
          value = "/delete",
          method = RequestMethod.DELETE,
          params = {"id"})
  @ResponseBody
  public void deleteHome(long id) {
    homeService.deleteHome(id);
  }
}
