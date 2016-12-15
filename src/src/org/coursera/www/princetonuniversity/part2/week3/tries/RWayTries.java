package org.coursera.www.princetonuniversity.part2.week3.tries;

public class RWayTries<V> {
	
	private static final int R = 256;
	private Node rootNode = new Node();
	
	private static class Node
	{
		private Object value;
		private Node[] next  = new Node[R];
	}
	
	public void put(String key,V value)
	{
		rootNode = put(rootNode,key,value,0);
	}

	private Node put(Node node, String key, V value, int elpasedStringlength) {
		
		if(node == null)
			node = new Node();
		
		if(key.length() == elpasedStringlength)
		{
			node.value = value;
			return node;
		}
		char c = key.charAt(elpasedStringlength);
		node.next[c] = put(node.next[c],key,value,elpasedStringlength+1);
		
		return node;
	}
	
	private V get(String key)
	{
		Node node = get(rootNode,key,0);
		if(node == null)
			return null;
		else
			return (V) node.value;
	}
	
	private Node get(Node node, String key, int index) {
		
		if(node == null)
			return null;
		if(key.length() == index)
			return node;
		char c = key.charAt(index);
		return get(node.next[c],key,index+1);
		
	}

	public static void main(String[] args)
	{
		RWayTries<Integer> trie = new RWayTries<Integer>();
		trie.put("so", 1);
		trie.put("soo", 2);
		trie.put("sow", 3);
		trie.put("the", 4);
		
		System.out.println(trie.get("soo"));
		System.out.println(trie.get("soe"));
		System.out.println(trie.get("sow"));
		
		trie.put("sow", 7);
		
		System.out.println(trie.get("sow"));
	}
}
