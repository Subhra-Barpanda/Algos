package org.geeksforgeeks.practice.www.arrays.basic;

import java.util.Scanner;

/*Given an array of size n-1 and given that there are numbers from 1 to n with one missing, the missing number is to be found.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,size of array.
The second line of each test case contains N-1 input C[i],numbers in array.

Output:

Print the missing number in array.

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 1000
1 ≤ C[i] ≤ 1000

Example:

Input
2
5
1 2 3 5
10
1 2 3 4 5 6 7 8 10

Output
4
9*/

public class MissingNumbersInArray {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		
		while(noOfTestCases-- > 0)
		{
			int arrayLength = in.nextInt();
			int expectedSum = (arrayLength * (arrayLength+1))/2;
			int actualSum = 0;
			while(--arrayLength > 0)
			{
				actualSum = actualSum + in.nextInt();
			}
			System.out.println(expectedSum-actualSum);
		}
	}
}
