package com.hackerrank.www.algorithms.implementation;

import java.util.Scanner;

public class BiggerIsGreater 
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
	
		int noOfTestCases = s.nextInt();
		String input = null;
		String[] outputArray = new String[noOfTestCases];
		int suffixIndex = -1;
		int pivotIndex = -1;
		char[] inputArray = null;
		
	
		for(int i=0;i<noOfTestCases;i++)
		{
			StringBuilder output = new StringBuilder();
			input = s.next();
			inputArray = input.toCharArray();
			suffixIndex = getSuffixIndex(inputArray);
			if(suffixIndex == -1)
				outputArray[i] = "no answer";
			else
			{
				pivotIndex = suffixIndex - 1;
				int j = inputArray.length-1;
				for(j=inputArray.length-1;j>=0;j--)
				{
					if(inputArray[j] <= inputArray[pivotIndex])
					{
						continue;
					}
					else
						break;
				}
				swap(inputArray,pivotIndex,j);
				for(int k=suffixIndex,l=inputArray.length-1;k<inputArray.length-1;k++,l--)
				{
					swap(inputArray,k,l);
				}
				for(int k=0;k<inputArray.length;k++)
					output = output.append(inputArray[k]);
				
				outputArray[i] = output.toString();
			}
			
		}
		for(int i=0;i<noOfTestCases;i++)
			System.out.println(outputArray[i]);
	}
	
	private static void swap(char[] inputArray,int firstIndex,int otherIndex)
	{
		char temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[otherIndex];
		inputArray[otherIndex] = temp;
	}
	
	private static int getSuffixIndex(char[] inputArray)
	{
		int j = inputArray.length-1;
		for(j=inputArray.length-1;j>=0;j--)
		{
			if(j-1 >= 0 && inputArray[j] <= inputArray[j-1])
			{
				continue;
			}
			else
				break;	
		}
		if(j>0)
			return j;
		else
			return -1;
	}
}
