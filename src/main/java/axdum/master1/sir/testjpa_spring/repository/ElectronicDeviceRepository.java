package axdum.master1.sir.testjpa_spring.repository;

import axdum.master1.sir.testjpa_spring.model.ElectronicDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectronicDeviceRepository extends JpaRepository<ElectronicDevice, Long> {
  /**
   * Find electronic devices by name.
   *
   * @param name the name
   * @return the matching electronic devices list
   */
  List<ElectronicDevice> findByName(String name);

  /**
   * Find an electronic device by Id.
   *
   * @param id the Id of the electronic device to find
   * @return the matching electronic device
   */
  ElectronicDevice findOneById(Long id);

  /**
   * Check if the electronic device exists by Id.
   *
   * @param id the Id of the electronic device
   */
  boolean existsById(Long id);
}
