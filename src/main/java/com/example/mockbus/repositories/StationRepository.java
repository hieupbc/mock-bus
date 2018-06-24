package com.example.mockbus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mockbus.entities.StationDomain;

public interface StationRepository extends JpaRepository<StationDomain, Integer> {

}
