<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/ScriptStyle.jsp" %>
<html>
<head>
<meta charset="utf-8">
<title>Zpark Contact</title>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
<style>
.Wdate {
	border: #999 1px solid;
	height: 20px;
	background: #fff url(./My97DatePicker/skin/dedatePicker.gif) no-repeat
		right;
}

.Wdate::-ms-clear {
	display: none;
}

.WdateFmtErr {
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
	<img src="./images/logo.png" width="280" height="100"
		style="position: absolute; left: 60px; top: 40px; z-index: 3;" />
	<img src="./images/11.jpg" height="100%" width="100%"
		style="position: absolute; z-index: 2;" />
	<div class="container"
		style="margin-top: 10%; font-family: fantasy; position: absolute; z-index: 4; width: 1200px; left: 30px; top: 0px;">
		<section id="content">
			<form action="<%=path %>/test/AddContactAction_1">
				<h1>个人通讯录</h1>
				<br />
				<div align="right">当前用户: ${sessionScope.username }</div>
				<div></div>
				<br />
				<div>
					联系人id:<input type="text" name="id" value="${param.id }" readonly="readonly" />
				</div>  
				<div>
					姓名:<input type="text" name="name" value="" placeholder="请输入姓名" />
				</div>
				<div>
					生日:<input style='height: 45px;' class='Wdate' id='dt'
						type="text" name='birth' onclick='WdatePicker()' value="" placeholder="请选择日期"/>
				</div> 
				
				<div>
					年龄:<input type="text" name="age" value="" placeholder="请输入年龄" />
				</div>
				<div>
					电话:<input type="text" name="phone" value="" placeholder="请输入手机号码" />
				</div>
				<div>
					邮编:<input type="text" name="zipCode" value="" placeholder="请输入邮编" />
				</div>
				<div>
					<input name="butt" type="submit" value="添加" /> <input name="butt"
						type="button" value="返回" onclick="JavaScript:history.go(-1);" />
				</div>

			</form>
		</section>
	</div>
</body>
</html>