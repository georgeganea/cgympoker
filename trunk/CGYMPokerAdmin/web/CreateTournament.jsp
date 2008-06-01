<%-- 
    Document   : CreateTournament
    Created on : May 30, 2008, 5:37:52 PM
    Author     : carmen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <% String tname=null;
            tname=request.getParameter("tname");
           if ((tname!=null)&&(tname.length()>0)){
                if(request.getParameter("create")!=null){%>
                    <jsp:forward page="welcome.jsp">
                    <jsp:param name="tournamentName" value="<%=tname%>"/>
                    <jsp:param name="button" value="1"/>
                    </jsp:forward>
               <% }
                else if(request.getParameter("start")!=null){ %>
                        <jsp:forward page="welcome.jsp">
                        <jsp:param name="tournamentName" value="<%=tname%>"/>
                        <jsp:param name="button" value="2"/>
                        </jsp:forward>
               <% }
         }else{ %>
              <jsp:forward page="retry.jsp"/>
        <% } %>        
     
    </body>
</html>
