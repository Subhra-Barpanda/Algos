package org.coursera.www.princetonuniversity.part1.week3.comparator;

import java.util.Comparator;

public class Student {
	
	public static Comparator<Student> byName = new byName();
	public static Comparator<Student> byRollNo = new byRollNo();
	
	private String name;
	private int rollNo;
	
	public Student(String name, int rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	
	private static class byName implements Comparator<Student>
	{
		public int compare(Student s1, Student s2) {
			return s1.name.compareTo(s2.name);
		}
		
	}
	
	private static class byRollNo implements Comparator<Student>
	{
		public int compare(Student s1, Student s2) {
			return s1.rollNo - s2.rollNo;
		}
		
	}

}
