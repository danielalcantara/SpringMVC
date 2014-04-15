<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="../template/" var="template"></c:url>
<c:import url="${ template }cabecalho.jsp"></c:import>
<title>Cadastro de Tarefa</title>
</head>
<body>
	<c:import url="${ template }topo.jsp"></c:import>
	<h3>Adicionar tarefa</h3>
	<form action="adicionar" method="post">
		<label for="titulo">Título: </label><input type="text" name="titulo" />
		<form:errors path="tarefa.titulo" cssStyle="color:red;" />
		<br /> <label for="descricao">Descrição: </label>
		<textarea rows="5" cols="30" name="descricao"> </textarea>
		<form:errors path="tarefa.descricao" cssStyle="color:red;" />
		<br /> <input type="button" value="Voltar"
			onclick="redirecPagina('listar')"> <input type="submit"
			value="Gravar" />
	</form>
	<c:import url="${ template }rodape.jsp"></c:import>