<%-- 
    Document   : index
    Created on : 4 nov. 2013, 09:49:47
    Author     : ydoghri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Médecins GSB</title>
    </head>
    <body>
        <form action="Control?action=listeMedecinsNom"method="POST">
            <legend>Rechercher un médecin par nom</legend>
            <label for="nomMed">Nom du médecin : </label>
            <input type="text" name="nomMed">
            <input type="submit">
        </form>
    </body>
</html>
