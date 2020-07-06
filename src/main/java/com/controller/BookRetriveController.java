package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.doa.BookDoa;

/**
 * Servlet implementation class BookRetriveController
 */
public class BookRetriveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<BookBean> dataofbooks=new BookDoa().BookDataRetrive();
		if(dataofbooks==null)
			System.out.println("no data");
		else {
		request.setAttribute("booklist", dataofbooks);
		request.getRequestDispatcher("BookList.jsp").forward(request, response);
	
		}
	}	

}
