package org.coursera.www.princetonuniversity.part1.week2.sorting;

public class InsertionSort {

	public static  boolean isLess(Comparable p,Comparable q)
	{
		if(p.compareTo(q) <= 0)
			return true;
		
		return false;
	}
	
	public static void swap(Comparable[] inputArray,int p,int q)
	{
		Comparable temp = inputArray[p];
		inputArray[p] = inputArray[q];
		inputArray[q] = temp;
	}
	
	public static void sort(Comparable[] inputArray)
	{
		for(int i=1;i<inputArray.length;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(j > 0 && isLess(inputArray[j],inputArray[j-1]))
				{
					swap(inputArray,j,j-1);
					//System.out.println("In Progress index ="  +toString(inputArray));
				}
				else
					break;
			}
		}
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
		Integer[] arrayOfInts = new Integer[]{3,7,1,5,9,2,8,6,5,4};
		
		String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		System.out.println(toString(arrayOfStrings));
		
		sort(arrayOfStrings);
		
		System.out.println(toString(arrayOfStrings));
	}
}
