package arrays;

import java.util.LinkedList;
import java.util.List;

public class OwnLinkedList<E> {
	
	List linkedListinstance = new LinkedList();

	Node<E> currNode = null;
	Node<E> headNode = null;
	Node<E> tailNode = null;
	int noOfElements = 0;
	
	public void add(E data) 
	{
		Node<E> newNode = new Node<E>(data,null);
		//Node currNode = headNode;
		
		if(headNode == null)
			headNode = newNode;
		
		/*while(headNode != null && headNode.getNext() != null)
		{
			currNode = currNode.getNext();
		}
		currNode.getNext().setNext(newNode);*/
		
		if(tailNode == null)
			tailNode = newNode;
		else
		{
			tailNode.setNext(newNode);
			tailNode = newNode;
		}
		
		noOfElements = noOfElements + 1;
	}
	
	public void remove(int index) 
	{
		currNode = headNode;
		if(index <=  noOfElements)
		{
			for(int i=0;i<index-1;i++)
			{
				currNode = currNode.getNext();
			}
			currNode.setNext(currNode.getNext().getNext());
			noOfElements = noOfElements - 1;
		}
	}
	
	public int size()
	{
		return noOfElements;
	}
	
	public E get(int index)
	{
		currNode = headNode;
		if(index <=  noOfElements)
		{
			for(int i=0;i<index-1;i++)
			{
				currNode = currNode.getNext();
			}
			return (E) currNode.getNext().getNodeValue();
		}
		else
			return null;
	}
	
	public String toString()
	{
		String result = "";
		currNode = headNode;
		for(int i=0;i<noOfElements;i++)
		{
			result = result + currNode.getNodeValue().toString() + "," ;
			currNode = currNode.getNext();
		}
		
		if(headNode!=null)
			return result.substring(0,result.length()-1);
		else
			return "No Elements present";
	}
	
	public void add(E data, int index) 
	{
		
	}
	
	public static void main(String a[])
	{
		OwnLinkedList<String> newList = new OwnLinkedList<String>();
		System.out.println("newList = "+newList);
		System.out.println("newList.size() = "+newList.size());
		newList.add("Subhra");
		newList.add("Prakash");
		System.out.println("newList = "+newList);
		System.out.println("newList.size() = "+newList.size());
		System.out.println("newList.get(1) = "+newList.get(1));
		newList.add("dass");
		newList.add("rest");
		System.out.println("newList = "+newList);
		System.out.println("newList.size() = "+newList.size());
		newList.remove(2);
		System.out.println("newList = "+newList);
		System.out.println("newList.size() = "+newList.size());
		
	}
}
