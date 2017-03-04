package ParkingLot;

/*
 * Spot:
 * 	-- type
 * 	-- whether available
 */
public class Spot {
	private int level;
	private int id;
	private Main.Type type;
	private boolean available = true;
	private Vehicle car;
	
	Spot(int level, int id, Main.Type type) {
		this.level = level;
		this.id = id;
		this.type = type;
	}
	
	protected int getLevel() {
		return level;
	}
	
	protected int getId() {
		return id;
	}
	
	protected Main.Type getType() {
		return type;
	}
	
	protected boolean isAvailable() {
		return this.available;
	}
	
	protected Vehicle getVehicle() {
		return this.car;
	}
	
	protected void parking(Vehicle car) {
		this.car = car;
		this.available = false;
	}
	
	protected void leaving(Vehicle car) {
		this.car = null;
		this.available = true;
	}
}
