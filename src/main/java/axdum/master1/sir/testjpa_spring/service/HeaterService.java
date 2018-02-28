package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.Heater;
import axdum.master1.sir.testjpa_spring.repository.HeaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeaterService {
    @Autowired
    HeaterRepository heaterRepository;

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
     * Create a new Heater.
     *
     * @param heater the new Heater
     */
    public void addHeater(Heater heater) {
        heaterRepository.save(heater);
    }

    /**
     * Update the Heater.
     *
     * @param id   the id of the Heater to update
     * @param heater the Heater to update
     */
    public void updateHeater(Long id, Heater heater) {
        heaterRepository.save(heater);
    }

    /**
     * Delete the Heater.
     *
     * @param id the id of the Heater to delete
     */
    public void deleteHeater(Long id) {
        heaterRepository.deleteById(id);
    }
}
