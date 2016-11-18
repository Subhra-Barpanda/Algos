package com.hackerrank.www.algorithms.implementation;

import java.util.Scanner;

public class BiggerIsGreaterTuned {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		
		String input = null;
		String[] outputArray = new String[noOfTestCases];
		char[] inputArray = null;
		boolean isNextPermutationAvailable = false;
		
		
		for(int i=0;i<noOfTestCases;i++)
		{
			StringBuilder output = new StringBuilder();
			input = s.next();
			inputArray = input.toCharArray();
			isNextPermutationAvailable = nextPermutation(inputArray);
			if(isNextPermutationAvailable)
			{
				for(int j=0;j<inputArray.length;j++)
					output = output.append(inputArray[j]);
				
				outputArray[i] = output.toString();
			}
			else
				outputArray[i] = "no answer";
		}
		for(int i=0;i<noOfTestCases;i++)
			System.out.println(outputArray[i]);
	}
	
	private static boolean nextPermutation(char[] array) {
	    // Find longest non-increasing suffix
	    int i = array.length - 1;
	    while (i > 0 && array[i - 1] >= array[i])
	        i--;
	    // Now i is the head index of the suffix
	    
	    // Are we at the last permutation already?
	    if (i <= 0)
	        return false;
	    
	    // Let array[i - 1] be the pivot
	    // Find rightmost element that exceeds the pivot
	    int j = array.length - 1;
	    while (array[j] <= array[i - 1])
	        j--;
	    // Now the value array[j] will become the new pivot
	    // Assertion: j >= i
	    
	    // Swap the pivot with j
	    char temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = temp;
	    
	    // Reverse the suffix
	    j = array.length - 1;
	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	        i++;
	        j--;
	    }
	    
	    // Successfully computed the next permutation
	    return true;
	}

}
