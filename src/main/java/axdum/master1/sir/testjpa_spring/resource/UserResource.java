package axdum.master1.sir.testjpa_spring.resource;

import axdum.master1.sir.testjpa_spring.model.User;
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
        return userRepository.findOne(id);
    }
}
