package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/home")
public class HomeResource {
    @Autowired
    HomeService homeService;

    /**
     * Get all homes list.
     *
     * @return the list of all homes
     */
    @GetMapping("/all")
    public List<Home> getAll() {
        return homeService.getAllHomes();
    }

    /**
     * Get the list of homes matching the name.
     *
     * @param name the name of homes
     * @return a list of homes
     */
    @GetMapping("/{name}")
    public List<Home> getHome(@PathVariable("name") String name) {
        return homeService.getHomeByName(name);
    }

    /**
     * Get the home matching the id.
     *
     * @param id the id of the home
     * @return the home
     */
    @GetMapping("/id/{id}")
    public Home getId(@PathVariable("id") Long id) {
        return homeService.getHomeById(id);
    }

    /**
     * Create a new home.
     *
     * @param home the new home
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addReservation(@RequestBody Home home) {
        homeService.addHome(home);
    }

    /**
     * Update the home.
     *
     * @param id   the id of the home to update
     * @param home the home to update
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateReservation(@RequestBody Home home, @PathVariable("id") Long id) {
        homeService.updateHome(id, home);
    }
}
