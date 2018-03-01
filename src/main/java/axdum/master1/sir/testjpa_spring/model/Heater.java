package axdum.master1.sir.testjpa_spring.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("HEATER")
@Table(name = "heater", catalog = "jpaspring")
public class Heater extends SmartDevice {
  @JsonManagedReference
  private Home home;

  /**
   * Empty constructor of Heater.
   */
  public Heater() {
    super();
  }

  /**
   * Heater  constructor with parameters.
   *
   * @param name         the name
   * @param hourOnPerDay the number of operating hours per day
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   * @param home         the home
   */
  public Heater(String name, Double hourOnPerDay, int dayOnPerYear, int watts, Home home) {
    super(name, hourOnPerDay, dayOnPerYear, watts);
    this.home = home;
  }

  /**
   * Heater constructor without home.
   *
   * @param name         the name
   * @param hourOnPerDay the number of operating days per year
   * @param dayOnPerYear the number of operating days per year
   * @param watts        the power
   */
  public Heater(String name, Double hourOnPerDay, int dayOnPerYear, int watts) {
    super(name, hourOnPerDay, dayOnPerYear, watts);
  }

  /**
   * Get the home.
   *
   * @return the home
   */
  @ManyToOne
  public Home getHome() {
    return home;
  }

  /**
   * Set the home.
   *
   * @param home the home
   */
  public void setHome(Home home) {
    this.home = home;
  }
}
