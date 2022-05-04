<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="services.*,beans.*,java.util.*,javax.servlet.http.HttpServletRequest"%>
    <jsp:useBean  id="form" class="beans.form"  scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
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
  margin : 5px;
}

#submit{
    display: inline-block;
    border: none;
    text-align:center;
    background: #0069ed;
    color: #ffffff;
    font-family: sans-serif;
    font-size: 1rem;
    cursor: pointer;
    margin: 5px;
    height:30px;
    width:80px;
    border:none;
    background-color:#8099ff;
    border-radius:8px;
    
}

#submit:hover {
    background: #0053ba;
}

#reset{
    display: inline-block;
    border: none;
    text-align:center;
    color: #ffffff;
    font-family: sans-serif;
    font-size: 1rem;
    cursor: pointer;
    margin: 5px;
    height:26px;
    width:70px;
    border:none;
    background-color:#df4e4f;
    border-radius:8px;
    
}
#reset:hover {
    background: #aa3300;
}
.warn{
  background-color:red;
  margin:0;
}

.p{
margin:10px;
padding:25px;
}
</style>
</head>
<body>

<fieldset>
<div class="warn">   
   <legend>
   <h3>Fait attention à ce remarque!</h3>
   </legend>
  <p class="p">repondre a tous les questions avant de valider sinon vous recevrer un error !!</p>
</div>
</fieldset>
  
<%!  // une liste pour les questions
   List<question> listq = new ArrayList<question>(); 
     // une liste pour les reponses correspondants a un question 
   List<reponse> listr = new ArrayList<reponse>();
   String question; 
   String reponse;
   // un compteur pour calculer le nombre des questions
   
 %><% %>
  <fieldset>
      <legend>Qustions : </legend>
   <form action="reponse.jsp" method="get" >
   <%
      int i=0;
      listq = dao_question.getQuestions(form.getId_form()); 
     for( question q : listq){
    	 
   %>
	 <%=++i%>-<b><%= q.getLib_question()%></b><br/>
	  
	   <% 
	     listr =dao_reponse.getReponseFor(q.getId_question()); 
	     for(reponse r : listr){ 
	   %>
		   <input type="radio" name="repQ<%=i%>" value="<%=r.getId_reponse()%>">
		   <label><%= r.getLib_reponse() %> </label><br/>
		   
	  <% }%><br> 
	     <% } %> 
	  
	  <input type="hidden" name="length" value="<%=listq.size() %>"/>
	   <input type="reset" value="reset" id="reset"/>
	   <input type="submit" value="valider" id="submit"/>
	   
</form>
</fieldset>
</body>
</html>