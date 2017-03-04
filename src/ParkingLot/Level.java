package ParkingLot;
import java.util.*;

/*
 * Structure:
 *  -- multiple spot
 *  -- whether has available spot
 */
public class Level {
	int size = 0;
	int id;
	int emptySpots = 0;
	private List<Spot> spots;
	
	Level(int id, int size) {
		this.id = id;
		this.size = size;
		emptySpots = this.size;
		spots = new ArrayList<Spot>();
		for (int i = 0; i < size; i = i + 1) {
			if (i < size / 2) {
				spots.add(new Spot(id, i, Main.Type.Normal));
			} else {
				spots.add(new Spot(id, i, Main.Type.Compact));
			}
		}		
	}
	
	protected int getEmptySpots() {
		return emptySpots;
	}
	
	protected Spot hasSpots(Vehicle car) {
		for (int i = 0; i < size; i++) {
			Spot newSpot = spots.get(i);
			if (newSpot.isAvailable() && newSpot.getType() == car.getSize()) {
				newSpot.parking(car);
				emptySpots--;
				return newSpot;
			}
		}
		return null;
	}
	
	protected Spot getSpot(Vehicle car) {
		for (int i = 0; i < size; i++) {
			Spot newSpot = spots.get(i);
			if (!newSpot.isAvailable() && newSpot.getVehicle().equals(car)) {
				newSpot.leaving(car);
				emptySpots++;
				return newSpot;
			}
		}
		return null;
	}
	
	
	
	
}
