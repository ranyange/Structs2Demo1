<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/ScriptStyle.jsp" %>
<html>
<head>
<meta charset="utf-8">
<title>Zpark Contact</title>
<style type="text/css">
.Tab {
	border-collapse: collapse;
	width: 100%;
	height: 15px;
}

.Tab td,th {
	border: solid 1px;
	text-align: center;
}
</style>
</head>
<body>
	<!-- 这里要用uri来访问图片不会出现路径错误-->
	<img src="<%=path %>/images/logo.png" width="280" height="100"
		style="position: absolute; left: 40px; top: 20px; z-index: 3;" />
	<img src="<%=path %>/images/11.jpg" height="100%" width="100%"
		style="position: absolute; z-index: 2;" />
	<div class="container"
		style="margin-top: 10%; font-family: fantasy; position: absolute; z-index: 4; width: 1200px; left: 40px; top: -40px;">
		<section id="content">
			<h1>个人通讯录</h1>
		</section>
		<br />
		<div align="right">
			<span>
				当前用户: <a href='#'>${sessionScope.username }</a>
			</span>
			<span>
				<a href="<%=path%>/test/logoutAction_1">退出登录</a>
			</span>
		</div>
		<br />
		
		<form action="">
			<label><a href="<%=path %>/addContact.jsp">添加联系人</a></label>
			<table class="Tab">	
				<tr>
					<th>姓名</th>
					<th>生日</th>
					<th>年龄</th>
					<th>电话号码</th>
					<th>邮编</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${sessionScope.ps}" var="p">
				
					<tr>
		
						<td>${p.name }</td>
						<td>${p.birth }</td>
						<td>${p.age }</td>
						<td>${p.phone }</td>
						<td>${p.zipCode }</td>
						<td><a href="<%=path %>/test/deleteContactAction_1?id=${p.id}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="<%=path %>/updatePerson.jsp?id=${p.id}&name=${p.name}&birth=${p.birth}&age=${p.age}&phone=${p.phone}&zipcode=${p.zipCode}">修改</a></td>
					</tr>
				
				
				</c:forEach>
					
				
				
				
				
			</table>

		</form>
	</div>
</body>
</html>