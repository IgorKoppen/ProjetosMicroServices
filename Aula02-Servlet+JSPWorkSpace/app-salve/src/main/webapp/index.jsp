<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>app-salve</title>
</head>
<body>
  <form action="pessoa" method="get">
  <label for="nome">Nome</label>
  <input name="nome" type="text" placeholder="nome" id="nome"/>
  <label for="sobrenome">Sobrenome</label>
  <input name="sobrenome" type="text" placeholder="sobrenome" id="sobrenome"/>
  <label for="email">Email</label>
  <input name="email" type="email" placeholder="email" id="email"/>
  <button type="submit">Enviar dados</button>
  <button type="button" onclick="cancelar()">Cancelar</button>
  </form>
  <script type="text/javascript">
  function cancelar(){
	  const nome = document.getElementById("nome");
	  const sobrenome = document.getElementById("sobrenome");
	  const email = document.getElementById("email");
	  nome.value = "";
	  sobrenome.value = "";
	  email.value = "";
  }
</script>
</body>
</html>