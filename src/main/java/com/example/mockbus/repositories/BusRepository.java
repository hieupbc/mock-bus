package com.example.mockbus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mockbus.entities.BusDomain;

public interface BusRepository extends JpaRepository<BusDomain, Integer> {

	Page<BusDomain> findAll(Pageable pageable);
}
