<%-- 
    Document   : Conect
    Created on : 22/10/2019, 11:51:32
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 
   out.println(ConexaoMySQL.statusConection());
 
%>

<%
 
    ConexaoMySQL.getConexaoMySQL();
 
   out.println(ConexaoMySQL.statusConection());
 
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
