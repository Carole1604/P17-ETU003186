<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Budget Initial</title>
</head>
<body>
    <h1>Prevision Budget</h1>
    <form action="<%= request.getContextPath() %>/init" method="post">
        <label for="libelle">Libelle : </label>
        <input type="text" name="sakafo" id="libelle">
        
        <label for="montant">Montant Initial : </label>
        <input type="number" name="montant" id="montant" step="0.01" required>
        
        <input type="submit" value="Continuer vers les depenses">
    </form>
</body>
</html>