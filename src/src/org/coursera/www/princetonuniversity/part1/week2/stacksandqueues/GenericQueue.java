package org.coursera.www.princetonuniversity.part1.week2.stacksandqueues;

public interface GenericQueue<E> extends Iterable<E> {
	
	public void enqueue(E e);
	public E dequeue();
	public E peek();

}
