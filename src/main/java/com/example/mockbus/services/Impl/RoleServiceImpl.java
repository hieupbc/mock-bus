package com.example.mockbus.services.Impl;

import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.repositories.RoleRepository;
import com.example.mockbus.services.RoleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<RoleDomain,Integer> implements RoleService {
    public RoleServiceImpl(RoleRepository jpaRepository) {
        super(jpaRepository);
    }
}
