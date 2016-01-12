<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" type="text/css" href="http://localhost:8080/vraptor-produtos/bootstrap/css/bootstrap.min.css">
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de produto</title>
</head>
<body>

	<table class="table table-stripped table-bordered table-hover">
		<thead>
			<th>
				<td>Nome</td>
				<td>Valor</td>
				<td>Quantidade</td>
			</th>
		</thead>
		<c:forEach var="produto" items="${produtoList}">
			<tr>
				<td>${produto.nome}</td>
				<td>${produto.valor}</td>
				<td>${produto.quantidade}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>