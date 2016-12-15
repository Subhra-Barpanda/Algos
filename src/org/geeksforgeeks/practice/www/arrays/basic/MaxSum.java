package org.geeksforgeeks.practice.www.arrays.basic;

import java.util.Scanner;

/*Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input C[i].

Output:

Print the maximum sum of a subsequence.

Constraints:

1 ≤ T ≤ 80
1 ≤ N ≤ 100
1 ≤ C[i] ≤ 500

Example:

Input:
2
6
5 5 10 100 10 5
4
3 2 7 10

Output:
110
13*/

public class MaxSum {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		
		while(noOfTestCases-- > 0)
		{
			int arrayLength = in.nextInt();
			int i=0;
			while(i-- > 0)
			{
				int inputElement = in.nextInt();
			}
			
		}
	}
}
