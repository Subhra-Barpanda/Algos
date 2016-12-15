package arrays;

public class Node<E> {

	private E nodeValue;
	private Node<E> next;
	
	public Node(E nodeValue, Node<E> next) {
		super();
		this.nodeValue = nodeValue;
		this.next = next;
	}
	
	public E getNodeValue() {
		return nodeValue;
	}
	public void setNodeValue(E nodeValue) {
		this.nodeValue = nodeValue;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
}
