package fr.digi.banque.entités;

import jakarta.persistence.*;

import java.util.Set;

@Entity

public class LivretA extends Compte {

    private Double tauxLiv;

    public LivretA() {

    }

    public LivretA(Double tauxLiv) {
        this.tauxLiv = tauxLiv;
    }

    public LivretA(int numero, double solde, Double tauxLiv) {
        super(numero, solde);
        this.tauxLiv = tauxLiv;
    }


    public LivretA(Integer id, int numero, double solde, Set<Client> clients, Set<Operation> operations, Double tauxLiv) {
        super(id, numero, solde, clients, operations);
        this.tauxLiv = tauxLiv;
    }

    @Override
    public String toString() {
        return "LivretA{" +
                "tauxLiv=" + tauxLiv +
                '}';
    }

    public Double getTauxLiv() {
        return tauxLiv;
    }

    public void setTauxLiv(Double tauxLiv) {
        this.tauxLiv = tauxLiv;
    }


}
