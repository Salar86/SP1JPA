package flow1.dao;

import flow1.config.HibernateConfig;
import flow1.dto.UserDTO;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserDAOImpl implements IUserDAO{
    private  static UserDAOImpl userDAO = null;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public UserDAOImpl() {
    }

    public static UserDAOImpl getInstance() {
        if (userDAO == null) {
            userDAO = new UserDAOImpl();
        }
        return userDAO;
    }
    @Override
    public int createUser(Users user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        return user.getId();
    }

    @Override
    public Users findUser(int id) {
        Users user;
        try (EntityManager em = emf.createEntityManager()) {
            user = em.find(Users.class, id);
        }
        return user;
    }

    @Override
    public Users updateUser(Users user) {
        Users updatedUser;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            updatedUser = em.merge(user);
            em.getTransaction().commit();
        }
        return updatedUser;
    }

    @Override
    public void deleteUser(int id) {
        Users deleteUser;
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            deleteUser = em.find(Users.class, id);
            if (deleteUser != null) {
                em.remove(deleteUser);
            }
            em.getTransaction().commit();
        }

    }

    @Override
    public List<UserDTO> getAllUserInfo(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<UserDTO> query = em.createQuery(
                    "select new flow1.dto.UserDTO(u.firstName, u.lastName, u.email, a.address, a.zip.zip, h.category) " +
                            "FROM Users u, Hobby h join u.address a where u.id = :id", UserDTO.class);
            query.setParameter("id", id);
            return query.getResultList();
        }
    }
}
