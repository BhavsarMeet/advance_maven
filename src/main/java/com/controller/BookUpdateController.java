package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.doa.BookDoa;

/**
 * Servlet implementation class BookUpdateController
 */
public class BookUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String bName=request.getParameter("txtBookName");
		int bPrice=Integer.parseInt(request.getParameter("txtBookPrice"));
		int bQty=Integer.parseInt(request.getParameter("txtBookQuantity"));
		int bId=Integer.parseInt(request.getParameter("hidBookId"));
		int aId=Integer.parseInt(request.getParameter("txtAuthorId"));
		
		BookBean bb=new BookBean();
		bb.setbId(bId);
		bb.setbName(bName);
		bb.setbPrice(bPrice);
		bb.setbQty(bQty);
		bb.setaId(aId);
		System.out.println("authorid:"+bb.getaId());
		if(new BookDoa().updateBook(bb))
		{
			response.sendRedirect("BookRetriveController");
		}
		else
			response.sendRedirect("BookRetriveController");
		
	}

}
