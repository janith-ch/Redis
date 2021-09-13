package com.example.redisdemo.Sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/redis/v1")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public List<User> getUsers() {

        Map<String, User> userMap = userRepository.getAll();

        List<User> userList = new ArrayList<>(userMap.values());

        return userList;
    }

    @PostMapping("/")
    public void createUser(@RequestBody User user) {

        userRepository.create(user);

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {

        return userRepository.delete(id);
    }

    @PutMapping("/")
    public String userUpdate(@RequestBody User user) {

        return userRepository.update(user);
    }

    @GetMapping("/user/{id}")
    public Object getById(@PathVariable int id) {

        return  userRepository.get(id);

    }

}
