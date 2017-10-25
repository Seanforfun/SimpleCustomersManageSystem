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
		<form action="${pageContext.request.contextPath }/search">
			<div>
				<select name="select">
					<option">Search Options</option>
					<option value="cellphone">Search by cellphone</option>
					<option value="name">Search by name</option>
					<option value="type">Search by type</option>
				</select> 
				<input type="text" name="msg">
				<input type="submit" value="search">
			</div>
		</form>
		<table border="1">
			<tr>
				<td>checkbox<input type="checkbox" id="main" onclick="change()">
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
				<td>Operation</td>
			</tr>

			<form action="${pageContext.request.contextPath }/delete"
				method="post" id="f">
				<c:forEach items="${customers}" var="c">
					<tr>
						<td><input type="checkbox" value="${c.id }" name="ck"></td>
						<td>${c.id }</td>
						<td>${c.name }</td>
						<td>${c.gender }</td>
						<td>${c.birthday }</td>
						<td>${c.cellphone }</td>
						<td>${c.email }</td>
						<td>${c.preference }</td>
						<td>${c.type }</td>
						<td>${c.description }</td>
						<td><a
							href="${pageContext.request.contextPath }/findbyid?id=${c.id }">modify</a>&nbsp;&nbsp;
							<a
							href="${pageContext.request.contextPath }/deleteCustomer?id=${c.id}">delete</a>
						</td>
					</tr>
				</c:forEach>
			</form>
			<tr>
				<td><a
					href="${pageContext.request.contextPath }/add/addCustomer.jsp">Add
						Customer</a></td>
				<td><a href="javascript:void(0)" onclick="sendDel()">Delete
						Customer</a></td>
			</tr>
		</table>
	</c:if>
</body>
<script type="text/javascript">
	function change() {
		var main = document.getElementById("main");

		var cks = document.getElementsByName("ck");

		for (var i = 0; i < cks.length; i++) {
			cks[i].checked = main.checked;
		}
	}

	function sendDel() {
		document.getElementById("f").submit();
	}
</script>
</html>