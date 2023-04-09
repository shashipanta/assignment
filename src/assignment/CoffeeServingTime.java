package assignment;

import java.util.Arrays;

public class CoffeeServingTime {
	
	public static final int totalRows = 30;
    public static final int coffeePotCapacity = 7;
    public static final int rowTravelTime = 1;
    public static final int timeToFillCup = 3;
    public static final int timeToFillPot = 30;    
    
    public static int findCoffeeServingTime(int[] coffeeRequestedRow) {
    	int totalRequest = coffeeRequestedRow.length;
    	
    	if(totalRequest == 0 ) return 0;
    	
    	int lastRowToServe = coffeeRequestedRow[totalRequest - 1];
    	
    	int timeToFillRequestedCup = totalRequest * timeToFillCup;
    	int timeToFillPotDuringServing = coffeePotCapacity != totalRequest ? totalRequest / coffeePotCapacity * timeToFillPot: 0;
    	int timeToTraverseRow = (lastRowToServe - 1) * 2 * rowTravelTime;
    	
    	return timeToFillRequestedCup + timeToFillPotDuringServing + timeToTraverseRow;
    	
    }
    
	
	public static int findTotalTimeToServe(int[] coffeeRequestedRow) {
		if(coffeeRequestedRow.length == 0) return 0;
		
		int totalTimeTaken = 0;
		int servedPassengersIndex = 0;
		int currentCoffeePotCapacity = coffeePotCapacity;

		// lets sort requestCoffeeRows in case it needs

		int lastRequestRow = coffeeRequestedRow[coffeeRequestedRow.length - 1];
		//	System.out.println("Last row " + lastRequestRow);
	    
		// we dont need to traverse all n rows if we have m last requests where m < n
		for(int i=1; i <= lastRequestRow; i++) {

			if(currentCoffeePotCapacity <= 0) {
				currentCoffeePotCapacity = 7;
				totalTimeTaken += timeToFillPot;
			}

			// fill and serve coffee for requested passengers
			if(i == coffeeRequestedRow[servedPassengersIndex]) {
				totalTimeTaken += timeToFillCup;

				// decrease the coffee capacity 
				currentCoffeePotCapacity--;
				servedPassengersIndex++;
			}
			// simulate row traversal

			totalTimeTaken += rowTravelTime;
		}

		return totalTimeTaken + lastRequestRow * rowTravelTime - 2;
		
	}
	
	
	public static void main(String[] args) {
		int[] requestedCoffeeRows = {3, 4, 5, 7, 10, 13, 18, 20, 24, 25};
		int[] requestedCoffeeRows1 = {};
		int[] requestedCoffeRows2 = {1,2, 3, 4,5, 6, 7, 8, 9, 10,15,20, 21, 22, 23, 25,30};
		
		System.out.println("For Array     : " + Arrays.toString(requestedCoffeeRows) );
		System.out.println("Time to serve : " + findTotalTimeToServe(requestedCoffeeRows));
		System.out.println();
		System.out.println("For Array     : " + Arrays.toString(requestedCoffeeRows1) );
		System.out.println("Time to serve : " + findTotalTimeToServe(requestedCoffeeRows1));
		System.out.println();
		System.out.println("For Array     : " + Arrays.toString(requestedCoffeRows2) );
		System.out.println("Time to serve : " + findTotalTimeToServe(requestedCoffeRows2));
		
//		System.out.println(findCoffeeServingTime(requestedCoffeRows2));
	}
	
	

}
