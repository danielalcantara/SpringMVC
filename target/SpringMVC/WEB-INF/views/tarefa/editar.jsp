<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url value="../template/" var="template"></c:url>
<c:import url="${ template }cabecalho.jsp"></c:import>
<title>Cadastro de Tarefa</title>
</head>
<body>
	<c:import url="${ template }topo.jsp"></c:import>
	<c:if test="${ camposObr }"><span class="msgErro"><fmt:message key="campos.obrigatorios"></fmt:message></span></c:if>
	<h3>Adicionar tarefa</h3>
	<form action="editar" method="post">
		<input type="hidden" name="id" value="${ tarefa.id }">
		<label for="titulo">Título: </label><input type="text" name="titulo" value="${ tarefa.titulo }" />
		<form:errors path="tarefa.titulo" cssStyle="color:red;" />
		<br />
		<label for="descricao">Descrição: </label><textarea rows="5" cols="30" name="descricao">${ tarefa.descricao }</textarea>
		<form:errors path="tarefa.descricao" cssStyle="color:red;" />
		<br>
		<label for="finalizado">Finalizado? </label><input type="checkbox" name="finalizado" value="true" ${ tarefa.finalizado ? 'checked' : '' }>
		<br />
		<label for="dataFinalizacao">Data Finalização: </label>
		<input type="text" name="dataFinalizacao" class="campoData" value='<fmt:formatDate value="${ tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy"/>'>
		<br>
		<br>
		<input type="button" value="Voltar" onclick="redirecPagina('listar')">
		<input type="submit" value="Gravar" />
	</form>
<c:import url="${ template }rodape.jsp"></c:import>