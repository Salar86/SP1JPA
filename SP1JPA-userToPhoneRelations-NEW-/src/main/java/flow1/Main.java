package flow1;

import flow1.config.HibernateConfig;
import flow1.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try (EntityManager em = emf.createEntityManager()) {
            Users u1 = new Users("Preben", "Prebensen", "preben@mail.dk");
            Address address = new Address("Ferskenvej 80");
            Zip zip = new Zip(4700, "Næstved", "Region Sjælland", "Næstved Kommune");
            zip.addAddress(address);
            address.addUser(u1);
            u1.addPhone("+4555774778");
            Hobby h1 = new Hobby("ssss","spil","fodbold");

            u1.addhoppe(h1);
            em.getTransaction().begin();
            em.persist(u1);
            em.persist(h1);
            em.getTransaction().commit();
        }
    }
}