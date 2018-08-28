package recursion;

import java.util.Arrays;
import java.util.List;

/**
 * A magic index in an array is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index,
 * if one exists, otherwise return -1.
 */
public class MagicIndex {
	/**
	 * Binary search O(log n)
	 */
	public static int binarySearch(Integer[] array, int start, int end) {
		int mid = (start + end) / 2;
//		int mid = (start + end) >> 1;
		if (start <= end) {
			if (mid == array[mid]) {
				// check for magic index.
				return mid;
			} else if (mid > array[mid]) {
				// If mid > A[mid] means fixed point might be on
				// the right half of the array
				return binarySearch(array, mid + 1, end);
			} else {
				// If mid<A[mid] means fixed point might be on
				// the left half of the array
				return binarySearch(array, start, mid - 1);
			}
		}
		return -1;
	}
	
	/**
	 * Binary search with collections O(log n)
	 */
	public static int binarySearchCollection(Integer[] array, Integer low, Integer high) {
		List<Integer> intList = Arrays.asList(array);
		Integer mid = (low + high) / 2;
//		Integer mid = (low + high) >> 1;
		Comparable<? super Integer> midVal = intList.get(mid);
		int cmp = midVal.compareTo(mid);
		
		if (cmp < 0) {
            low = mid + 1;
			return binarySearchCollection(array, low, high);
		} else if (cmp > 0) {
            high = mid - 1;
            return binarySearchCollection(array, low, high);
		} else {
			return mid;
		}
	}
	
	/**
	 * Sequence search by the upside.
	 * @param array 
	 * @return int 
	 */
	public static int sequenceSearchUp(Integer[] array) {
		int result = -1;
		
		for (int i = array.length-1; i > 0; i--) {
			if (array[i] == i) {
				// first occurrence
				return result = i;
			}
		}
		
		return result;
	}
	
	/**
	 * Sequence search by the downside.
	 * @param array 
	 * @return int 
	 */
	public static int sequenceSearchDown(Integer[] array) {
		int result = -1;
		int start = 0;
		
		for (Integer element : array) {
			if (element == start++) {
				// first occurrence
				return result = start - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Integer[] array = {-1, 0, 2, 3, 4, 10}; // 2 is expected
		int result1 = binarySearch(array, 0, array.length);
		int result2 = binarySearchCollection(array, 0, array.length);
		int result3 = sequenceSearchUp(array);
		int result4 = sequenceSearchDown(array);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
	
}
