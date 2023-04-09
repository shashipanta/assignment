package assignment.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ParkingLotImpl implements ParkingLot{
	
	public static Scanner scanner = new Scanner(System.in);
	private static Map<Integer, Car> parkedCarMap = new HashMap<>(10);
	
	private int spotId;

	@Override
	public int parkCar(Car car) throws ParkingLotFullException {
		
		List<Integer> notOccupiedSpots = getNotOccupiedSpotInfo();
		
		if(notOccupiedSpots.isEmpty()) throw new ParkingLotFullException();
		
		// pick random occupied spot
		int randomIndex = (int) ((Math.random()*10) % notOccupiedSpots.size());
		System.out.println("random index : " + randomIndex + " for notOccupiedList " + notOccupiedSpots);
		spotId = notOccupiedSpots.get(randomIndex);
		parkedCarMap.put(spotId, car);
		
		return spotId;
	}

	@Override
	public boolean isParkingLotFull() {
		return (parkedCarMap.size() == 10) ? true : false;
	}
	
	public boolean isParkingLotEmpty() {
		return (parkedCarMap.size() == 0) ? true : false;
	}

	@Override
	public List<Car> getParkedCars() {
		if(isParkingLotEmpty()) return null;
		List<Car> parkedCarList = new ArrayList<>();
		for(Entry<Integer, Car> mapEntry: parkedCarMap.entrySet()) {
			parkedCarList.add(mapEntry.getValue());
		}
		return parkedCarList;
	}

	@Override
	public int removeCar(int spotId) throws NoCarFoundException {
		if(!parkedCarMap.keySet().contains(spotId)) throw new NoCarFoundException(spotId);
//		parkedCarMap.computeIfPresent(spotId, (key, val) -> parkedCarMap.remove(spotId));
		if(parkedCarMap.containsKey(spotId)){
			parkedCarMap.remove(spotId);
			
		}
		return 0;
	}
	
	public static void viewParkedCarDashboard() {
		String dashboardMsg = "%d - %s - %s";
		for(Entry<Integer, Car> carEntry: parkedCarMap.entrySet()) {
			int spotId = carEntry.getKey();
			String manufacturer = carEntry.getValue().getCarManufacturer();
			int liscenceNumber = carEntry.getValue().getCarNumber();
			System.out.println(String.format(dashboardMsg, spotId, manufacturer, liscenceNumber));
		}
	}
	
	public static List<Integer> getOccupiedInfo() {
		return parkedCarMap.keySet().stream().sorted().toList();
	}
	
	public static List<Integer> getNotOccupiedSpotInfo() {
		List<Integer> totalParkingSpots = new ArrayList<>(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9,10}));
		totalParkingSpots.removeAll(parkedCarMap.keySet().stream().toList());
		return totalParkingSpots;
	}
	
	public void getParkingStatus() {
		String seperator = "----------------------------------------------------------------------";
		System.out.println(seperator);
		System.out.println("                         [ Parking Status ]                           ");
		System.out.println(seperator);
		System.out.println("Occupied spots : " + getOccupiedInfo());
		System.out.println("Vaccant spots  : " + getNotOccupiedSpotInfo());
		System.out.println(seperator);
	}
	
	// MENU
	
	public static int getUserChoice() {
		
		String[] optionsArr = {"  1  : VIEW PARKING STATUS",
							"  2  : PARK CAR",
							"  3  : REMOVE CAR",
							"  4  : PRINT PARKED CAR DETAILS",
							"  5  : VIEW ASCENDING ORDER"
		};
		String seperator = "----------------------------------------------------------------------";
		String menuHeader = ""
				+ "\t                   _    _               _       _    \n"
				+ "\t  _ __  __ _  _ _ | |__(_) _ _   __ _  | | ___ | |_  \n"
				+ "\t | '_ \\/ _` || '_|| / /| || ' \\ / _` | | |/ _ \\|  _| \n"
				+ "\t | .__/\\__,_||_|  |_\\_\\|_||_||_|\\__, | |_|\\___/ \\__| \n"
				+ "\t |_|                            |___/                \n"
				+ "";
		
		System.out.println(seperator);
		System.out.println(menuHeader);
		System.out.println(seperator);
		for(String option: optionsArr) {
			System.out.println(option);
		}
		System.out.println(seperator);
		System.out.print("Enter your choice : \t");
		int userChoice = scanner.nextInt();
		scanner.nextLine();
		return userChoice;
	}

}
