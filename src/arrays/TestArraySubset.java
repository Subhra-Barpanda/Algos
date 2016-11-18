package arrays;

public class TestArraySubset {
	public int getMultipliedValue(int[] a,int n,int size)
	{
		int result = 1;
		int count = 0;
		int max	= result;
		
		for(int i=0;i<n;i++)
		{
			count = 0;
			result = 1;
			while(count < size && ((i+size <= n)))
			{
				result = result * a[i+count];
				count ++;
			}
			if(result > max)
			{
				max = result;
			}
			
		}
		
		return max;
		
	}
	
	public static void main(String[] args)
	{
	
		TestArraySubset tst = new TestArraySubset();
		int[] testArray = new int[]{4,8,9,11,10,10,1};
		int output = tst.getMultipliedValue(testArray, testArray.length, 5);
		System.out.println("output = "+output);
	}
}
