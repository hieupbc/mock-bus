package com.example.mockbus.services.Impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.mockbus.entities.JourneyDomain;
import com.example.mockbus.repositories.JourneyRepository;
import com.example.mockbus.services.JourneyService;

@Service
public class JourneyServiceImpl extends BaseServiceImpl<JourneyDomain, Integer> implements JourneyService  {

	public JourneyServiceImpl(JourneyRepository jpaRepository) {
		super(jpaRepository);
	}

}
