package assignment.parkinglot;

public class Car extends CarManufacturerComparator{
	
	private String carManufacturer;
	private int carNumber;
	
	public Car(String carManufacturer, int carNumber) {
		super();
		this.carManufacturer = carManufacturer.toUpperCase();
		this.carNumber = carNumber;
	}
	public String getCarManufacturer() {
		return carManufacturer;
	}
	public void setCarManufacturer(String carManufacturer) {
		this.carManufacturer = carManufacturer;
	}
	public int getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	@Override
	public String toString() {
		return "Car [carManufacturer=" + carManufacturer + ", carNumber=" + carNumber + "]";
	}

}
