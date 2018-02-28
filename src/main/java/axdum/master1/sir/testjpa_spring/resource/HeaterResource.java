package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.Heater;
import axdum.master1.sir.testjpa_spring.service.HeaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/heater")
public class HeaterResource {
    @Autowired
    HeaterService heaterService;

    /**
     * Get all Heaters list.
     *
     * @return the list of all Heaters
     */
    @GetMapping("/all")
    public List<Heater> getAll() {
        return heaterService.getAllHeaters();
    }

    /**
     * Get the list of Heaters matching the name.
     *
     * @param name the name of Heaters
     * @return a list of Heaters
     */
    @GetMapping("/{name}")
    public List<Heater> getHeater(@PathVariable("name") String name) {
        return heaterService.getHeaterByName(name);
    }

    /**
     * Get the Heater matching the id.
     *
     * @param id the id of the Heater
     * @return the Heater
     */
    @GetMapping("/id/{id}")
    public Heater getId(@PathVariable("id") Long id) {
        return heaterService.getHeaterById(id);
    }

    /**
     * Create a new Heater.
     *
     * @param heater the new Heater
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addReservation(@RequestBody Heater heater) {
        heaterService.addHeater(heater);
    }

    /**
     * Update the Heater.
     *
     * @param id     the id of the Heater to update
     * @param heater the Heater to update
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateReservation(@RequestBody Heater heater, @PathVariable("id") Long id) {
        heaterService.updateHeater(id, heater);
    }
}
