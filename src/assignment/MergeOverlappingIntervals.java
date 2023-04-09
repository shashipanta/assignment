package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingIntervals {
	
	/*
	 * 3) Given an sorted collection of intervals where intervals[i] = [starti,endi]
	 * , merge all overlapping intervals, and return a collection of the
	 * non-overlapping intervals that cover all the intervals in the input.
	 * 
	 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
	 * [[1,6],[8,10],[15,18]]
	 */
	
	public static int[] merge(int[] left, int[] right) {
		return new int[] {left[0], right[1]};
	}
	
	
	public static void main(String[] args) {
		
		List<int[]> intervals = new ArrayList<>();
		List<int[]> mergedIntervals = new ArrayList<>();
		intervals.add(new int[] {1,3});
//		intervals.add(new int[] {2,6});
		intervals.add(new int[] {8,10});
		intervals.add(new int[] {15,18});
//		intervals.add(new int[] {17, 31});
		
		
		int nextIntervalIndex = 0;
		for(int i=0; i<intervals.size(); i++) {
			int[] leftArr = intervals.get(i);
			int[] rightArr = null;
		
			try {
				
				nextIntervalIndex = i+1;
				rightArr = intervals.get(nextIntervalIndex);
				
			}catch (Exception e) {
				// last element add directly
				mergedIntervals.add(leftArr);
				break;
			}
			if(leftArr[1] >= rightArr[0]) {
				mergedIntervals.add(merge(leftArr, rightArr));
				// [] + [] so skip one 
				i++;
			} else {
				mergedIntervals.add(leftArr);
			}
		}

		System.out.println("Initial Intervals : ");
		intervals.stream().map(intArr -> Arrays.toString(intArr)).forEach(System.out::println);
		System.out.println("Merged Intervals : ");
		mergedIntervals.stream().map(intArr -> Arrays.toString(intArr) ).forEach(System.out::println);	
		
	}

}
