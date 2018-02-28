package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.*;
import axdum.master1.sir.testjpa_spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/user")
public class UserResource {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{nickname}")
    public List<User> getUser(@PathVariable("nickname") final String nickname) {
        return userRepository.findByName(nickname);
    }

    @GetMapping("/id/{id}")
    public User getId(@PathVariable("id") final Integer id) {
        return userRepository.getOne(id);
    }

    @GetMapping("/{id}/homes")
    public List<Home> getHomes(@PathVariable("id") final Integer id) {
        return userRepository.getOne(id).getHomes();
    }

    @GetMapping("/{id}/friends")
    public List<User> getFriends(@PathVariable("id") final Integer id) {
        return userRepository.getOne(id).getFriends();
    }
/*
    @GetMapping("/{id}/smartdevices")
    public List<SmartDevice> getSmartDevices(@PathVariable("id") final Integer id) {
        return userRepository.getOne(id).getSmartDevices();
    }
*/
    @GetMapping("/{id}/electronic")
    public List<ElectronicDevice> getElecDevices(@PathVariable("id") final Integer id) {
        return userRepository.getOne(id).getElectronicDevices();
    }
/*
    @GetMapping("/{id}/heaters")
    public List<Heater> getHeaters(@PathVariable("id") final Integer id) {
        return userRepository.getOne(id).getHeaters();
    }
*/
    @GetMapping("/update/{id}/name/{name}")
    public User updateName(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {


        User user = getId(id);
        user.setName(name);

        return userRepository.save(user);
    }

    @GetMapping("/update/{id}/firstname/{firstname}")
    public User updateFirstName(@PathVariable("id") final Integer id, @PathVariable("firstname") final String firstname) {
        User user = getId(id);
        user.setFirstName(firstname);

        return userRepository.save(user);
    }

    @GetMapping("/update/{id}/nickname/{nickname}")
    public User updateNickname(@PathVariable("id") final Integer id, @PathVariable("nickname") final String nickname) {
        User user = getId(id);
        user.setPseudo(nickname);

        return userRepository.save(user);
    }

    @GetMapping("/update/{id}/mail/{mail}")
    public User updateMail(@PathVariable("id") final Integer id, @PathVariable("mail") final String mail) {
        User user = getId(id);
        user.setMail(mail);

        return userRepository.save(user);
    }
}
