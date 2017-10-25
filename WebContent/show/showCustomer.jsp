<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Single customer</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/modify" method="post">
		<input type="hidden" name="id" value="${customer.id }">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${customer.name }"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<c:if test="${customer.gender == 'male' }">
						<input type="radio" name="gender" value="male" checked="checked">male
						<input type="radio" name="gender" value="female">female
					</c:if>
					<c:if test="${customer.gender != 'male' }">
						<input type="radio" name="gender" value="male">male
						<input type="radio" name="gender" value="female" checked="checked">female
					</c:if>
				</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="text" name="birthday" value="${customer.birthday }"></td>
			</tr>
			<tr>
				<td>Cellphone:</td>
				<td><input type="text" name="cellphone" value="${customer.cellphone }"></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><input type="text" name="email" value="${customer.email }"></td>
			</tr>
			<tr>
				<td>Preference:</td>
				<td><input type="text" name="preference" value="${customer.preference }"></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><input type="text" name="type" value="${customer.type }"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="description" value="${customer.description }">
			</tr>
			<tr colspan="2">
				<td><input type="submit" value="modify"></td>
			</tr>
		</table>
	</form>
</body>
</html>