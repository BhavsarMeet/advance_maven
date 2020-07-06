<%@page import= "java.util.ArrayList" %>
<%@page import= "com.bean.BookBean" %>
<%@page import= "com.bean.UsersBean" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>booklist</title>
</head>
<body>
<%
	UsersBean ub=(UsersBean)session.getAttribute("ub");  
	
%>
<h3><a href="UsersLogoutController">Logout</a></h3>
<%
	if(ub!=null)
	{
		ArrayList<BookBean> listofbooks=(ArrayList)request.getAttribute("booklist");
%>
	<h1><%=ub.getuName() %></h1>
	<table border="2px solid black" bgcolor="yellow" align="center">
		
		<tr>
			<th>Book ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Author Name</th>
			<th>Action</th>
				
		</tr>
		
		<tr>
				<%
					for(int i=0;i<listofbooks.size();i++)
					{
						BookBean bb=listofbooks.get(i);%>
						<td><%=bb.getbId()%></td>
						<td><%=bb.getbName()%></td>
						<td><%=bb.getbPrice()%></td>
						<td><%=bb.getbQty()%></td>
						<td><%=bb.getaName() %></td>
						<td><a href="BookDeleteController?bId=<%=bb.getbId()%>">Delete</a></td>
						<td><a href="BookEditController?bId=<%=bb.getbId()%>">Update</a></td>
		</tr>				
				<%	}
	}else
	{
		response.sendRedirect("UsersLogin.jsp");
	}
				%>		
		
		
	</table>
</body>
</html>