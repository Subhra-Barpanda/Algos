package org.coursera.www.princetonuniversity.part1.week5.balancedsearchtrees;

public class RedBlackBST<K extends Comparable<K>,V> {
	
	private Node headNode = null;
	private static boolean RED = true;
	private static boolean BLACK = false;
	
	private class Node
	{
		private K key;
		private V value;
		private Node left;
		private Node right;
		private boolean color;
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public Node(K key, V value, boolean color) {
			super();
			this.key = key;
			this.value = value;
			this.color = color;
		}
	}
	
	public boolean isRedColor(Node node)
	{
		if(node == null)
			return false;
		else
		{
			if(node.color == RED)
				return true;
			
			return false;
		}
	}
	
	public V get(K key)
	{
		int compareValue = -1;
		Node currNode = headNode;
		while(currNode != null)
		{
			compareValue = key.compareTo(headNode.getKey());
			if(compareValue < 0)
				currNode = currNode.left;
			else if(compareValue > 0)
				currNode = currNode.right;
			else
				return currNode.getValue();
		}
		
		return null;
	}
	
	public void put(K key,V value)
	{
		headNode = put(headNode,key,value);
	}
	
	private Node put(Node node,K key,V value)
	{
		if(node == null)
			return new Node(key,value,RED);
		else
		{
			int compareValue = key.compareTo(node.getKey());
			if(compareValue < 0)
				node.left = put(node.left,key,value);
			else if(compareValue > 0)
				node.right = put(node.right,key,value);
			else
				node.value = value;
		}
		
		if(!isRedColor(node.left) && isRedColor(node.right))
			node = rotateLeft(node);
		if(isRedColor(node.left) && isRedColor(node.left.left))
			node = rotateRight(node);
		if(isRedColor(node.left) && isRedColor(node.right))
			flipColors(node);
		
		return node;
	}

	private void flipColors(Node node) {
		node.left.color =  BLACK;
		node.right.color =  BLACK;
		node.color = RED;
	}

	private Node rotateRight(Node node) {
		Node h = node.left;
		Node x = h.right;
		h.right = node;
		node.left = x;
		h.color = node.color;
		node.color = RED;
		return h;
		
	}

	private Node rotateLeft(Node node) {
		Node h = node.right;
		Node x = h.left;
		h.left = node;
		node.right = x;
		h.color = node.color;
		node.color = RED;
		return h;
	}
	
	
}
