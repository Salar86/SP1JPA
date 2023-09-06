package flow1;

import flow1.config.HibernateConfig;
import flow1.model.Address;
import flow1.model.Hobby;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try (EntityManager em = emf.createEntityManager()) {
            Users u1 = new Users("Olele", "Prebensen", "preben@mail.dk");
            Users u2 = new Users("Karsten", "Olesen", "ole@mail.dk");
            Address address = new Address("Klovervej");
            address.addUser(u1);
            address.addUser(u2);
            Hobby hobbyOne = new Hobby("Link", "Sports", "Running");
            Hobby hobbyTwo = new Hobby("Link", "Sports", "Climbing");

            em.getTransaction().begin();

            em.persist(u1);
            em.persist(u2);
            em.persist(hobbyOne);
            em.persist(hobbyTwo);
            hobbyOne.addUsers(u1);
            hobbyOne.addUsers(u1);
            hobbyTwo.addUsers(u2);
            em.getTransaction().commit();



        }
    }
}