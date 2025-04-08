package com.model;

import java.time.LocalDateTime;

public class Depense {
    private int idDepense;
    private int idPrevision;
    private String typeDepense;
    private double montant;
    private LocalDateTime dateDepense;

    
    public Depense(int idDepense, int idPrevision, String typeDepense, double montant, LocalDateTime dateDepense) {
        this.idDepense = idDepense;
        this.idPrevision = idPrevision;
        this.typeDepense = typeDepense;
        this.montant = montant;
        this.dateDepense = dateDepense;
    }

    public Depense() {}
    
    public int getIdDepense() {
        return idDepense;
    }
    public void setIdDepense(int idDepense) {
        this.idDepense = idDepense;
    }
    public int getIdPrevision() {
        return idPrevision;
    }
    public void setIdPrevision(int idPrevision) {
        this.idPrevision = idPrevision;
    }
    public String getTypeDepense() {
        return typeDepense;
    }
    public void setTypeDepense(String typeDepense) {
        this.typeDepense = typeDepense;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public LocalDateTime getDateDepense() {
        return dateDepense;
    }
    public void setDateDepense(LocalDateTime dateDepense) {
        this.dateDepense = dateDepense;
    }
}