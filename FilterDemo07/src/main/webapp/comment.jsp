<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Filter</title>
</head>
<body style="font-size: 30px">
 <form action="comment" method="post">
   评论：<input name="content"> 
  
        <input type="submit" value="确定">
         <%
		String comm = (String)request.getAttribute("comment_overlength");
	     %>
	<span style="font-size: 15px;color:red">
	     <%=comm==null?"":comm%>
	</span>
 </form>

</body>
</html>