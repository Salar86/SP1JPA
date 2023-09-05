package flow1;

import flow1.config.HibernateConfig;
import flow1.model.Address;
import flow1.model.Phone;
import flow1.model.Users;
import flow1.model.Zip;
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
            em.getTransaction().begin();
            em.persist(u1);
            em.getTransaction().commit();
        }
    }
}