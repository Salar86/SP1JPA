package flow1;

import flow1.DAO.AddressDAOImpl;
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
            Address address1 = new Address("Holgervej");
            address.addUser(u1);
            address.addUser(u2);
            Hobby hobbyOne = new Hobby("Link", "Sports", "Running");
            Hobby hobbyTwo = new Hobby("Link", "Sports", "Climbing");

            em.getTransaction().begin();

            em.getTransaction().commit();

            AddressDAOImpl DAO = AddressDAOImpl.getInstance();
            DAO.addAddressToUser(address1, 1);



        }
    }
}