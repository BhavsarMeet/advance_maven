<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UsersInsertController">
	<table>
		<tr>
			<td>UserName:</td>
			<td><input type="text" name="txtUserName"></td>${uName}
		</tr>
		<tr>
			<td>UserAge:</td>
			<td><input type="text" name="txtUserAge"></td>${uAge}
		</tr>
		<tr>
			<td>UserEmail:</td>
			<td><input type="text" name="txtUserEmail"></td>${uEmail}
		</tr>
		<tr>
			<td>UserPassword:</td>
			<td><input type="password" name="pwdUserPassword"></td>${uPassword}
		</tr> 
		<tr>
		<td><input type="submit" value="submit"></td>
		</tr>
		
			
	</table>
</form>	
</body>
</html>