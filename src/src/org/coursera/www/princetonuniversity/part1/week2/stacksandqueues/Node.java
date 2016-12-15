package org.coursera.www.princetonuniversity.part1.week2.stacksandqueues;

public class Node<E> {
	
	Node next;
	E value;
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	
	public Node(Node<E> next, E value) {
		super();
		this.next = next;
		this.value = value;
	}
	
	/*public String toString()
	{
		return (String) value;
	}*/
}
