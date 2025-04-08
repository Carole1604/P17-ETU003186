<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>État des Dépenses</title>
</head>
<body>
    <h1>État des Dépenses</h1>
    <h2>Prévision: ${prevision.libelle}</h2>
    <table>
        <tr>
            <th>Montant initial</th>
            <td>${prevision.montantInitial}</td>
        </tr>
        <tr>
            <th colspan="2">Détail des dépenses</th>
        </tr>
        <c:forEach items="${depenses}" var="depense" varStatus="status">
            <tr>
                <td>${status.index + 1}. ${depense.typeDepense}</td>
                <td>${depense.montant}</td>
            </tr>
        </c:forEach>
        <tr class="total">
            <th>Total dépensé</th>
            <td>${totalDepense}</td>
        </tr>
        <tr class="total">
            <th>Reste</th>
            <td>