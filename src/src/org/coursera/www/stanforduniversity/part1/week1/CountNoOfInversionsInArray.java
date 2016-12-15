package org.coursera.www.stanforduniversity.part1.week1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountNoOfInversionsInArray {
	
	private static int countOfInversions = 0;
	public static Set<Comparable[]> inversionSet = new HashSet<Comparable[]>();
	
	private static void MergeAndCountNoOfInversions(Comparable[] inputArray,Comparable[] auxArray,int lowIndex,int midIndex,int highIndex)
	{
		int resultCount = 0;
		auxArray = Arrays.copyOf(inputArray, inputArray.length);
		Comparable[] inverseElements;
		for(int i=lowIndex,j=midIndex+1,k=lowIndex;k<inputArray.length;k++)//use lowIndex in place of 0 for assignment of k
		{
			if(i>midIndex)
			{
				inputArray[k] = auxArray[j];
				j++;
			}
			else if(j>highIndex)
			{
				inputArray[k] = auxArray[i];
				i++;
			}
			else if(isLess(auxArray[i],auxArray[j]))
			{
				inputArray[k] = auxArray[i];
				i++;
			}
			else
			{
				inputArray[k] = auxArray[j];
				resultCount = resultCount + (midIndex - i + 1);
				for(int y=i;y<=midIndex;y++)
				{
					inverseElements = new Comparable[2];
					inverseElements[0] = auxArray[y];
					inverseElements[1] = auxArray[j];
					inversionSet.add(inverseElements);
				}
				j++;
			}
		}
		
		//System.out.println("lowIndex = "+lowIndex+" midIndex = "+midIndex+" highIndex = "+highIndex);
		//System.out.println(toString(inputArray));
		
		countOfInversions = countOfInversions + resultCount;
			
	}
	
	private static boolean isLess(Comparable a,Comparable b)
	{
		if(a.compareTo(b) <= 0)//use <=0 rather than == -1
			return true;
		
		return false;
	}
	
	private static void SortAndCountOfInversions(Comparable[] inputArray,Comparable[] auxArray,int lowIndex,int highIndex)
	{
		if(lowIndex>=highIndex)
			return;
		
		int mid = lowIndex + (highIndex - lowIndex)/2;
		
		SortAndCountOfInversions(inputArray,auxArray,lowIndex,mid);
		SortAndCountOfInversions(inputArray,auxArray,mid+1,highIndex);
		MergeAndCountNoOfInversions(inputArray,auxArray,lowIndex,mid,highIndex);
	}
	
	private static int countNoOfInversions(Comparable[] inputArray)
	{
		SortAndCountOfInversions(inputArray,new Comparable[inputArray.length],0,inputArray.length-1);
		return countOfInversions;
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
		
		System.out.println(countNoOfInversions(arrayOfInts));
		//System.out.println(countNoOfInversions(arrayOfStrings));
		
		System.out.println(toString(arrayOfInts));
		//System.out.println(toString(arrayOfStrings));
		
		//System.out.println("Subh".substring(0,2));
		
		for(Comparable[] a:inversionSet)
		{
			System.out.println(toString(a));
		}
	}

}
