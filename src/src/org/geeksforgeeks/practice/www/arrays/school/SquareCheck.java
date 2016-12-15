package org.geeksforgeeks.practice.www.arrays.school;

/*Given coordinates of four points in a plane, find if the four points form a square or not.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains 4 space separated integer points a , b , c , d

Output:
For each test case print 1 if the four points form a square else print 0.
Remember to output the answer of each test case in a new line.

Constraints:
1<=T<=100
1<=a,b,c,d<=100

Example:

Input:
2
20 20 20 10 10 20 10 10
10 10 10 10 20 10 20 30

Output:
1
0*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SquareCheck 
{
	public static void main (String[] args)
	{
	    Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		int inputElement = 0;
		boolean breakFlag = false;
		
		Map<Integer,Integer> xMap = null;
		Map<Integer,Integer> yMap = null;
		
		while(noOfTestCases-- > 0)
		{
		    breakFlag = false;
			xMap = new HashMap<Integer,Integer>();
			yMap = new HashMap<Integer,Integer>();
			
			for(int i=1;i<=8;i++)
			{
				inputElement = in.nextInt();
				if(i%2 == 0)
				{
					if(yMap.containsKey(inputElement))
						yMap.put(inputElement, yMap.get(inputElement)+1);
					else
						yMap.put(inputElement, 1);
					
					if(yMap.size() > 2)
					{
					    for(int j=i+1;j<=8;j++)
					        in.nextInt();
					        
					    breakFlag = true;
						break;
					}
					else if(yMap.get(inputElement) > 2)
					{
					    for(int j=i+1;j<=8;j++)
					        in.nextInt();
					        
					    breakFlag = true;
						break;
					}
				}
				else
				{
					if(xMap.containsKey(inputElement))
						xMap.put(inputElement, xMap.get(inputElement)+1);
					else
						xMap.put(inputElement, 1);
					
					if(xMap.size() > 2)
					{
					    for(int j=i+1;j<=8;j++)
					        in.nextInt();
					        
					    breakFlag = true;
						break;
					}
					else if(xMap.get(inputElement) > 2)
					{
					    for(int j=i+1;j<=8;j++)
					        in.nextInt();
					        
					    breakFlag = true;
					    break;
					}
				}
			}
			if(breakFlag)
				System.out.println("0");
			else
				System.out.println("1");
		}
	 }
}
