package com.aleal.rooms.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PropertiesRooms {

	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;
}
