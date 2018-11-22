<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img src="images/1.jpg" style="width: 100%;height: 100%;z-index: -1;position: absolute;">
<jsp:include page="header.jsp"></jsp:include>

<center>
<form action="Login1" method="get">

用户名<input type="text" name="username" />

<br/>

<br/>

&nbsp;&nbsp;密码<input type="password" name="psd" />

<br/>

<br/>

<button type="submit">登录</button>

<button type="reset">重填</button>

</form>
<%
String err =(String)session.getAttribute("error");
if(err!=null){
     out.print("<div style='color:red;'>"+err+"</div>");
}

else{
	out.print("<div>"+""+"</div>");
}
//out.print("<div style='color:red;'>"+err+"</div>");
%>

</center>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>