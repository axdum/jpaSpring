package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import axdum.master1.sir.testjpa_spring.model.Heater;
import axdum.master1.sir.testjpa_spring.model.Home;
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
   * Populate Database.
   */
  public void populate() {
    // Personnes
    User axelD = new User("axdum", "Axel", "Dumont", "axel.dumont3@gmail.com");
    User elisaD = new User("lisou", "Elisa", "Dumont", "lisou@gmail.com");
    User claraD = new User("Clara76", "Clara", "Dumont", "clacla@gmail.com");

    // Résidences
    Home appartAxel = new Home("Appartement Rennes", 50, 4, axelD);
    Home homeAxel = new Home("Maison de campagne", 240, 8, axelD);
    Home appartElisa = new Home("Appartement Rouen", 55, 5, elisaD);
    Home appartElisa2 = new Home("Appartement Harajuku", 25, 3, elisaD);
    Home appartClara = new Home("Appartement Rouen", 60, 5, claraD);

    // Chauffages
    appartAxel.addHeater(new Heater("chauffage séjour", 20.0, 225, 1000, appartAxel));
    appartAxel.addHeater(new Heater("chauffage salle de bain", 2.5, 300, 500, appartAxel));
    appartAxel.addHeater(new Heater("chauffage chambre", 15.2, 220, 1000, appartAxel));
    homeAxel.addHeater(new Heater("chauffage salon", 18.7, 105, 2000, homeAxel));
    homeAxel.addHeater(new Heater("chauffage salle de bain étage", 1.3, 100, 500, homeAxel));
    homeAxel.addHeater(new Heater("chauffage salle de bain rdc", 2.7, 100, 500, homeAxel));
    homeAxel.addHeater(new Heater("chauffage entrée", 20.8, 98, 1000, homeAxel));
    homeAxel.addHeater(new Heater("chauffage chambre 1", 5.1, 95, 1000, homeAxel));
    homeAxel.addHeater(new Heater("chauffage chambre 2", 7.8, 108, 1000, homeAxel));
    homeAxel.addHeater(new Heater("chauffage cuisine", 16.2, 104, 8000, homeAxel));

    appartElisa.addHeater(new Heater("chauffage séjour", 23.2, 225, 8000, appartElisa));
    appartElisa.addHeater(new Heater("chauffage salle de bain", 4.7, 500, 500, appartElisa));
    appartElisa.addHeater(new Heater("chauffage chambre", 14.7, 220, 2000, appartElisa));
    appartElisa2.addHeater(new Heater("chauffage séjour", 23.6, 150, 8000, appartElisa2));
    appartElisa2.addHeater(new Heater("chauffage salle de bain", 4.3, 154, 500, appartElisa2));
    appartElisa2.addHeater(new Heater("chauffage chambre", 14.2, 149, 2000, appartElisa2));

    appartClara.addHeater(new Heater("chauffage séjour", 23.1, 300, 8000, appartClara));
    appartClara.addHeater(new Heater("chauffage salle de bain", 4.3, 350, 500, appartClara));
    appartClara.addHeater(new Heater("chauffage chambre", 14.5, 320, 2000, appartClara));
    appartClara.addHeater(new Heater("chauffage cuisine", 18.1, 310, 1000, appartClara));

    axelD.addHome(appartAxel);
    axelD.addHome(homeAxel);
    elisaD.addHome(appartElisa);
    elisaD.addHome(appartElisa2);
    claraD.addHome(appartClara);

    // Appareils electroniques
    axelD.addElectronicDevice(new ElectronicDevice("TV Samsung", 1.2, 250, 2000, axelD));
    axelD.addElectronicDevice(new ElectronicDevice("Micro-Ondes", 0.2, 250, 1500, axelD));
    elisaD.addElectronicDevice(new ElectronicDevice("TV Phillips", 2.5, 250, 2000, elisaD));
    claraD.addElectronicDevice(new ElectronicDevice("Réveil", 24.0, 340, 20, axelD));

    // Amis
    axelD.addFriend(elisaD);
    axelD.addFriend(claraD);
    elisaD.addFriend(axelD);
    elisaD.addFriend(claraD);
    claraD.addFriend(elisaD);

    this.addUser(elisaD);
    this.addUser(claraD);
    this.addUser(axelD);

  }

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
