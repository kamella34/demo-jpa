package fr.digi.m0323;


import fr.digi.m0323.entité.Client;
import fr.digi.m0323.entité.Emprunt;
import fr.digi.m0323.entité.Livre;
import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.HashSet;
import java.util.Set;

public class TestBibliotheque {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-m0323");
             EntityManager em = emf.createEntityManager();)
        {
            EntityTransaction et = em.getTransaction();
            et.begin();



            Emprunt empt = em.find(Emprunt.class,1);
            if (empt!= null) {
                System.out.println(empt.getLivres());
            }

            Client cli = em.find(Client.class,1);
            if (cli!= null) {
                System.out.println("Client: " +cli.getNom() + " " + cli.getEmprunts()) ;
            }

            Client newClient = new Client();
            newClient.setNom("Wayne");
            newClient.setPrenom("Bruce");
            em.persist(newClient);

            Client newClient2 = new Client("Nestor","aldred");
            em.persist(newClient2);

            Livre newLivre1 = new Livre("batman vs terminator","Sarah Connor");
            em.persist(newLivre1);

            Set<Livre> listlivre  = new HashSet<Livre>();
            listlivre.add(newLivre1);

            Emprunt newEmprunt = new Emprunt (LocalDate.now(),LocalDate.now(),30, listlivre, newClient);
            em.persist(newEmprunt);


            et.commit();
        }
    }
}
