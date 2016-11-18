package org.coursera.www.princetonuniversity.part1.week4.symboltables;

import java.util.Iterator;

public class SymbolTablesOrderedImpl<K extends Comparable<K>,V> implements Iterable<K>
{
	private K[] keyArray = null;
	private V[] valueArray = null;
	int currIndex = -1;
	
	public SymbolTablesOrderedImpl(int size)
	{
		keyArray = (K[]) new Comparable[size];
		valueArray = (V[]) new Object[size];
	}
	
	public V get(K key)
	{
		if(currIndex == -1)
			return null;
		
		int searchHitIndex = bSearch(key);
		if(searchHitIndex <= currIndex && keyArray[searchHitIndex].compareTo(key) == 0)
			return valueArray[searchHitIndex];
		
		return null;
	}
	
	public void put(K key,V value)
	{
		int searchHitIndex = -1;
		if(currIndex == -1)
		{
			keyArray[++currIndex] = key;
			valueArray[currIndex] = value;
		}
		else
		{
			searchHitIndex = bSearch(key);
			if(searchHitIndex <= currIndex && keyArray[searchHitIndex].compareTo(key) == 0)
				valueArray[searchHitIndex] = value;
			else
			{
				currIndex++;
				for(int i=currIndex;i>searchHitIndex;i--)
				{
					keyArray[i] = keyArray[i-1];
					valueArray[i] = valueArray[i-1];
				}
				keyArray[searchHitIndex] = key;
				valueArray[searchHitIndex] = value;
				
			}
		}
	}
	
	public boolean contains(K key)
	{
		return get(key) != null;
	}
	
	public int bSearch(K key)
	{
		int midIndex = 0;
		int lowIndex = 0;
		int highIndex = currIndex;
		
		while(lowIndex<=highIndex)
		{
			midIndex = lowIndex + (highIndex - lowIndex)/2;

			if(keyArray[midIndex].compareTo(key) == 0)
				return midIndex;
			else if(keyArray[midIndex].compareTo(key) == -1)
			{
				lowIndex = midIndex + 1;
			}
			else if(keyArray[midIndex].compareTo(key) == 1)
			{
				highIndex = midIndex - 1;
			}
		}
		
		return lowIndex;
	}
	
	@Override
	public Iterator<K> iterator() {
		return new OrderedIterator();
	}
	
	private class OrderedIterator implements Iterator<K>
	{
		private int startIndex = 0;
		@Override
		public boolean hasNext() {
			if(startIndex <= currIndex)
				return true;
			
			return false;
		}

		@Override
		public K next() {
			return keyArray[startIndex++];
		}

		@Override
		public void remove() {
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
	
	public static void main(String a[])
	{
		SymbolTablesOrderedImpl<Integer,String> impl = new SymbolTablesOrderedImpl<Integer, String>(10);
		impl.put(2, "A");
		impl.put(1, "B");
		impl.put(6, "C");
		for(Integer i:impl)
		{
			System.out.println("Key = "+i+" has value = "+impl.get(i));
		}
		impl.put(3, "D");
		impl.put(6, "X");
		for(Integer i:impl)
		{
			System.out.println("Key = "+i+" has value = "+impl.get(i));
		}
		System.out.println(impl.contains(5));
		System.out.println(impl.get(5));
		System.out.println(impl.get(2));
		System.out.println(impl.contains(6));
	}
	
}
