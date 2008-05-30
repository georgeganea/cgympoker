<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*,org.cgympoker.common.*" %>

<jsp:useBean id="idHandler" class="org.cgympoker.util.Authenticate" scope="request">
<jsp:setProperty name="idHandler" property="*"/>
</jsp:useBean>

<jsp:useBean id="serverC" class="org.cgympoker.util.ServerCentralBean" scope="session">
<jsp:setProperty name="serverC" property="*"/>
</jsp:useBean>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head><body>
<%
String userName = request.getParameter("userName");
String passWord = request.getParameter("passWord");
ServerCentral serv=idHandler.authenticate(userName, passWord);
  if (serv!=null){ 
      serverC.setServer(serv);
      response.sendRedirect("welcome.jsp");
} else {
    response.sendRedirect("index.jsp");
}
%>
</body></head>
</html>