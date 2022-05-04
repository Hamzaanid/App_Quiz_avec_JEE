<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="services.dao_reponse,beans.*,java.util.*,javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Score</title>
<style>
fieldset {
  background-color: #eeeeee;
}

legend {
  background-color: gray;
  color: white;
  padding: 5px 10px;
}
</style>
</head>
<body>
<%!  int length;  %>

<% 
  int result=0;
  length = Integer.parseInt(request.getParameter("length"));
  for( int i=1 ;i<=length;i++) 
   {
    String rep = request.getParameterValues("repQ"+i)[0];
    if(dao_reponse.isCorrect(Integer.parseInt(rep))) ++result;
   }
%>
 <fieldset>
 <legend><h3>Resultats</h3></legend>
  <h4> Votre score de bonnes réponses est :  <%=result%> sur <%= request.getParameter("length") %></h4> 
 </fieldset>

</body>
</html>