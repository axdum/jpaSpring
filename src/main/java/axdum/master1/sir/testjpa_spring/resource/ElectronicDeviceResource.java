package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import axdum.master1.sir.testjpa_spring.service.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/elecdevice")
public class ElectronicDeviceResource {
    @Autowired
    ElectronicDeviceService electronicDeviceService;

    /**
     * Get all ElectronicDevices list.
     *
     * @return the list of all ElectronicDevices
     */
    @GetMapping("/all")
    public List<ElectronicDevice> getAll() {
        return electronicDeviceService.getAllElectronicDevices();
    }

    /**
     * Get the list of ElectronicDevices matching the name.
     *
     * @param name the name of ElectronicDevices
     * @return a list of ElectronicDevices
     */
    @GetMapping("/{name}")
    public List<ElectronicDevice> getElectronicDevice(@PathVariable("name") String name) {
        return electronicDeviceService.getElectronicDeviceByName(name);
    }

    /**
     * Get the ElectronicDevice matching the id.
     *
     * @param id the id of the ElectronicDevice
     * @return the ElectronicDevice
     */
    @GetMapping("/id/{id}")
    public ElectronicDevice getId(@PathVariable("id") Long id) {
        return electronicDeviceService.getElectronicDeviceById(id);
    }

    /**
     * Create a new ElectronicDevice.
     *
     * @param electronicDevice the new ElectronicDevice
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void addReservation(@RequestBody ElectronicDevice electronicDevice) {
        electronicDeviceService.addElectronicDevice(electronicDevice);
    }

    /**
     * Update the ElectronicDevice.
     *
     * @param id               the id of the ElectronicDevice to update
     * @param electronicDevice the ElectronicDevice to update
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateReservation(@RequestBody ElectronicDevice electronicDevice, @PathVariable("id") Long id) {
        electronicDeviceService.updateElectronicDevice(id, electronicDevice);
    }
}
