package arrays;

public class OwnArrayList<T> {
	
	private T[] innerArray = (T[])new Object[10];
	private T[] innerTempArray = (T[])new Object[innerArray.length];
	private int currIndex = -1;
	
	public void add(T e)
	{
		if((currIndex+1) == Math.ceil(innerArray.length/2))
		{
			resize();
		}
		currIndex = currIndex + 1;
		innerArray[currIndex] = e;
	}
	
	public void remove(int index)
	{
		currIndex = currIndex - 1;
		for(int i=currIndex;i<=currIndex;i++)
		{
			innerArray[i] = innerArray[i+1];
		}
	}
	
	public void set(int index,T e)
	{
		innerArray[index] = e;
	}
	
	public T get(int index)
	{
		return innerArray[index];
	}
	
	public int size()
	{
		return currIndex + 1;
	}
	
	private void resize()
	{
		System.out.println("resize called with original size = "+innerArray.length);
		innerTempArray = innerArray;
		innerArray = (T[])new Object[innerArray.length * 2];
		for(int i=0;i<=currIndex;i++)
		{
			innerArray[i] = innerTempArray[i];
		}
		System.out.println("resize called with resized size = "+innerArray.length);
	}
	
	public String toString()
	{
		String result = "";
		System.out.println("currIndex = "+currIndex);
		for(int i=0;i<=currIndex;i++)
		{
			result = result + innerArray[i]+" ,";
		}
		
		if(currIndex > -1)
			return result.substring(0,result.length() - 2);
		else
			return "No values inserted yet";
	}
	
	public static void main(String args[])
	{
		OwnArrayList<Integer> myIntList = new OwnArrayList<Integer>();
		System.out.println("myIntList = "+myIntList);
		myIntList.add(4);
		myIntList.add(5);
		System.out.println("myIntList = "+myIntList);
		System.out.println("myIntList.size() = "+myIntList.size());
		myIntList.add(6);
		System.out.println("myIntList.size() = "+myIntList.size());
		System.out.println("myIntList = "+myIntList);
		myIntList.remove(1);
		System.out.println("myIntList.size() = "+myIntList.size());
		System.out.println("myIntList = "+myIntList);
		myIntList.set(0, 10);
		System.out.println("myIntList.size() = "+myIntList.size());
		System.out.println("myIntList = "+myIntList);
	}

}
