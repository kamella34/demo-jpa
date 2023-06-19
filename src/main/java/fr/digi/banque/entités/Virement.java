package fr.digi.banque.entités;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Vir")
public class Virement extends Operation {

    private String beneficiaire;

    public Virement() {
    }

    public Virement(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Virement(Integer id, LocalDateTime dateOp, double montant, String motif, Compte compte, String beneficiaire) {
        super(id, dateOp, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public Virement(LocalDateTime dateOp, double montant, String motif, Compte compte, String beneficiaire) {
        super(dateOp, montant, motif, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
