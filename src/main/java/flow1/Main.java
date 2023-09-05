package flow1;

import flow1.config.HibernateConfig;
import flow1.model.Phone;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try (EntityManager em = emf.createEntityManager()) {
            Users u1 = new Users("Preben", "Prebensen", "preben@mail.dk");
            u1.addPhone("+4555774778");
            em.getTransaction().begin();
            em.persist(u1);
            em.getTransaction().commit();
        }
    }
}