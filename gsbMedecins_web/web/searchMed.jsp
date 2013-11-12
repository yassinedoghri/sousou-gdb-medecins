<%-- 
    Document   : index
    Created on : 4 nov. 2013, 09:49:47
    Author     : ydoghri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="entete.jsp"/>
<div id="contenu">
    <h2>Recherche des m�decins par nom</h2>
    <form action="Control?action=listeMedecinsNom" method="post">
        <div class="corpsForm">
            <p>
                <label for="nomMed">Nom du m�decin : </label>
                <input type="text" name="nomMed">
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
