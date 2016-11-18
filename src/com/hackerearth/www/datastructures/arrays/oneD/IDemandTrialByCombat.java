package com.hackerearth.www.datastructures.arrays.oneD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IDemandTrialByCombat {
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		int[] inputArray = null;
		int[] outputArray = null;
		List<int[]> outputList = new ArrayList<int[]>();
		StringBuilder result = null;
		
		for(int i=0;i<noOfTestCases;i++)
		{
			int noOfElements = s.nextInt();
			int noOfHours = s.nextInt(); 
			
			inputArray = new int[noOfElements];
			outputArray = new int[noOfElements];
			
			for(int j=0;j<noOfElements;j++)
			{
				inputArray[j] = s.nextInt();
			}
			
			while(noOfHours>0)
			{
				for(int k=0;k<inputArray.length;k++)
				{
					if(k == 0)
					{
						if(inputArray[k+1] == 1)
							outputArray[k] = 1;
						else if(inputArray[k+1] == 0)
							outputArray[k] = 0;
					}		
					else if(k == inputArray.length-1)
					{
						if(inputArray[k-1] == 1)
							outputArray[k] = 1;
						else if(inputArray[k-1] == 0)
							outputArray[k] = 0;
					}
					else
					{
						if(inputArray[k-1] == 1 && inputArray[k+1] == 1)
							outputArray[k] = 1;
						else if(inputArray[k-1] == 0 || inputArray[k+1] == 0)
							outputArray[k] = 0;
					}
				}
				inputArray = Arrays.copyOf(outputArray, inputArray.length);
				noOfHours--;
			}
			
			outputList.add(inputArray);
			
		}
		
		for(int[] output:outputList)
		{
			result = new StringBuilder("");
			for(int i=0;i<output.length;i++)
			{
				result = result.append(output[i]).append(" "); 
			}
			System.out.println(result.substring(0,result.length()-1));
		}
	}
	
	
}
