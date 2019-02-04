<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/commons/common.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchPage</title>

<%@ include file="/commons/queryCondition.jsp" %>
</head>
<body background="search.jpg" style="background-repeat:no-repeat"> 
	
	<br>
	<br>
		<form action="wordServlet?method=getWords" method="post">
			<font size = "4" face="Arial, Helvetica">nameMatch :</font>
			 
			<br>
			<input type="text" size = "12" name="nameFeatureOne"/> 
			<input type="text" size = "12"  name="nameFeatureTwo"/> 
			<input type="text" size = "12"  name="nameFeatureThree"/> 
			<br>
			
			<font size = "4" face="Arial, Helvetica">meaningMatch :</font>
			<br>
			<input type="text" size = "12"  name="meaningFeatureOne"/>     
			<input type="text" size = "12"  name="meaningFeatureTwo"/>     
			<input type="text" size = "12"  name="meaningFeatureThree"/>     
			
			<input type="submit" value="Search"/>
		</form>
	
	
	<br><br>
 		<table cellpadding="20">
			
			<c:forEach items="${wordpage.list }" var="word">
				<tr>
					<td>${word.name}</td>
					<td>${word.pron}</td>
					<td>${word.meaning}</td>
				</tr>
			</c:forEach>
			
		</table>
	


</body>
</html>