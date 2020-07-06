<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${Error}
	<form action="AdminLoginController">
		<table>	
			<tr>
			<td>Email:-</td>
			<td><input type="text" name="txtAdminEmail"></td>
			</tr>
			
			<tr>
			<td>Password:-</td>
			<td><input type="password" name="pwdAdminPassword"></td>
			</tr>
			
			
			<tr>
			<td><input type="submit" value="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>