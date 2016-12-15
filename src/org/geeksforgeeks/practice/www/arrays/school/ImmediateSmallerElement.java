package org.geeksforgeeks.practice.www.arrays.school;

import java.util.Scanner;

public class ImmediateSmallerElement {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int noOfTestCases = in.nextInt();
		
		while(noOfTestCases-- > 0)
		{
			int arraySize = in.nextInt();
			int[] inputArray = new int[arraySize];
			int[] outputArray = new int[arraySize];;
			for(int i=0;i<arraySize;i++)
			{
				inputArray[i] = in.nextInt();
				if(i > 0)
				{
					if(inputArray[i] < inputArray[i-1])
					{
						outputArray[i-1] = inputArray[i];
					}
					else
						outputArray[i-1] = -1;
				}
			}
			outputArray[arraySize-1] = -1;
			
			StringBuilder result = new StringBuilder();
			for(int i=0;i<outputArray.length;i++)
			{
				result = result.append(outputArray[i]).append(" ");
			}
			System.out.println(result.toString().substring(0,result.length()-1));
		}
	}
}
