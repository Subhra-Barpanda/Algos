package org.coursera.www.princetonuniversity.part1.week3.mergesort;

public class MergeSort {
	
	//private static Comparable[] auxillaryArray;
	
	public static void merge(Comparable[] inputArray,Comparable[] aux,int first,int mid,int last)
	{
		//System.out.println("In merge with first = "+first+" mid = "+mid+" last = "+last);
		assert(isSorted(inputArray,first,mid));
		assert(isSorted(inputArray,mid+1,last));
		
		for(int i=0;i<aux.length;i++)
		{
			aux[i] = inputArray[i];
		}
		for(int k=first,i=first,j=mid+1;k<=last;k++)
		{
			//System.out.println("i = "+i+" mid = "+mid+" j = "+j+" last = "+last);
			//System.out.println(toString(inputArray));
			if(i > mid)
			{
				inputArray[k] = aux[j];
				j = j + 1;
			}
			else if(j > last)
			{
				inputArray[k] = aux[i];
				i = i + 1;
			}
			else if(isLess(aux[i],aux[j]))
			{
				inputArray[k] = aux[i];
				i = i + 1;
			}
			else
			{
				inputArray[k] = aux[j];
				j = j + 1;
				
			}
		
		}
		
		//System.out.println(toString(inputArray));
		
		assert(isSorted(inputArray,first,last));
	}
	
	private static boolean isSorted(Comparable[] inputArray, int first, int last) 
	{
		
		boolean flag= false;
		
		for(int i=first+1;i<=last;i++)
		{
			if(isLess(inputArray[i-1],inputArray[i]))
			{
				flag = true;
				continue;
			}
			else
			{
				flag = false;
				break;
			}
				
		}
		return flag;
	}

	public static void sort(Comparable[] inputArray,Comparable[] aux,int start,int last)
	{
		if(start >= last)
		{
			return;
		}
		
		int mid = start + (last - start)/2;
		
		sort(inputArray,aux,start,mid);
		
		//System.out.println("start = "+start+" mid = "+mid);
		
		sort(inputArray,aux,mid+1,last);
		
		//System.out.println("mid = "+mid+" last = "+last);
		
		merge(inputArray,aux,start,mid,last);
	}
	
	private static void sort(Comparable[] inputArray)
	{
		sort(inputArray,new Comparable[inputArray.length],0,inputArray.length-1);
	}
	
	public static  boolean isLess(Comparable p,Comparable q)
	{
		if(p.compareTo(q) <= 0)
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
	
	public static void main(String[] a)
	{
		Integer[] arrayOfInts = new Integer[]{3,7,1,5,9,2,8,6,5,4,0};
		
		String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		//System.out.println(toString(arrayOfInts));
		System.out.println(toString(arrayOfStrings));
		
		//System.out.println("lastIndex = "+lastIndex);
		
		//sort(arrayOfInts);
		sort(arrayOfStrings);
		
		//System.out.println(toString(arrayOfInts));
		System.out.println(toString(arrayOfStrings));
	}

}
