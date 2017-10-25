<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show customers information</title>
</head>
<body>
	<c:if test="${empty customers }">
		No customer found.
	</c:if>
	<c:if test="${not empty customers }">
		<table border="1">
			<tr>
				</td>
				<td>Id</td>
				<td>Name</td>
				<td>Gender</td>
				<td>Birthday</td>
				<td>Cellphone</td>
				<td>E-mail</td>
				<td>Preference</td>
				<td>Type</td>
				<td>Description</td>
			</tr>

			<c:forEach items="${customers}" var="c">
				<tr>
					<td>${c.id }</td>
					<td>${c.name }</td>
					<td>${c.gender }</td>
					<td>${c.birthday }</td>
					<td>${c.cellphone }</td>
					<td>${c.email }</td>
					<td>${c.preference }</td>
					<td>${c.type }</td>
					<td>${c.description }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath }/findall">
			back
		</a>
	</c:if>
</body>
</html>