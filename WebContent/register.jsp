<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户注册</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $(function(){
       $("#uid").bind("keyup",(function(){
    var uid = $(this).val();
    if($(this).val()==""){ $("#tip").html("请输入用户名");$("#tip").css("color","red");
	}else{
     //用ajax去数据库匹配，
    $.ajax({
        url:"CheckIdService", //要处理的页面
        data:{u:uid}, //要传过去的数据
        type:"POST",  //提交方式
        dataType:"TEXT", //返回的数据类型，TEXT字符串 JSON返回JSON XML返回XML；dataType中T要大写！！
        success: function(data){  //回调函数，data为形参，页面返回的值
            if(data.trim()=="OK")//trim()去空格
            {
                $("#tip").html("该用户名可用");
                $("#tip").css("color","green");
            }
            else
            {
                $("#tip").html("该用户名已注册");
                $("#tip").css("color","red");
            }
        }
    }); }
	
}))
    });
</script>    
	<script type="text/javascript">
	      var select=document.getElementByName("header");
	      var options=select.getElementsByTagName("option");
	      var placeholder=document.getElementsByName("place");
	      function selectheader(){
	           placeholder.src=select.value;
	           
	      }
	</script>
    <script type="text/javascript">
       function checkForm(){
            if(document.registerform.ID.value==""){
              window.alert("账号不能为空！");
              return false;
            }
            else if(document.registerform.Password.value==""){
              window.alert("密码不能为空！");
              return false;
            }
			else if(document.registerform.Password.value!=document.registerform.Password2.value){
              window.alert("密码不一致！");
              return false;
            }
			else if(document.registerform.Sex.value==""){
              window.alert("性别不能为空！");
              return false;
            }
			else if(document.registerform.Phone.value==""){
              window.alert("电话不能为空！");
              return false;
            }
			else if(document.registerform.Home.value==""){
              window.alert("家乡不能为空！");
              return false;
            }
			else if(document.registerform.Email.value==""){
              window.alert("电子邮件不能为空！");
              return false;
            }else
            {
             return true;  
            }
       }
        function cancelregister(){
            document.registerform.method="post";
            document.registerform.target="_top";
            document.registerform.action="frame.jsp";
            document.registerform.submit();
        }
       
    </script>
    <style>
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
		.tip{
			color:#F00;
		}
    </style>
  </head>
  <body >
   <div class="title"><img src="img/timg.jpg" width="100" height="100"></div><div class="title2"><span>在线书城</span></div><div class="login">
    <form action="RegServlet" name="registerform" method="post" onSubmit="return checkForm()">
               
       <table align="center"  width="300" >
         <tr>
			<td colspan="2" align="center" style="color: #000; font-size;36px; font-family: '微软雅黑';" rowspan="1"><b>用户注册</b></td>
         </tr>
          <tr>
            <td ></td>
            <td><span id="tip">请输入账号</span></td>
         </tr>
         <tr>
            <td >账    号：</td>
            <td><input name="ID" type="text" id="uid" > </td>
         </tr>
         <tr>
            <td>密    码：</td>
            <td><input name="Password" type="password" > </td>
         </tr>
          <tr>
            <td>再输一次密码：</td>
            <td><input name="Password2" type="password" > </td>
         </tr>
         <tr>
            <td>性    别:</td>
            <td><input name="Sex" type="radio" value="男">男 <input name="Sex" type="radio" value="女">女</td><!--单选按钮-->
         </tr>
         <tr>
           <td>电话号码：</td>
           <td><input name="Phone" type="text"/></td>
         </tr>
        <tr>
            <td>家    乡：</td>
            <td>
              <select name="Home" ><!--下拉列表-->
                <option value="北    京">北     京</option>
                <option value="上   海">上   海</option>
                <option value="广   州">广   州</option>
                <option value="深    圳">深    圳</option>             
              </select>
             </td>
         </tr>
         <tr>
           <td>电子邮件：</td>
           <td><input name="Email" type="text"/></td>
         </tr>
        
         <tr>
            <td></td>
            <td><input type="submit" value=" 注    册 "  > <input type="button" value=" 取    消 "  onclick="cancelregister()"></td>
         </tr>
       </table>         
     </form></div>
  </body>
</html>
