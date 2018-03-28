package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import axdum.master1.sir.testjpa_spring.model.User;
import axdum.master1.sir.testjpa_spring.repository.ElectronicDeviceRepository;
import axdum.master1.sir.testjpa_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicDeviceService {
  @Autowired
  ElectronicDeviceRepository electronicDeviceRepository;
  @Autowired
  UserRepository userRepository;

  /**
   * Get all ElectronicDevices list.
   *
   * @return the list of all ElectronicDevices
   */
  public List<ElectronicDevice> getAllElectronicDevices() {
    return electronicDeviceRepository.findAll();
  }

  /**
   * Get the ElectronicDevice matching the id.
   *
   * @param id the id of ElectronicDevice
   * @return the ElectronicDevice
   */
  public ElectronicDevice getElectronicDeviceById(Long id) {
    return electronicDeviceRepository.findOneById(id);
  }

  /**
   * Get the ElectronicDevice matching the nickname.
   *
   * @param name the name of the ElectronicDevice
   * @return the ElectronicDevice
   */
  public List<ElectronicDevice> getElectronicDeviceByName(String name) {
    return electronicDeviceRepository.findByName(name);
  }

  /**
   * Create a electronic device
   *
   * @param name         the name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param nickname     the nickname of the owner
   */
  public String createElectronicDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts, String nickname) {
    try {
      User owner = userRepository.findFirstByPseudo(nickname);
      ElectronicDevice electronicDevice = new ElectronicDevice(name, hourOnPerDay, dayOnPerYear, watts, owner);
      electronicDeviceRepository.save(electronicDevice);
    } catch (Exception ex) {
      return "Error creating the electronic device: " + ex.toString();
    }
    return "Electronic device succesfully created !";
  }

  /**
   * Update a heater.
   *
   * @param id           the id of the electronic device to update
   * @param name         the name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param nickname     the nickname of the owner
   * @return heater updated or not
   */
  public String updateElectronicDevice(Long id, String name, Double hourOnPerDay, int dayOnPerYear, int watts, String nickname) {
    try {
      User owner = userRepository.findFirstByPseudo(nickname);
      ElectronicDevice electronicDevice = electronicDeviceRepository.findOneById(id);
      electronicDevice.setName(name);
      electronicDevice.sethourOnPerDay(hourOnPerDay);
      electronicDevice.setdayOnPerYear(dayOnPerYear);
      electronicDevice.setWatts(watts);
      electronicDevice.setOwner(owner);
      electronicDeviceRepository.save(electronicDevice);
    } catch (Exception ex) {
      return "Error updating the electronic device: " + ex.toString();
    }
    return "Electronic Device succesfully updated !";
  }

  /**
   * Delete the heater if exists.
   *
   * @param id the id of the heater to delete
   */
  public String deleteElectronicDevice(Long id) {
    if (electronicDeviceRepository.existsById(id)) {
      try {
        ElectronicDevice electronicDevice = electronicDeviceRepository.findOneById(id);
        electronicDeviceRepository.delete(electronicDevice);
      } catch (Exception ex) {
        return "Error deleting the electronic device: " + ex.toString();
      }
      return "Electronic device succesfully updated !";
    }
    return "ElectronicDevice doesn't exist !";
  }
}
