package fr.digi.banque;

import fr.digi.banque.entités.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.mariadb.jdbc.CallableParameterMetaData;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestBanque {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
             EntityManager em = emf.createEntityManager();) {
            EntityTransaction et = em.getTransaction();
            et.begin();

            LocalDate date1 = LocalDate.of(1915, 4, 7);
            LocalDate date2 = LocalDate.of(1943, 9, 16);
            LocalDate date3 = LocalDate.of(1941, 10, 1);
            LocalDate date4 = LocalDate.of(2000, 1, 1);

            LocalDateTime dt1= LocalDateTime.now();

            Compte compte1 = new Compte(1111, 10000000);
            //em.persist(compte1);

            Compte compte2 = new Compte(2222, 20000);
            //em.persist(compte2);

            Compte compte3 = new Compte(3333, 300);
            //em.persist(compte3);

            LivretA livret1 = new LivretA(222,20200,10.10);
            //em.persist(livret1);

            AssuranceVie assuranceVie1 = new AssuranceVie(11,345,date4,2.5);
            //em.persist(assuranceVie1);

            Banque banque1 = new Banque("GothamBank");


            Adresse adress1 = new Adresse("1007 Moutain Drive", 12345, "Gotham City");
            Adresse adress2 = new Adresse("Iceberg Lounge",12345,"GothamCity");


            Client client1 = new Client("Wayne", "Bruce", date1, banque1, adress1);
            client1.addCompte(compte1);
            //em.persist(client1);

            Client client2 = new Client("Pennyworth", "Alfred", date2, banque1, adress1);
            client2.addCompte(compte1);
            //em.persist(client2);


            Client client3 = new Client("Oswald","Cobblepot",date3,banque1,adress2);
            client3.addCompte(livret1);
            client3.addCompte(assuranceVie1);
            //em.persist(client3);

            Virement virement1 = new Virement(dt1,30333,"Don",livret1,client2.getNom());
            compte1.getOperations().add(virement1);
           //em.persist(virement1);

            Operation op1 = new Operation(dt1,10000,"dessous de table",compte1);
            Operation op2 = new Operation(dt1,100, "un motif");


            op2.setCompte(compte1);


            op2.setMotif("un autre motif");
            em.persist(op1);
            em.persist(op2);
            em.persist(banque1);


            System.out.println("ICI" + compte1);
            em.remove(op2);

            et.commit();
        }
    }
}

