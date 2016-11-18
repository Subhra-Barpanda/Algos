package com.hackerearth.www.datastructures.arrays.oneD;

import java.util.*;

public class UniqueSubArrays {
	
		public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running
	         * Use either of these methods for input

	        //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);*/

	        //Scanner
	        Scanner s = new Scanner(System.in);
	        int N = s.nextInt();
	        
	        for(int z=0;z<N;z++)
	        {
	        	int arrayLength = s.nextInt();
		        int[] inputArray = new int[arrayLength];
		
		        for (int i = 0; i < arrayLength; i++) {
		            inputArray[i] = s.nextInt();
		        }
		        
		        int uniqueSubArraySum = 1*arrayLength;
		        int uniqueSubArrayLength = 0;
		        for(int i=0;i<arrayLength;i++)
		        {
		        	uniqueSubArrayLength = 1;
		        	
		        	while(uniqueSubArrayLength<arrayLength)
		        	{
		        		boolean breakFlag = false;
		        		for(int j=i;j<uniqueSubArrayLength;j++)
		        		{
		        			
		        			int k=j+1;
		        			while(k<=uniqueSubArrayLength)
		        			{
		        				if(inputArray[j]!=inputArray[k])
		        				{
		        					k++;
		        					continue;
		        				}
		        				else
		        					breakFlag = true;
		        			}
		        			if(!breakFlag && k==uniqueSubArrayLength)
		        			{
			        			uniqueSubArraySum = uniqueSubArraySum + (uniqueSubArrayLength+1)*1;
		        			}
		        			else
		        				break;
		        		}
		        		if(breakFlag)
		        			break;
		        		
		        		uniqueSubArrayLength++;
		        	}
		        	
		        }
		        
		        System.out.println(uniqueSubArraySum);
		        
		        /*int uniqueSubArraySum = 1*arrayLength;
		        int uniqueSubArrayLength = 2;
		        
		        for(int i=0;i<arrayLength;i++)
		        {
		        while(uniqueSubArrayLength<=arrayLength)
		        {
		        	int uniqueSubArrayCount = 0;
		        	
		        	for(int j=0;j<arrayLength;j++)
		        	{
		        		int jValue = inputArray[j];
		        		int temp = uniqueSubArrayLength;
		        		boolean breakFlag = false;
		        		
		        		if(j+temp <= arrayLength && temp <= uniqueSubArrayLength)
		        		{	
			        		while(j+temp <= arrayLength && temp <= uniqueSubArrayLength)
			        		{
			        			int tempValue = inputArray[j+temp-1];
			        			if(jValue != tempValue)
			        			{
			        				temp++;
			        				continue;
			        			}
			        			else
			        			{
			        				breakFlag = true;
			        				break;
			        			}
			        			
			        		}
		        		}
		        		else
		        			breakFlag = true;
		        		
		        		if(!breakFlag)
		        			uniqueSubArrayCount++;
		        	}
		        	
		        	System.out.println("uniqueSubArrayCount = "+uniqueSubArrayCount+" uniqueSubArrayLength = "+uniqueSubArrayLength);
		        	
		        	uniqueSubArraySum = uniqueSubArraySum + uniqueSubArrayCount*uniqueSubArrayLength;
		        	uniqueSubArrayLength++;*/
		        }
		        /*}
		        
		        //System.out.println(uniqueSubArraySum);
		        
	        }*/
	    }
	}
