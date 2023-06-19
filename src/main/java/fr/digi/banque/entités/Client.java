package fr.digi.banque.entités;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String prenom;
    private String nom;
    private LocalDate dateNaissance;
    @ManyToMany
    @JoinTable(name = "CLIENT_COMPTE",
            joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "ID"))
    private Set<Compte> comptes;


    @ManyToOne
    @JoinColumn(name = "ID_BANQUE")
    private Banque banque;

    @Embedded
    private Adresse adresse;

    {
        comptes = new HashSet<>();
    }

    public Client() {
    }

    public Client(String prenom, String nom, LocalDate dateNaissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }

    public Client(String prenom, String nom, LocalDate dateNaissance, Banque banque, Adresse adresse) {
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.banque = banque;
        this.adresse = adresse;
    }

    public Client(Integer id, String prenom, String nom, LocalDate dateNaissance, Set<Compte> comptes, Banque banque, Adresse adresse) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.comptes = comptes;
        this.banque = banque;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", comptes=" + comptes +
                ", banque=" + banque +
                ", adresse=" + adresse +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idClient) {
        this.id = idClient;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void addCompte(Compte compte){
        comptes.add(compte);
    }
}
