<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:url value="../template/" var="template"></c:url>
<c:import url="${ template }cabecalho.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<b><spring:message code="tarefa.adicionada.com.sucesso"></spring:message></b>
	<br>
	<input type="button" value="Listar" onclick="redirecPagina('listar')">
	<c:import url="${ template }rodape.jsp"></c:import>