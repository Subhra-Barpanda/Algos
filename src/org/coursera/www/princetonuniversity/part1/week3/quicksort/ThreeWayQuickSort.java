package org.coursera.www.princetonuniversity.part1.week3.quicksort;

public class ThreeWayQuickSort 
{
	private static boolean isLess(Comparable a,Comparable b)
	{
		if(a.compareTo(b) < 0)
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
		
		int sortedIndex = firstIndex;
		
		int i = firstIndex+1;
		int j = lastIndex;
		
		while(true)
		{
			if(i<=j)
			{
				if(isLess(inputArray[i],inputArray[sortedIndex]))
				{
					swap(inputArray,i,sortedIndex);
					i++;
					sortedIndex++;
				}
				else if(isLess(inputArray[sortedIndex],inputArray[i]))
				{
					swap(inputArray,i,j);
					j--;
				}
				else
					i++;
			}
			else
				break;
		}
		//System.out.println("sortedIndex = "+sortedIndex);
		sort(inputArray,firstIndex,sortedIndex-1);
		//System.out.println(toString(inputArray));
		sort(inputArray,j+1,lastIndex);
		/*System.out.println("sortedIndex = "+sortedIndex+" i = "+i+" j= "+j);
		System.out.println(toString(inputArray));*/
	}
	
	private static void sort(Comparable[] inputArray)
	{
		sort(inputArray,0,inputArray.length-1);
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
		Integer[] arrayOfInts = new Integer[]{4,5,1,2,3,5,5,1,4,3};
		
		String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		System.out.println(toString(arrayOfInts));
	
		//System.out.println("lastIndex = "+lastIndex);
		
		sort(arrayOfInts);
		
		System.out.println(toString(arrayOfInts));
	}
}
