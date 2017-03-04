package ParkingLot;

public class Vehicle {
	String title;
	Main.Type size;
	
	Vehicle(String title, Main.Type size) {
		this.title = title;
		this.size = size;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Main.Type getSize() {
		return size;
	}
}
