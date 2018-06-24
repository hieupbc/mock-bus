package com.example.mockbus.repositories;

import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.entities.UserDomain;

import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDomain, Long> {

    Optional<UserDomain> findUserDomainByEmail(String email);

    List<UserDomain> findUserDomainByRoles(RoleDomain roleDomain);

    List<UserDomain> findUserDomainByCreatedAtBefore(Instant instant);

    List<UserDomain> findUserDomainByNameIsLike(String s);

    List<UserDomain> findTop10ByNameLikeOrderById(String s);

    Page<UserDomain> findAll(Pageable pageable);

    Page<UserDomain> findUserDomainByNameIsLike(String name,Pageable pageable);
    
    
}
