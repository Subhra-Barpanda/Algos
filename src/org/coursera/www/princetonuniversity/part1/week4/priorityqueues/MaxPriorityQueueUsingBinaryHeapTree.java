package org.coursera.www.princetonuniversity.part1.week4.priorityqueues;

import java.util.Iterator;

public class MaxPriorityQueueUsingBinaryHeapTree<Key extends Comparable<Key>> implements Iterable<Key> {

	private Key[] InputKeyArray;
	private int currIndex = 0;
	
	@Override
	public Iterator<Key> iterator() {
		
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Key>
	{		
		int startIndex = 1;
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
			return InputKeyArray[startIndex++];
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
	
	public MaxPriorityQueueUsingBinaryHeapTree(int size)
	{
		InputKeyArray = (Key[]) new Comparable[size+1];
	}
	
	public void insert(Key k)
	{
		if(currIndex + 1 <= InputKeyArray.length-1)
		{
			InputKeyArray[++currIndex] = k;
			if(currIndex > 1)
			{
				swim(currIndex);
			}
		}
		else
		{
			if(isLess(k,InputKeyArray[1]))
			{
				deleteMax();
				InputKeyArray[++currIndex] = k;
				swim(currIndex);
			}
		}
	}
	
	public void deleteMax()
	{
		swap(InputKeyArray,1,currIndex);
		InputKeyArray[currIndex] = null;
		currIndex = currIndex - 1;
		sink(1);
	}
	
	public Key extractMax()
	{
		return InputKeyArray[1];
	}
	
	public int size()
	{
		return currIndex;
	}

	private void sink(int index) 
	{
		while(index*2<=currIndex && (isLess(InputKeyArray[index],InputKeyArray[index*2]) || (index*2+1<=currIndex && isLess(InputKeyArray[index],InputKeyArray[index*2+1]))))//moved index*2+1<=currIndex to OR condition and replaced it with index*2<=currIndex  
		{
			if(index*2+1 <= currIndex && isLess(InputKeyArray[index*2],InputKeyArray[index*2+1]))
			{
				swap(InputKeyArray,index,index*2+1);
				index = index*2+1;
			}
			else
			{
				swap(InputKeyArray,index,index*2);
				index = index*2;
			}
		}
	}

	private void swim(int currIndex) 
	{
		while(currIndex != 1 && isLess(InputKeyArray[currIndex/2],InputKeyArray[currIndex]))
		{
			swap(InputKeyArray,currIndex/2,currIndex);
			currIndex = currIndex/2;
		}
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
	
	public static void main(String[] a)
	{
		MaxPriorityQueueUsingBinaryHeapTree<Integer> arrayOfInts = new MaxPriorityQueueUsingBinaryHeapTree<Integer>(5);
		//String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		arrayOfInts.insert(3);
		
		StringBuilder result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(7);
		
		result = new StringBuilder();
		for(Integer i:arrayOfInts)
		{
			result = result.append(i).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		
		arrayOfInts.insert(1);
		
		result = new StringBuilder();
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
