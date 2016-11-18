package com.hackerearth.www.datastructures.arrays.oneD;

import java.util.*;

class NiceArches 
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
        
        String[] inputArray = new String[N];
        
        for(int z=0;z<N;z++)
        {
        	inputArray[z] = s.next();
        	
        }
        
        int noOfNiceArches = 0;
        Stack<Character> charStack = null;
        String word = null;
        
        for(int i=0;i<inputArray.length;i++)
        {
	        //int[] inputArray = new int[arrayLength];
        	
        	boolean breakFlag = false;
        	
        	charStack = new Stack<Character>();
        	word = inputArray[i];
        	
	
	        for (int j = 0; j < word.length(); j++) 
	        {
	        	if(charStack.isEmpty())
	        		charStack.push(word.charAt(j));
	        	else if(charStack.peek().equals(word.charAt(j)))
	        		charStack.pop();
	        	else
	        		charStack.push(word.charAt(j));
	        	
	        	if(j+1 > 0 && j+1%4 == 0 && charStack.isEmpty())
	        	{
	        		continue;
	        	}
	        	else if(j+1 > 0 && j+1%4 == 0)
	        	{
	        		breakFlag = true;
	        		break;
	        	}
	        	else if(j == word.length()-1 && !charStack.isEmpty())
	        	{
	        		breakFlag = true;
	        	}	
	        }
	        
	        if(!breakFlag)
	        	noOfNiceArches++;
        }
        
        System.out.println(noOfNiceArches);
    }
}