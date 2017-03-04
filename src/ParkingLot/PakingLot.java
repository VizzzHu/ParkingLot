package ParkingLot;

import java.util.*;

// structure:
// have multiple levels
// each level has multiple spots
// check whether hasSpot

/*
 * Structure:
 * 	-- have multiple levels
 * Functions:
 *  -- total available spots
 * 	-- check whether has available spots
 *  -- parking
 *  -- leaving
 */
public class PakingLot {
	private List<Level> levels;
	int levelNum = 0;
	int emptySpots = 0;
	
	PakingLot(int levelNum) {
		this.levelNum = levelNum;
		levels = new ArrayList<Level>();
		for (int i = 0; i < levelNum; i++) {
			levels.add(new Level(i, 20));
		}
		emptySpots = calculateEmptySpots();
	}
	
	public void parking(Vehicle car) {
		Spot newSpot = hasSpots(car);
		if (newSpot != null) {
			System.out.println("Welcome!" + car.getTitle());
			System.out.println("Your car size is: " + car.getSize());
			System.out.println("Please park at Level " + newSpot.getLevel() + " Spot No. " + newSpot.getId());
		} else {
			System.out.println("Sorry, the parking lot is full.");
		}
		System.out.println("-----------------------------");

	}
	
	public void leaving(Vehicle car) {	
		Spot oldSpot = getSpot(car);
		if (oldSpot != null) {
			System.out.println("Thank you for your parking!" + car.getTitle());
			System.out.println("Level " + oldSpot.getLevel() + " Spot No. " + oldSpot.getId());
		} else {
			System.out.println("Sorry, please pay first.");
		}
		System.out.println("-----------------------------");
	}
	
	private Spot getSpot(Vehicle car) {
		for (int i = 0; i < levelNum; i++) {
			Spot newSpot = levels.get(i).getSpot(car);
			if ( newSpot != null) {
				return newSpot;
			}
		}
		return null;
	}
	
	private Spot hasSpots(Vehicle car) {
		for (int i = 0; i < levelNum; i++) {
			Spot newSpot = levels.get(i).hasSpots(car);
			if ( newSpot != null) {
				return newSpot;
			}
		}
		return null;
	}
	
	public int getEmptySpots() {
		return emptySpots;
	}
	
	private int calculateEmptySpots() {
		int temp = 0;
		for (int i = 0; i < levelNum; i++) {
			temp += levels.get(i).getEmptySpots();
		}
		return temp;
	}
	
	
	
}
