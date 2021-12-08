package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.UserService;
import com.moulik.businessassistant.model.Role;
import com.moulik.businessassistant.model.User;
import com.moulik.businessassistant.repository.RoleRepository;
import com.moulik.businessassistant.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setPassword(user.getPassword());
//        user.setPassword(user.getPassword());
        user.setActive(true);
//        Role userRole = roleRepository.findByName("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersByRoleId(long roleId) {
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.getById(roleId);
        roles.add(role);
        return userRepository.findAllByRoles(roles);
    }

    public User getUserById(Long id) throws RecordNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public User createUser(User user) {
        return saveUser(user);
    }

    public User updateUser(User newUser, Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setEmail(newUser.getEmail());
                    user.setUserName(newUser.getUserName());
                    user.setRoles(newUser.getRoles());
//                    user.setPassword(passwordEncoder.encode(newUser.getPassword()));
//                    user.setPassword(newUser.getPassword());
                    user.setPhone(newUser.getPhone());
                    user.setAddress(newUser.getAddress());
                    user.setActive(newUser.getActive());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return saveUser(newUser);
                });
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<String> getUserList() {
        return userRepository.getUserList();
    }
}
