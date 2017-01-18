package seicodeproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author Nidhi Sharma 
 * This class is compiled using java8. Given the following
 * class, There are 3 methods that can be used to return an array that
 * has no duplicates. To retain the original order call method
 * getDistinctElementArrayWithOrder.
 * 
 * positives and negatives of each method are defined on method comments
 * 
 * getDistinctArray method is Naive/Negative Implementation -
 * Implemented Below 3 methods (getDistinctElementArray,
 * getDistinctElementArrayWithOrder, getDistinctElementArraySorted) to
 * avoid negatives.
 *
 */
public class DeDup {

	private int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(String[] args) {
		DeDup deDup = new DeDup();
		// Just to print int array - using Arrays.toString
		System.out.println(
				"getDistinctElementArray= " + Arrays.toString(deDup.getDistinctElementArray(deDup.randomIntegers)));
		System.out.println("getDistinctElementArrayWithOrder= "
				+ Arrays.toString(deDup.getDistinctElementArrayWithOrder(deDup.randomIntegers)));
		System.out.println("getDistinctElementArraySorted= "
				+ Arrays.toString(deDup.getDistinctElementArraySorted(deDup.randomIntegers)));
	}

	/*
	 * Naive/Negative Implementation - Implemented Below 3 methods
	 * (getDistinctElementArray, getDistinctElementArrayWithOrder,
	 * getDistinctElementArraySorted) to avoid negatives. Below implementation
	 * is just to implement remove duplicate using for loop. Ideally not at all
	 * preferred because of performance issues.
	 */
	public int[] getDistinctArray(final int[] randomInt) {
		List<Integer> distElements = new ArrayList<Integer>();
		// Pick all elements one by one
		for (int i = 0; i < randomInt.length; i++) {
			// Check for duplicate element
			boolean isDistinct = false;
			for (int j = 0; j < i; j++) {
				if (randomInt[i] == randomInt[j]) {
					isDistinct = true;
					break;
				}
			}
			if (!isDistinct) {
				distElements.add(randomInt[i]);
			}
		}
		return distElements.stream().mapToInt(Number::intValue).toArray();
	}

	/*
	 * Another Naive/Negative Implementation - Implemented Below 3 methods
	 * (getDistinctElementArray, getDistinctElementArrayWithOrder,
	 * getDistinctElementArraySorted) to avoid negatives. Below implementation
	 * is just to implement remove duplicate using List contains. Ideally not
	 * preferred because of performance issues.
	 */
	public int[] getDistinctArrayUsingList(final int[] randomInt) {
		List<Integer> distElements = new ArrayList<Integer>();
		// Pick all elements one by one
		for (int i = 0; i < randomInt.length; i++) {
			// Check for duplicate element
			if (!distElements.contains(randomInt[i])) {
				distElements.add(randomInt[i]);
			}
		}
		return distElements.stream().mapToInt(Number::intValue).toArray();
	}

	/*
	 * Get distinct elements using HashSet. Advisable to use this method in case
	 * where we don't need to manage any kind of order of elements in
	 * collection.It gives best performance(O(1)) for insertion, removal and
	 * retrieval.
	 */
	public int[] getDistinctElementArray(final int[] randomInt) {
		// Creates an empty hashset
		Set<Integer> distinctElements = new HashSet<Integer>();
		// Traverse the input array
		for (int i = 0; i < randomInt.length; i++) {
			// If not present, then put it in hashtable and print it
			distinctElements.add(randomInt[i]);
		}
		return distinctElements.stream().mapToInt(Number::intValue).toArray();
	}

	/*
	 * Get distinct elements using LinkedHashSet. Advisable to use this method
	 * in case where we need to manage insertion order of elements in
	 * collection.It gives performance(O(1)) for insertion, removal and
	 * retrieval. But it require more memory then HashSet.
	 */
	public int[] getDistinctElementArrayWithOrder(final int[] randomInt) {
		// Creates an empty hashset
		Set<Integer> distinctElements = new LinkedHashSet<Integer>();

		distinctElements = Arrays.stream(randomInt).boxed().collect(Collectors.toSet());

		// Traverse the input array
		for (int i = 0; i < randomInt.length; i++) {
			// If not present, then put it in hashtable and print it
			distinctElements.add(randomInt[i]);
		}
		return distinctElements.stream().mapToInt(Number::intValue).toArray();
	}

	/*
	 * Get distinct elements using TreeSet. Advisable to use this method in case
	 * where we need sorted collection. Less performant then HashSet and
	 * LinkedHashSet It gives performance(O(log(n))) for insertion, removal and
	 * retrieval. Require more memory then HashSet and LinkedHashSet.
	 */
	public int[] getDistinctElementArraySorted(final int[] randomInt) {
		// Creates an empty hashset
		Set<Integer> distinctElements = new TreeSet<Integer>();
		// Traverse the input array
		for (int i = 0; i < randomInt.length; i++) {
			// If not present, then put it in hashtable and print it
			distinctElements.add(randomInt[i]);
		}
		return distinctElements.stream().mapToInt(Number::intValue).toArray();
	}
}
