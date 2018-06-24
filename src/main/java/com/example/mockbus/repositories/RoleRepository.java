package com.example.mockbus.repositories;

import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleDomain, Integer> {
    Optional<RoleDomain> findRoleDomainByName(RoleName name);
}
