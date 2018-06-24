package com.example.mockbus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mockbus.entities.TicketDomain;

public interface TicketRepository extends JpaRepository<TicketDomain, Integer> {

}
