package com.moulik.businessassistant.repository;

import com.moulik.businessassistant.model.Role;
import com.moulik.businessassistant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
    boolean existsByEmail(String email);
    boolean existsByUserName(String username);
    @Query("SELECT userName FROM User order by userName")
    List<String> getUserList();

}
