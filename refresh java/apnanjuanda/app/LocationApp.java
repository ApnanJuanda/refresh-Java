package apnanjuanda.app;

import apnanjuanda.data.City;

public class LocationApp {
	public static void main(String[] args) {
		//Location location = new Location("city"); //error
		City city = new City("Bandung");
		System.out.println("Kota: " + city.name);
	}
}	
