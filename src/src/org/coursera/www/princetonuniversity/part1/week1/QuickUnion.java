package org.coursera.www.princetonuniversity.part1.week1;

public class QuickUnion {
	
	//private int length;
	private int[] originalArray;
	
	public QuickUnion(int size)
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
			return getRoot(p) == getRoot(q);
		else
			return false;
	}
	
	public void union(int p,int q)
	{
		int rootp = getRoot(p);
		int rootq = getRoot(q);
		if(p >= 0 && q >= 0 && p < originalArray.length && q < originalArray.length && !isConnected(p,q))
		{
			/*if(p==6 && q==1)
			{
				System.out.println("rootp = "+rootp);
				System.out.println("rootq = "+rootq);
				System.out.println("originalArray[p] = "+originalArray[p]);
				System.out.println("originalArray[rootq] = "+originalArray[rootq]);
			}*/
			originalArray[rootp] = originalArray[rootq];
		}
		else
			System.out.println("Index is out of Bounds");
	}
	
	public int getRoot(int p)
	{
		while(originalArray[p] != p)
			p = originalArray[p];
		
		return p;
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
		QuickUnion qf = new QuickUnion(10);
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
