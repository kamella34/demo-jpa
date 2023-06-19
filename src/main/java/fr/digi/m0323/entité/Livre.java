package fr.digi.m0323.entité;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


//@Entity(name="livre")

@Entity
@Table(name="livre")

public class Livre {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

@Column(name="titre")
private String titre;
  @Column(name="auteur")
private String auteur;

  @ManyToMany(mappedBy="livres")
  private Set<Emprunt> emprunts;

/*  {
    emprunts = new HashSet<>();
  }*/
  public Livre() {

  }

  public Livre(String titre, String auteur) {
    this.titre = titre;
    this.auteur = auteur;
  }

  public Livre(Integer id, String titre, String auteur) {
    this.id = id;
    this.titre = titre;
    this.auteur = auteur;
  }

  @Override
  public String toString() {
    return "Livre{" +

            " titre='" + titre + '\'' +
            ", auteur='" + auteur + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitre() {
    return titre;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public String getAuteur() {
    return auteur;
  }

  public void setAuteur(String auteur) {
    this.auteur = auteur;
  }
}
