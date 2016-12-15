package com.hackerearth.www.datastructures.basicOfStacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SignalRangeTuned 
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
		        Stack<Integer> inputStack = new Stack<Integer>();
		        Stack<Integer> tempStack = new Stack<Integer>();
		        int countOfI = 0;
		        int tempPoppedOut = 0;
		
		        for (int i = 0; i < arrayLength; i++)
		        {
		            inputArray[i] = s.nextInt();
		        }
		        
		        for (int i = 0; i < arrayLength; i++) 
		        {
		        	countOfI = 1;
		        	if(i==0)
		        	{
		        		inputStack.push(inputArray[i]);
		        		outputArray[i] = countOfI;
		        	}
		        	else
		        	{
		        		if(!inputStack.isEmpty() && inputStack.peek() > inputArray[i])
		        		{
		        			outputArray[i] = countOfI;
		        			inputStack.push(inputArray[i]);
		        		}
		        		else if(!inputStack.isEmpty() && inputStack.peek() <= inputArray[i])
		        		{
		        			while(!inputStack.isEmpty() && inputStack.peek() <= inputArray[i])
		        			{
		        				tempPoppedOut = inputStack.pop();
		        				tempStack.push(tempPoppedOut);
		        				countOfI++;
		        			}
		        			while(!tempStack.isEmpty())
		        			{
		        				tempPoppedOut = tempStack.pop();
		        				inputStack.push(tempPoppedOut);
		        			}
		        			outputArray[i] = countOfI;
		        			inputStack.push(inputArray[i]);
		        			
		        		}
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
