package flow1.DAO;


import flow1.DTO.UserAddressDTO;
import flow1.config.HibernateConfig;
import flow1.model.Address;
import flow1.model.Users;
import flow1.model.Zip;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

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
    // Can be cahnged to return an Address object if needed - for UnitTest i suppose.
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

    public List<UserAddressDTO> getFullAddress(){
        EntityManager em = emf.createEntityManager();;
        TypedQuery<UserAddressDTO> query = em.createQuery("SELECT NEW flow1.DTO.UserAddressDTO(users.firstName, users.lastName, address.address, zip.city, zip.zip) " +
                " FROM Address address, Users users" +
                " WHERE users.address.id=address.id ", UserAddressDTO.class);
        return query.getResultList();
    }
}
