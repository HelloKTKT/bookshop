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
	    a:link{color:#FF4500;text-decoration:none}/*未访问，红色，无下划线*/
	    a:active{color:blue;}/*激活，红色*/
	    a:visited{color:red;text-decoration:none}/*已访问，紫色，无下划线*/
	    a:hover{color:yellow;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
	</style>

  </head>  
  <body background="img/timgbg.jpg">
    <br> <br> <br>
     
       <table align="center"   width="900" >
          <tr bgcolor="#ff0000" >
             <td colspan="8"><font face="隶书" size="5" >我的购物车</font></td>
          </tr>
          <tr>
            <td width="60" align="center" ><font color="blue"><b>图书编号</b></font></td>
            <td align="center" ><font color="blue"><b>图书名称</b></font></td>
            <td align="center"><font color="blue"><b>单价</b></font></td>
             <td align="center" width="20"></td>
            <td align="center" width="60"><font color="blue"><b>数量</b></font></td>
            <td align="center" width="20"></td>
            <td align="center"><font color="blue"><b>总价</b></font></td>          
            <td align="center"><font color="blue"><b>操作</b></font></td>
          </tr>
           <tr>
            <td colspan="8"><hr></td>
          </tr>
          <% 
             List<CartBook> list=(List<CartBook>)request.getAttribute("booklist");
              String userid=(String) session.getAttribute("userid");
              CartDao cdao=new CartDao();
              int total=cdao.getTotalPrice(userid); 
             // int total=0;  
              int i=1;      
              System.out.print(list.size());  
             
          %>
           <% 
         String msg=(String)request.getAttribute("msg");  //弹窗信息
      if(msg!=null){ %>
              <%=msg %>
         <%} %>
          <% 
            if(list.size()==0){
          %> 
            <tr>
               <td colspan="8" align="center" height="30">请添加书籍!</td>
            </tr>
          <%     
            }
            else{
            
             for(i=0;i<list.size();i++){
          %>
           <tr align="center">
             <td height="80" width="60"><%=list.get(i).getBookid() %></td>
             <td align="center"><%=list.get(i).getName() %></td>
             <td align="center">￥<%=list.get(i).getPrice() %></td>
             <td align="center" width="20">                         
             <form action="UpdateNumServlet?bookidtext=<%=list.get(i).getBookid() %>" method="post" name="numform"><!--减数量 -->
                <br> 
                <input value="-" type="submit" name="sub" >              
                <input type="hidden" value="-1" name="hid"> 
              </form>
             </td>
               
              <td align="center"  width="60"> 
               <input type="text"   size="10" readonly  value="<%=list.get(i).getNum() %>" style="text-align:center"> 
              </td>
              
             <td align="center" width="20">
             <form action="UpdateNumServlet?bookidtext=<%=list.get(i).getBookid() %>" method="post" ><!-- 加数量 --> 
                <br> 
                <input value="+" type="submit" name="add" >
                <input type="hidden" value="1" name="hid"> 
             </form>     
             </td>
             <td align="center">￥<%=list.get(i).getAllprice() %></td>
             <td align="center">
              <a href="DeleteBookServlet?bookid=<%=list.get(i).getBookid()%>">删除</a>            
             </td>
           </tr>         
          <%} }%>
          <tr>
            <td colspan="8"><hr></td>
          </tr>
          <tr> 
             <td width="80">总金额：</td> 
             <td colspan="7">￥<%=total %></td>
           </tr> 
          <tr>
            <td colspan="8"><hr></td>
          </tr>
          <tr>
            <td colspan="2">            
              
            <a href="ClearCartServlet">清空购物车</a>
            </td>
            <td align="right"  colspan="6" valign="bottom">
              <form action="orders.jsp" method="post">
                 <br>
                <input value="商品结算" type="submit">   <a href="PageQueryServlet">返回继续购物</a>
              </form>          
            </td>
          </tr>  
          <tr>
            <td colspan="8"><hr></td>
          </tr>       
       </table>

      
  </body>
</html>
