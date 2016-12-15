package arrays;

import java.util.Scanner;

/*If you are given an integer array and an integer 'k' as input, 
 * write a program to print elements with maximum values from each 
 * possible sub-array (of given input array) of size 'k'. 
 * If the given input array is {9,6,11,8,10,5,14,13,93,14} and for k = 4, 
 * output should be 11,11,11,14,14,93,93. 
 * Please observe that 11 is the largest element in the first, 
 * second and third sub-arrays - {9,6,11,8}, {6,11,8,10} and {11,8,10,5}; 
 * 14 is the largest element for fourth and fifth sub-array 
 * and 93 is the largest element for remaining sub-arrays.*/

public class MaxSubArray {
	
	public static void main(String args[])
	{
		int[] inputArray = {9,6,11,8,10,5,14,13,93,14};
		System.out.println("Enter the size of subArray");
		Scanner scan = new Scanner(System.in);
		int subArraySize = scan.nextInt();
		
		int outputArraySize = inputArray.length - subArraySize + 1;
		
		int[] outputArray = new int[outputArraySize];
		
		
		//int count = 0;
		for(int i=0;i<inputArray.length;i++)
		{
			int max = 0;
			if((i + subArraySize) <= inputArray.length)
			{
				for(int j=0;j < subArraySize;j++)
				{
					if(inputArray[i+j] > max)
						max = inputArray[i+j];
				}
				outputArray[i]=max;
			}
			
		}
		
		System.out.print("output array = ");
		for(int i=0;i<outputArray.length;i++)
		{
			System.out.print((outputArray[i]+" ,"));
		}
	}

}
