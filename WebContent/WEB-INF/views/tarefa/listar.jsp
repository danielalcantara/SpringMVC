<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<c:url value="../template/" var="template"></c:url>
<c:import url="${ template }cabecalho.jsp"></c:import>
<title>Listar Contato</title>
</head>
<body>
	<c:import url="${ template }topo.jsp"></c:import>
	<input type="button" value="Cria nova tarefa"
		onclick="redirecPagina('formAdicionar')">
	<br>
	<br>
	<table class="tableList">
		<tr>
			<th>Código</th>
			<th>Título</th>
			<th class="tdTextoLongo">Descrição</th>
			<th>Finalizado</th>
			<th>Data Finalização</th>
			<th colspan="2">Ações</th>
		</tr>
		<c:forEach var="tarefa" items="${tarefas}" varStatus="id">
			<tr class="${ id.count % 2 == 0 ? 'linhaPar' : 'linhaImpar' }">
				<td class="tdCenter">${tarefa.id}</td>
				<td>${tarefa.titulo}</td>
				<td>${tarefa.descricao}</td>
				<td class="tdCenter">
					<input type="checkbox" value="true"	onclick="setSituacao(${ tarefa.id }, this.checked);"
					${ tarefa.finalizado ? 'checked' : '' }>
				</td>
				<td id="dataFinalizacao_${ tarefa.id }" class="tdCenter">
					<fmt:formatDate	value="${ tarefa.dataFinalizacao.time }" pattern="dd/MM/yyyy" />
				</td>
				<td><a href="remover?id=${ tarefa.id }">Remover</a></td>
				<td><a href="formEditar?id=${ tarefa.id }">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="${ template }rodape.jsp"></c:import>