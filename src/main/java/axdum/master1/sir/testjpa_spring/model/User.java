package axdum.master1.sir.testjpa_spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "id")
@Table(name = "user", catalog = "jpaspring")
public class User {
  private Long id;
  private String pseudo;
  private String firstName;
  private String name;
  private String mail;
  @JsonBackReference
  private List<Home> homes;
  @JsonIgnore
  private List<User> friends;
  @JsonBackReference
  private List<ElectronicDevice> electronicDevices;

  /**
   * Empty constructor of User.
   */
  public User() {
    super();
    homes = new ArrayList<Home>();
    friends = new ArrayList<User>();
    electronicDevices = new ArrayList<ElectronicDevice>();
  }

  /**
   * * User Constructor with paramaters.
   *
   * @param pseudo    the nickname
   * @param firstName the name
   * @param name      the first name
   * @param mail      the mail address
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

  /**
   * Add a friend.
   *
   * @param friend the friend
   */
  public void addFriend(User friend) {
    this.friends.add(friend);
  }

  /**
   * Add a home.
   *
   * @param home the home
   */
  public void addHome(Home home) {
    this.homes.add(home);
  }

  /**
   * Add an electronic device.
   *
   * @param electronicDevice the electronic device
   */
  public void addElectronicDevice(ElectronicDevice electronicDevice) {
    this.electronicDevices.add(electronicDevice);
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
   * Get the nickname.
   *
   * @return the nickname
   */
  @Column(unique = true)
  public String getPseudo() {
    return pseudo;
  }

  /**
   * Set the nickname.
   *
   * @param pseudo the nickname
   */
  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  /**
   * Get the first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
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
   * Get the mail address.
   *
   * @return the mail address
   */
  public String getMail() {
    return mail;
  }

  /**
   * Set the mail address.
   *
   * @param mail the email address
   */
  public void setMail(String mail) {
    this.mail = mail;
  }

  /**
   * Get the homes list.
   *
   * @return the homes list
   */
  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
  public List<Home> getHomes() {
    return homes;
  }

  /**
   * Set the homes list.
   *
   * @param homes the homes list
   */
  public void setHomes(List<Home> homes) {
    this.homes = homes;
  }

  /**
   * Get the friends list.
   *
   * @return the friends list
   */
  @ManyToMany(cascade = CascadeType.ALL)
  public List<User> getFriends() {
    return friends;
  }

  /**
   * Set the friends list.
   *
   * @param friends the friends list
   */
  public void setFriends(List<User> friends) {
    this.friends = friends;
  }

  /**
   * Get the electronic devices list.
   *
   * @return the electronic devices list
   */
  @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
  public List<ElectronicDevice> getElectronicDevices() {
    return electronicDevices;
  }

  /**
   * Set the electronic devices list.
   *
   * @param electronicDevices the electronic devices list
   */
  public void setElectronicDevices(List<ElectronicDevice> electronicDevices) {
    this.electronicDevices = electronicDevices;
  }
}
