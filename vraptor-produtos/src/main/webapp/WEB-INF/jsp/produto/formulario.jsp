<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulário de Produto</title>
</head>
<body>

	<a href="<c:url value='/produto/lista'/>">
    	Listar Produtos!
	</a>

	<form action='<c:url value='/produto/adiciona'></c:url>' method="post">
		Nome: <input type="text" name="produto.nome" class="form-control">
		Valor: <input type="text" name="produto.valor" class="form-control">
		Quantidade: <input type="text" name="produto.quantidade" class="form-control">
		<input type="submit" value="Salvar" class="btn btn-primary" />
	</form>
	
	<c:if test="${not empty errors}">
	  <div class="alert alert-danger">
	    <c:forEach var="error" items="${errors}">
	        ${error.category} - ${error.message}<br />
	    </c:forEach>
	  </div>
	</c:if>

</body>
</html>