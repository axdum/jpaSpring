package axdum.master1.sir.testjpa_spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("ELECTRONIC_DEVICE")
@Table(name = "user", catalog = "jpaspring")
public class ElectronicDevice extends SmartDevice {
  @JsonManagedReference
  private User owner;

  /**
   * Empty constructor of ElectronicDevice.
   */
  public ElectronicDevice() {
    super();
  }

  /**
   * ElectronicDevice constructor with parameters.
   *
   * @param name         electric device name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param owner        the owner
   */
  public ElectronicDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts, User owner) {
    super(name, hourOnPerDay, dayOnPerYear, watts);
    this.owner = owner;
  }

  /**
   * ElectronicDevice constructor without owner.
   *
   * @param name         electric device name
   * @param hourOnPerDay the number of operating days per year
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   */
  public ElectronicDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts) {
    super(name, hourOnPerDay, dayOnPerYear, watts);
  }

  /**
   * Get the owner.
   *
   * @return the owner
   */
  @ManyToOne
  public User getOwner() {
    return owner;
  }

  /**
   * Set the owner.
   *
   * @param owner the owner
   */
  public void setOwner(User owner) {
    this.owner = owner;
  }
}
