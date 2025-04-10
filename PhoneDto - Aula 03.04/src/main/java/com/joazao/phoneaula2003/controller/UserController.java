package com.joazao.phoneaula2003.controller;


import com.joazao.phoneaula2003.dto.UserDto;
import com.joazao.phoneaula2003.model.User;
import com.joazao.phoneaula2003.repository.UserRepository;
import com.joazao.phoneaula2003.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping ("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    //Métodos Post
    @PostMapping("/create")
    public ResponseEntity<User> creatUser(@RequestBody UserDto createUserDto) {
        var user = userService.createUser(createUserDto);
        System.out.println(createUserDto);
        return ResponseEntity.ok(userRepository.findById(user).get());
    }

    //Métodos Get
    //@GetMapping
//    public ResponseEntity<List<UserDto>> getUsers() {
//        var users = userService.getUsers();
//        return ResponseEntity.ok(users);
//   }

   /*@GetMapping("/{userId}")
    public ResponseEntity<User> getUsersById(@PathVariable ("userId") User user) {
        var userSaved = userRepository.findById(user.getId());
        if (userSaved.isPresent()) {
            return ResponseEntity.ok(userSaved.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateById(@PathVariable ("userId") Long userId, @RequestBody User user) {
        var userEntity = userRepository.findById(userId);

        if (userEntity.isPresent()) {
             var userGet = userEntity.get();
             userGet.setName(user.getName());
             userGet.setEmail(user.getEmail());
           // userGet.setPhones(user.getPhones());
        }
        return ResponseEntity.ok(userRepository.save(user));
    }


    @DeleteMapping ("/{userId}")
    public ResponseEntity<User> deleteById(@PathVariable ("userId") Long userId) {
        var userEntity = userRepository.findById(userId);

        if (userEntity.isPresent()) {
            var userGet = userEntity.get();
            userRepository.delete(userGet);
            return ResponseEntity.ok(userGet);
        }
        return ResponseEntity.notFound().build();
    }
*/

}
