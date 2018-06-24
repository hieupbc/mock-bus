package com.example.mockbus.services.Impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.mockbus.entities.TicketDomain;
import com.example.mockbus.repositories.TicketRepository;
import com.example.mockbus.services.TicketService;

@Service
public class TicketServiceImpl extends BaseServiceImpl<TicketDomain, Integer> implements TicketService {

	public TicketServiceImpl(TicketRepository jpaRepository) {
		super(jpaRepository);
	}

}
