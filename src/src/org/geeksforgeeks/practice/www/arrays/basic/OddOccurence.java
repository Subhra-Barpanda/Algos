package org.geeksforgeeks.practice.www.arrays.basic;

import java.util.Scanner;

/*Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number.

Expected Time Complexity: O(n)
Expected Auxiliary Space​: Constant

Input:

The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of two lines.

The first line of each test case consists of an integer N, where N is the size of array.
The second line of each test case contains N space separated integers denoting array elements.

Output:

Corresponding to each test case, print in a new line, the number which occur odd number of times.*/

public class OddOccurence {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		
		while(noOfTestCases-- > 0)
		{
			int arrayLength = in.nextInt();
			int xorValue = 0;
			while(arrayLength-- > 0)
			{
				int inputElement = in.nextInt();
				xorValue = xorValue ^ inputElement;
			}
			System.out.println(xorValue);
		}
	}

}
