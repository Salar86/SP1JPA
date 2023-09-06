package flow1.DAO;


import flow1.config.HibernateConfig;
import flow1.model.Address;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class AddressDAOImpl implements IAddressDAO {

    private static AddressDAOImpl addressDAO = null;
    private AddressDAOImpl(){}
    public static AddressDAOImpl getInstance(){

        if (addressDAO == null){
            addressDAO = new AddressDAOImpl();
        }
        return addressDAO;
    }

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    @Override
    // Can be cahnged to return a Address object if needed - for UnitTest i suppose.
    public void createAddress(String address) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Address(address));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Address getAddressOfUser(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address foundAddress = em.find(Address.class, id);
        em.getTransaction().commit();
        em.close();

        return foundAddress;
    }

    @Override
    public Address updateAddress(Address address) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address addressToUpdate = em.merge(address);
        em.getTransaction().commit();
        em.close();
        return addressToUpdate;
    }

    @Override
    public void addAddressToUser(Address address, int userId) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Users addressToUpdate = em.find(Users.class, userId);
        address.addUser(addressToUpdate);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAddress(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Address addressToDelete = em.find(Address.class, id);
        if(addressToDelete != null){
            em.remove(addressToDelete);
        }
        em.getTransaction().commit();
        em.close();
    }
}
