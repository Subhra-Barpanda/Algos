package org.geeksforgeeks.practice.www.arrays.school;

import java.util.Scanner;

/*Given an array, return second  largest element from an array.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input C[i].

Output:

Print the second largest element.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 500
1 ≤ C[i] ≤ 1200

Example:

Input
2
5
89 24 75 11 23
6
56 42 21 23 65 20

Output
75
56*/

public class SecondLargest {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		
		while(noOfTestCases-- > 0)
		{
			int arrayLength = in.nextInt();
			int secondLargest = -1;
			int firstLargest = 0;
			int inputElement = 0;
			while(arrayLength-- > 0)
			{
				inputElement = in.nextInt();
				if(inputElement > firstLargest)
				{
					secondLargest = firstLargest;
					firstLargest = inputElement;
				}
				else if(inputElement < firstLargest && inputElement > secondLargest)
					secondLargest = inputElement;	
			}
			System.out.println(secondLargest);
		}
	}

}
