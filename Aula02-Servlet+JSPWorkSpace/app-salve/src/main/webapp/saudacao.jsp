<%@page import="br.com.fiap.model.Pessoa" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saudação</title>
</head>
<body>
<main>
<h1>Bem vindo(a)</h1>
<%
Pessoa pessoa = (Pessoa) request.getAttribute("Pessoa");
%>
</main>

<div>
<h3>Olá, <%=pessoa.getNomeCompleto()%></h3>
<h3>E-mail, <%=pessoa.getEmail() %></h3>
</div>
<a href="index.jsp" style="background-color: gray; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;">Voltar</a>

</a>
</body>
</html>