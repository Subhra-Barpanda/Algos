package com.hackerearth.www.datastructures.arrays.oneD;

import java.util.*;

class TheAmazingRace 
{
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
	        
	        int maxSight = 0;
	        int maxSightIndex = 1;
	        int noOfDriversVisible = 0;
	        
	        for(int i=0;i<arrayLength;i++)
	        {
	        	noOfDriversVisible = 0;
	        	for(int j=i-1;j>=0;j--)
	        	{
	        		if(inputArray[j]<inputArray[i])
	        			noOfDriversVisible++;
	        		else
	        			break;
	        	}
	        	
	        	int j = i + 1;
	        	while(j<arrayLength && inputArray[i] > inputArray[j])
	        	{
	        		noOfDriversVisible++;
	        		j++;
	        	}
	        	
	        	if(maxSight < i*noOfDriversVisible)
	        	{
	        		maxSight = i*noOfDriversVisible;
	        		maxSightIndex = i+1;
	        	}
	        	
	        	//System.out.println("i = "+i+" (i)*noOfDriversVisible = "+(i)*noOfDriversVisible+" maxSightIndex = "+maxSightIndex);
	        }
	        System.out.println(maxSightIndex);
        }
    }
}