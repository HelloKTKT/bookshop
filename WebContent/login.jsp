<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<% if(session.getAttribute("userid")!=null){
	response.sendRedirect("loginsuccess.jsp");
} %>
<head>
    <title>网上书店</title>
     <!--javascript语言写的代码块-->
    <script type="text/javascript">
       function login(){
            if(document.loginform.id.value==""){
              window.alert("账号不能为空！");
              return ;
            }
            if(document.loginform.password.value==""){
              window.alert("密码不能为空！");
              return ;
            }
            loginform.submit();
       }
        function register(){
            document.loginform.method="post";
            document.loginform.target="leftframe";
            document.loginform.action="register.jsp";
            document.loginform.submit();
        }
       
    </script>
     <script type="text/javascript">
       /***********错误处理方法*********/
       function onerror(){
         alert("您的操作有误！");
       }
        /***********实例化ajax对象的方法*********/
       function getInfo(){
           var loader=new net.AjaxRequest("getInfo.jsp?nocache="+new Date().getTime(),deal_getInfo,onerror,"GET");
           
       }
        /***********回调函数*********/
       function deal_getInfo(){
          document.getElementById("showInfo").innerHTML=this.req.responseText;
       }
       
       window.onload=function(){
	        getInfo();	//调用getInfo()方法获取公告信息
	        window.setInterval("getInfo()", 600000);	//每隔10分钟调用一次getInfo()方法
       }
     </script>
   <style type="text/css">
	    a:link{color:red;text-decoration:none}/*未访问，红色，无下划线*/
	    a:active{color:blue;}/*激活，红色*/
	    a:visited{color:yellow;text-decoration:none}/*已访问，紫色，无下划线*/
	    a:hover{color:blue;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
        .input1{
			border: #CCC inset 2px;
			height:25px;
		}
		   .input2{
			border: #CCC outset 2px;
			height:25px;
			text-align:center;
			font:"微软雅黑";
			
		}
		.title{
			margin:0;
			float:left;

		}
			.title2{
			margin:20px 1px;
			float:left;

		}
			.title2 span{
	font-family: "微软雅黑", cursive;
	font-size: 36px;
		}
		.login{
			clear:both;
			margin-top:20px;
			padding-top:20px;
		}
		
	 </style>
</head>
<body >
<div class="title"><img src="img/timg.jpg" width="100" height="100"></div><div class="title2"><span>在线书城</span></div>
<div class="login">
<form action="LoginServlet" name="loginform" method="post">

  <h2 align="center" style=" font-family:微软雅黑">用户登录</h2>
         <br>         
       <table width="249" height="168" align="center" style="border:1px solid">
         <tr>
            <td width="53"><b>账 号：</b></td>
            <td width="175"><input name="id" type="text" class="input1" size="25"> </td>
         </tr>
         <tr>
            <td><b>密 码：</b></td>
            <td><input name="password" type="password" size="25" class="input1"> </td>
         </tr>
         <tr>
            <td></td>
            <td><input type="button" value="登  录" onclick="login()" class="input2">
                
             <input type="button" value="立即注册" onclick="register()" class="input2">  
            </td>          
         </tr>
       </table>
                 
   </form></div>
  </body>
</html>
