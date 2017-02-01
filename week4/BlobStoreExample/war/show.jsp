<%@ page import="com.jdoexample.*" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.PersistenceManager" %>

<html>
   <body>

  <%

   String qry = "select from " + Person.class.getName();
  
   PersistenceManager pm = PerManFact.get().getPersistenceManager();
   
   List<Person> people = (List<Person>)pm.newQuery(qry).execute();

    for(Person per : people)
    {

  %>
  <%= per.getName() %>
  <%
    }
   
  %>


   </body>




</html>
