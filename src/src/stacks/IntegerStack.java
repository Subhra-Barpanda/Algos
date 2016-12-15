package stacks;

public class IntegerStack {
	
	public static void main(String a[])
	{
		StackImplementation<Integer> intStack = new StackImplementation<Integer>(1000);
		System.out.println(intStack.size());
		intStack.push(45);
		intStack.push(37);
		System.out.println(intStack.size());
		System.out.println(intStack); 
		System.out.println(intStack.top());
		intStack.push(12);
		intStack.push(15);
		System.out.println(intStack.top());
		System.out.println(intStack);
		intStack.pop();
		System.out.println(intStack);
		
	}

}
