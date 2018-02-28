package axdum.master1.sir.testjpa_spring.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("HEATER")
public class Heater extends SmartDevice {
    private Home home;

    /**
     * Constructeur Heater vide.
     */
    public Heater() {
        super();
    }

    /**
     * Constructeur Heater avec résidence renseignée.
     *
     * @param name
     *          le nom du chauffage
     * @param hourOnPerDay
     *          le nombre d'heures moyen de fonctionnement par jour du chauffage
     * @param dayOnPerYear
     *          le nombre de jours de fonctionnement par an du chauffage
     * @param watts
     *          la puissance en watts du chauffage
     * @param home
     *          la résidence du chauffage
     */
    public Heater(String name, Double hourOnPerDay, int dayOnPerYear, int watts, Home home) {
        super(name, hourOnPerDay, dayOnPerYear, watts);
        this.home = home;
    }

    /**
     * Constructeur Heater sans résidence.
     *
     * @param name
     *          le nom du chauffage
     * @param hourOnPerDay
     *          le nombre d'heures moyen de fonctionnement par jour du chauffage
     * @param dayOnPerYear
     *          le nombre de jours de fonctionnement par an du chauffage
     * @param watts
     *          la puissance en watts du chauffage
     */
    public Heater(String name, Double hourOnPerDay, int dayOnPerYear, int watts) {
        super(name, hourOnPerDay, dayOnPerYear, watts);
    }

    /**
     * Obtenir la résidence du chauffage.
     *
     * @return la résidence du chauffage
     */
    @ManyToOne
    public Home getHome() {
        return home;
    }

    /**
     * Renseigner la résidence du chauffage.
     *
     * @param home
     *          : la résidence du chauffage
     */
    public void setHome(Home home) {
        this.home = home;
    }
}
