package com.example.mockbus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mockbus.entities.SeatDomain;

public interface SeatRepository extends JpaRepository<SeatDomain, Integer> {

}
