package com.util;

import java.util.regex.Pattern;

public class CheckValidation
{
	public static boolean checkName(String name)
	{
		boolean isError=false;
		
		if(name==null || name=="" || name.trim().length()<0)
		{
			System.out.println("yes");
			isError=true;
		}
		return isError;
	}
	public static boolean checkPrice(int price)
	{
		boolean isError=false;
		
		if(price<=0)
		{
			isError=true;
		}
		return isError;
	}
	public static boolean checkQty(int qty)
	{
		boolean isError=false;
		
		if(qty<=0)
		{
			isError=true;
		}
		return isError;
	}
	public static boolean checkuName(String uName)
	{
		boolean isError=false;
		
		if(uName==null || uName=="" || uName.trim().length()<0)
			isError=true;
		
		return isError;
	}
	public static boolean checkuEmail(String uEmail)
	{
		boolean isError=false;
		Pattern p=Pattern.compile("[a-zA-Z0-9]{1,15}[@]{1}[a-z]{1,6}[.]{1}[c]{1}[o]{1}[m]{1}");
		
		if(!p.matches("[a-z0-9]{1,15}[@]{1}[a-z]{1,6}[.]{1}[c]{1}[o]{1}[m]{1}", uEmail))
			isError=true;
		
		return isError;
	}
	public static boolean checkuPassword(String uPassword)
	{
		boolean isError=false;
		Pattern p1=Pattern.compile("[a-zA-Z0-9@!^&*#$%]{6,12}");
		
		if(!p1.matches("[a-zA-Z0-9@!^&*#$%]{6,12}",uPassword))
			isError=true;
		
		return isError;
	}
	public static boolean checkuAge(int uAge)
	{
		boolean isError=false;
		
		if(!(uAge>10 && uAge<100))
			isError=true;
		
		return isError;	
	}
	
}
