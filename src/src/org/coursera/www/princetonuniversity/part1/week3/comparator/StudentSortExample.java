package org.coursera.www.princetonuniversity.part1.week3.comparator;

import java.util.Arrays;

public class StudentSortExample {
	
	public static void main(String args[])
	{
		Student[] studentArray = new Student[10];
		
		int[] arrayOfInts = new int[]{3,7,1,5,9,2,8,6,5,4};
		String[] arrayOfStrings = new String[]{"tea","bea","aea","dea","pea","zee","bee","fee","qee","mee"};
		
		for(int i =0;i<10;i++)
		{
			studentArray[i] = new Student(arrayOfStrings[i],arrayOfInts[i]);
		}
		
		toString(studentArray);
		Arrays.sort(studentArray,Student.byName);
		System.out.println("After sorting by Name");
		toString(studentArray);
		Arrays.sort(studentArray,Student.byRollNo);
		System.out.println("After sorting by Roll No");
		toString(studentArray);
		
	}
	
	public static void toString(Student[] inputArray)
	{
		StringBuilder str = null;
		for(int i=0;i<inputArray.length;i++)
		{
			str = new StringBuilder("");
			str = str.append(inputArray[i].getName()).append(" having roll no ").append(inputArray[i].getRollNo());
			System.out.println(str);
		}
	}

}
