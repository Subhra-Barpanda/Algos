package stacks;

public class StackImplementation<E> implements Stack<E>{

	private E[] stackArray;
	private int currIndex = -1;
	private int arrayLength;
	//stackArray = new E[size];
	
	
	public StackImplementation(int size)
	{
		this.arrayLength = size;
		this.stackArray = (E[])new Object[arrayLength];
	}
	
	@Override
	public void push(E e) {
		stackArray[currIndex+1] = e;
		currIndex = currIndex + 1;
		
	}

	@Override
	public E pop() {
		
		E poppedElement = stackArray[currIndex];
		stackArray[currIndex] = null;
		currIndex = currIndex - 1;
		return poppedElement;
	}

	@Override
	public int size() {
		return currIndex+1;
	}

	@Override
	public E top() {
		return stackArray[currIndex];
	}
	
	public String toString()
	{
		StringBuilder result = new StringBuilder();
		for(int i=currIndex;i>=0;i--)
		{
			result = result.append(stackArray[i]).append(" , ");
		}
		
		return result.substring(0,result.length()-3);
		
	}

}
