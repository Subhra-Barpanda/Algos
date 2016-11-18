package org.coursera.www.princetonuniversity.part1.week2.stacksandqueues;

import java.util.Arrays;
import java.util.Iterator;

public class GenericStackImplementationUsingResizingArray<E> implements GenericStack<E>,Iterable<E>{

	private E[] stackArray;
	private int currIndex = -1;
	private int arrayLength;
	
	public GenericStackImplementationUsingResizingArray(/*int size*/)
	{
		this.arrayLength = 10;
		this.stackArray = (E[])new Object[arrayLength];
	}
	
	@Override
	public void push(E e) {
		if(currIndex == stackArray.length - 1)
			resizeArray(stackArray.length*2);
		stackArray[currIndex+1] = e;
		currIndex = currIndex + 1;
		
	}

	private void resizeArray(int i) {
		E[] tempArray = Arrays.copyOf(stackArray, i);
		stackArray = tempArray;
		tempArray = null;
		
	}

	@Override
	public E pop() {
		
		E poppedElement = stackArray[currIndex];
		stackArray[currIndex] = null;
		currIndex = currIndex - 1;
		
		if(currIndex <= stackArray.length/4)
			resizeArray(stackArray.length/2);
		
		
		return poppedElement;
	}

	@Override
	public E top() {
		return stackArray[currIndex];
	}

	@Override
	public Iterator<E> iterator() {
		return new ReverseListIterator();
	}
	
	public int size() {
		return stackArray.length;
	}
	
	private class ReverseListIterator implements Iterator<E>
	{

		int endOfStackIndex = currIndex;
		@Override
		public boolean hasNext() 
		{
			if(endOfStackIndex >= 0)
				return true;
			
			return false;
		}

		@Override
		public E next() 
		{
			return stackArray[endOfStackIndex--];
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
	
	/*public String toString()
	{
		StringBuilder result = new StringBuilder();
		for(int i=currIndex;i>=0;i--)
		{
			result = result.append(stackArray[i]).append(" , ");
		}
		
		return result.substring(0,result.length()-3);
		
	}*/

}
