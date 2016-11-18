package org.coursera.www.princetonuniversity.part1.week2.sorting;

import java.util.Random;

public class Shuffling {
	
	public static void shuffle(Comparable[] inputArray)
	{
		int randomIndex = 0;
		Random random = new Random();
		for(int i=0;i<inputArray.length;i++)
		{
			randomIndex = random.nextInt(i+1);
			System.out.println("randomIndex = "+randomIndex);
			swap(inputArray,i,randomIndex);
		}
	}
	
	public static void swap(Comparable[] inputArray,int p,int q)
	{
		Comparable temp = inputArray[p];
		inputArray[p] = inputArray[q];
		inputArray[q] = temp;
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
		Integer[] arrayOfInts = new Integer[]{1,2,3,4,5,6,7,8,9};
		
		String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		System.out.println(toString(arrayOfInts));
		
		shuffle(arrayOfInts);
		
		System.out.println(toString(arrayOfInts));
	}
}
