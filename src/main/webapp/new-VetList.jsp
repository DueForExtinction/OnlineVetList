<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a new veterinarian list</title>
</head>
<body>
<form action = "createNewVetListServlet" method ="post">
Vet name: <input type="text" name= "vetBisName"><br/>
Veterinarian name: <input type="text" name="vetName"><br/>

Available pets: <br/>
<select name="allPetsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentpet">
<option value="${currentpet.id }">${currentpet.name } | ${currentpet.owner } | ${currentpet.operation}</option>
</c:forEach>
</select>
<br/>
<input type="submit" value="Create List and Add Pets">
</form>
<a href ="index.html">Go add new pets instead.</a>
</body>
</html>