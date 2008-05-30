<%-- 
    Document   : ListUsers
    Created on : May 31, 2008, 12:42:38 AM
    Author     : carmen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
    <HEAD>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>List users</TITLE>
    </HEAD>

    <BODY>
        <% 
            //if(request.getParameter("buttonName") != null) {
            if(request.getParameterNames() != null) {
        %>
            You clicked 
            <%= request.getParameter("listUsers") %>
        <%
            }
        %>

      <%--  <FORM NAME="list" METHOD="POST">
            <INPUT TYPE="BUTTON" VALUE="AddUser" ONCLICK="addUser()">
            <INPUT TYPE="BUTTON" VALUE="DeleteUser" ONCLICK="deleteUser()">
        </FORM> --%>
        <script type="text/javascript">
            document.write("Hello World!")
        </script>           
      </BODY>
</HTML>
