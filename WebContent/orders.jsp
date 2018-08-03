<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.beans.CartBook" import="com.Dao.CartDao"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>填写订单</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style>
	*{font-family:微软雅黑;}
    </style>  
    </head>  
  
  <body background="img/timgbg.jpg" >
      <form action="OrderServlet" method="post">
      <br><br>
       <table align="center"  width="900" >
          <tr>
            <td colspan="2" bgcolor="#FFC125"><b>填写订单信息:</b></td>            
          </tr>
          <tr>
            <td colspan="2"><hr></td>
          </tr>
          <tr >
            <td colspan="2" bgcolor="#FFE4B5">收货人信息</td>
          </tr>
          <tr>
            <td width="150">收  货  人：</td>
            <td><input type="text" name="receiver"></td>
          </tr>
           <tr>
            <td width="150">详细地址：</td>
            <td><input type="text" name="address" size="70"></td>
          </tr>
           <tr>
            <td width="150">邮政编码：</td>
            <td><input type="text" name="post"></td>
          </tr>
           <tr>
            <td width="150">移动电话：</td>
            <td><input type="text" name="mobile"></td>
            
          </tr>
          <tr  bgcolor="#FFE4B5">
             <td colspan="2">送货方式：<b>货到付款</b></td>
          </tr>
          <tr  bgcolor="#FFE4B5">
             <td colspan="2">给卖家留言：</td>
          </tr>
          <tr >
             <td colspan="2"><input type="text" size="100" name="message"></td>
          </tr>
           <tr>
            <td colspan="2"><hr></td>
          </tr>
          <tr>
             <td align="center" colspan="2"><input type="submit" value="生成订单"></td>
          </tr>
       </table>
       </form>
  </body>
</html>
