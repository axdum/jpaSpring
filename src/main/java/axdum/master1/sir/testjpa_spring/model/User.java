package axdum.master1.sir.testjpa_spring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user", catalog = "jpaspring")
public class User {
    private Long id;
    private String pseudo;
    private String firstName;
    private String name;
    private String mail;
    private List<Home> homes;
    private List<User> friends;
    private List<ElectronicDevice> electronicDevices;

    /**
     * Constructeur User vide.
     */
    public User() {
        super();
        homes = new ArrayList<Home>();
        friends = new ArrayList<User>();
        electronicDevices = new ArrayList<ElectronicDevice>();
    }

    /**
     * Constructeur User.
     *
     * @param firstName le nom de la personne
     * @param name      le prénom de la personne
     * @param mail      le mail de la personne
     */
    public User(String pseudo, String firstName, String name, String mail) {
        super();
        this.pseudo = pseudo;
        this.firstName = firstName;
        this.name = name;
        this.mail = mail;
        homes = new ArrayList<Home>();
        friends = new ArrayList<User>();
        electronicDevices = new ArrayList<ElectronicDevice>();
    }
/*
    public List<Heater> listHeaters() {
        ArrayList heaters = new ArrayList<Heater>();
        for (Home home : this.homes) {
            heaters.addAll(home.getHeaters());
        }
        return heaters;
    }

    public List<SmartDevice> getSmartDevices(){
        ArrayList<SmartDevice> smartDevices = new ArrayList<SmartDevice>();
        for (Home home : this.homes) {
            smartDevices.addAll(home.getHeaters());
        }
        smartDevices.addAll(this.electronicDevices);
        return smartDevices;
    }*/

    /**
     * Ajouter un ami.
     *
     * @param friend l'ami
     */
    public void addFriend(User friend) {
        this.friends.add(friend);
    }

    /**
     * Ajouter une résidence.
     *
     * @param home la résidence
     */
    public void addHome(Home home) {
        this.homes.add(home);
    }

    /**
     * Ajouter un appareil électronique.
     *
     * @param electronicDevice l'appareil électronique
     */
    public void addElectronicDevice(ElectronicDevice electronicDevice) {
        this.electronicDevices.add(electronicDevice);
    }

    /**
     * Obtenir l'ID de la personne.
     *
     * @return l'ID de la personne
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Renseigner l'ID de la personne.
     *
     * @param id l'ID de la personne
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtenir le pseudo de la personne.
     *
     * @return le pseudo de la personn
     */
    @Column(unique=true)
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Renseigner le pseudo de la personne.
     *
     * @param pseudo le pseudo de la personne
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Obtenir le prénom de la personne.
     *
     * @return le prénom de la personne
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Renseigner le prénom de la personne.
     *
     * @param firstName le prénom de la personne
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Obtenir le nom de la personne.
     *
     * @return le nom de la personne
     */
    public String getName() {
        return name;
    }

    /**
     * Rensigner le nom de la personne.
     *
     * @param name le nom de la personne
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtenier le mail de la personne.
     *
     * @return le mail de la personne
     */
    public String getMail() {
        return mail;
    }

    /**
     * Renseigner le mail de la personne.
     *
     * @param mail le mail de la personne
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Obtenir la liste des résidences de la personne.
     *
     * @return la liste des résidences de la personne
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    public List<Home> getHomes() {
        return homes;
    }

    /**
     * Renseigner la liste des résidences de la personne.
     *
     * @param homes la liste des résidences de la personne
     */
    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    /**
     * Obtenir la liste des amis de la personne.
     *
     * @return la liste des amis de la personne
     */
    @ManyToMany
    public List<User> getFriends() {
        return friends;
    }

    /**
     * Renseigner la liste des amis de la personne.
     *
     * @param friends la liste des amis de la personne
     */
    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    /**
     * Obtenir la liste des appareils electroniques de la personne.
     *
     * @return la liste des appareils electroniques de la personne
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    public List<ElectronicDevice> getElectronicDevices() {
        return electronicDevices;
    }

    /**
     * Renseigner la liste des appareils electroniques de la personne.
     *
     * @param electronicDevices la liste des appareils electroniques de la personne
     */
    public void setElectronicDevices(List<ElectronicDevice> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }
}
