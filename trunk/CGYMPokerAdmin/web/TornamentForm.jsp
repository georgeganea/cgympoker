<%-- 
    Document   : TornamentFrom
    Created on : May 31, 2008, 2:43:46 AM
    Author     : carmen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>TournamentForm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
      
      <form name="tournform" action="CreateTournament.jsp"method="get">
        <br><br>
        TournamentName: <input type="text" name="tname" size="25" />
        <br/>
        Start In: <input type="text" name="start" size="8" />minutes
        <br/>
        Stop After: <input type="text" name="stop" size="8" />minutes
        <br/>
        <input type="submit" value="Create"/>
    </form>
    
     <FORM NAME="tournform2" ACTION="ListUsers.jsp" METHOD="POST">
            <INPUT TYPE="submit" VALUE="ListUsers" />
     </form>           
    </body>
</html>

