package fr.digi.banque;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestBanque {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
             EntityManager em = emf.createEntityManager();) {
             EntityTransaction et = em.getTransaction();
                et.begin();



            et.commit();
        }
    }
}

