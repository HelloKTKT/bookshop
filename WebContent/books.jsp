<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.beans.Book"%><html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书信息列表</title>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	    a:link{color:#FF4500;text-decoration:none}/*未访问，红色，无下划线*/
	    a:active{color:blue;}/*激活，红色*/
	    a:visited{color:red;text-decoration:none}/*已访问，紫色，无下划线*/
	    a:hover{color:yellow;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
	.content {
	text-align: center;
}
    </style>
  </head>
  
  <body background="img/timgbg.jpg" >
        
       <table align="center" width="900">
          <tr>
             <td align="center" colspan="6" valign="baseline">
                 <h2 style=" font-family:隶书;color:#0A0A0A;font-size:50px">网上书店</h2>
             </td>
          </tr>
      
           <% List<Book> list=(List<Book>)request.getAttribute("list");%>
    
         
            <% 
               for(Book b:list){ 
                                  
             %>   <tr >      
            <td width="100" height="140" class="content"><img src="http://localhost:8080/BooksAdmin/<%=b.getPic() %>" width="115" height="130"/></td>
            <td width="160" > 
                 <font color="#0000FF" face="隶书">ISDN :<%=b.getBookId() %></font><br>
                 <font color="#0000FF" face="隶书"> 书 名:<%=b.getName() %></font><br>
              	 <font color="#0000FF" face="隶书"> 作 者:<%=b.getAuthor() %></font><br>
              	 <font color="#0000FF" face="隶书">出 版:<%=b.getPublisher() %></font><br>
              	 <font color="#0000FF" face="隶书">价 格:<%=b.getPrice() %> </font><br>   
              	    <a href="BookInfo/Book1.jsp?bookid=<%=b.getBookId()%>">查看详细信息</a>                           
            </td>     </tr>
                                    
          <%} %>   
        
             
          <tr>
			<td align="right" colspan="6" class="content"><%= request.getAttribute("bar") %></td>          
          </tr>
       </table>
  </body>
</html>
