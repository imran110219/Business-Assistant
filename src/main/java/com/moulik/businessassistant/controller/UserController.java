package com.moulik.businessassistant.controller;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.RoleService;
import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.model.Role;
import com.moulik.businessassistant.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> list = userService.getAllUsers();
        List<Role> roleList = roleService.getAllRoles();
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleList);
        model.addAttribute("users", list);
        return "user";
    }

    @GetMapping(value={"/login","/"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping(value="/users/checkEmail")
    public ResponseEntity<Boolean> checkEmail(String email){
        boolean isEmail = !userService.existsByEmail(email);
        return new ResponseEntity<>(isEmail, HttpStatus.OK);
    }

    @PostMapping(value="/users/checkUsername")
    public ResponseEntity<Boolean> checkUsername(String username){
        boolean isUsername = !userService.existsByUserName(username);
        return new ResponseEntity<>(isUsername, HttpStatus.OK);
    }

    @PostMapping(value="/users/add")
    public ResponseEntity<String> addUser(User user){
        userService.createUser(user);
        return new ResponseEntity<>("User is added successfully", HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws RecordNotFoundException {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/users/edit/{id}")
    public ResponseEntity<String> editUserById(@RequestBody User newUser, @PathVariable(value = "id") Long userId) {
        userService.updateUser(newUser, userId);
        return new ResponseEntity<>("User is Edited Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/users/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteUserById(@PathVariable(value = "id") Long userId){
        userService.deleteUserById(userId);
        return new ResponseEntity<>("User is Deleted Successfully", HttpStatus.OK);
    }
}
