package fr.digi.m0323;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestJpa {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-m0323");
            EntityManager em = emf.createEntityManager();){
            System.out.println(em);
        }
    }
}
