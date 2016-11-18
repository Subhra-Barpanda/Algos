package org.coursera.www.stanforduniversity.part1.week3.randomizedselection;

public class FindIthElementInArray 
{
	private static int findPartitionElementIndex(Comparable[] inputArray,int lowIndex,int highIndex)
	{
		Comparable pivotElement = inputArray[lowIndex];
		int i=lowIndex + 1;
		
		for(int j=lowIndex + 1;j<=highIndex;j++)
		{
			if(isLess(pivotElement,inputArray[j]))
				continue;
			else if(isLess(inputArray[j],pivotElement))
			{
				if(i!=j)
					swap(inputArray,i,j);
				i++;
			}
		}
		
		swap(inputArray,i-1,lowIndex);
		return i-1;
		
		/*int i=lowIndex + 1;
		int j = highIndex;
		
		while(i<=j)
		{
			while(i<=highIndex && isLess(inputArray[i],pivotElement))
				i++;
			
			while(j>=i && isLess(pivotElement,inputArray[j]))
				j--;
			
			if(j<=i)
				break;
			
			swap(inputArray,i,j);
		}
		
		swap(inputArray,lowIndex,j);
		
		return j;*/
	}
	
	private static Comparable findIthElement(Comparable[] inputArray,int lowIndex,int highIndex,int ithIndex)
	{
		int partitionElementIndex = findPartitionElementIndex(inputArray,lowIndex,highIndex);
		
		if(lowIndex >= highIndex)
			return inputArray[partitionElementIndex];
		
		System.out.println("ithIndex = "+ithIndex+" partitionElementIndex = "+partitionElementIndex);
		System.out.println(toString(inputArray));
		
		if(partitionElementIndex == ithIndex)
			return inputArray[partitionElementIndex];
		else if(partitionElementIndex > ithIndex)
			return findIthElement(inputArray,lowIndex,partitionElementIndex - 1,ithIndex);
		else if(partitionElementIndex < ithIndex)
			return findIthElement(inputArray,partitionElementIndex + 1,highIndex,ithIndex/*-partitionElementIndex*/);
		
		return null; 
	}
	
	public static Comparable findIthElement(Comparable[] inputArray,int ithIndex)
	{
		return findIthElement(inputArray,0,inputArray.length-1,ithIndex-1);
	}
	
	private static void swap(Comparable[] inputArray,int firstIndex,int secondIndex)
	{
		Comparable temp = inputArray[firstIndex];
		inputArray[firstIndex] = inputArray[secondIndex];
		inputArray[secondIndex] = temp;
		temp = null;
	}
	
	private static boolean isLess(Comparable a,Comparable b)
	{
		if(a.compareTo(b) <= 0)
			return true;
		
		return false;
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
	
	public static void main(String[] args)
	{
		Integer[] arrayOfInts = /*new Integer[]{1,3,5,2,4,6};*/new Integer[]{3,7,1,5,9,2,8,6,5,4,0};
		//String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		System.out.println(toString(arrayOfInts));
		//System.out.println(toString(arrayOfStrings));
		
		//System.out.println("lastIndex = "+lastIndex);
		
		System.out.println(findIthElement(arrayOfInts,7));
		//System.out.println(countNoOfInversions(arrayOfStrings));
		
		//System.out.println(toString(arrayOfInts));
		//System.out.println(toString(arrayOfStrings));
		
		//System.out.println("Subh".substring(0,2));
		
		/*for(Comparable[] a:inversionSet)
		{
			System.out.println(toString(a));
		}*/
	}
	
}
