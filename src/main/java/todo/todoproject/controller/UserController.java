package todo.todoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.todoproject.entity.User;
import todo.todoproject.repository.UserRepository;

import java.util.List;
import java.util.UUID;


@RestController
public class UserController {

    @Autowired
private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:5500")
    @PostMapping("/newuser")
    ResponseEntity<User> registerUser(@RequestBody User newUser)  {
        List<User> allUsers = userRepository.findAll();
        for(User u : allUsers) {
            if (u.getEmail().equals(newUser.getEmail())) {
                return null;
            }
        }
        userRepository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:5500")
    @GetMapping("/getUserID/{user}/{pw}")
    public UUID checkUser(@PathVariable(name="user") String user, @PathVariable(name="pw") String pw){

        User u = new User();
        u.setEmail(user);
        u.setPassword(pw);

        List<User> allUsers = userRepository.findAll();
        for(User x : allUsers) {
            if (u.getEmail().equals(x.getEmail())) {
                if(u.getPassword().equals(x.getPassword())){
                    return x.getId();
                }
            }
        }
        return null;
    }
}
