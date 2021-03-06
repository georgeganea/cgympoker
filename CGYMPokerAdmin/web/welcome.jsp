<%-- 
    Document   : welcome
    Created on : May 30, 2008, 1:36:21 PM
    Author     : Ioana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,org.cgympoker.common.*" %>
  
<jsp:useBean id="serverC" scope="session" class="org.cgympoker.util.ServerCentralBean">
<jsp:setProperty name="serverC" property="*"/>
</jsp:useBean>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome CGYMPoker Admin!</h1>
        <br>
         <%@ include file="TournamentForm.html" %>
         
          <%
          ServerCentral server=serverC.getServer();
         
          if(request.getParameterNames()!=null){
             String id_t=request.getParameter("tournamentName");
             if ((id_t!=null)&&(id_t.length()>0)){
                 if(request.getParameter("button").equals("1")){
                     server.createTournament(id_t);
                 }
                 if(request.getParameter("button").equals("2")){
                     server.startTournament(id_t);
                 }
            } 
        }
         int n=server.getAllTournaments().size();
         List<Tournament> list=server.getAllTournaments();
         if(n>0){ %>
         <br><br>
            <TABLE border="1" summary="This table lists the current tournaments.">
                <CAPTION><EM><B>Tournaments</B></EM></CAPTION>
                <TR><TH rowspan="1">Turnament<br>Name
                <TH rowspan="1">Status
                <TH rowspan="1">Players
                </TR>
                <%
                for(int i=0;i<n;i++){
                   
                %>
                <TR><TD><%=list.get(i).getID() %></TD><TD><%=list.get(i).getStatus()%></TD><TD><%=list.get(i).getPlayers().size()%></TD>
                </TR>
                  
                <%}%>    
            </TABLE>
        <%}%>
    </body>
</html>
