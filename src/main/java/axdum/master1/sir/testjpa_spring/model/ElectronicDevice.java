package axdum.master1.sir.testjpa_spring.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("ELECTRONIC_DEVICE")
public class ElectronicDevice extends SmartDevice {
    private User owner;

    /**
     * Constructeur ElectronicDevice vide.
     */
    public ElectronicDevice() {
        super();
    }

    /**
     * Constructeur ElectronicDevice avec propriétaire renseigné.
     *
     * @param name
     *          le nom de l'appareil électronique
     * @param hourOnPerDay
     *          le nombre d'heures moyen de fonctionnement par jour de l'appareil
     *          électronique
     * @param dayOnPerYear
     *          le nombre de jours de fonctionnement par an de l'appareil
     *          électronique
     * @param watts
     *          la puissance en watts de l'appareil électronique
     * @param owner
     *          le propriétaire de l'appareil électronique
     */
    public ElectronicDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts, User owner) {
        super(name, hourOnPerDay, dayOnPerYear, watts);
        this.owner = owner;
    }

    /**
     * Constructeur ElectronicDevice sans propriétaire.
     *
     * @param name
     *          le nom de l'appareil électronique
     * @param hourOnPerDay
     *          le nombre d'heures moyen de fonctionnement par jour de l'appareil
     *          électronique
     * @param dayOnPerYear
     *          le nombre de jours de fonctionnement par an de l'appareil
     *          électronique
     * @param watts
     *          la puissance en watts de l'appareil électronique
     */
    public ElectronicDevice(String name, Double hourOnPerDay, int dayOnPerYear, int watts) {
        super(name, hourOnPerDay, dayOnPerYear, watts);
    }

    /**
     * Obtenir le proprétaire de l'appareil électronique.
     *
     * @return le propriétaire de l'appareil électronique
     */
    @ManyToOne
    public User getOwner() {
        return owner;
    }

    /**
     * Renseigner le proprétaire de l'appareil électronique.
     *
     * @param owner
     *          le proprétaire de l'appareil électronique
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
