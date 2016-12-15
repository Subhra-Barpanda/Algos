package arrays;

import java.util.ArrayList;
import java.util.List;

/*Given an array with positive and negative elements in it, re-arrange these elements 
 * such that positive and negative elements are placed in alternate order. 
 * Positive elements should be placed at even indices and negative elements 
 * should be placed at odd indices. The order of same signed elements should remain same.
 * It is not guaranteed that positive and negative elements are equal in number. 
 * If there are more number of positive elements then after arranging positive and negative elements
 * in correct order, remaining positive elements should be placed at the end of the array. 
 * Same is the case when there are more number of negative elements. 
 * No extra space other than auxiliary variables should be used.

For example, if the input array is {-1,3,2,4,5,-6,7,-9} output should be {3,-1,2,-6,4,-9,5,7}. 
Note how the order of elements 3,2,4,5,7 and of elements -1,-6,-9 is unchanged among themselves.
Also the extra positive elements 5 and 7 are placed at the end of the array. 
In the sub-array which maintains alternate order, positive elements are placed at even indices 
and negative elements are placed at odd indices.*/

public class AlternatePositiveNegative 
{
	public static void main(String a[])
	{
		int[] inputArray = {-1,3,2,4,5,-6,7,-9};
		int inputSize = inputArray.length;
		int[] outputArray = new int[inputSize];
		
		List<Integer> positiveList = new ArrayList<Integer>();
		List<Integer> negativeList = new ArrayList<Integer>();
		
		for(int i=0;i<inputArray.length;i++)
		{
			if(inputArray[i] >= 0)
			{
				positiveList.add(inputArray[i]);
			}
			else
				negativeList.add(inputArray[i]);
			
		}
		
		int count = 1;
		for(int i: negativeList)
		{
			outputArray[count] = i;
			count = count + 2;
		}
		count = 0;
		for(int i=0;i<outputArray.length;i++)
		{
			if(outputArray[i] == 0)
			{
				outputArray[i] = positiveList.get(count);
				count++;
			}
		}
		
		System.out.println("Output Array is : ");
		for(int i=0;i<outputArray.length;i++)
		{
			System.out.print(outputArray[i] + " , ");
		}
		
	}
}
