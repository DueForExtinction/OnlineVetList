<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="editPetServlet" method="post">
Name: <input type="text" name="name" value="${petToEdit.name}">
Owner: <input type="text" name="owner" value="${petToEdit.owner}">
Operation: <input type="text" name="operation" value="${petToEdit.operation}">
<input type="hidden" name="id" value="${petToEdit.id}">
<input type="submit" value="Save edited pet">
</form>
</body>
</html>