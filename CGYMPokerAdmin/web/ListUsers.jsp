<%-- 
    Document   : ListUsers
    Created on : May 31, 2008, 12:42:38 AM
    Author     : carmen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,org.cgympoker.common.*" %>
<jsp:useBean id="serverC" scope="session" class="org.cgympoker.util.ServerCentralBean">
<jsp:setProperty name="serverC" property="*"/>
</jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<HTML>
    <HEAD>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>List users</TITLE>
    </HEAD>

    <BODY>
        <FORM NAME="back" ACTION="welcome.jsp" METHOD="POST">
            <INPUT TYPE="submit" VALUE="BackToTournaments" />
        </form>   
        <% 
             ServerCentral server=serverC.getServer();
            //if(request.getParameter("buttonName") != null) {
            if(request.getParameterNames() != null) {
        
                int n=server.getUserList().size();
                ArrayList<String> userlist=server.getUserList();
                ArrayList<String> user=new ArrayList<String>();
                if(n>0){ %>
                    <TABLE border="1" summary="This table lists the CGYMPoker users.">
                    <CAPTION><EM>CGYMPoker Users</EM></CAPTION>
                    <TR><TH rowspan="1">UserName
                    <TH rowspan="1">Score
                    <%
                    for(int i=0;i<n;i++){
                        user=server.getUserInfo(userlist.get(i));
                    %>
                        <TR><TD><%=user.get(0)%><TD><%=user.get(1)%>
                    <%}%>    
                  </TABLE>
        <%}%>
            TODO:List of Users
            
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
