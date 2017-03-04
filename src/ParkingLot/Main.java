package ParkingLot;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		// design a paking lot
		// user case 1: give a car an available paking spot
		// user case 2: a car leave paking spot
		// Objects: paking lot, car
		PakingLot parkingLot = new PakingLot(3);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		for (int i = 0; i < 20; i++) {
			String title = getSaltString();
			Vehicle newCar = new Vehicle(title, Type.Compact);
			vehicles.add(newCar);
			parkingLot.parking(newCar);
		}
		
		for (int i = 0; i < 20; i++) {
			parkingLot.leaving(vehicles.get(i));
		}
	}

	protected static String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	enum Type {
		Compact, Normal;
	};

}