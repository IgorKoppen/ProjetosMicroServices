<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultado</title>
</head>
<body>

<h1>Resultado</h1>
<h3>Área: <%=request.getAttribute("area")%></h3>
<h3>Perímetro: <%=request.getAttribute("perimetro") %></h3>
<a href="index.jsp" style="background-color: gray; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;">Voltar</a>

</body>
</html>