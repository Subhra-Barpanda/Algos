package com.hackerearth.www.datastructures.arrays.oneD;

import java.util.*;

public class FreedoAndLargeNumbers 
{
	private static Map<Long,Long> IndexValueCountMap = new LinkedHashMap<Long,Long>();
	
	public static void main(String args[] ) throws Exception 
	{
		Scanner s = new Scanner(System.in);
        int N = s.nextInt();//ok
        
        //int[] inputArray = new int[N];
        //List<Long> inputList = new ArrayList<Long>();
        
        long input = 0L;
	
        for (int i = 0; i < N; i++) 
        {
        	input = s.nextLong();
        	//inputList.add(input);
        	if(!IndexValueCountMap.isEmpty() && IndexValueCountMap.containsKey(input))
				IndexValueCountMap.put(input, (IndexValueCountMap.get(input))+1);
			else
				IndexValueCountMap.put(input, 1L);
        }
        
        int noOfProblems = s.nextInt();//ok
        
        long[] solutionArray = new long[noOfProblems];
        
        /*for(long l:inputList)
		{
			if(!IndexValueCountMap.isEmpty() && IndexValueCountMap.containsKey(l))
				IndexValueCountMap.put(l, (IndexValueCountMap.get(l))+1);
			else
				IndexValueCountMap.put(l, 1L);
		}*/
        
        for(int i=0;i<noOfProblems;i++)
        {
	        int problemType = s.nextInt();
	        long f = s.nextLong();
	        long solution = typeSubProblem(/*inputList,*/f,problemType);
	        solutionArray[i] = solution;
        }
        
        for(int i=0;i<noOfProblems;i++)
        {
        	System.out.println(solutionArray[i]);
        }

	}
	
	private static long typeSubProblem(/*List<Long> inputList,*/long f,int problemType)
	{
		long answer = -1L;
		for(long i:IndexValueCountMap.keySet())
		{
			if(problemType == 0 && IndexValueCountMap.get(i) >= f)
			{
				answer = i;
				break;
			}
			else if(problemType == 1 && IndexValueCountMap.get(i) == f)
			{
				answer = i;
				break;
			}
		}
		
		if(answer != -1L)
			return answer;
		else
			return 0;
	}
}
