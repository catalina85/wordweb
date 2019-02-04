<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearchPage</title>
<script type="text/javascript" src="script/jquery-1.7.2.min.js"></script>
<%@ include file="/commons/queryCondition.jsp" %>	
<script type="text/javascript">
	
	$(function(){
		
		$("#pageNo").change(function(){
			var val = $(this).val();
			val = $.trim(val);
			
			//1. 校验 val 是否为数字 1, 2, 而不是 a12, b
			var flag = false;
			var reg = /^\d+$/g;
			var pageNo = 0;
			
			if(reg.test(val)){
				//2. 校验 val 在一个合法的范围内： 1-totalPageNumber
				pageNo = parseInt(val);
				if(pageNo >= 1 && pageNo <= parseInt("${wordpage.totalPageNumber }")){
					flag = true;
				}
			}
			
			
			if(!flag){
				alert("输入的不是合法的页码.");
				$(this).val("");
				return;
			}
			
			//3. 页面跳转
			var href = "wordServlet?method=getWords&pageNo=" + pageNo + "&" + $(":hidden").serialize();
			window.location.href = href;
		});
	})
	
</script>
<%@ include file="/commons/queryCondition.jsp" %>
</head>

<body bgcolor="#adfedc" background="" style="background-repeat:no-repeat"> 
	<br>
		<form   action="wordServlet?method=getWords" method="post">
			<font size = "3" face="Arial, Helvetica">nameMatch :</font>
			<br>
			<input type="text" size = "12" name="nameFeatureOne" value="${param.nameFeatureOne }"/> 
			<input type="text" size = "12"  name="nameFeatureTwo" value="${param.nameFeatureTwo }"/> 
			<input type="text" size = "12"  name="nameFeatureThree" value="${param.nameFeatureThree }"/> 
			<br>
			
			<font size = "3" face="Arial, Helvetica">meaningMatch :</font>
		
			<br>
			<input type="text" size = "12"  name="meaningFeatureOne" value="${param.meaningFeatureOne }"/>     
			<input type="text" size = "12"  name="meaningFeatureTwo" value="${param.meaningFeatureTwo }"/>     
			<input type="text" size = "12"  name="meaningFeatureThree" value="${param.meaningFeatureThree }"/>     
			
			<input type="submit"  value="Search"/>
		
		
		</form>

	
			<table  style="margin:0 0 5 750">
				<tr>
					<td width="220">
					<font size = "4" face="Arial, Helvetica">Number:&nbsp;${param.gId}&nbsp;${param.name}</font>
					</td>
					
					<td width="80">
					<font size = "4" face="Arial, Helvetica">Total:&nbsp;${sessionScope.MBase.wordNumber }</font>
					</td>
					
					<td>
					<a href="wordServlet?method=forwardPage&page=base&pageNo=${wordpage.pageNo }&backpath=${backpath}">
					<font size = "4" face="Arial, Helvetica">我的词库</font>
					</a>
					</td>
				
				</tr>
			</table>
		
		<!--  
			<div>
				<div style="float:right">  Right  :</div>
				<div style="float:right">  Left  :</div>
			</div>
		-->
		
	
	<center>

	
	
	
 		<table border="2" cellpadding="10" cellspacing="1">
 		
 			<tr>
				<th width="50">ROWNUM</th>
				<th width="50">GID</th>
				<th width="200">NAME</th>
				<th width="200">PRON</th>
				<th width="40">TIME</th>
				<th width="100">DATE</th>
				<th width="70">LISTNAME</th>
				<th width="90">SHOW</th>
			</tr>
			

 			
			
			<c:forEach items="${wordpage.list }" var="word">
				<tr>
				  
					<td width="50" align="right">
					<font size = "4" face="Arial, Helvetica">${word.rowNum}</font>
					</td>
				
					<td width="50"align="right">
					<a href="wordServlet?method=addToMBase&pageNo=${wordpage.pageNo }&gId=${word.gId}&name=${word.name}">
					<font size = "4" face="Arial, Helvetica">${word.gId}</font>
					</a>
					</td>
					
					<td width="200">
					<font size = "5" face="Arial, Helvetica">${word.name}</font>
					</td>
					
					<td width="200">
					<font size = "5" face="Arial, Helvetica">${word.pron}</font>
					</td>
					
					
					
					<td width="40" align="center">
					<font size = "5" face="Arial, Helvetica">${word.mTime}</font>
					</td>
					
					<td width="100" align="center">
					<font size = "4" face="Arial, Helvetica">${word.mDate}</font>
					</td >
					
					<td width="70" align="center">
					<font size = "4" face="Arial, Helvetica">${word.lNa}</font>
					</td>
					<td width="90" align="center">
					<a href="wordServlet?method=getWord&pageNo=${wordpage.pageNo }&gId=${word.gId}&backpath=${backpath}">
					<font size = "4" face="Arial, Helvetica">显示词义</font>
					</a>
					
					
					 
					</td>
				
				</tr>
			</c:forEach>
			
		</table>
		
		
		<font size = "5" face="Arial, Helvetica">共 ${wordpage.totalPageNumber } 页</font>
		&nbsp;&nbsp;
			
		<font size = "5" face="Arial, Helvetica">当前第 ${wordpage.pageNo } 页</font>
		
		&nbsp;&nbsp;
		
		<c:if test="${wordpage.hasPrev }">
			<a href="wordServlet?method=getWords&pageNo=1">
			<font size = "5" face="Arial, Helvetica">首页</font>
			</a>
			&nbsp;&nbsp;
			<a href="wordServlet?method=getWords&pageNo=${wordpage.prevPage }">
			
			<font size = "5" face="Arial, Helvetica">上一页</font>
		
			</a>
		</c:if>

		&nbsp;&nbsp;
		
		<c:if test="${wordpage.hasNext }">
			<a href="wordServlet?method=getWords&pageNo=${wordpage.nextPage }">
			
			
			<font size = "5" face="Arial, Helvetica">下一页</font>
		
			</a>
			&nbsp;&nbsp;
			<a href="wordServlet?method=getWords&pageNo=${wordpage.totalPageNumber }">
			
			
			<font size = "5" face="Arial, Helvetica">末页</font>
		
			</a>
		</c:if>
		
		&nbsp;&nbsp;
		<font size = "5" face="Arial, Helvetica">转到</font>
		
		<input type="text" size="1" id="pageNo"/> 	
		
		<font size = "5" face="Arial, Helvetica">页</font>
			

	</center>
</body>
</html>