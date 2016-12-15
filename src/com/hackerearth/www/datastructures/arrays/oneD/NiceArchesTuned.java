package com.hackerearth.www.datastructures.arrays.oneD;

import java.util.Scanner;
import java.util.Stack;

public class NiceArchesTuned {
	
	public static void main(String args[] ) throws Exception 
	{
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int noOfNiceArches = 0;
        String word = null;
        
        for(int z=0;z<N;z++)
        {
        	word = s.next();
        	noOfNiceArches = noOfNiceArches + isArchPresent(word);
        }
        
        System.out.println(noOfNiceArches);
	}
	
	private static int isArchPresent(String input)
	{
        Stack<Character> charStack = null;
        
        boolean breakFlag = false;
        	
    	charStack = new Stack<Character>();
    	
        for (int j = 0; j < input.length(); j++) 
        {
        	if(charStack.isEmpty())
        		charStack.push(input.charAt(j));
        	else if(charStack.peek().equals(input.charAt(j)))
        		charStack.pop();
        	else
        		charStack.push(input.charAt(j));
        	
        	if(j+1 > 0 && j+1%4 == 0 && charStack.isEmpty())
        	{
        		continue;
        	}
        	else if(j+1 > 0 && j+1%4 == 0)
        	{
        		breakFlag = true;
        		break;
        	}
        	else if(j == input.length()-1 && !charStack.isEmpty())
        	{
        		breakFlag = true;
        	}	
        }
	        
	    if(!breakFlag)
	    	return 1;
	    else
	    	return 0;
	}

}
