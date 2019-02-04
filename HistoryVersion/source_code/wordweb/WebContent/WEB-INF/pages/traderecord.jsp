<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>  
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Record</title>
</head>
<body bgcolor="#adfedc">

	<center>
		<br>
		<h2>User: ${param.username }</h2>
		
		<font size = "4" face="Arial, Helvetica">TotalDays : ${totalDays }</font>
		&nbsp;
		<font size = "4" face="Arial, Helvetica">TotalAmount : ${Amount }</font>
		
		
		<br>
		<br>
			<table>
				<c:forEach items="${trades}" var="trade">
					
					
					<table border="1" cellpadding="10" cellspacing="0">
					
						<tr>
							<td width="200" colspan="3">Time: ${trade.tradeTime }</td>
							<td width="200" colspan="3">Amount: ${trade.tradeTotalAmount }</td>
						</tr>
		
						
						
					</table>
					<br>
					
					
				</c:forEach>
			</table>
		
	</center>

</body>
</html>