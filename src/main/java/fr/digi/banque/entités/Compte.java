package fr.digi.banque.entités;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPTE")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class Compte {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private int numero;

    private double solde;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client> clients;

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    {
        clients = new HashSet<>();
        operations = new HashSet<>();

    }

    public Compte() {
    }


    public Compte(int numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }

    public Compte(Integer id, int numero, double solde, Set<Client> clients, Set<Operation> operations) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;
        this.clients = clients;
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero=" + numero +
                ", solde=" + solde +
                ", clients=" + clients +
                ", operations=" + operations +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }
}
