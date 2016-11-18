package org.coursera.www.princetonuniversity.part1.week3.quicksort;

public class QuickSort {
	
	private static boolean isLess(Comparable a,Comparable b)
	{
		if(a.compareTo(b) <= 0)
			return true;
		
		return false;
		
	}
	
	private static void swap(Comparable[] inputArray,int firstIndex,int otherIndex)
	{
		Comparable temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[otherIndex];
		inputArray[otherIndex] = temp;
	}
	
	private static void sort(Comparable[] inputArray,int firstIndex,int lastIndex)
	{
		if(lastIndex<=firstIndex)
			return;
		int sortedIndex = getSortedIndex(inputArray,firstIndex,lastIndex);
		//System.out.println("sortedIndex = "+sortedIndex);
		sort(inputArray,firstIndex,sortedIndex-1);
		//System.out.println(toString(inputArray));
		sort(inputArray,sortedIndex+1,lastIndex);
	}
	
	private static void sort(Comparable[] inputArray)
	{
		sort(inputArray,0,inputArray.length-1);
	}
	
	private static int getSortedIndex(Comparable[] inputArray,int firstIndex,int lastIndex)
	{
		int sortedIndex = firstIndex;
		
		int i = firstIndex+1;
		int j = lastIndex;
		
		while(i<=j)
		{
			while(i<=lastIndex)
			{
				if(isLess(inputArray[i],inputArray[sortedIndex]))
				{
					i++;
					continue;
				}
				else
					break;
			}
			
			//System.out.println("i = "+i);
			
			while(j>=i)
			{
				if(isLess(inputArray[sortedIndex],inputArray[j]))
				{
					j--;
					continue;
				}
				else
					break;
			}
			
			//System.out.println("j = "+j);
			
			if(j>=i)
				swap(inputArray,i,j);
			else
			{
				//System.out.println("In break");
				break;
			}
			
		}
		//System.out.println("Outside while with sortedIndex = "+sortedIndex+" j = "+j);
		if(i!=j && j==i-1)
			swap(inputArray,sortedIndex,j);
		
		return j;
	}
	
	public static String toString(Comparable[] inputArray)
	{
		StringBuilder str = new StringBuilder("");
		for(int i=0;i<inputArray.length;i++)
		{
			str = str.append(inputArray[i]).append(" , ");
		}
		return str.substring(0, str.length() - 3).toString();
	}
	
	public static void main(String[] a)
	{
		Integer[] arrayOfInts = new Integer[]{3,7,1,5,9,2,8,6,5,4,0};
		
		String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		System.out.println(toString(arrayOfInts));
	
		//System.out.println("lastIndex = "+lastIndex);
		
		sort(arrayOfInts);
		
		System.out.println(toString(arrayOfInts));
	}

}
