package com.model;

import java.time.LocalDateTime;

public class Prevision {
    private int idPrevision;
    private String libelle;
    private double montantInitial;
    private LocalDateTime dateCreation;

 
    public Prevision(int idPrevision, String libelle, double montantInitial, LocalDateTime dateCreation) {
        this.idPrevision = idPrevision;
        this.libelle = libelle;
        this.montantInitial = montantInitial;
        this.dateCreation = dateCreation;
    }

    public Prevision() {}
    
    public int getIdPrevision() {
        return idPrevision;
    }
    public void setIdPrevision(int idPrevision) {
        this.idPrevision = idPrevision;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public double getMontantInitial() {
        return montantInitial;
    }
    public void setMontantInitial(double montantInitial) {
        this.montantInitial = montantInitial;
    }
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }


}