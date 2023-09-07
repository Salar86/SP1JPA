package flow1.dao;

import flow1.config.HibernateConfig;
import flow1.dto.UserDTO;
import flow1.model.Phone;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class PhoneDAOImpl implements IPhoneDAO{
    private static PhoneDAOImpl phoneDAO = null;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();


    public PhoneDAOImpl() {
    }

    public static PhoneDAOImpl getInstance(){
        if (phoneDAO == null) {
            phoneDAO = new PhoneDAOImpl();
        }
        return phoneDAO;
    }

    @Override
    public String createPhone(String phone) {
        Phone newPhone = new Phone(phone);
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(newPhone);
            em.getTransaction().commit();
        }

        return phone;
    }

    @Override
    public List<Phone> findPhoneByUserId(int id) {
        try (EntityManager em = emf.createEntityManager()){
             TypedQuery<Phone> query = em.createQuery("SELECT p from Phone p WHERE p.user.id = :id", Phone.class);
             query.setParameter("id", id);
             return query.getResultList();

        }

    }

    @Override
    public Phone updatePhone(Phone phone) {
        Phone updatedPhone;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            updatedPhone = em.merge(phone);
            em.getTransaction().commit();
        }
        return updatedPhone;
    }

    @Override
    public void deletePhone(String phone) {
        Phone deletePhone;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            deletePhone = em.find(Phone.class, phone);
            if (deletePhone!= null) {
                em.remove(deletePhone);
            }
        }

    }
    public List<UserDTO> getAllUserInfoByPhone(String phone) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<UserDTO> query = em.createQuery(
                    "select new flow1.dto.UserDTO(u.firstName, u.lastName, u.email, a.address, a.zip.zip, h.category) " +
                            "FROM Users u, Address a, Hobby h, Phone p where p.id = :phone", UserDTO.class);
            query.setParameter("phone", phone);
            return query.getResultList();
        }
    }
}
