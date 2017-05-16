<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>User Login</title>
  </head>
  
  <body>
	<form action="${ pageContext.request.contextPath }/login.action" method="post">
		username:<input name = "username" type = "text" />
		password:<input name = "password" type = "password"/>
		<input type = "submit" value = "submit"/>
	</form>
	<hr/>
	<%
		String msg = (String)request.getAttribute("username");
		if(msg == null){
			msg = "";
		}
	%>
	<%=msg %>
  </body>
</html>
