package org.geeksforgeeks.practice.www.arrays.school;

/*Given an array of integers check whether there are two numbers present with given product.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and a product p.
The second line of each test case contain N number of a[].

Output:
Print Yes if two numbers product is equal to p else No.

Constraints:

1 ≤ T ≤ 51
1 ≤ N ≤ 200
0 ≤ a[] ≤ 1000
1 ≤ pro ≤ 2000000

Example:

Input:

2

5 2

1 2 3 4 5

8 46

5 7 9 22 15 344 92 8

Output:

Yes

No*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EqualToProduct {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		
		while(noOfTestCases-- > 0)
		{
			int arraySize = in.nextInt();
			int requiredProduct = in.nextInt();
			int[] inputArray = new int[arraySize];
			for(int i=0;i<arraySize;i++)
			{
				inputArray[i] = in.nextInt();
			}
			
			if(isRequiredProductExist(inputArray,requiredProduct))
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}
	}
	
	private static boolean isRequiredProductExist(int[] inputArray,int requiredProduct)
	{
		Set<Integer> complimentSet = new HashSet<Integer>();
		for(int i=0;i<inputArray.length;i++)
		{
			if(complimentSet.contains(inputArray[i]))
				return true;
			if(inputArray[i] != 0 && requiredProduct%inputArray[i]==0)
				complimentSet.add(requiredProduct/inputArray[i]);
		}
		
		return false;
	}

}
