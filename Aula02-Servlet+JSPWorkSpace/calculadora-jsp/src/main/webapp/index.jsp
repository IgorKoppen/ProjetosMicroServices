<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculadora</title>
</head>
<body>

<h1>Retângulo</h1>
<h2>Vamos calcular a área e o perímetro do retâgulo?</h2>

<form action="calcular" method="post">
<label for="base">Base:</label>
<input name="base" type="text" placeholder="base" id="base"/>
<label for="altura">Altura:</label>
<input name="altura" type="text" placeholder="altura" id="altura"/>
<button type="submit">Calcular</button>
<button type="button" onclick="cancelar()">Cancelar</button>
</form>


<script type="text/javascript">
  function cancelar(){
	  const base = document.getElementById("base");
	  const altura = document.getElementById("altura");
	  base.value = "";
	  altura.value = "";
  }
</script>
</body>

</html>