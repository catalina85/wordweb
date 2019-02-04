<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>InputDatePage</title>
</head>

<body  background="review.jpg"  style="background-repeat:no-repeat"> 
	
	<br>
	<br>
		<form action="wordServlet?method=getReviewWords" method="post">
			
			<font size = "5" face="Arial, Helvetica">InputDate :</font>
			<br>
			<font size = "4" face="Arial, Helvetica">like [2010-01-01]</font>
			 
			<br>
			<input type="text" size = "15" style= "font: 16px arial; height: 1.3em; padding-top:2px" name="mDate"/> 
			<font size = "3" face="Arial, Helvetica">To</font>
			<input type="text" size = "15" style= "font: 16px arial; height: 1.3em; padding-top:2px" name="mDateEnd"/> 

			
			<br>
			
    
			
			<input type="submit" align="right" size = "15" style= "font: 16px arial; height: 1.6em; padding-top:2px" value="Search"/> 
		</form>
	
	
</body>
</html>