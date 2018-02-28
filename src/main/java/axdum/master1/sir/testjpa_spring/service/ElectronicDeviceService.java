package axdum.master1.sir.testjpa_spring.service;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import axdum.master1.sir.testjpa_spring.repository.ElectronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicDeviceService {
    @Autowired
    ElectronicDeviceRepository electronicDeviceRepository;

    /**
     * Get all ElectronicDevices list.
     *
     * @return the list of all ElectronicDevices
     */
    public List<ElectronicDevice> getAllElectronicDevices() {
        return electronicDeviceRepository.findAll();
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
     * Get the ElectronicDevice matching the id.
     *
     * @param id the id of ElectronicDevice
     * @return the ElectronicDevice
     */
    public ElectronicDevice getElectronicDeviceById(Long id) {
        return electronicDeviceRepository.findById(id);
    }

    /**
     * Create a new ElectronicDevice.
     *
     * @param electronicDevice the new ElectronicDevice
     */
    public void addElectronicDevice(ElectronicDevice electronicDevice) {
        electronicDeviceRepository.save(electronicDevice);
    }

    /**
     * Update the ElectronicDevice.
     *
     * @param id               the id of the ElectronicDevice to update
     * @param electronicDevice the ElectronicDevice to update
     */
    public void updateElectronicDevice(Long id, ElectronicDevice electronicDevice) {
        electronicDeviceRepository.save(electronicDevice);
    }

    /**
     * Delete the ElectronicDevice.
     *
     * @param id the id of the ElectronicDevice to delete
     */
    public void deleteElectronicDevice(Long id) {
        electronicDeviceRepository.deleteById(id);
    }
}
