package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.Heater;
import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.repository.HeaterRepository;
import axdum.master1.sir.testjpa_spring.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaterService {
  @Autowired
  HeaterRepository heaterRepository;
  @Autowired
  HomeRepository homeRepository;

  /**
   * Get all Heaters list.
   *
   * @return the list of all Heaters
   */
  public List<Heater> getAllHeaters() {
    return heaterRepository.findAll();
  }

  /**
   * Get the Heater matching the nickname.
   *
   * @param name the name of the Heater
   * @return the Heater
   */
  public List<Heater> getHeaterByName(String name) {
    return heaterRepository.findByName(name);
  }

  /**
   * Get the Heater matching the id.
   *
   * @param id the id of Heater
   * @return the Heater
   */
  public Heater getHeaterById(Long id) {
    return heaterRepository.findById(id);
  }

  /**
   * Create a heater
   *
   * @param name         the name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param homeId       the id of the home
   */
  public String createHeater(String name, Double hourOnPerDay, int dayOnPerYear, int watts, Long homeId) {
    try {
      Home home = homeRepository.findById(homeId);
      Heater heater = new Heater(name, hourOnPerDay, dayOnPerYear, watts, home);
      homeRepository.save(home);
    } catch (Exception ex) {
      return "Error creating the Heater: " + ex.toString();
    }
    return "Heater succesfully created !";
  }

  /**
   * Update a heater.
   *
   * @param id           the id of the heater to update
   * @param name         the name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param homeId       the id of the home
   * @return heater updated or not
   */
  public String updateHeater(Long id, String name, Double hourOnPerDay, int dayOnPerYear, int watts, Long homeId) {
    try {
      Home home = homeRepository.findById(homeId);
      Heater heater = heaterRepository.findById(id);
      heater.setName(name);
      heater.sethourOnPerDay(hourOnPerDay);
      heater.setdayOnPerYear(dayOnPerYear);
      heater.setWatts(watts);
      heater.setHome(home);
      heaterRepository.save(heater);
    } catch (Exception ex) {
      return "Error updating the heater: " + ex.toString();
    }
    return "Heater succesfully updated !";
  }

  /**
   * Delete the heater if exists.
   *
   * @param id the id of the heater to delete
   */
  public String deleteHeater(Long id) {
    if (heaterRepository.existsById(id)) {
      try {
        Heater heater = heaterRepository.findById(id);
        heaterRepository.delete(heater);
      } catch (Exception ex) {
        return "Error deleting the heater: " + ex.toString();
      }
      return "Heater succesfully updated !";
    }
    return "Heater doesn't exist !";
  }
}
