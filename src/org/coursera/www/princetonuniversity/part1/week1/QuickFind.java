package org.coursera.www.princetonuniversity.part1.week1;

public class QuickFind {
	
	//private int length;
	private int[] originalArray;
	
	public QuickFind(int size)
	{
		//this.length = size;
		originalArray = new int[size];
		for(int i=0;i<originalArray.length;i++)
		{
			originalArray[i] = i;
		}
	}
	
	public boolean isConnected(int p,int q)
	{
		if(p >= 0 && q>=0 && p<originalArray.length && q<originalArray.length)
			return originalArray[p] == originalArray[q];
		else
			return false;
	}
	
	public void union(int p,int q)
	{
		if(p >= 0 && q >= 0 && p < originalArray.length && q < originalArray.length && !isConnected(p,q))
		{
			int originalValue = originalArray[p];
			for(int i=0;i<originalArray.length;i++)
			{
				if(originalArray[i] == originalValue)
					originalArray[i] = originalArray[q];
			}
		}
		else
			System.out.println("Index is out of Bounds");
	}
	
	public String toString()
	{
		String result = "";
		for(int i=0;i<originalArray.length;i++)
		{
			result = result + originalArray[i] + " , ";
		}
		
		return result.substring(0,result.length()-3);
		
	}
	
	public static void main(String a[])
	{
		QuickFind qf = new QuickFind(10);
		System.out.println(qf.toString());
		qf.union(4, 3);
		System.out.println(qf.toString());
		qf.union(3, 8);
		System.out.println(qf.toString());
		qf.union(6, 5);
		System.out.println(qf.toString());
		qf.union(9, 4);
		System.out.println(qf.toString());
		qf.union(2, 1);
		System.out.println(qf.toString());
		System.out.println("connected(0, 7) = "+qf.isConnected(0, 7));
		System.out.println("connected(8, 9) = "+qf.isConnected(8, 9));
		qf.union(5, 0);
		System.out.println(qf.toString());
		qf.union(7, 2);
		System.out.println(qf.toString());
		qf.union(6, 1);
		System.out.println(qf.toString());
		qf.union(1, 0);
		System.out.println(qf.toString());
		System.out.println("connected(0, 7) = "+qf.isConnected(0, 7));	
	}

}
