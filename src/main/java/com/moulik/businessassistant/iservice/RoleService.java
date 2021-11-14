package com.moulik.businessassistant.iservice;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(Long id) throws RecordNotFoundException;

    Role createRole(Role role);

    Role updateRole(Role newRole, Long id);

    void deleteRoleById(Long id);
}
