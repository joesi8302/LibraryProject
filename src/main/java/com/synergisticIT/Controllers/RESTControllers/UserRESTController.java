package com.synergisticIT.Controllers.RESTControllers;

import com.synergisticIT.Domain.User;
import com.synergisticIT.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList =  userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirlines(@PathVariable Integer id){
        User user = userService.getUserById(id);
        if(user != null){
            userService.deleteUser(id);
            return new ResponseEntity<>("User deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("User of id " + id+ " was not found", HttpStatus.NOT_FOUND);
        }
    }
}
