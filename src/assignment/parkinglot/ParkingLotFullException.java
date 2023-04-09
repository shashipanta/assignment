package assignment.parkinglot;

public class ParkingLotFullException extends Throwable{

	private static final long serialVersionUID = 1L;
	
	public ParkingLotFullException() {
		super("Parking lot is full");
	}

}
