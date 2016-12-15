package org.coursera.www.princetonuniversity.part1.week4.priorityqueues;

public class HeapSort 
{
	private static Comparable[] tempArray;
	private static void maintainHeapStructure(Comparable[] inputArray)
	{
		for(int i=inputArray.length/2;i>0;i--)
		{
			while(i*2<inputArray.length && (isLess(inputArray[i],inputArray[i*2]) || (i*2+1<inputArray.length && isLess(inputArray[i],inputArray[i*2+1]))))
			{
				if(i*2+1<inputArray.length && isLess(inputArray[i*2],inputArray[i*2+1]))
				{
					swap(inputArray,i,i*2+1);
					i = i*2+1;
				}
				else
				{
					swap(inputArray,i,i*2);
					i = i*2;
				}
			}
		}
	}
	
	private static void heapSort(Comparable[] inputArray)
	{
		int endOfArrayIndex = inputArray.length-1;
		while(endOfArrayIndex > 0)
		{
			swap(inputArray,1,endOfArrayIndex);
			//System.out.println("After swap = "+toString(inputArray));
			sink(inputArray,1,endOfArrayIndex);
			//System.out.println("After sink = "+toString(inputArray));
			endOfArrayIndex--;
		}
	}
	
	private static void sink(Comparable[] inputArray,int index,int currIndex) 
	{
		while(index*2<currIndex && (isLess(inputArray[index],inputArray[index*2]) || (index*2+1<currIndex && isLess(inputArray[index],inputArray[index*2+1]))))//removed = from index*2<=currIndex 
		{
			if(index*2+1 < currIndex && isLess(inputArray[index*2],inputArray[index*2+1]))
			{
				swap(inputArray,index,index*2+1);
				index = index*2+1;
			}
			else
			{
				swap(inputArray,index,index*2);
				index = index*2;
			}
		}
	}
	
	public static void sort(Comparable[] inputArray)
	{
		tempArray = new Comparable[inputArray.length+1];
		for(int i=1;i<tempArray.length;i++)
			tempArray[i] = inputArray[i-1];
		
		maintainHeapStructure(tempArray);
		System.out.println(toString(tempArray));
		heapSort(tempArray);
		
		for(int i=1;i<tempArray.length;i++)
			inputArray[i-1] = tempArray[i];
	}
	
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
		
		System.out.println(toString(arrayOfStrings));
		
		//System.out.println("lastIndex = "+lastIndex);
		
		sort(arrayOfStrings);
		
		System.out.println(toString(arrayOfStrings));
	}
	
	
}
