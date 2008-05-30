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
              String tname=request.getParameter("tournamentName");
              String startIn=request.getParameter("tstart");
              String stopIn=request.getParameter("tstop");
          
             if ((tname!=null)&&(startIn!=null)&&(stopIn!=null)){
                long d=Calendar.getInstance().getTimeInMillis();
                Date start=new Date(d);
                start.setTime(d+Long.parseLong(startIn)*60000);
                Date stop=new Date();
                stop.setTime(start.getTime()+Long.parseLong(stopIn)*60000);
                Date date = new Date();
        
                server.createTournament(10,start,stop);
       
            } 
        }
         int n=server.getAllTournaments().size();
         List<Tournament> list=server.getAllTournaments();
         if(n>0){ %>
            <TABLE border="1" summary="This table lists the current tournaments.">
                <CAPTION><EM>Tournaments</EM></CAPTION>
                <TR><TH rowspan="1">Turnament<br>Name
                <TH rowspan="1">Start
                <TH rowspan="1">Stop
                <TH rowspan="1">Status
                <%
                for(int i=0;i<n;i++){
                %>
                  <TR><TD><%=list.get(i).getID() %><TD><%=list.get(i).getStartTime().toString() %><TD><%=list.get(i).getStopTime().toString()%><TD><%=list.get(i).getStatus()%>
                <%}%>    
            </TABLE>
        <%}%>
    </body>
</html>
