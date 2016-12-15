package arrays;

/*Given an increasing sequence of numbers from 1 to n with only one missing number, 
 * how can you find that missing number without traversing the sequence in linear fashion. 
 * In other words, time complexity of your algorithm must be less than O(n)?

For example, if the given sequence is 1,2,4,5,6,7,8 then the missing number is 3. 
If the given sequence is 1,3,4,5 then the missing number is 2. 
For the input 2,3,4,5 output returned should be 1 as it is the missing number.*/

public class MissingNumber {

	public static void main(String a[])
	{
		int[] inputArray = {1,2,3,4,5,6,8};
		int middle = (int) Math.floor(inputArray.length/2);
		int output = 0;
		if(inputArray[middle] == (middle+1))
		{
			for(int i = middle+1;i<inputArray.length;i++)
			{
				if(inputArray[i] != (i+1))
				{
					output = inputArray[i] - 1;
					System.out.println("Missing Element = "+output);
					break;
				}
				
			}
		}
		else
		{
			for(int i = 0;i<=middle;i++)
			{
				if(inputArray[i] != (i+1))
				{
					output = inputArray[i] - 1;
					System.out.println("Missing Element = "+output);
					break;
				}
				
			}
		}		
	}
}
