package org.coursera.www.princetonuniversity.part1.week6.hashtables;

public class LinearProbingSymbolTable<K,V> {
	
	private static final int M = 15;
	private Object[] keyArray = new Object[M];
	private Object[] valueArray = new Object[M];
	
	private int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	public V get(K key)
	{
		int hash = hash(key);
		while(keyArray[hash] != null)
		{
			if(keyArray[hash].equals(key))
				return (V) valueArray[hash];
			else
				hash = (hash + 1)%M;
		}
		return null;
	}
	
	public boolean contains(K key)
	{
		return get(key) != null;
	}
	
	public void put(K key,V value)
	{
		int hash = hash(key);
		boolean breakFlag = false;
		while(keyArray[hash] != null)
		{
			if(keyArray[hash].equals(key))
			{
				valueArray[hash] = value;
				breakFlag = true;
				break;
			}
			else
				hash = (hash + 1)%M;
		}
		if(!breakFlag)
		{
			keyArray[hash] = key;
			valueArray[hash] = value;
		}
	}
	
	public static void main(String a[])
	{
		LinearProbingSymbolTable<Integer,String> impl = new LinearProbingSymbolTable<Integer,String>();
		impl.put(2, "A");
		impl.put(1, "B");
		impl.put(6, "C");
		
		impl.put(3, "D");
		impl.put(6, "X");
		
		System.out.println(impl.contains(5));
		System.out.println(impl.get(5));
		System.out.println(impl.get(2));
		System.out.println(impl.contains(6));
		System.out.println(impl.get(6));
	}

}
