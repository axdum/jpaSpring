package axdum.master1.sir.testjpa_spring.model;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "home", catalog = "jpaspring")
public class Home {
  private Long id;
  private String name;
  private int size;
  private int nbRooms;
  @JsonManagedReference
  private User owner;
  @JsonBackReference
  private List<Heater> heaters;

  /**
   * Empty constructor of Home.
   */
  public Home() {
    super();
    heaters = new ArrayList<Heater>();
  }

  /**
   * Home constructor with Id.
   */
  public Home(Long id) {
    super();
    this.id = id;
  }

  /**
   * Home constructor with paramaters.
   *
   * @param name    the name
   * @param size    the surface (m3)
   * @param nbRooms the number of rooms
   * @param owner   the owner
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
   * Home constructor withour paramaters.
   *
   * @param name    the name
   * @param size    the surface (m3)
   * @param nbRooms the number of rooms
   */
  public Home(String name, int size, int nbRooms) {
    super();
    this.name = name;
    this.size = size;
    this.nbRooms = nbRooms;
  }

  /**
   * Add a heater to the Home.
   *
   * @param heater the heater
   */
  public void addHeater(Heater heater) {
    this.heaters.add(heater);
  }

  /**
   * Get the ID.
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
   * Renseigner le nom de la résidence.
   *
   * @param name le nom de la résidence
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get the surface.
   *
   * @return the surface
   */
  public int getSize() {
    return size;
  }

  /**
   * Set the surface.
   *
   * @param size the surface
   */
  public void setSize(int size) {
    this.size = size;
  }

  /**
   * Get the number of rooms.
   *
   * @return the number of rooms
   */
  public int getNbRooms() {
    return nbRooms;
  }

  /**
   * Set the number of rooms.
   *
   * @param nbRooms the number of rooms
   */
  public void setNbRooms(int nbRooms) {
    this.nbRooms = nbRooms;
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

  /**
   * Get the heaters list.
   *
   * @return the heaters list
   */
  @OneToMany(mappedBy = "home", cascade = CascadeType.ALL)
  public List<Heater> getHeaters() {
    return heaters;
  }

  /**
   * Set the heaters list.
   *
   * @param heaters the heaters list
   */
  public void setHeaters(List<Heater> heaters) {
    this.heaters = heaters;
  }
}
