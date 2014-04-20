<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="template/" var="template"></c:url>
<c:import url="${ template }cabecalho.jsp"></c:import>
<title>Página de Login</title>
</head>
<body>
	<c:import url="${ template }topo.jsp"></c:import>
	<h2>Página de Login das Tarefas</h2>
	<form action="efetuaLogin" method="post">
		Login: <input type="text" name="login" /> <br /> Senha: <input
			type="password" name="senha" /> <br /> <input type="submit"
			value="Entrar" />
	</form>
	<c:import url="${ template }rodape.jsp"></c:import>