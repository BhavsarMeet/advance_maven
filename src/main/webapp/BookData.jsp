<%@page import="java.util.ArrayList"%>
<%@page import="com.doa.Authordao"%>
<%@page import="com.bean.AuthorBean"%>
<%@page import="com.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	AdminBean ab1=(AdminBean)session.getAttribute("ab");  
	
%>
<h3><a href="AdminLogoutController">Logout</a></h3>
<%
	if(ab1!=null)
	{%>	
	<form action="BookInsertController">
		<table>
			<tr>
			<td>Book Name:</td>
			<td><input type="text" name="txtBookName" ></td>${bname}
			</tr>
			
			<tr>
			<td>Book Quantity:</td>
			<td><input type="text" name="txtBookQuantity" ></td>${bqty}			
			</tr>
				
			<tr>
			<td>Book Price:</td>
			<td><input type="text" name="txtBookPrice" ></td>${bprice}			
			</tr>	
			
			<tr>
			<td>Author:</td>
			<td>
			<select name="txtAuthorId">
				<option value="0">select author</option>
			<%
				Authordao ad=new Authordao();
				ArrayList<AuthorBean> al=ad.authorlist();
			
				for(int i=0;i<al.size();i++)
				{AuthorBean ab=al.get(i);
				%>	
				<option value=<%=ab.getaId() %>><%=ab.getaName() %></option>		
			  <%}%>	
						
			</select></td>
			</tr>
		
			<td><input type="submit" value="Submit" ></td>			
				
		</table>
	</form>
<%}else
{	response.sendRedirect("AdminLogin.jsp");

	}%>
</body>
</html>