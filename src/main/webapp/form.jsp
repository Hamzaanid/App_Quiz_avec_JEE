<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="services.dao_form,beans.form,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>QCM</title>
<style>

fieldset {
  background-color: #eeeeee;
}

legend {
  background-color: gray;
  color: white;
  padding: 5px 10px;
}

input {
  margin: 5px;
}
h1{
 text-align:center;
}
#valider{
    display: inline-block;
    border: none;
    text-align:center;
    background: #0069ed;
    color: #ffffff;
    font-family: sans-serif;
    font-size: 1rem;
    cursor: pointer;
    margin: 5px;
    height:24px;
    width:80px;
    border:none;
    background-color:#8099ff;
    border-radius:8px;
    
}

#valider:hover {
    background: #0053ba;
}
</style>
</head>
<body>
 <%!
   List<form> listf= dao_form.getForms();
 %>
<div>
<h2> choisir un QCM</h2>
<fieldset>
<form action="qcm" method="get">
<% for(form f : listf) { %>
<input type="radio" name="form" value="<%=f.getId_form() %>" /><label> <%=f.getLib_form()%> </label><br/>
<% } %>

<input type="submit" value="valider" id="valider">
</form>
</fieldset>
</div>
</body>
</html>