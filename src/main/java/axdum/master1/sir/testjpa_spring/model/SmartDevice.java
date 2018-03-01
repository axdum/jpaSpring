package axdum.master1.sir.testjpa_spring.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_SMARTDEVICE")
@Table(name = "smartdevice", catalog = "jpaspring")
@DiscriminatorValue("SD")
public class SmartDevice {
    private Long id;
    private String name;
    private Double hourOnPerDay;
    private int dayOnPerYear;
    private int watts;

    /**
     * Empty constructor of SmartDevice.
     */
    public SmartDevice() {
        super();
        this.hourOnPerDay = 0.0;
        this.dayOnPerYear = 0;
        this.watts = 0;
    }

    /**
     * SmartDevice constructor with parameters.
     *
     * @param name         the name
     * @param hourOnPerDay the number of operating hours per day
     * @param dayOnPerYear the number of operating days per year
     * @param watts        the power
     */
    public SmartDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts) {
        super();
        this.name = name;
        this.hourOnPerDay = hourOnPerDay;
        this.dayOnPerYear = dayOnPerYear;
        this.watts = watts;
    }

    /**
     * Get the Id.
     *
     * @return the Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Set the Id.
     *
     * @param id the Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the number of operating hours per day.
     *
     * @return the number of operating hours per day
     */
    public Double gethourOnPerDay() {
        return hourOnPerDay;
    }

    /**
     * Set the number of operating hours per day.
     *
     * @param hourOnPerDay the number of operating hours per day
     */
    public void sethourOnPerDay(Double hourOnPerDay) {
        this.hourOnPerDay = hourOnPerDay;
    }

    /**
     * Get the number of operating days per year.
     *
     * @return the number of operating days per year
     */
    public int getdayOnPerYear() {
        return dayOnPerYear;
    }

    /**
     * Set the number of operating days per year.
     *
     * @param dayOnPerYear the number of operating days per year
     */
    public void setdayOnPerYear(int dayOnPerYear) {
        this.dayOnPerYear = dayOnPerYear;
    }

    /**
     * Get the power (watts).
     *
     * @return the power
     */
    public int getWatts() {
        return watts;
    }

    /**
     * Set the power (watts)
     *
     * @param watts the power
     */
    public void setWatts(int watts) {
        this.watts = watts;
    }
}
