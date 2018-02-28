package axdum.master1.sir.testjpa_spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Home {
    private Integer id;
    private String name;
    private int size;
    private int nbRooms;
    private User owner;
    private List<Heater> heaters;

    /**
     * Constructeur Home vide.
     */
    public Home() {
        super();
        heaters = new ArrayList<Heater>();
    }

    /**
     * Constructeur Home avec propriétaire renseigné.
     *
     * @param name    le nom de la résidence
     * @param size    la taille de la résidence en m3
     * @param nbRooms le nombre de pièces de la résidence
     * @param owner   le propriétaire de la résidence
     */
    public Home(String name, int size, int nbRooms, User owner) {
        super();
        this.name = name;
        this.size = size;
        this.nbRooms = nbRooms;
        this.owner = owner;
        heaters = new ArrayList<Heater>();
    }

    /**
     * Constructeur Home sans propriétaire.
     *
     * @param name    le nom de la résidence
     * @param size    la taille de la résidence en m3
     * @param nbRooms le nombre de pièces de la résidence
     */
    public Home(String name, int size, int nbRooms) {
        super();
        this.name = name;
        this.size = size;
        this.nbRooms = nbRooms;
    }

    /**
     * Calcule la consommation annuelle d'électricité de la résidence.
     *
     * @return la consommation annuelle d'électricité de la résidence en kWh
     */
    public Double calcAnnualCons() {
        Double total = 0.0;
        for (Heater heater : heaters) {
            total = +heater.calcAnualCons();
        }
        return total;
    }

    /**
     * Ajouter un chauffage à la résidence.
     *
     * @param heater le chauffage
     */
    public void addHeater(Heater heater) {
        this.heaters.add(heater);
    }

    /**
     * Obtenir l'ID de la résidence.
     *
     * @return l'ID de la résidence
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    /**
     * Renseigner l'ID de la résidence.
     *
     * @param id l'ID de la résidence
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtenir le nom de la résidence.
     *
     * @return le nom de la résidence
     */
    public String getName() {
        return name;
    }

    /**
     * Renseigner le nom de la résidence.
     *
     * @param name le nom de la résidence
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtenir la taille de la résidence.
     *
     * @return la taille de la résidence
     */
    public int getSize() {
        return size;
    }

    /**
     * Renseigner la taille de la résidence.
     *
     * @param size la taille de la résidence
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Obtenir le nombre de pièce de la résidence.
     *
     * @return le nombre de piècees de la résidence
     */
    public int getNbRooms() {
        return nbRooms;
    }

    /**
     * Renseigner le nombre de pièces de la résidence.
     *
     * @param nbRooms le nombre de pièces de la résidence
     */
    public void setNbRooms(int nbRooms) {
        this.nbRooms = nbRooms;
    }

    /**
     * Obtenir le propriétaire de la résidence.
     *
     * @return le propriétaire de la résidence
     */
    @ManyToOne
    public User getOwner() {
        return owner;
    }

    /**
     * Renseigner le propriétaire de la résidence.
     *
     * @param owner le propriétaire de la résidence
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }

    /**
     * Obtenir la liste des radiateurs de la résidence.
     *
     * @return la liste de radiateurs de la résidence
     */
    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST)
    public List<Heater> getHeaters() {
        return heaters;
    }

    /**
     * Renseigner la liste des radiateurs de la résidence.
     *
     * @param heaters la liste des radiateurs de la résidence
     */
    public void setHeaters(List<Heater> heaters) {
        this.heaters = heaters;
    }
}
