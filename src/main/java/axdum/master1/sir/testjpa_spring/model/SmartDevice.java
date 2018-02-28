package axdum.master1.sir.testjpa_spring.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_SMARTDEVICE")
@DiscriminatorValue("SD")
public class SmartDevice {
    private Long id;
    private String name;
    private Double hourOnPerDay;
    private int dayOnPerYear;
    private int watts;

    /**
     * Constructeur SmartDevice sans params.
     */
    public SmartDevice() {
        super();
    }

    /**
     * Constructeur SmartDevice.
     *
     * @param name         le nom de l'appareil intelligent
     * @param hourOnPerDay le nombre d'heures moyen de fonctionnement par jour de l'appareil
     *                     intelligent
     * @param dayOnPerYear le nombre de jours de fonctionnement par an de l'appareil
     *                     intelligent
     * @param watts        la puissance en watts de l'appareil intelligent
     */
    public SmartDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts) {
        super();
        this.name = name;
        this.hourOnPerDay = hourOnPerDay;
        this.dayOnPerYear = dayOnPerYear;
        this.watts = watts;
    }

    /**
     * Calcule la consommation annuelle de l'appareil intelligent.
     *
     * @return la consommation annuelle de l'appareil intelligent
     */
    public Double calcAnualCons() {
        return hourOnPerDay * dayOnPerYear * (watts / 1000);
    }

    /**
     * Obtenir l'ID de l'appareil intelligent.
     *
     * @return l'ID de l'appareil intelligent
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Rensigner l'ID de l'appareil intelligent.
     *
     * @param id l'ID de l'appareil intelligent
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtenir le nom de l'appareil intelligent.
     *
     * @return le nom de l'appareil intelligent
     */
    public String getName() {
        return name;
    }

    /**
     * Renseigner le nom de l'appareil intelligent.
     *
     * @param name le nom de l'appareil intelligent
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtenir le nombre d'heures moyen de fonctionnement par jour de l'appareil
     * intelligent.
     *
     * @return le nombre d'heures moyen de fonctionnement par jour de l'appareil
     * intelligent
     */
    public Double gethourOnPerDay() {
        return hourOnPerDay;
    }

    /**
     * Renseigner le nombre d'heures moyen de fonctionnement par jour de l'appareil
     * intelligent.
     *
     * @param hourOnPerDay le nombre d'heures moyen de fonctionnement par jour de l'appareil
     *                     intelligent
     */
    public void sethourOnPerDay(Double hourOnPerDay) {
        this.hourOnPerDay = hourOnPerDay;
    }

    /**
     * Obtenir le nombre de jours de fonctionnement par an de l'appareil
     * intelligent.
     *
     * @return le nombre de jours de fonctionnement par an de l'appareil intelligent
     */
    public int getdayOnPerYear() {
        return dayOnPerYear;
    }

    /**
     * Renseigner le nombre de jours de fonctionnement par an de l'appareil
     * intelligent.
     *
     * @param dayOnPerYear le nombre de jours de fonctionnement par an de l'appareil
     *                     intelligent
     */
    public void setdayOnPerYear(int dayOnPerYear) {
        this.dayOnPerYear = dayOnPerYear;
    }

    /**
     * Obtenir la puissance de l'appareil intelligent en watts.
     *
     * @return la puissance de l'appareil intelligent en watts
     */
    public int getWatts() {
        return watts;
    }

    /**
     * Renseigner la puissance de l'appareil intelligent en watts.
     *
     * @param watts la puissance de l'appareil intelligent en watts
     */
    public void setWatts(int watts) {
        this.watts = watts;
    }
}
