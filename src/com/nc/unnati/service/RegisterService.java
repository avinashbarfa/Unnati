package com.nc.unnati.service;

import java.util.ArrayList;
import java.util.List;

public class RegisterService {

	public static List<String> getAllStates() {
		
		List<String> states = new ArrayList<>();
		
		states.add("Madhya Pradesh");
		states.add("Maharastra");
		states.add("Punjab");
		
		return states;
		
	}
}
