package com.moulik.businessassistant.controller.api;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(Model model) {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws RecordNotFoundException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/users/edit/{id}")
    public User editUserById(@RequestBody User newUser, @PathVariable(value = "id") Long userId) {
        return userService.updateUser(newUser, userId);
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long userId){
        userService.deleteUserById(userId);
    }
}
