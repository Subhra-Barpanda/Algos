package arrays;

/*Given an array representing prices of the stock on different days, 
 * find the maximum profit that can be earned by performing maximum of one transaction. 
 * A transaction consists of activity of buying and selling the stock on different or same days. 

For example in this array - {100, 80, 120, 130, 70, 60, 100, 125} the price 
of the stock on day-1 is 100, on day-2 is 80 and so on. The maximum profit that could be 
earned in this window is 65 (buy at 60 and sell at 125).

For price array - {100, 80, 70, 65, 60, 55, 50}, maximum profit that could be earned is 0.*/

public class StocksMaxProfit {
	
	public static void main(String a[])
	{
		int[] inputArray = {100, 80, 70, 65, 60, 55, 50};
		int min = inputArray[0];
		int minIndex = 0;
		for(int i=1;i<inputArray.length;i++)
		{
			if(inputArray[i] < min)
			{
				min = inputArray[i];
				minIndex = i;
			}
		}
		int max = min;
		for(int i=minIndex+1;i<inputArray.length;i++)
		{
			if(inputArray[i] > max)
			{
				max = inputArray[i];
			}
		}
		
		int maxProfit = max - min;
		
		System.out.println("Max profit attainable = "+maxProfit);
	}

}
