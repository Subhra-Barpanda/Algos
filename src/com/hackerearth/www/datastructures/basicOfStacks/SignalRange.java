package com.hackerearth.www.datastructures.basicOfStacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SignalRange 
{
	public static void main(String args[] ) throws Exception {
        
		Scanner s = new Scanner(System.in);
        int noOfTestCases = s.nextInt();
        List<int[]> outputList = new ArrayList<int[]>();
		StringBuilder result = null;
        
        for(int z=0;z<noOfTestCases;z++)
        {
        	int arrayLength = s.nextInt();
	        int[] inputArray = new int[arrayLength];
	        int[] outputArray = new int[arrayLength];
	        int countOfI = 0;
	
	        for (int i = 0; i < arrayLength; i++)
	        {
	            inputArray[i] = s.nextInt();
	        }
	        
	        for (int i = 0; i < arrayLength; i++) 
	        {
	        	countOfI = 1;
	        	if(i==0)
	        		outputArray[i] = countOfI;
	        	else
	        	{
	        		for (int j = i-1; j >= 0; j--)
	        		{
	        			if(inputArray[j] <= inputArray[i])
	        				countOfI++;
	        			else
	        				break;
	        		}
	        		outputArray[i] = countOfI;
	        	}
	        }
	        outputList.add(outputArray);
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
