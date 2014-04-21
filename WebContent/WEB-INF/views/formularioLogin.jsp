<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="template/" var="template"></c:url>
<c:import url="${ template }cabecalho.jsp"></c:import>
<title>Página de Login</title>
</head>
<body>
	<c:import url="${ template }topo.jsp"></c:import>
	<h2>Página de Login</h2>
	<form id="formLogin" action="efetuaLogin" method="post">
		<label for="login">Login: </label>
		<input type="text" name="login" />
		<br />
		<label for="senha">Senha: </label>
		<input type="password" name="senha" />
		<p>
			<input type="submit" value="Entrar" />
		</p>
	</form>
	<c:import url="${ template }rodape.jsp"></c:import>