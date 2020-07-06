package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.doa.BookDoa;
import com.util.CheckValidation;

/**
 * Servlet implementation class BookInsertController
 */
public class BookInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		String bName=request.getParameter("txtBookName");
		int bQty=Integer.parseInt(request.getParameter("txtBookQuantity"));
		int bPrice=Integer.parseInt(request.getParameter("txtBookPrice"));
		int aId=Integer.parseInt(request.getParameter("txtAuthorId"));
		boolean isError=false;
		
		BookBean bb=new BookBean();
		
		if(CheckValidation.checkName(bName))
		{	
			isError=true;
			request.setAttribute("bname", "*Name cannot be empty");
		}
		else
		{	
			bb.setbName(bName);
		}
		
		if(CheckValidation.checkQty(bQty))
		{	
			isError=true;
			request.setAttribute("bqty", "*Quantity cannot be empty");
		}
		else
		{
			bb.setbQty(bQty);
		}
		
		if(CheckValidation.checkPrice(bPrice))
		{			
			isError=true;
			request.setAttribute("bprice", "*Price cannot be empty");
		}
		else
		{	
			bb.setbPrice(bPrice);
		}
		bb.setaId(aId);
		if(!isError)
		{	
			if(new BookDoa().addBook(bb))
				response.sendRedirect("Success.html");
		}
		else
		{
			request.getRequestDispatcher("BookData.jsp").forward(request, response);
		}
	}

}
