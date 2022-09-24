package todo.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import todo.todoproject.entity.User;
import todo.todoproject.repository.UserRepository;
import java.util.List;

@RestController
public class UserController {

    @Autowired
private UserRepository userRepository;

    @CrossOrigin
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
