<%-- 
    Document   : listMedNom
    Created on : 12 nov. 2013, 12:35:19
    Author     : ydoghri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="entete.jsp"/>
<div id="contenu">
    <h3>R�sultat(s) pour "<i>${nomR}</i>"</h3>
    <table class="listeLegere">
        <caption>Liste des m�decins par nom</caption>
        <tr>
            <th>Nom</th>
            <th>Pr�nom</th>
            <th>Adresse</th>
            <th>Sp�cialit�</th>
            <th>T�l�phone</th>
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
    <br />
    <a href="Control?action=listeMedecinsNom">Retour � la recherche</a>
</div>
<jsp:include page="pied.jsp"/>
