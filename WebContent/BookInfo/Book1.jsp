<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.Dao.BookDao" %>
<%@ page import="com.beans.Book" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>三国演义</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	    a:link{color:blue;text-decoration:none}/*未访问，红色，无下划线*/
	    a:active{color:blue;}/*激活，红色*/
	    a:visited{color:yellow;text-decoration:none}/*已访问，紫色，无下划线*/
	    a:hover{color:blue;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
	</style>

  </head> 
  <body background="../img/timgbg.jpg" >
        <% int bookid=Integer.parseInt(request.getParameter("bookid"));  
            BookDao bookdao=new BookDao();   
            Book b=bookdao.getBookById(bookid);  
            String msg=(String)request.getAttribute("msg"); 
                             
         %>
       
      <form action="CheckLogin?bookid=<%=b.getBookId() %>" method="post" name="checkform">
        <table align="center"  width="800">
             <tr>
                <td width="100" height="140"><img src="http://localhost:8080/BooksAdmin/<%=b.getPic() %>" width="191" height="181"/></td>
            	<td > 
                  <font color="#000000" face="隶书" size="4">ISDN :<%=b.getBookId() %></font><br>
                  <font color="#000000" face="隶书" size="4"> 书 名:<%=b.getName() %></font><br>
              	  <font color="#000000" face="隶书" size="4"> 作 者:<%=b.getAuthor() %></font><br>
              	  <font color="#000000" face="隶书" size="4">出 版:<%=b.getPublisher() %></font><br>
              	  <font color="#000000" face="隶书" size="4">价 格:<%=b.getPrice() %> </font><br>                 	                         
                </td> 
             </tr>
             <tr><td colspan="2"> <hr color="#FF0000"></td></tr>  
             
             <tr>
               <td colspan="2"> <h2><font color="#8B0000" face="隶书">简介：</font></h2></td>
             </tr>  
             
             <tr>
               <td colspan="2">  
               &nbsp;&nbsp;&nbsp;&nbsp;<%=b.getIntro().replace("\n","<br/>&nbsp;&nbsp;&nbsp;&nbsp;") %>
             </td>
             </tr>
               
              <tr>
                <td colspan="2" align="right">                
                <input value="加入购物车" type="submit">  <a href="../PageQueryServlet">继续购物</a></td>
               </tr>         
        </table>              
     </form>
   <% if(msg!=null){ %>  
              <%=msg %>  
         <%} %>  
  </body>
</html>
