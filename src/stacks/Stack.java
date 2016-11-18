package stacks;

public interface Stack<E> {
	
	public void push(E e);
	public E pop();
	public int size();
	public E top();
	public String toString();
	

}
