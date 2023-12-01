package com.aleal.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.config.HotelsServiceConfiguration;
import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.model.PropertiesHotels;
import com.aleal.hotels.services.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private HotelsServiceConfiguration hsc;
	
	@GetMapping("hotels")
	public List<Hotel> search(){
		return (List<Hotel>) this.service.search();	
	}
	
	@GetMapping("hotels/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels pm = new PropertiesHotels(hsc.getMsg(), hsc.getBuildVersion(),hsc.getMailDetails());
		String js = owj.writeValueAsString(pm);
		return js;		
	}

}
