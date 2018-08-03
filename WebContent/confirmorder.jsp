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
	.cen{
		text-align:center;}
    </style>  
    </head>  
  <% 
             List<CartBook> list=(List<CartBook>)request.getAttribute("booklist");
             Map<String,String> map=(Map<String,String>)request.getAttribute("hashmap");
              String userid=(String) session.getAttribute("userid");
              CartDao cdao=new CartDao();
              int total=cdao.getTotalPrice(userid); 
             // int total=0;  
              int i=1;      
              System.out.print("list number*****"+list.size());  
              System.out.print("list hashmap*****"+map.size()); 
              /*Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();  
              while (it.hasNext()) {  
                   Map.Entry<String, String> entry = it.next();  
                     System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());  
              }  */
          %>
  <body background="img/timgbg.jpg" >
  <h1>请确认订单信息</h1>
      <form action="OrderCreatServlet" method="post">
      <br><br><table class="cen">
       <tr>
            <th>商品编号</th> 
            <th width="492">图书名称</th> 
            <th width="137">数量</th>
            <th width="40">单价</th>
            <th width="46">总价</th>
                  <%for(i=0;i<list.size();i++){ %>   
          </tr>
          <tr><td><%=list.get(i).getBookid() %></td><td><%=list.get(i).getName() %></td><td><%=list.get(i).getNum() %></td>
          <td><%=list.get(i).getPrice() %></td><td><%=list.get(i).getAllprice() %></td></tr><%}%>
          </table>
      <hr>
      <h2>总价:￥<%=total %></h2>
      
       <table align="center"  width="900" >
          <tr>
            <td colspan="2" bgcolor="#FFC125"><b>确认订单信息:</b></td>            
          </tr>
          
          <tr >
            <td colspan="2" bgcolor="#FFE4B5">收货人信息</td>
          </tr>
          <tr>
            <td width="161">收  货  人：</td>
            <td><%=map.get("receiver")%></td>
          </tr>
           <tr>
            <td width="161">详细地址：</td>
            <td><%=map.get("address")%></td>
          </tr>
           <tr>
            <td width="161">邮政编码：</td>
            <td><%=map.get("post")%></td>
          </tr>
           <tr>
            <td width="161">移动电话：</td>
            <td><%=map.get("mobile")%></td>
            
          </tr>
          <tr  bgcolor="#FFE4B5">
             <td colspan="2">送货方式：<b>货到付款</b></td>
          </tr>
          <tr  bgcolor="#FFE4B5">
             <td colspan="2">给卖家留言：</td>
          </tr>
          <tr >
             <td colspan="2"><%=map.get("message")%></td>
          </tr>
           <tr>
            <td colspan="2"><hr></td>
          </tr>
          <tr>
             <td align="center" colspan="2"><input type="submit" value="确认订单"></td>
          </tr>
          <input type="hidden" name="total" value="<%=total %>"/>
          <input type="hidden" name="receiver" value="<%=map.get("receiver")%>"/>
          <input type="hidden" name="address" value="<%=map.get("address")%>"/>
          <input type="hidden" name="post" value="<%=map.get("post")%>"/>
          <input type="hidden" name="mobile" value="<%=map.get("mobile")%>"/>
          <input type="hidden" name="message" value="<%=map.get("message")%>"/>
       </table>
       </form>
       
  </body>
</html>
