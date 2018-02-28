package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.Home;
import axdum.master1.sir.testjpa_spring.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    HomeRepository homeRepository;

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
        return homeRepository.findById(id);
    }

    /**
     * Create a new home.
     *
     * @param home the new home
     */
    public void addHome(Home home) {
        homeRepository.save(home);
    }

    /**
     * Update the home.
     *
     * @param id   the id of the home to update
     * @param home the home to update
     */
    public void updateHome(Long id, Home home) {
        homeRepository.save(home);
    }

    /**
     * Delete the home.
     *
     * @param id the id of the home to delete
     */
    public void deleteHome(Long id) {
        homeRepository.deleteById(id);
    }
}
