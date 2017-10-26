<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show customers information by page</title>
</head>
<body>
	<c:if test="${empty pb.cs }">
		No customer found.
	</c:if>
	<c:if test="${not empty pb.cs }">
		<table border="1">
			<tr>
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

			<c:forEach items="${pb.cs}" var="c">
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
			<tr>
				<td colspan="10" align="center">
				<a href="${pageContext.request.contextPath}/findallpage?pageNum=1&numPerPage=${pb.numPerPage}">first page</a>&nbsp;&nbsp;
				 <c:if test="${pb.pageNum == 1}">
					previous&nbsp;&nbsp;
				</c:if>
				 <c:if test="${pb.pageNum != 1}">
				 <a href="${pageContext.request.contextPath}/findallpage?pageNum=${pb.pageNum-1}&numPerPage=${pb.numPerPage}">previous</a>&nbsp;&nbsp;
				 </c:if>
				 <c:if test="${pb.pageNum == pb.totalPage}">
					next&nbsp;&nbsp;
				 </c:if>
				<c:if test="${pb.pageNum != pb.totalPage}">
				 <a href="${pageContext.request.contextPath}/findallpage?pageNum=${pb.pageNum+1}&numPerPage=${pb.numPerPage}">next</a>&nbsp;&nbsp;
				  </c:if>
				  <a href="${pageContext.request.contextPath}/findallpage?pageNum=${pb.totalPage}&numPerPage=${pb.numPerPage}">last page</a>&nbsp;&nbsp;
				  	<select id="select" onchange="changeNumPerPage(this.value)">
				  		<option>--Customers per page--</option>
				  		<option value="1">1</option>
				  		<option value="2">2</option>
				  		<option value="3">3</option>
				  		<option value="4">4</option>
				  		<option value="5">5</option>
				  		<option value="6">6</option>
				  		<option value="7">7</option>
				  		<option value="8">8</option>
				  		<option value="9">9</option>
				  		<option value="10">10</option>
				  	</select>
				  </td>
			</tr>
			<tr>
				<td align="center" colspan="9">
					<c:forEach begin="1" end="${pb.totalPage }" var="n" step="1">
					<c:if test="${n == pb.pageNum }">
					<font color="red">
						 <a href="${pageContext.request.contextPath}/findallpage?pageNum=${n}&numPerPage=${pb.numPerPage}">${n }</a>&nbsp;&nbsp;
						 </font>
						 </c:if>
						 <c:if test="${n != pb.pageNum }">
							 <a href="${pageContext.request.contextPath}/findallpage?pageNum=${n}&numPerPage=${pb.numPerPage}">${n }</a>&nbsp;&nbsp;
						 </c:if>
					</c:forEach>
				</td>
			</tr>
		</table>
	</c:if>
</body>
<script type="text/javascript">
	function changeNumPerPage(value)
	{
		location.href = "${pageContext.request.contextPath}/findallpage?numPerPage=" + value;
	}
</script>
</html>