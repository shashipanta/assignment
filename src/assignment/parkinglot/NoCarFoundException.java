package assignment.parkinglot;

public class NoCarFoundException extends Throwable{
	
	private static final long serialVersionUID = -101381317420750548L;

	public NoCarFoundException(int spotId) {
		super("No car found in given spot : " + spotId);
	}

}
