package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import axdum.master1.sir.testjpa_spring.service.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/elecdevice")
public class ElectronicDeviceResource {
  @Autowired
  ElectronicDeviceService electronicDeviceService;

  /**
   * Get all Heaters list.
   *
   * @return the list of all Heaters
   */
  @GetMapping("/all")
  public List<ElectronicDevice> getAllElectronicDevices() {
    return electronicDeviceService.getAllElectronicDevices();
  }

  /**
   * Get the Heater matching the id.
   *
   * @param id Heater id
   * @return the Heater
   */
  @GetMapping("/id/{id}")
  public ElectronicDevice getElectronicDeviceById(@PathVariable("id") Long id) {
    return electronicDeviceService.getElectronicDeviceById(id);
  }

  /**
   * Get Heaters by name.
   *
   * @param name Heater name.
   * @return the Heater
   */
  @GetMapping("/{name}")
  public List<ElectronicDevice> getHeater(@PathVariable("name") String name) {
    return electronicDeviceService.getElectronicDeviceByName(name);
  }

  /**
   * Create an electronic device.
   *
   * @param name          the electric device name
   * @param hourOnPerDay  the number of operating hours per day
   * @param dayOnPerYear  the number of operating days per year
   * @param watts         the power
   * @param ownerNickname the owner nickname
   */
  @RequestMapping(
          value = "/create",
          method = RequestMethod.POST,
          params = {"name", "hourOnPerDay", "dayOnPerYear", "watts", "ownerNickname"})
  @ResponseBody
  public void createElectronicDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts, String ownerNickname) {
    electronicDeviceService.createElectronicDevice(name, hourOnPerDay, dayOnPerYear, watts, ownerNickname);
  }

  /**
   * Update the electronic device with the passed Id.
   *
   * @param name         the name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param nickname     the owner nickname
   */
  @RequestMapping(value = "/update",
          method = RequestMethod.PUT,
          params = {"id", "name", "hourOnPerDay", "dayOnPerYear", "watts", "nickname"})
  @ResponseBody
  public void updateElectronicDevice(Long id, String name, Double hourOnPerDay, int dayOnPerYear, int watts, String nickname) {
    electronicDeviceService.updateElectronicDevice(id, name, hourOnPerDay, dayOnPerYear, watts, nickname);
  }

  /**
   * Delete the Heater with the passed id.
   *
   * @param id the Id of the Heater to delete
   */
  @RequestMapping(
          value = "/delete",
          method = RequestMethod.DELETE,
          params = {"id"})
  @ResponseBody
  public void deleteElectronicDevice(long id) {
    electronicDeviceService.deleteElectronicDevice(id);
  }
}
