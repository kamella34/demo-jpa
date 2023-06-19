package fr.digi.banque.entités;

import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name="BANQUE")
public class Banque {
    @Id
    @Column(name="ID")
   private Integer id;
   private String nom;

    @OneToMany(mappedBy="banque")
    private Set<Client> clients;

    public Banque() {
    }

    public Banque(Integer id, String nom, Set<Client> clients) {
        this.id = id;
        this.nom = nom;
        this.clients = clients;
    }

    public Banque(String nom, Set<Client> clients) {
        this.nom = nom;
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
