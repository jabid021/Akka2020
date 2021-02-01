<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${pageContext.request.userPrincipal.name != null}">
	<c:set var="ctx" value="${pageContext.servletContext.contextPath}" />
	Bonjour ${pageContext.request.userPrincipal.name}
<form action="${ctx}/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}">
		<button type="submit" class="btn btn-link">deconnection</button>
	</form>
</c:if>