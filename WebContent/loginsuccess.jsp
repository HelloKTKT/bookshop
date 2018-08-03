<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		.home{
			clear:both;
			margin-top:20px;
			padding-top:20px;
			font-family: "微软雅黑";
			font-size: 20px;
			text-align: center;	
		}
		ul{
			list-style-type:none;
			padding:0;
			
			}
			ul li{
				height:40px;
				line-height:40px;
				
				
				
			}
			ul li a{
				display:block;
				background:#000;
				border: #FFF dashed 1px;
				color:#FFF;
				text-decoration: none;
				
			}
			ul li a:hover{
				background:#FFF;
				color:#000;
				
			}

 </style>
<script>

</script>
</head>
<body>
<div class="title"><img src="img/timg.jpg" width="100" height="100"></div><div class="title2"><span>在线书城</span></div><div class="login">
<div class="home">
  <p>欢迎！    </p>
  <p>${sessionScope.userid} </p>
  <p><ul>
  <li><a href="PageQueryServlet" target="rightframe">首页</a></li>
  <li><a href="CartServlet" target="rightframe">我的购物车</a></li>
  <li><a href="MyServlet" target="rightframe">我的订单</a>
  </li>
  <li><a href="MyInformationServer" target="rightframe">我的信息</a></li>
  <li><a href="ExitLoginServlet" >退出登录</a></li>
  </ul></p>
</div>
</body>
</html>