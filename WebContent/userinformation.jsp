<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.beans.CartBook" import="com.Dao.CartDao"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	 div{
		 text-align:center;
		 font-family:微软雅黑;
		 padding:0px auto;
	 }
		 

    </style>

  </head>  
  <body background="img/timgbg.jpg">
<div> <h1 >我的信息</h1>
<a href="Code.jsp">修改密码</a>
</div>
<div>
<form action="updateMyinformationService" method="post">
<table align="center">
<input type="hidden" name="id" value="${userdata.ID}"/>
<tr><td>id:</td><td>${userdata.ID}</td></tr>
<tr><td>性别:</td><td><input name="sex" value="${userdata.sex}"/></td></tr>
<tr><td>联系电话:</td><td><input name="phone" value="${userdata.phone}"/></td></tr>
<tr><td>所在城市:</td><td><input name="home" value="${userdata.home}"/></td></tr>
<tr><td>邮箱:</td><td><input name="email" value="${userdata.email}"/></td></tr>
</table>
<input type="submit" value="修改"/>

</form>
</div>
  
  
   
  </body>
</html>
