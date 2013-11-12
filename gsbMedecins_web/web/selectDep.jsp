<%-- 
    Document   : v_selectDep
    Created on : 12 nov. 2013, 12:11:03
    Author     : ydoghri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="entete.jsp"/>
<div id="contenu">
    <h2>Recherche des m�decins par d�partement</h2>
    <h3>D�partement � s�lectionner : </h3>
    <form action="Control?action=listeMedecinsDep" method="post">
        <div class="corpsForm">
            <p>
                <label for="lstMois" accesskey="n">D�partement : </label>
                <select name="choixDep">
                    <option value="-1">Choisir un d�partement...</option>
                    <c:forEach var="dep" items="${listDeps}">
                        <option value="${dep.num}">${dep.num}</option>
                    </c:forEach>
                </select>
            </p>
        </div>
        <div class="piedForm">
            <p>
                <input id="ok" type="submit" value="Valider" size="20" />
                <input id="annuler" type="reset" value="Effacer" size="20" />
            </p> 
        </div>

    </form>
<jsp:include page="pied.jsp"/>