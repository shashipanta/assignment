package assignment.parkinglot;

import java.util.List;

public interface ParkingLot {
	public int parkCar(Car car) throws ParkingLotFullException;
	public int removeCar(int spotId) throws NoCarFoundException;
	public boolean isParkingLotFull();
	public List<Car> getParkedCars();

}
