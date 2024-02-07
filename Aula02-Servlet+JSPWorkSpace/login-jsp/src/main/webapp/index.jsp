<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login JSP</title>
</head>
<body>

<form name="form" action="login" method="post" >
 <label for="nome">nome</label>
 <input type="text" id="nome" name="nome" value="" maxlength="30" placeholder="nome"/>
 <label for="senha"></label>
 <input type="password" id="senha" name="senha" value="" maxlength="30" placeholder="senha"/>
 <% 
 String errorMensagem = request.getParameter("error");
 boolean Iserro = (errorMensagem != null ? false : true);

 
 if(Iserro){ 
 %>
	  <span style="color: red;">Usuario ou senha invalidos!</span>
 <%
 }

 %>
 <button type="submit">Entrar</button>
</form>

</body>
</html>