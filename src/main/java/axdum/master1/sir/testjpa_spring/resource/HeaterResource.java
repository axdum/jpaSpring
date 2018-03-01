package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.Heater;
import axdum.master1.sir.testjpa_spring.service.HeaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/heater")
public class HeaterResource {
  @Autowired
  HeaterService heaterService;

  /**
   * Get all Heaters list.
   *
   * @return the list of all Heaters
   */
  @GetMapping("/all")
  public List<Heater> getAllHeaters() {
    return heaterService.getAllHeaters();
  }

  /**
   * Get the Heater matching the id.
   *
   * @param id Heater id
   * @return the Heater
   */
  @GetMapping("/id/{id}")
  public Heater getHeaterById(@PathVariable("id") Long id) {
    return heaterService.getHeaterById(id);
  }

  /**
   * Get Heaters by name.
   *
   * @param name Heater name.
   * @return the Heater
   */
  @GetMapping("/{name}")
  public List<Heater> getHeater(@PathVariable("name") String name) {
    return heaterService.getHeaterByName(name);
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
  @RequestMapping(
          value = "/create",
          method = RequestMethod.POST,
          params = {"name", "hourOnPerDay", "dayOnPerYear", "watts", "homeId"})
  @ResponseBody
  public void createHeater(String name, Double hourOnPerDay, int dayOnPerYear, int watts, Long homeId) {
    heaterService.createHeater(name, hourOnPerDay, dayOnPerYear, watts, homeId);
  }

  /**
   * Update the Heater with the passed Id.
   *
   * @param name         the name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param homeId       the id of the home
   */
  @RequestMapping(value = "/update",
          method = RequestMethod.PUT,
          params = {"id", "name", "hourOnPerDay", "dayOnPerYear", "watts", "homeId"})
  @ResponseBody
  public void updateHeater(Long id, String name, Double hourOnPerDay, int dayOnPerYear, int watts, Long homeId) {
    heaterService.updateHeater(id, name, hourOnPerDay, dayOnPerYear, watts, homeId);
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
  public void deleteHeater(long id) {
    heaterService.deleteHeater(id);
  }
}
