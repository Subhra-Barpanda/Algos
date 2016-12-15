package arrays;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
//import java.util.List;
import java.util.Map;

/*Given an array of numbers and a positive integer 'n', find 'n'th most frequent 
 * occurring number in that array. If there are more than one numbers which are occurring 
 * 'n'th most frequently, then you can return any one of such integers.
 * 
Example:  For the input array {1,2,2,2,4,4,4,4,5,5,5,5,5,7,7,8,8,8,8}
if n = 1, then the output returned should be 5 because it is the most frequent number,
if n = 2, output can be either 4 or 8 since any of these numbers could be considered 
as the 2nd most frequent number,
if n = 3, again output can be either 4 or 8
if n = 4, output should be 2.*/

public class MostFrequest {
	public static void main(String args[])
	{
		int[] inputArray = {1,2,2,2,4,4,4,4,5,5,5,5,5,7,7,8,8,8,8};
		Map<Integer,Integer> outputMap = new HashMap<Integer,Integer>();
		List<Integer> countList = new ArrayList<Integer>();
		for(int i=0;i<inputArray.length;i++)
		{
			int element = inputArray[i];
			int count = 1;
			int temp = 1;
			if(!outputMap.containsKey(element))
			{
				while(i+temp < inputArray.length)
				{
					if(inputArray[i+temp] == element)
						count++;
					
					temp++;
				}
				outputMap.put(element, count);
				countList.add(count);
			}
			
			
		}
		System.out.println(outputMap);
		System.out.println("Before Sorting = "+countList);
		Collections.sort(countList);
		System.out.println("After Sorting = "+countList);
		
		System.out.println("Please enter the value of n: ");
		Scanner in = new Scanner(System.in);
		int nthElement = in.nextInt();
		
		int nthOccurence = countList.get(countList.size() - nthElement);
		
		System.out.println("nthOccurence = "+nthOccurence);
		
		Iterator it = outputMap.keySet().iterator();
		
		String output = "";
		while(it.hasNext())
		{
			int key = (Integer) it.next();
			if(outputMap.get(key).equals(nthOccurence))
			{
				output = output + key + " , " ;
			}
		}
		
		System.out.println("Output = "+output.substring(0,output.length() - 3));
		
		}
	}
