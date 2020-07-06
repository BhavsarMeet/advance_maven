package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.doa.BookDoa;

/**
 * Servlet implementation class BookEditController
 */
public class BookEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int bId=Integer.parseInt(request.getParameter("bId"));
		BookBean bb=new BookDoa().getById(bId);
		request.setAttribute("bookbean", bb);
		request.getRequestDispatcher("BookEdit.jsp").forward(request, response);
	}

}
