<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<jsp:useBean id="idHandler" class="org.cgympoker.util.Authenticate" scope="request">
<jsp:setProperty name="idHandler" property="*"/>
</jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head><body>
<%
String userName = request.getParameter("userName");
String passWord = request.getParameter("passWord");
if (idHandler.authenticate(userName, passWord)!=null){
response.sendRedirect("welcome.jsp");
} else {
response.sendRedirect("retry.jsp");
}
%>
</body></head>
</html>