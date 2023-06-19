package fr.digi.m0323;

import fr.digi.m0323.entité.Livre;
import jakarta.persistence.*;

public class TestJpa {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-m0323");
             EntityManager em = emf.createEntityManager();) {
            //System.out.println(em);
            EntityTransaction et = em.getTransaction();
            et.begin();

            Livre l = em.find(Livre.class, 1);
            if (l != null) {
                System.out.println(l.getTitre() + " de " + l.getAuteur());
                System.out.println(l);
            }


            Livre newBook = new Livre();
            newBook.setAuteur("Sega");
            newBook.setTitre("Jpa");
            em.persist(newBook);

            Livre newBook2 = new Livre();
            newBook2.setAuteur("Sega");
            newBook2.setTitre("jcbd");
            em.persist(newBook2);


            Livre newBook3 = new Livre("java","Sega");
            em.persist(newBook3);


            Livre modifLivre = em.find(Livre.class, 5);
            if (null != modifLivre) {
                modifLivre.setTitre("Du plaisir dans la cuisine");
            }


            TypedQuery<Livre> query = em.createQuery("from Livre  where titre='Jpa'", Livre.class);
            TypedQuery<Livre> query2 = em.createQuery("select l3 from Livre l3 where l3.auteur='Sega'", Livre.class);
            TypedQuery<Livre> queryList = em.createQuery("select list from Livre list ", Livre.class);

            Livre l1 = query.getResultList().get(0);
            System.out.println(l1);


            for (Livre l2 : query2.getResultList()) {
                System.out.println(l2);
            }

            System.out.println(query2.getResultList());


            Livre removeBook = em.find(Livre.class, 3);
            if (null != removeBook) {
                em.remove(removeBook);
            }

            System.out.println(queryList.getResultList());
            for (Livre llist : queryList.getResultList()) {
                System.out.println(llist);
            }

            //em.getTransaction().commit();
            et.commit();
        }
    }
}
