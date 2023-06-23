package fr.digi.banque.entités;


import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Operation {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateOp;
    private double montant;
    private String motif;

    @ManyToOne()
    @JoinColumn(name = "ID_COMPTE")
    private Compte compte;

    public Operation() {
    }

    public Operation(Integer id, LocalDateTime dateOp, double montant, String motif, Compte compte) {
        this.id = id;
        this.dateOp = dateOp;
        this.montant = montant;
        this.motif = motif;
        //this.compte = compte;
        this.setCompte(compte) ;
    }

    public Operation(LocalDateTime dateOp, double montant, String motif, Compte compte) {
        this.dateOp = dateOp;
        this.montant = montant;
        this.motif = motif;
        //this.compte = compte;
        this.setCompte(compte) ;
    }

    public Operation(LocalDateTime dateOp, double montant, String motif) {
        this.dateOp = dateOp;
        this.montant = montant;
        this.motif = motif;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", dateOp=" + dateOp +
                ", montant=" + montant +
                ", motif='" + motif + '\'' +
                ", compte=" + compte +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateOp() {
        return dateOp;
    }

    public void setDateOp(LocalDateTime dateOp) {
        this.dateOp = dateOp;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }


    public void setCompte(Compte compte){
        if(this.compte != null){
            this.compte.getOperations().remove(this);
        }
        this.compte = compte;
        if(this.compte != null){
            this.compte.getOperations().add(this);
        }
    }

}
