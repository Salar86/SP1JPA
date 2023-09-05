package flow1;

import flow1.config.HibernateConfig;
import flow1.model.Address;
import flow1.model.Phone;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try (EntityManager em = emf.createEntityManager()) {
            Users u1 = new Users("Preben", "Prebensen", "preben@mail.dk");
            Users u2 = new Users("Ole", "Olesen", "ole@mail.dk");
            Users u3 = new Users("Test", "Testesen", "ole@mail.dk");
            u1.addPhone("+4555774778");
            Address address = new Address("Klovervej");
            Address address1 = new Address("Olvej");
            address.addUser(u1);
            address.addUser(u2);

            address.getUsers().add(u3);

            em.getTransaction().begin();
            em.persist(u1);
            em.persist(u2);
            em.getTransaction().commit();
        }
    }
}