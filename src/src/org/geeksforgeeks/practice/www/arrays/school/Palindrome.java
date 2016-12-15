package org.geeksforgeeks.practice.www.arrays.school;

import java.util.Scanner;

/*Given an integer, check whether it is a palindrome or not.
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of a single line. The first line of each test case contains a single integer N to be checked for palindrome.

Output:
Print "Yes" or "No" (without quotes) depending on whether the number is palindrome or not.

Constraints:
1 <= T <= 1000
1 <= N <= 10000

Example:
Input:
3
6
167
55555

Output:
Yes
No
Yes*/

public class Palindrome {
	
	public static void main (String[] args)
	{
	    Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		String inputElement = "0";
		
		while(noOfTestCases-- > 0)
		{
			inputElement = in.next();
			if(checkPalindrome(inputElement))
				System.out.println("Yes");
			else
				System.out.println("No");
			
		}
	}
	
	private static boolean checkPalindrome(String input)
	{
		if(input.length() == 1)
			return true;
		else
		{
			int i=0;
			int j= input.length()-1;
			while(j>i)
			{
				if(input.charAt(i) == input.charAt(j))
				{
					i++;
					j--;
					continue;
				}
				else
					return false;
			}
		}
		return true;
	}

}
