package fr.digi.banque.entités;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity

public class AssuranceVie extends Compte {
    private Integer idAssuranceVie;
    private LocalDate dateFin;
    private double tauxAss;

    public AssuranceVie() {

    }

    public AssuranceVie(Integer idAssuranceVie, LocalDate dateFin, double tauxAss) {
        this.idAssuranceVie = idAssuranceVie;
        this.dateFin = dateFin;
        this.tauxAss = tauxAss;
    }

    public Integer getIdAssuranceVie() {
        return idAssuranceVie;
    }

    public void setIdAssuranceVie(Integer idAssuranceVie) {
        this.idAssuranceVie = idAssuranceVie;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTauxAss() {
        return tauxAss;
    }

    public void setTauxAss(double tauxAss) {
        this.tauxAss = tauxAss;
    }
}
