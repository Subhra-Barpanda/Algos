package org.coursera.www.princetonuniversity.part1.week2.stacksandqueues;

public class StringStack {
	
	public static void main(String args[])
	{
		//GenericStackImplementationUsingLinkedList<String> stringStack = new GenericStackImplementationUsingLinkedList<String>();
		GenericStackImplementationUsingResizingArray<String> stringStack = new GenericStackImplementationUsingResizingArray<String>();
		stringStack.push("to");
		stringStack.push("be");
		stringStack.push("or");
		stringStack.push("not");
		
		StringBuilder result = new StringBuilder();
		
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		System.out.println("After Pop");
		stringStack.pop();
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		stringStack.push("be");
		
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		stringStack.push("subhra");
		
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		System.out.println("After Pop");
		stringStack.pop();
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		System.out.println("After Pop");
		stringStack.pop();
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		stringStack.push("that");
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		stringStack.pop();
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		stringStack.pop();
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		stringStack.pop();
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
		
		stringStack.push("is");
		
		result = new StringBuilder();
		for(String s:stringStack)
		{
			result = result.append(s).append(" ,");
		}
		System.out.println((result.substring(0,result.length()-2)).toString());
		System.out.println(stringStack.size());
	}

}
