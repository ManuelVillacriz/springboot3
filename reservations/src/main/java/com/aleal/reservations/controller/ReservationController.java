package com.aleal.reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.reservations.config.ReservationsServiceConfiguration;
import com.aleal.reservations.model.PropertiesReservations;
import com.aleal.reservations.model.Reservation;
import com.aleal.reservations.services.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ReservationController {
	
	@Autowired
	private IReservationService service;
	
	@Autowired
	private ReservationsServiceConfiguration hsc; 
	

	@GetMapping("reservations")
	public List<Reservation> search(){
		return (List<Reservation>) this.service.search();	
	}
	
	@GetMapping("reservations/read/properties")
	public String getPropertiesReservations() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesReservations pm = new PropertiesReservations(hsc.getMsg(), hsc.getBuildVersion(),hsc.getMailDetails());
		String js = owj.writeValueAsString(pm);
		return js;		
	}

}
