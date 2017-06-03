<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>  
    <form method = "GET" action = "${pageContext.request.contextPath }/user/main">
    	<table>
    		<tr>
    			<td>username:</td>
    			<td><input name = "username" type = "text"/></td>
    		</tr>
    		<tr>
    			<td>password:</td>
    			<td><input name = "password" type = "password"/></td>
    		</tr>
    		<tr>
    			<td><input value = "submit" type = "submit"/></td>   
    			<td><input value = "reset" type = "reset"/></td>
    		</tr>
    	</table>
    </form>
    <button onclick="location='${pageContext.request.contextPath}/user/regist'">regist</button>	
	
 
    
    <hr/>
    <%String msg = (String)request.getAttribute("msg");
	  if(msg == null){
		  msg="";
	  }
    %>
    ${msg}
  </body>
</html>
