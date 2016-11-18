package org.coursera.www.princetonuniversity.part1.week2.stacksandqueues;

import java.util.Iterator;

public class GenericQueueImplementationUsingLinkedList<E> implements
		GenericQueue<E> {

	Node<E> headNode = null;
	Node<E> tailNode = null;
	
	@Override
	public void enqueue(E e) {
		
		Node<E> currHeadNode = headNode;
		if(currHeadNode != null)
		{
			headNode = new Node<E>(currHeadNode, e);
		}
		else
		{
			headNode = new Node<E>(currHeadNode, e);
			tailNode = headNode;
		}
	}

	@Override
	public E dequeue() {
		
		Node<E> tempNode = null;
		if(tailNode != null && headNode != tailNode)
		{
			Node<E> currNode = headNode;
			
			while(currNode.next != tailNode)
			{
				currNode = currNode.next;
			}
			
			tailNode = currNode;
			tempNode = currNode.next;
			currNode.next = null;
			
			return tempNode.value;
		}
		else if(tailNode != null && headNode == tailNode)
		{
			tempNode = headNode;
			headNode = null;
			tailNode = null;
			return tempNode.value;
			
		}
		else
			return null;
	}

	@Override
	public E peek() {
		if(headNode != null)
			return headNode.getValue();
		else
			return null;
	}
	
	public int size()
	{
		int size = 0;
		Node<E> currNode = headNode;
		
		while(currNode != null)
		{
			size++;
			currNode = currNode.next;
		}
		
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<E>
	{

		Node<E> currNode = headNode;
		@Override
		public boolean hasNext() {
			
			
			if(currNode != null)
				return true;
			
			return false;
		}

		@Override
		public E next() {
			
			Node<E> tempNode = currNode;
			if(currNode != null)
			{
				currNode = currNode.next;
				return tempNode.value;
			}
			
			return null;
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

	public static void main(String args[])
	{
		GenericQueueImplementationUsingLinkedList<String> stringQueue = new GenericQueueImplementationUsingLinkedList<String>();
		//GenericStackImplementationUsingResizingArray<String> stringStack = new GenericStackImplementationUsingResizingArray<String>();
		stringQueue.enqueue("to");
		stringQueue.enqueue("be");
		stringQueue.enqueue("or");
		stringQueue.enqueue("not");
		
		StringBuilder result = new StringBuilder();
		
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringStack.size());
		
		System.out.println("After dequeue");
		stringQueue.dequeue();
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		stringQueue.enqueue("be");
		
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		stringQueue.enqueue("subhra");
		
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		System.out.println("After dequeue");
		stringQueue.dequeue();
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		System.out.println("After dequeue");
		stringQueue.dequeue();
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		stringQueue.enqueue("that");
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		stringQueue.dequeue();
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		stringQueue.dequeue();
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		stringQueue.dequeue();
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
		
		stringQueue.enqueue("is");
		
		result = new StringBuilder();
		for(String s:stringQueue)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		//System.out.println(stringQueue.size());
	}
	
}
