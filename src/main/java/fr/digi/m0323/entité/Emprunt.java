package fr.digi.m0323.entité;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_debut")
    private LocalDate dateDebut;
    @Column(name = "date_fin")
    private LocalDate dateFin;
    private int delai;

    @ManyToMany
    @JoinTable(name = "compo",
            joinColumns = @JoinColumn(name = "Id_EMP", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
    private Set<Livre> livres;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    {
        livres = new HashSet<>();
    }

    public Emprunt() {

    }

    public Emprunt(LocalDate date_debut, LocalDate date_fin, int delai, Integer id_client) {
        this.dateDebut = date_debut;
        this.dateFin = date_fin;
        this.delai = delai;
    }

    public Emprunt(Integer id, LocalDate date_debut, LocalDate date_fin, int delai, Integer id_client) {
        this.id = id;
        this.dateDebut = date_debut;
        this.dateFin = date_fin;
        this.delai = delai;

    }

    public Emprunt(LocalDate dateDebut, LocalDate dateFin, int delai, Set<Livre> livres, Client client) {

        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.delai = delai;
        this.livres = livres;
        this.client = client;
    }

    @Override
    public String toString() {
        return "Emprunt{" +

                " dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", delai=" + delai +
                ", livres=" + livres +

                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate date_fin) {
        this.dateFin = date_fin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    public void setLivres(Set<Livre> livres) {
        this.livres = livres;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
