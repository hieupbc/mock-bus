package com.example.mockbus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mockbus.entities.RouteDomain;

public interface RouteRepository extends JpaRepository<RouteDomain, Integer> {

}
