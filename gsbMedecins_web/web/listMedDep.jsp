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
        <div align="center">
            <h1>Médecins pour le département n°${leDep.num}</h1>
            <table>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Adresse</th>
                    <th>Spécialité</th>
                    <th>Téléphone</th>
                </tr>
                <c:forEach var="med" items="${listMeds}">
                    <tr>
                        <td>${med.nom}</td>
                        <td>${med.prenom}</td>
                        <td>${med.adresse}</td>
                        <td>${med.spe}</td>
                        <td>${med.tel}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
