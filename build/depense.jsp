<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dépenses</title>
</head>
<body>
    <h1>Gestion des Dépenses</h1>
    
    <h2>Prévision: ${prevision.libelle} - Montant initial: ${prevision.montantInitial}</h2>
    
    <h3>Ajouter une dépense</h3>
    <form action="${pageContext.request.contextPath}/add-depense" method="post">
        <div>
            <label for="type">Type :</label>
            <select id="type" name="type" required>
                <option value="Alimentation">Alimentation</option>
                <option value="Transport">Transport</option>
                <option value="Logement">Logement</option>
                <option value="Loisirs">Loisirs</option>

            </select>
        </div>
        <div>
            <label for="montant">Montant :</label>
            <input type="number" id="montant" name="montant" step="0.01" required>
        </div>
        <button type="submit">Ajouter</button>
    </form>
    <h3>Liste des dépenses</h3>
    <table>
        <thead>
            <tr>
                <th>Type</th>
                <th>Montant</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${depenses}" var="depense">
                <tr>
                    <td>${depense.typeDepense}</td>
                    <td>${depense.montant}</td>
                </tr>
            </c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <th>Total dépensé :</th>
                <td>${totalDepense}</td>
            </tr>
            <tr>
                <th>Reste :</th>
                <td>${prevision.montantInitial - totalDepense}</td>
            </tr>
        </tfoot>
    </table>
    <a href="${pageContext.request.contextPath}/etat">Voir l'état complet</a>

    <c:if test="${not empty erreur}">
        <p style="color: red;">${erreur}</p>
    </c:if>
</body>
</html>