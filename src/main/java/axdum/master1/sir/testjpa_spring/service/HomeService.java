package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.model.User;
import axdum.master1.sir.testjpa_spring.repository.HomeRepository;
import axdum.master1.sir.testjpa_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
  @Autowired
  HomeRepository homeRepository;
  @Autowired
  UserRepository userRepository;

  /**
   * Get all homes list.
   *
   * @return the list of all homes
   */
  public List<Home> getAllHomes() {
    return homeRepository.findAll();
  }

  /**
   * Get the home matching the nickname.
   *
   * @param name the name of the home
   * @return the home
   */
  public List<Home> getHomeByName(String name) {
    return homeRepository.findByName(name);
  }

  /**
   * Get the home matching the id.
   *
   * @param id the id of home
   * @return the home
   */
  public Home getHomeById(Long id) {
    return homeRepository.findOneById(id);
  }

  /**
   * Create a new Home.
   *
   * @param name          home name
   * @param size          home surface (m3)
   * @param nbRooms       home number of rooms
   * @param ownerNickname home owner nickname
   * @return home created or not
   */
  public String createHome(String name, int size, int nbRooms, String ownerNickname) {
    try {
      User user = userRepository.findFirstByPseudo(ownerNickname);
      Home home = new Home(name, size, nbRooms, user);
      homeRepository.save(home);
    } catch (Exception ex) {
      return "Error creating the Home: " + ex.toString();
    }
    return "Home succesfully created !";
  }

  /**
   * Update a Home.
   *
   * @param id            the Id of the home to update
   * @param name          new name
   * @param size          new surface (m3)
   * @param nbRooms       new number of rooms
   * @param ownerNickname new owner nickname
   * @return user updated or not
   */
  public String updateHome(Long id, String name, int size, int nbRooms, String ownerNickname) {
    try {
      User newOwner = userRepository.findFirstByPseudo(ownerNickname);
      Home home = homeRepository.findOneById(id);
      home.setName(name);
      home.setSize(size);
      home.setNbRooms(nbRooms);
      home.setOwner(newOwner);
      homeRepository.save(home);
    } catch (Exception ex) {
      return "Error updating the home: " + ex.toString();
    }
    return "Home succesfully updated !";
  }

  /**
   * Delete the home if exists.
   *
   * @param id the id of the home to delete
   */
  public String deleteHome(Long id) {
    if (homeRepository.existsById(id)) {
      try {
        Home home = homeRepository.findOneById(id);
        homeRepository.delete(home);
      } catch (Exception ex) {
        return "Error deleting the home: " + ex.toString();
      }
      return "Home succesfully updated !";
    }
    return "Home doesn't exist !";
  }
}
