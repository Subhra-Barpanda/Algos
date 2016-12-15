package org.coursera.www.princetonuniversity.part1.week6.hashtables;

public class SeparateChainingSymbolTable<K,V> {
	
	private static int M = 16;
	
	private Node[] nodeArray = new Node[M];
	
	private static class Node
	{
		private Object key;
		private Object value;
		private Node next;
		
		public Node(Object key, Object value, Node next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private int hash(K key)
	{
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	public boolean contains(K key)
	{
		return get(key) != null;
	}
	
	public V get(K key)
	{
		int hash = hash(key);
		Node node = null;
		for(node = nodeArray[hash];node != null;node = node.next)
		{
			if(key.equals(node.key))
				return (V) node.value;
		}
		return null;
	}
	
	public void put(K key,V value)
	{
		int hash = hash(key);
		Node node = null;
		boolean breakFlag = false;
		for(node = nodeArray[hash];node != null;node = node.next)
		{
			if(key.equals(node.key))
			{
				node.value = value;
				breakFlag = true;
				break;
			}
		}
		if(!breakFlag)
			nodeArray[hash] = new Node(key,value,nodeArray[hash]);
	}
	
	public static void main(String a[])
	{
		SeparateChainingSymbolTable<Integer,String> impl = new SeparateChainingSymbolTable<Integer,String>();
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
