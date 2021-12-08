package com.moulik.businessassistant.iservice;



import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.User;

import java.util.List;

/**
 * @author Sadman
 */
public interface UserService {
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
    User findUserByEmail(String email);
    User findUserByUserName(String userName);
    User saveUser(User user);
    List<User> getAllUsers();
    List<User> getAllUsersByRoleId(long roleId);
    User getUserById(Long id) throws RecordNotFoundException;
    User createUser(User user);
    User updateUser(User newUser, Long id);
    void deleteUserById(Long id);
    List<String> getUserList();
}
