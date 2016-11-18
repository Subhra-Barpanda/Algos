package org.coursera.www.princetonuniversity.part1.week4.symboltables;

import java.util.Iterator;

public class SymbolTableBasicUnorderedImpl<T,E> implements Iterable<T>
{
	private Node headNode = null;
	
	private class Node
	{
		private Node next;
		private T key;
		private E value;
		
		public T getKey() {
			return key;
		}
		/*public void setKey(T key) {
			this.key = key;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}*/
		
		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		
		public Node(Node next, T key, E value) {
			super();
			this.next = next;
			this.key = key;
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}
	}
	
	public boolean contains(T Key)
	{
		return get(Key) != null;
	}
	
	public E get(T Key)
	{
		Node currNode = headNode;
		while(currNode != null)
		{
			if(currNode.getKey().equals(Key))
				return (E) currNode.getValue();
			
			currNode = currNode.next;
		}
		return null;
	}
	
	public void put(T Key,E Value)
	{
		if(headNode == null)
			headNode = new Node(null,Key,Value);
		
		else
		{
			boolean breakFkag = false;
			Node currNode = headNode;
			
			while(currNode != null)
			{
				if(currNode.getKey().equals(Key))
				{
					breakFkag = true;
					currNode.setValue(Value);
					break;
				}
				else
					currNode = currNode.next;
			}
			if(!breakFkag)
			{
				Node newNode = new Node(headNode,Key,Value);
				headNode = newNode;
			}
		}
	}
	
	public boolean isEmpty()
	{
		return headNode == null;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T>
	{
		private Node currNode = headNode;

		@Override
		public boolean hasNext() {
			
			if(currNode != null)
				return true;
			
			return false;
		}

		@Override
		public T next() {
			
			Node tempNode = currNode;
			currNode = currNode.next;
			return tempNode.getKey();
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
		SymbolTableBasicUnorderedImpl<Integer,String> impl = new SymbolTableBasicUnorderedImpl<Integer,String>();
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
