 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ include file="/ScriptStyle.jsp" %>
 <html> 
	<head>
		<meta charset="utf-8">
		<title>Zpark Contact</title>
		 
		 <script type="text/javascript">
		    function upload(){
		    var time=new Date().getTime();
		    document.getElementById('img').src="<%=path %>/kaptcha.jpg?d="+time;
		    }
  		</script>
	</head>	
<body>
	<img src="${pageContext.request.contextPath}/images/logo.png" width="280" height="100" style="position:absolute;  left:100px; top:60px; z-index:3;"/> 
	<img src="./images/11.jpg" height="100%" width="100%" style="position:absolute;z-index:2;"/> 
	<div class="container" style="margin-top: 10%; font-family: fantasy;position:absolute;z-index:4;width: 1300px; left:30px; top:80px;">
	<section id="content">
		<form action="${pageContext.request.contextPath }/test/loginAction_1">
			<h1>个人通讯录</h1>
			<div>
				<span>${sessionScope.exception }<c:remove var="exception" scope="session"></c:remove></span>
			</div>
			<div>
				<input type="text" placeholder="用户名" required="" name="username" style="background:url(./images/2.png) no-repeat; "/>
			</div>
			<div>
				<input type="password" placeholder="密码" required="" name="password" style="background:url(./images/1.png) no-repeat; "/>
			</div>
			<div>
				<input type="text" placeholder="验证码" required="" name="kaptcha" style="background:url(./images/1.png) no-repeat;" />
			</div>
			<div>
				<img id="img" alt="验证码" onclick="upload()" src="/Structs2Demo1/kaptcha.jpg" title="验证码">
			</div>
			<div>
			<div>
				<span>${sessionScope.kapError }</span>
			</div>
				 
			</div>
			 
			<div style="margin:24px; float:left;">
				<input name="butt" type="submit" value="登录" />
				<input name="butt" type="button" value="注册" onclick="location.href='./register.jsp'"/>
			</div>
			
		</form>
	</section>
</div>
</body>
</html>