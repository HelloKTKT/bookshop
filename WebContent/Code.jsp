<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
*{
	text-align:center;
	font-family:微软雅黑;
}
#errortip{
	color:#F00;
}
</style>

<script>
function check(){
	var pw=document.getElementById("pw").value;
	var pw1=document.getElementById("pw1").value;
	var pw2=document.getElementById("pw2").value;
	if(pw1==""||pw2==""||pw=="")
	{
		document.getElementById("errortip").innerHTML="密码不能为空！";
		return false;
	}
	
	if(pw1!=pw2){

		document.getElementById("errortip").innerHTML="两次密码不一致，请重新输入！";
		return false;
	}
	else{
	return true;
	}
}
</script>
</head>
<body background="img/timgbg.jpg">
<h1>修改密码</h1>
<hr>
<div><form action="CheckCodeService" method="post" onSubmit="return check()"><input type="hidden" value="qwe"
name="test"/>
<table align="center">
<tr><td>当前密码：</td><td><input type="password" name="pw" id="pw"/></td></tr>
<tr><td>新密码：</td><td><input type="password" name="pw1"  id="pw1"/></td></tr>
<tr><td>确认新密码：</td><td><input type="password" name="pw2" id="pw2" /></td></tr>
<tr><td colspan="2"><input type="submit" value="确认修改"/></td></tr>
</table></form>
<span id="errortip"></span>
</div>



</body>
</html>