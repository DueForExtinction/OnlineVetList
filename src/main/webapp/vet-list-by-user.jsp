<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veterinarian Lists</title>
</head>
<body>
<form method="post" action="petListNavigationServlet">
<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
<tr>
<td><input type="radio" name="id" value="${currentlist.id}"></td>
<td><h2>${currentlist.vetBisName}</h2></td></tr>
<tr><td colspan="3">Veterinarian: ${currentlist.veterinarian.vetName }</td></tr>
<c:forEach var="listVal" items="${currentlist.petInfo }"><tr><td></td><td colspan="3">${listVal.name}, ${listVal.owner}, ${listVal.operation}
</td></tr>
</c:forEach>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToVetList">
<input type="submit" value="delete" name="doThisToVetList">
<input type="submit" value="add" name="doThisToVetList">
</form>
<a href="addPetsForVetsListServlet">Create a new Vet List</a>
<a href="index.html">Add new pets</a>
</body>
</html>