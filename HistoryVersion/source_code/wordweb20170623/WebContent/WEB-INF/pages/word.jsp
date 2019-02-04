<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GetWord</title>
<script type="text/javascript" src="script/jquery-1.7.2.min.js">
</script>
<%@ include file="/commons/queryCondition.jsp" %>		
</head>
<body bgcolor="#adfedc">

	
	<center>
		
		<br>
		<br><br>
		<a href="wordServlet?method=forwardPage&page=base&pageNo=${param.pageNo }">
		<font size = "5" face="Arial, Helvetica">返回我的词库</font>
		</a>
		&nbsp;&nbsp;
		&nbsp;&nbsp;
		&nbsp;&nbsp;
		&nbsp;&nbsp;
		&nbsp;&nbsp;
		
		
		<a href="wordServlet?method=${param.backpath }&pageNo=${param.pageNo }">
		<font size = "5" face="Arial, Helvetica">Back</font>
		</a>
		&nbsp;&nbsp;

		<br><br>
		<br>
		<table border="1" cellpadding="10" cellspacing="1">

			<tr>
				<td width="80" align="center"><font size = "5" face="Arial, Helvetica">Name</font></td>
				<td width="900" align="center"><font size = "5" face="Arial, Helvetica">${word.name}</font></td>
			</tr>	

			<tr>
				<td width="60" align="center"><font size = "5" face="Arial, Helvetica">Pron</font></td>
				<td width="900" align="center"><font size = "5" face="Arial, Helvetica">${word.pron}</font></td>
			</tr>

			<tr>
				<td width="60" align="center"><font size = "5" face="Arial, Helvetica">Meaning</font></td>
				<td width="900" align="left"><font size = "5" face="Arial, Helvetica">${word.meaning}</font></td>
			</tr>


			<tr>
				<td width="60" align="center"><font size = "5" face="Arial, Helvetica">Web</font></td>
				<td width="900" align="left"><font size = "5" face="Arial, Helvetica">${word.m}</font></td>
			</tr>
			
			
		
		</table>
		<!--  
		<font size = "5" face="Arial, Helvetica">${word.name} :</font>
		
		&nbsp;
		<font size = "5" face="Arial, Helvetica">${word.meaning}</font>
	    -->
		
		
		
		
		
		


	</center>
	
</body>
</html>