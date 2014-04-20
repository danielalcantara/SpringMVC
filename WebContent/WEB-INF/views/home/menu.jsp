<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/" var="raizSite"></c:url>
<c:url value="../template/" var="template"></c:url>
<c:import url="${ template }cabecalho.jsp"></c:import>
<title>Página principal</title>
</head>
<body>
	<c:import url="${ template }topo.jsp"></c:import>
	<h2>Página inicial da Lista de Tarefas</h2>
	<p>Bem vindo, ${usuarioLogado.login}</p>
	<a href="${ raizSite }tarefa/listar">Clique aqui</a> para acessar a lista de tarefas
	<c:import url="${ template }rodape.jsp"></c:import>