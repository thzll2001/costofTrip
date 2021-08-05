package com.david.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class LocationObj implements Serializable {
	Map<String, LocationElement > locations= null;

	public Map<String, LocationElement> getLocations() {
		return locations;
	}

	public void setlocations(Map<String, LocationElement> locations) {
		this.locations = locations;
	}
	
}