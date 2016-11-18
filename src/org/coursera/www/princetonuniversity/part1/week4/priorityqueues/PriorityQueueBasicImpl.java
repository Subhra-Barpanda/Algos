package org.coursera.www.princetonuniversity.part1.week4.priorityqueues;

import java.util.Iterator;

import org.coursera.www.princetonuniversity.part1.week2.stacksandqueues.Node;

public class PriorityQueueBasicImpl<Key extends Comparable<Key>> implements Iterable<Key> {
	
	private Key[] priorityQueue;
	private int currIndex = -1;
	
	public PriorityQueueBasicImpl(int size)
	{
		priorityQueue = (Key[]) new Comparable[size];
	}
	
	public void insert(Key k)
	{
		if(currIndex < priorityQueue.length-1)
		{
			currIndex = currIndex + 1;
			priorityQueue[currIndex] = k;
		}
		else 
		{
			//System.out.println("currIndex = "+currIndex);
			deleteMax(k);
		}
	}

	private void deleteMax(Key k) {
		
		int maxKeyIndex = findMaxIndex();
		
		//System.out.println("maxKeyIndex = "+maxKeyIndex);
		
		if(isLess(k,priorityQueue[maxKeyIndex]))
		{
			//System.out.println("inside replace");
			swap(priorityQueue,maxKeyIndex,priorityQueue.length-1);//swap with last element and override with new value
			priorityQueue[currIndex] = k;
		}
		
	}
	
	private int findMaxIndex()
	{
		int maxKeyIndex = 0;
		
		for(int i=1;i<priorityQueue.length;i++)
		{
			if(isLess(priorityQueue[maxKeyIndex],priorityQueue[i]))
				maxKeyIndex = i;
		}
		
		return maxKeyIndex;
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
	
	@Override
	public Iterator<Key> iterator() {
		
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Key>
	{		
		int startIndex = 0;
		@Override
		public boolean hasNext() 
		{
			if(startIndex <= currIndex)
				return true;
			
			return false;
		}

		@Override
		public Key next() 
		{
			return priorityQueue[startIndex++];
		}

		@Override
		public void remove() 
		{
			try 
			{
				throw new Exception("Not Supported");
			} 
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static void main(String[] a)
	{
		PriorityQueueBasicImpl<Integer> arrayOfInts = new PriorityQueueBasicImpl<Integer>(5);
		//String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		arrayOfInts.insert(3);
		arrayOfInts.insert(7);
		arrayOfInts.insert(1);
		
		StringBuilder result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(5);
		arrayOfInts.insert(9);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(2);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(8);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(6);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(5);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(4);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(0);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
	}

	

}
