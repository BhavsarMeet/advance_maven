package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doa.BookDoa;

/**
 * Servlet implementation class BookDeleteController
 */
public class BookDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int bId=Integer.parseInt(request.getParameter("bId"));
		
		BookDoa bd=new BookDoa();
			
		if(bd.deleteBook(bId))
		{
			response.sendRedirect("BookRetriveController");
		}	
		else
		{
			response.sendRedirect("BookRetriveController");
		}
			
	}

}
