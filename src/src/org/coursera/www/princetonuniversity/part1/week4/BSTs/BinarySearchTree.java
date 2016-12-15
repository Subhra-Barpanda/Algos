package org.coursera.www.princetonuniversity.part1.week4.BSTs;

import java.util.Iterator;
import org.coursera.www.princetonuniversity.part1.week2.stacksandqueues.GenericQueue;
import org.coursera.www.princetonuniversity.part1.week2.stacksandqueues.GenericQueueImplementationUsingLinkedList;

public class BinarySearchTree<K extends Comparable<K>,V> implements Iterable<K>
{
	private Node headNode = null;
	private GenericQueueImplementationUsingLinkedList<K> queue = new GenericQueueImplementationUsingLinkedList<K>();
	
	private class Node
	{
		private K key;
		private V value;
		private Node left;
		private Node right;
		private int count;
		
		/*public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}*/

		public K getKey() {
			return key;
		}
		
		/*public void setKey(K key) {
			this.key = key;
		}*/
		public V getValue() {
			return value;
		}
		/*public void setValue(V value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}*/
		
		public Node(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}	
	}
	
	public V get(K key)
	{
		Node currNode = headNode;
		while(currNode != null)
		{
			int compareValue = currNode.getKey().compareTo(key);
			if(compareValue == 0)
				return currNode.getValue();
			else if(compareValue < 0)
				currNode = currNode.right;
			else
				currNode = currNode.left;
		}
		
		return null;	
	}
	
	public void put(K key,V value)
	{
		headNode = put(headNode,key,value);
	}

	private Node put(Node node, K key, V value) 
	{
		if(node == null)
		{
			node = new Node(key,value);
		}
		else
		{
			int compareValue = node.getKey().compareTo(key);
			if(compareValue < 0)
				node.right = put(node.right,key,value);
			else if(compareValue > 0)
				node.left = put(node.left,key,value);
			else
				node.value = value;
		}
		
		node.count =  1 + getSize(node.left) + getSize(node.right);
		
		return node;
	}
	
	public K getMinKey()
	{
		Node currNode = headNode;
		while(currNode != null && currNode.left != null)
		{
			currNode = currNode.left;
		}
		if(headNode != null)
			return currNode.getKey();
		else
			return null;
	}
	
	public K getMaxKey()
	{
		Node currNode = headNode;
		while(currNode != null && currNode.right != null)
		{
			currNode = currNode.right;
		}
		if(headNode != null)
			return currNode.getKey();
		else
			return null;
	}
	
	public int getSize()
	{
		return getSize(headNode);
	}
	
	private int getSize(Node x)
	{
		if(x == null)
			return 0;
		else
			return x.count;
	}
	
	public K floorOfKey(K key)
	{
		Node x = floorOfKey(key,headNode);
		if(x != null)
			return x.key;
		
		return null;
	}

	private Node floorOfKey(K key, Node node) {
		if(node == null)
			return null;
		else
		{
			int compareValue = key.compareTo(node.key);
			if(compareValue == 0)
				return node;
			else if(compareValue < 0)
			{
				return floorOfKey(key,node.left);
			}
			Node x = floorOfKey(key,node.right);
			if(x != null)
				return x;
			else
				return node;
		}
	}
	
	public K ceilingOfKey(K key)
	{
		Node x = ceilingOfKey(key,headNode);
		if(x != null)
			return x.key;
		
		return null;
	}

	private Node ceilingOfKey(K key, Node node) {
		if(node == null)
			return null;
		else
		{
			int compareValue = key.compareTo(node.key);
			if(compareValue == 0)
				return node;
			else if(compareValue > 0)
			{
				return ceilingOfKey(key,node.right);
			}
			Node x = ceilingOfKey(key,node.left);
			if(x != null)
				return x;
			else
				return node;
		}
	}
	
	public int getRank(K key)
	{
		return getRank(key,headNode);
	}

	private int getRank(K key, Node node) {
		if(node == null)
			return 0;
		else
		{
			int compareValue = key.compareTo(node.key);
			
			if(compareValue > 0)
				return 1 + getRank(node.key,node);
			else if(compareValue < 0)
				return 1;
			else
				return 1 + getSize(node.left);
		}
	}

	@Override
	public Iterator<K> iterator() {
		
		inOrderTraversal(headNode,queue);
		return queue.iterator();
	}
	
	public Iterator<K> iterator(K start,K end) {
		inOrderTraversal(headNode,queue,start,end);
		return queue.iterator();
	}
	
	private void inOrderTraversal(Node node,GenericQueue<K> queue)
	{
		if(node == null)
			return;
		inOrderTraversal(node.right,queue);
		queue.enqueue(node.key);
		inOrderTraversal(node.left,queue);
	}
	
	private void inOrderTraversal(Node node,GenericQueue<K> queue,K start,K end)
	{
		if(node == null)
			return;
		inOrderTraversal(node.right,queue,start,end);
		if(node.key.compareTo(start) >= 0 && node.key.compareTo(end) <= 0)
			queue.enqueue(node.key);
		inOrderTraversal(node.left,queue,start,end);
	}
	
	
	public static void main(String a[])
	{
		BinarySearchTree<String,Integer> bst = new BinarySearchTree<String,Integer>();
		bst.put("S", 1);
		bst.put("E", 2);
		bst.put("X", 3);
		bst.put("A", 4);
		bst.put("R", 5);
		bst.put("C", 6);
		bst.put("H", 7);
		bst.put("G", 8);
		bst.put("M", 9);
		
		/*System.out.println(bst.getMaxKey());
		System.out.println(bst.getMinKey());
		System.out.println(bst.getSize());
		System.out.println(bst.get("C"));*/
		//System.out.println(bst.getRank("E"));
		
		/*System.out.println(bst.floorOfKey("I"));
		System.out.println(bst.ceilingOfKey("I"));*/
		
		/*StringBuilder result = new StringBuilder();
		for(String key:bst)
			result.append(key).append(",");
		
		System.out.println(result.substring(0,result.length()-1));*/
		
		StringBuilder result = new StringBuilder();
		
		Iterator<String> itr = bst.iterator("A", "M");
		while(itr.hasNext())
		{
			result = result.append(itr.next()).append(",");
		}
		
		System.out.println(result.substring(0,result.length()-1));
	}
}
