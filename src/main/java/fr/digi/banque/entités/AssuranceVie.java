package fr.digi.banque.entités;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Set;

@Entity

public class AssuranceVie extends Compte {

    private LocalDate dateFin;
    private double tauxAss;

    public AssuranceVie() {

    }

    public AssuranceVie(LocalDate dateFin, double tauxAss) {

        this.dateFin = dateFin;
        this.tauxAss = tauxAss;
    }

    public AssuranceVie(int numero, double solde, LocalDate dateFin, double tauxAss) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.tauxAss = tauxAss;
    }

    public AssuranceVie(Integer id, int numero, double solde, Set<Client> clients, Set<Operation> operations, LocalDate dateFin, double tauxAss) {
        super(id, numero, solde, clients, operations);
        this.dateFin = dateFin;
        this.tauxAss = tauxAss;
    }

    @Override
    public String toString() {
        return "AssuranceVie{" +
                ", dateFin=" + dateFin +
                ", tauxAss=" + tauxAss +
                '}';
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
