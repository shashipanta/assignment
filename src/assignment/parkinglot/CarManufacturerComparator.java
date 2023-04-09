package assignment.parkinglot;

import java.util.Comparator;

public class CarManufacturerComparator implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		return o1.getCarManufacturer().compareTo(o2.getCarManufacturer());
	}

}
