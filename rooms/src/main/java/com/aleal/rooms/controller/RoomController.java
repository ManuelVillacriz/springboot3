package com.aleal.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.rooms.config.RoomsServiceConfiguration;
import com.aleal.rooms.model.PropertiesRooms;
import com.aleal.rooms.model.Room;
import com.aleal.rooms.services.IRoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class RoomController {

	@Autowired
	private IRoomService service;
	
	@Autowired
	private RoomsServiceConfiguration hsc;
	
	@GetMapping("rooms")
	public List<Room> search(){
		return (List<Room>) this.service.search();	
	}
	
	@GetMapping("rooms/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesRooms pm = new PropertiesRooms(hsc.getMsg(), hsc.getBuildVersion(),hsc.getMailDetails());
		String js = owj.writeValueAsString(pm);
		return js;		
	}
}
