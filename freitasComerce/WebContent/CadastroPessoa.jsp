<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="MascaraValidacao.js"></script>
<script src="validator.min.js"></script>
<script src="validator.js"></script>
<title>Cadastro</title>
</head>

<body>
	<div class="container">
		<form action="CP">

			<div class="form-group">
				<label for="Nome">Seu nome:</label> <input type="text"
					class="form-control" id="Nome" />
			</div>

			<div class="form-group">
				<label for="Cpf">CPF:</label> <input type="text"
					class="form-control" id="Cpf" maxlength="14"
					onkeyup="FormataCpf(this,event)" />
			</div>

			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" id="pwd" placeholder="Senha" />
			</div>
			
			<%out.println("Nome"+"Cpf"+"Senha");%>

			<button type="submit" class="btn btn-default">Enviar</button>
		</form>
	</div>
</body>
</html>