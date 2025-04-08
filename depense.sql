
CREATE DATABASE  gestion_depense;
USE gestion_depense;

CREATE TABLE prevision (
    id_prevision INT AUTO_INCREMENT PRIMARY KEY,
    libelle VARCHAR(50) NOT NULL,
    montant_initial DECIMAL(10,2) NOT NULL,
    date_creation DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE depense (
    id_depense INT AUTO_INCREMENT PRIMARY KEY,
    id_prevision INT NOT NULL,
    type_depense VARCHAR(30) NOT NULL,
    montant DECIMAL(10,2) NOT NULL,
    date_depense DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_prevision) REFERENCES prevision(id_prevision)
);
