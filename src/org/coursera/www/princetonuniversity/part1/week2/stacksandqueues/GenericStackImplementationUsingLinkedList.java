package org.coursera.www.princetonuniversity.part1.week2.stacksandqueues;

import java.util.Iterator;

public class GenericStackImplementationUsingLinkedList<E> implements
		GenericStack<E>,Iterable<E>  {
	
	Node<E> headNode = null;

	@Override
	public E pop() {
		
		if(headNode != null)
		{
			Node<E> tempNode = headNode;
			headNode = tempNode.next;
			E eValue = (E) tempNode.getValue();
			tempNode = null;
			return eValue;
		}
		return null;
	}

	@Override
	public E top() {
		
		if(headNode != null)
			return (E) headNode.getValue();
		
		return null;
	}

	@Override
	public void push(E entity) {
		
		if(headNode != null)
		{
			Node<E> newNode = new Node<E>(headNode,entity);
			headNode = newNode;
		}
		else
			headNode = new Node<E>(null,entity);
		
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E>
	{
		
		private Node<E> currentNode = headNode;
		
		public boolean hasNext() 
		{
			if(currentNode != null)
				return true;
			
			return false;
		}

		public E next() 
		{
			Node<E> nextNode = currentNode;
			
			if(currentNode != null)
				currentNode = nextNode.next;
			
			return (E) nextNode.getValue();
		}

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

}
