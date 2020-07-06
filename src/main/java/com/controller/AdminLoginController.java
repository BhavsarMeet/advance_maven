package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.doa.AdminDoa;

/**
 * Servlet implementation class AdminLoginController
 */
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String aEmail=request.getParameter("txtAdminEmail");
		String aPassword=request.getParameter("pwdAdminPassword");
	
		AdminBean ab=new AdminDoa().LoginAdmin(aEmail, aPassword);
		HttpSession session=request.getSession();
		
		if(ab!=null)
		{
			session.setAttribute("ab", ab);
			response.sendRedirect("BookRetriveController");
		
		}
		else
		{
			request.setAttribute("Error", "Enter Valid username or password!!!");
			request.getRequestDispatcher("AdminLogin.jsp").forward(request, response);
		}
	}
}
