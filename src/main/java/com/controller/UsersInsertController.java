package com.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UsersBean;
import com.doa.UsersDao;
import com.util.CheckValidation;

/**
 * Servlet implementation class UsersInsertController
 */
public class UsersInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uName=request.getParameter("txtUserName");
		int uAge=Integer.parseInt(request.getParameter("txtUserAge"));
		String uEmail=request.getParameter("txtUserEmail");
		String uPassword=request.getParameter("pwdUserPassword");
		boolean isError=false;
		
		UsersBean ub=new UsersBean();
		
		if(CheckValidation.checkuName(uName))
		{
			isError=true;
			request.setAttribute("uName", "*Name cannot be Empty");
		}	
		else
			ub.setuName(uName);
		
		if(CheckValidation.checkuAge(uAge))
		{
			isError=true;
			request.setAttribute("uAge", "*Age must be between 18 to 100");
		}	
		else
			ub.setuAge(uAge);
	
		if(CheckValidation.checkuEmail(uEmail))
		{
			isError=true;
			request.setAttribute("uEmail", "*Enter valid Email");
		}	
		else
			ub.setuEmail(uEmail);
		
		if(CheckValidation.checkuPassword(uPassword))
		{
			isError=true;
			request.setAttribute("uPassword", "*Enter valid Password");
		}	
		else
			ub.setuPassword(uPassword);
		
		
		if(!isError)
		{	
			if(new UsersDao().addUsers(ub))
			{
				response.sendRedirect("Success.html");
			}
		}
		else
		{
			request.getRequestDispatcher("UsersData.jsp").forward(request, response);
		}
		
	}		
}


