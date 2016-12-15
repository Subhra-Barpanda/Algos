package org.coursera.www.princetonuniversity.part1.week2.sorting;

public class ShellShort {
	
	//private static int hSortValue;
	//private static int highestHValueFactor;

	public static  boolean isLess(Comparable p,Comparable q)
	{
		if(p.compareTo(q) <= 0)
			return true;
		
		return false;
	}
	
	public static void swap(Comparable[] inputArray,int p,int q)
	{
		Comparable temp = inputArray[p];
		inputArray[p] = inputArray[q];
		inputArray[q] = temp;
	}
	
	public static void sort(Comparable[] inputArray)
	{
		/*highestHValueFactor = inputArray.length/3 - 1;
		while(highestHValueFactor >= 0)
		{
			hSortValue = 3*highestHValueFactor + 1;
			for(int i=0;i<inputArray.length;i++)
			{
				if(hSortValue == 1)
				{
					for(int j=i;j>0;j--)
					{
						if(j > 0 && isLess(inputArray[j],inputArray[j-1]))
						{
							swap(inputArray,j,j-1);
							//System.out.println("In Progress index ="  +toString(inputArray));
						}
						else
							break;
					}
				}
				else
				{
					for(int j=i;j+hSortValue<inputArray.length;j++)
					{
						if(j > 0 && isLess(inputArray[j+hSortValue],inputArray[j]))
						{
							swap(inputArray,j+hSortValue,j);
							//System.out.println("In Progress index ="  +toString(inputArray));
						}
					}
				}
				//System.out.println("In Progress ="  +toString(inputArray));
				
			}
			highestHValueFactor = highestHValueFactor - 1;
		}*/
		
		int h = 1;
		while(h < inputArray.length/3)
		{
			h = 3*h + 1;
		}
		
		while(h>=1)
		{
			for(int i=h;i<inputArray.length;i++)
			{
				for(int j=i;j>0;j=j-h)
				{
					if(j-h >= 0 && isLess(inputArray[j],inputArray[j-h]))
						swap(inputArray,j,j-h);
					else
						break;
				}
			}
			h = h/3;
		}
	}
	
	public static String toString(Comparable[] inputArray)
	{
		StringBuilder str = new StringBuilder("");
		for(int i=0;i<inputArray.length;i++)
		{
			str = str.append(inputArray[i]).append(" , ");
		}
		return str.substring(0, str.length() - 3).toString();
	}
	
	public static void main(String[] a)
	{
		//Integer[] arrayOfInts = new Integer[]{3,7,1,5,9,2,8,6,5,4};
		
		String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		System.out.println(toString(arrayOfStrings));
		
		sort(arrayOfStrings);
		
		System.out.println(toString(arrayOfStrings));
	}
}
