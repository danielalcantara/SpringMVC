<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="label" required="true" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>
<label for="${ id }">${ label }: </label>
<input type="text" name="${ id }" id="${ id }" class="datepicker campoData" value="${ value }" />