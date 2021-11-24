package com.moulik.businessassistant.service;

import com.moulik.businessassistant.exception.RecordNotFoundException;
import com.moulik.businessassistant.iservice.RoleService;
import com.moulik.businessassistant.model.Role;
import com.moulik.businessassistant.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sadman
 */
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) throws RecordNotFoundException {
        return roleRepository.getById(id);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Role newRole, Long id) {
        return roleRepository.findById(id)
                .map(role -> {
                    role.setName(newRole.getName());
                    return roleRepository.save(role);
                })
                .orElseGet(() -> {
                    newRole.setId(id);
                    return roleRepository.save(newRole);
                });
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}
