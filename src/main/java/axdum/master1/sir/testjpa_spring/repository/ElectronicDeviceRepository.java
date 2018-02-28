package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import axdum.master1.sir.testjpa_spring.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectronicDeviceRepository extends JpaRepository<ElectronicDevice, Integer> {
    List<ElectronicDevice> findByName(String name);

    ElectronicDevice findById(Long id);

    void deleteById(Long id);
}
