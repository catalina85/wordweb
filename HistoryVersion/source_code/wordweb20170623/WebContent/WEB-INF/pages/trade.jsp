<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SubmitPage</title>
</head>

<body bgcolor="#adfedc"   style="background-repeat:no-repeat"> 
	<center>
		<br><br>
		<br><br>
		
		<h2>
		You have ${sessionScope.MBase.wordNumber } words to Rememory!
		<br>
		</h2>
	
		
		<c:if test="${requestScope.errors != null }">
			<font color="red">${requestScope.errors }</font>
		</c:if>
		
		<form action="wordServlet?method=trade" method="post">
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
					<td align="right" colspan="10"><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		
		</form>
		
	</center>	


</body>
</html>