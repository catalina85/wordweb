<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>

<body  background="user.jpg"  style="background-repeat:no-repeat"> 
	
	
		<br>
		<form action="userServlet?method=getTrade" method="post">
		<!-- 	
			username: <input type="text" name="username"/>
		<br><br>
			password: <input type="password" name="password"/>
		<br><br>
			<input align="right" type="submit" value="Submit"/>
		-->
		
		<table cellpadding="10"> 
				
				<tr>
					<td><font size = "4" face="Arial, Helvetica">username:</font></td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td><font size = "4" face="Arial, Helvetica">password:</font></td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td align="right" colspan="10"><input type="submit" value="Log In"/></td>
				</tr>
			</table>

		</form>
		
	
	
</body>
</html> 