package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.bean.UsersBean;
import com.doa.AdminDoa;
import com.doa.UsersDao;

/**
 * Servlet implementation class UserLoginController
 */
public class UsersLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uEmail=request.getParameter("txtUsersEmail");
		String uPassword=request.getParameter("pwdUsersPassword");
	
		UsersBean ub=new UsersDao().LoginUsers(uEmail, uPassword);
		HttpSession session=request.getSession();
		System.out.println(ub.getuName());
		if(ub!=null)
		{
			session.setAttribute("ub", ub);
			response.sendRedirect("BookRetriveController");
		}
		else
		{
			request.setAttribute("Error", "Enter Valid username or password!!!");
			request.getRequestDispatcher("UsersLogin.jsp").forward(request, response);
		}
	}
}
