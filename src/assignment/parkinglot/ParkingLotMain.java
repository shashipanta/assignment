package assignment.parkinglot;

import java.util.Random;

public class ParkingLotMain {

	static ParkingLotImpl parkingLotImpl = new ParkingLotImpl();

	static {
		Car car1 = new Car("Honda", 123);
		Car car2 = new Car("Ambani", 4359);
		Car car3 = new Car("Honda", 6480);
		Car car5 = new Car("Bhandari", 4359);
		Car car8 = new Car("Suzuki", 4359);
		Car car9 = new Car("Honda", 2309);
		Car car12 = new Car("Honda", 9423);


		try {
			parkingLotImpl.parkCar(car1);
			parkingLotImpl.parkCar(car2);
			parkingLotImpl.parkCar(car3);
			parkingLotImpl.parkCar(car5);
			parkingLotImpl.parkCar(car12);
			parkingLotImpl.parkCar(car8);
			parkingLotImpl.parkCar(car9);
		} catch (ParkingLotFullException e) {
			System.out.println(e.fillInStackTrace());
		}

	}

	public static void main(String[] args) {


		boolean runProgram = true;


		do {
			int userChoice = ParkingLotImpl.getUserChoice();
			switch (userChoice) {
			case 1: {
				parkingLotImpl.getParkingStatus();
				break;
			}
			case 2: {
				// park car
				try {
					int leftLimit = 97; // letter 'a'
				    int rightLimit = 122; // letter 'z'
				    int targetStringLength = 5;
				    Random random = new Random();
					String generatedString = random.ints(leftLimit, rightLimit + 1)
						      .limit(targetStringLength)
						      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
						      .toString();
					
					parkingLotImpl.parkCar(new Car("*"+generatedString, (int)(Math.random()*10000)));
				} catch (ParkingLotFullException e) {
					System.out.println(e.fillInStackTrace());
				}
				break;
			}
			case 3: {
				// remove parked car
				System.out.print("Enter parkingSpot to clear : \t");
				int carSpotId = ParkingLotImpl.scanner.nextLine().charAt(0) - '0';
				try {
					parkingLotImpl.removeCar(carSpotId);
				} catch (NoCarFoundException e) {
					// TODO Auto-generated catch block
					System.out.println(e.fillInStackTrace());
				}
				break;
			}
			case 4: {
				// print parked car details
				ParkingLotImpl.viewParkedCarDashboard();
				break;
			}
			case 5: {
				// view parked car in ascending order
				parkingLotImpl.getParkedCars().stream()
								.sorted(new CarManufacturerComparator())
								.forEach(car -> {
									System.out.println(String.format("%d - %s ", car.getCarNumber(),car.getCarManufacturer()));
								});
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + userChoice);
			}

			System.out.print("Press y to exit (y | Y): \t");
			char continueProgram = ParkingLotImpl.scanner.nextLine().charAt(0);
			if(Character.compare(Character.toLowerCase(continueProgram),'y') == 0) runProgram = !runProgram;


		}while(runProgram);

	}

}
