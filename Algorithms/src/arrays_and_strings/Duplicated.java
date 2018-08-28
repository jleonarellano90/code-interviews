package arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a method which receives an array of ints, and prints only those that are repeated.
 * Input: [1,3,5,1,7,9,1,5,5]
 * Output:
 * 1
 * 5
 **/
public class Duplicated {

	public static void main(String[] args) {
		Integer[] array = {1, 3, 5, 1, 7, 9, 1, 5, 5};
		duplicated1(array);
	}
	
	// O(n+n) -> O(2n) -> O(n)
	public static void duplicated1(Integer[] array) {
	     Set<Integer> compare = new HashSet<Integer>();
	     Set<Integer> result = new HashSet<Integer>();
	     // n
	     for (Integer item : array) {
	         if (!compare.add(item)) {
	        	 result.add(item);
	         }
	     }
	     // n
	     for (Integer value : result) {
	    	 System.out.println(value);
	     }
	 }
	
	//O(n^2)
	public static void duplicated2(Integer[] array) {
		for (int i = 0; i < array.length; i++) {
            int counter = 0;
            for (int j= i+1; j < array.length; j++) {
            	if (array[i] == array[j] && counter==0) {
            		System.out.println(array[i]);
            		counter++;
            	} else {
            		array[j] = -array[j];
            	}
            }
        }
	}
	
}
