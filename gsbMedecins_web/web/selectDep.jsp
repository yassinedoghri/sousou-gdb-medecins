<%-- 
    Document   : listMedDep
    Created on : 5 nov. 2013, 11:46:20
    Author     : ydoghri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Control?action=listeMedecinsDep"method="POST">
            <legend>Veuillez choisir un département</legend>
            <select name="choixDep">
                <option value="-1">Choisir un département...</option>
            <c:forEach var="dep" items="${listDeps}">
                <option value="${dep.num}">${dep.num}</option>
            </c:forEach>
            </select>
            <input type="submit">
        </form>
    </body>
</html>
