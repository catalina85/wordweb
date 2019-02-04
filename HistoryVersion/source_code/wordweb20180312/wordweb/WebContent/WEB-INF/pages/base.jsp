<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyWordBase</title>
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<%@ include file="/commons/queryCondition.jsp" %>	
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			
			var $tr = $(this).parent().parent();
			var title = $.trim($tr.find("td:first").text());
			var flag = confirm("确定要删除" + title + "的信息吗?");
			
			<!-- 
			
			return flag;
			
			-->
		
			if(flag){
				return true;
			}
			
			return false;
			
			
			
		});
	})
</script>
</head>
<body bgcolor="#adfedc">

	<br>
	<br>
	<table  style="margin:0 0 5 900">
				<tr>
					<td width="200">
								<font size = "5" face="Arial, Helvetica">TotalWords:&nbsp;${sessionScope.MBase.wordNumber }</font>
					
					
					</td>
				
				</tr>
			</table>
	<br>
	<center>
		
		
		<table  border="2" cellpadding="10" cellspacing="1">
 		
 			<tr>
				<th width="50">GID</th>
				<th width="200">NAME</th>
				<th width="200">PRON</th>
				<th width="40">TIME</th>
				<th width="100">DATE</th>
				<th width="70">LISTNAME</th>
				<th width="90">SHOW</th>
				<th width="90">HANDLE</th>
			</tr>
			

 			
			
			<c:forEach items="${sessionScope.MBase.items }" var="item">
				<tr>
				  
				
					<td width="50"align="right">
					<font size = "4" face="Arial, Helvetica">${item.word.gId}</font>
					</td>
					
					<td width="50">
					<font size = "5" face="Arial, Helvetica">${item.word.name}</font>
					</td>
					
					<td width="200">
					<font size = "5" face="Arial, Helvetica">${item.word.pron}</font>
					</td>
					
					
					<td width="40" align="center">
					<font size = "4" face="Arial, Helvetica">${item.word.mTime}</font>
					</td >
					
					<td width="100" align="center">
					<font size = "4" face="Arial, Helvetica">${item.word.mDate}</font>
					</td >
					
					<td width="70" align="center">
					<font size = "4" face="Arial, Helvetica">${item.word.lNa}</font>
					</td>
					
					<td  width="90" align="center">
					<a href="wordServlet?method=getWord&pageNo=${param.pageNo }&gId=${item.word.gId}&page=base" >
					<font size = "4" face="Arial, Helvetica">显示词义</font>
					</a>
					</td>
					
					<td  width="90" align="center">
					<a href="wordServlet?method=remove&pageNo=${param.pageNo }&gId=${item.word.gId}" class="delete">
					<font size = "4" face="Arial, Helvetica">remove</font>
					</a>
					</td>
				
				</tr>
			</c:forEach>
			
			
		</table>
	</center>
	<!--  
		<table  style="margin:10 0 5 1200">
	-->
		<br>
		<br>
		<table  >
				<tr>
					
				
					<td  align="right" width="450">  
						<a href="wordServlet?method=${param.backpath }&pageNo=${param.pageNo }" >
						<font size = "5" face="Arial, Helvetica" >Back</font>
						</a>
					</td>
					
					
					
					<td  align="right" width="500"> 	
						<a href="wordServlet?method=Submit" >
						<font size = "5" face="Arial, Helvetica" >Submit</font>
						</a>
					</td>
				
				</tr>
		</table>
		
		
	
		<br>
	
	
	<br><br>
	
	
</body>
</html>