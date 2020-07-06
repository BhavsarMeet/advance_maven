<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.doa.Authordao"%>
<%@page import="com.bean.AuthorBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BookUpdateController">
	<input type="hidden" name="hidBookId" value="${bookbean.bId}">
		<table>
			<tr>
			<td>Book Name:</td>
			<td><input type="text" name="txtBookName" value="${bookbean.bName}"></td>
			</tr>
			
			<tr>
			<td>Book Quantity:</td>
			<td><input type="text" name="txtBookQuantity" value="${bookbean.bQty}"></td>			
			</tr>
				
			<tr>
			<td>Book Price:</td>
			<td><input type="text" name="txtBookPrice" value="${bookbean.bPrice}"></td>			
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

</body>
</html>