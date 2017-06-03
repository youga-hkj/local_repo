<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>user regist</title>
</head>

<body>
	<form method = "post" action="${pageContext.request.contextPath}/user/user_regist" id="myForm">
		<table>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name" title="不能为空，并且长度在2到4之间"></td>
				
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="pwd" id="pwd"
					title="不能为空，并且长度在6到8之间"></td>
			</tr>
			<tr>
				<td>重复密码：</td>
				<td><input type="password" name=rePwd title="必须等于上一次输入的密码"></td>
			</tr>
			<tr>
				<td>性别:</td>
				<td>
					<div>
						<input type="radio" name="sex" value = "man">男 <input type="radio"
							name="sex" value = "woman">女<br> <label style="display:none"
							for="sex" class="error">必须选择性别</label>
					</div>
				</td>
			</tr>
			<tr>
				<td>联系电话:</td>
				<td><input type="text" name="phone" title="必须为11为数字，并且第一位数字为1"></td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input type="text" name="age" title="年龄必须在18到58之间"></td>
			</tr>
			<tr>
				<td>电子邮箱:</td>
				<td><input type="text" name="email" title="不能为空"></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"/></td>
				<td><input type="reset" value = "重置"/></td>
			</tr>
		</table>
		</form>
	
	<script src="js/jquery-1.8.3.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script type="text/javascript">
		$("#myForm").validate({
			rules:{
				name:{
				required:true,
				rangelength:[1,20]
				},
				pwd:{
				required:true,
				rangelength:[6,8]
				},
				rePwd:{
				required:true,
				equalTo:"#pwd"
				},
				sex:"required",
				phone:{
				required:true,
				//自定义验证规则，phoneRule为自定义验证规则的方法名
				phoneRule:true
				},
				age:{
				required:true,
				range:[18,58]
				},
				email:{
				required:true,
				email:true
				}
				},
				// 错误提示信息
				messages:{
				name:{
				// 会默认转换为label标签展示到页面上
				required:"姓名不能为空",
				rangelength:"姓名的长度在1到20之间"
				
				},
				pwd:{
				required:"密码不能为空",
				rangelength:"长度在6到8之间"
				},
				rePwd:{
				required:"不能为空",
				equalTo:"必须等于第一次输入的密码"
				},
				phone:{
				required:"联系电话不能为空",
				phoneRule:"联系电话书写不规范"
				},
				age:{
				required:"年龄不能为空",
				range:"年龄为18到58之间"
				},
				email:{
				required:"电子邮箱不能为空",
				email:"邮箱书写不规范"
				}
				}
				});
				// 自定义验证规则:phoneRule为验证的方法名；function(value,dom,param)为方法体，其中value为元素的值，dom为元素体本身，param为参数
				$.validator.addMethod("phoneRule",function(value,dom,param){
				// 使用一般方法
				/*if(value.substring(0,1) != "1"){
				return false;
				}
				if(value.length != 11){
				return false;
				}
				return true;*/
				// 使用正则表达式
				var pattern = /^1[0-9]{10}$/;

				var flag  = pattern.test(value);

				return flag;

				});
	</script>
		
	</body>

</html>
