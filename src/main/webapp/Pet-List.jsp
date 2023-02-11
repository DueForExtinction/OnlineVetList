<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add,edit,delete</title>
</head>
<body>
<form method ="post" action ="petNavigationServlet">
<table>
<c:forEach items="${requestScope.ListPets}" var="currentpet">
<tr>
<td><input type="radio" name="id" value="${currentpet.id}"></td>
	<td>Pet: ${currentpet.name},</td>
	<td>Owner: ${currentpet.owner},</td>
	<td>Operation: ${currentpet.operation}</td>
	</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="ChangePet">
<input type="submit" value="delete" name="ChangePet">
<input type="submit" value="add" name="ChangePet">
</form>
</body>
</html>

