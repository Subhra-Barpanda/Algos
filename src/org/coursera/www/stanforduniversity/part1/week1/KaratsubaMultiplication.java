package org.coursera.www.stanforduniversity.part1.week1;

public class KaratsubaMultiplication 
{
	
	private static int s;

	private static int multiplySingleDigitNumbers(int a,int b)
	{
		return a*b;
	}
	
	public static int multiply(int a,int b)
	{
		int aLength = (String.valueOf(a)).length();
		int bLength = (String.valueOf(b)).length();
		int baseReturn = 0;
		
		System.out.println("a = "+a+" b = "+b+" aLength = "+aLength+" bLength = "+bLength);
		
		if(aLength <= 1 || bLength <= 1)
		{
			System.out.println("In return");
			baseReturn = multiplySingleDigitNumbers(a,b);
			System.out.println("baseReturn = "+baseReturn);
			return baseReturn;
		}
		
		int midOfA = 0;
		int midOfB = 0;
		
		int p = 0;
		int r = 0;
		int q = 0;
		int s = 0;
		
		if(aLength > 1)
		{
			midOfA = (int) Math.ceil(aLength/2);
			p = Integer.parseInt(String.valueOf(a).substring(0,midOfA));
			q = Integer.parseInt(String.valueOf(a).substring(midOfA,aLength));
		}
		else
		{
			p = 0;
			q = a;
		}
		
		if(bLength > 1)
		{
			midOfB = (int) Math.ceil(bLength/2);
			r = Integer.parseInt(String.valueOf(b).substring(0,midOfB));
			s = Integer.parseInt(String.valueOf(b).substring(midOfB,bLength));
		}
		else
		{
			r = 0;
			s = b;
		}
		
		System.out.println("midOfA = "+midOfA+" midOfB = "+midOfB);
		
		int pr = multiply(p,r);
		int qs = multiply(q,s);
		int  x = multiply(p + q, r + s);
		
		int z = x - pr - qs;
		
		System.out.println("pr = "+pr+" qs = "+qs+" x = "+x+" z = "+z);
		
		int result = ((int) (Math.pow(10, aLength/2)*Math.pow(10, bLength/2)*pr) +  (int) (Math.pow(10, aLength/2)*z) + qs);
		
		System.out.println("                                     result = "+result);
		
		return result;
	}
	
	public static void main(String[] a)
	{
		System.out.println(multiply(1234,5678));
	}
	
	
	
	

}
