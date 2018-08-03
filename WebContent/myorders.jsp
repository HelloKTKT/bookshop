<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.beans.Order" import="com.Dao.*" import="com.beans.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script>
	function check(){
		var msg = "您是否真的确完成订单吗！";  
		if (confirm(msg)==true){
			   return true;  
			   }
		else{
			   return false; 
			    } 
	}
    </script>
    
	<style type="text/css">
	    a{text-decoration:none;
	}/*未访问，红色，无下划线*/
	    a:active{color:blue;}/*激活，红色*/
	   
	    a:hover{color:yellow;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
		*{font-family:微软雅黑;
		}
		table,h1{
			text-align:center;}
			
		.title{
			background:#F60;
			width:900;
			margin:auto;
		}
	
		.total{
			width:900;
			margin:0 auto;
			text-align:right;
			
		}
	</style>

  </head>  
  <body background="img/timgbg.jpg">

 <div class="title"><font  size="5" >我的订单--(<%=request.getAttribute("state") %>订单)</font><br><a href="MyServlet2?state=已完成">已完成订单</a>&nbsp;<a href="MyServlet2?state=待处理">未完成订单</a></div>
   <% 
             List<Order> list1=(List<Order>)request.getAttribute("list");
              String userid=(String) session.getAttribute("userid");
              Order odao=new Order();
          
              for(Order list:list1){
            	  System.out.println(list.getAddress());  
             

             
          %>
            <% 
            if(list1.size()==0){
          %> 
            <h1>无订单信息</h1>
          <%     
            }
            else{
            	//for(Cart_Books cbs:list.getCart_books()){
            
             
          %>
  <table align="center"   width="900" >
       
          <tr>
            <td width="218" align="center" ><font color="blue"><b>订单编号</b></font></td>
            <td width="122" align="center" ><font color="blue"><b>收货人</b></font></td>
            <td width="234" align="center"><font color="blue"><b>收货地址</b></font></td>
             <td align="center" width="87"><font color="blue"><b>邮编</b></font></td>
            <td align="center" width="128"><font color="blue"><b>联系电话</b></font></td>
            <td width="83" align="center"><b><font color="blue">状态</font></b></td>          
           
         </tr>
        
           <tr>
            <td colspan="8"></td>
          </tr>
        
         
        
           <tr align="center">
             <td  width="218"><%=list.getOid() %></td>
             <td align="center"><%=list.getReceiver() %></td>
             <td align="center"><%=list.getAddress() %></td>
             <td align="center"><%=list.getPost() %></td>
             <td align="center"><%=list.getMobile() %></td>
             <td align="center"><%=list.getState() %></td>

            
           
               
        
          </tr>  
           <tr><td colspan="6" align="left"><b>备注：<%=list.getMessage()%></b></td></tr></table>
  <table width="900" align="center"><tr>
           <th width="225">图书编号</th>
           <th width="225">图书名称</th>
           <th width="225">数量</th>
           <th width="225">总价</th>
           </tr>
           <% for(Cart_Books cbs:list.getCart_books()){%>
           <tr>
           <td><%=cbs.getBookid() %></td>
            <td><%=cbs.getName()%></td>
             <td><%=cbs.getNumber()%></td>
              <td><%=cbs.getAllprice()%></td>
           </tr>
    <%} %>
              
       </table>
      <div class="total"> <h2>总价：<%=list.getTotal()%></h2> 
      <% if(!list.getState().equals("已完成")){ %>
      <form method="post" action="CompleteOrderService" onSubmit="return check()">
      <input type="hidden" value="<%=list.getOid()%>" name="oid"/>
      <input type="submit" value="确认收货"/>
      </form>
      <%} %>
      </div>

      <hr>

       <%} } %>
     

      
  </body>
</html>
