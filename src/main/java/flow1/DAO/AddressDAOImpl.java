package flow1.DAO;


import flow1.config.HibernateConfig;
import flow1.model.Address;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class AddressDAOImpl implements IAddressDAO {

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    @Override
    // Can be cahnged to return a Address object if needed - for UnitTest i suppose.
    public void addAddressToDatabase(String address) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Address(address));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Address getAddress(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address foundAddress = em.find(Address.class, id);
        em.getTransaction().commit();
        em.close();

        return foundAddress;
    }

    @Override
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    public Address addAddressToUser(Users user) {
        return null;
    }

    @Override
    public void deleteAddress(int id) {

    }
}
