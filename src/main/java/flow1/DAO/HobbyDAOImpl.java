package flow1.DAO;

import flow1.config.HibernateConfig;
import flow1.model.Hobby;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HobbyDAOImpl implements flow1.dao.IHobbyDAO {
    private static HobbyDAOImpl hobbyDAO = null;

    private HobbyDAOImpl(){}

    public static HobbyDAOImpl getInstance(){
        if(hobbyDAO == null){
            hobbyDAO = new HobbyDAOImpl();
        }
        return hobbyDAO;
    }

    EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    @Override
    public Hobby createHobby(Hobby hobby) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(hobby);
        em.getTransaction().commit();
        em.close();

        return hobby;
    }

    @Override
    public Hobby getHobby(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Hobby foundHobby = em.find(Hobby.class, id);
        em.getTransaction().commit();
        em.close();
        return foundHobby;
    }

    @Override
    public void deleteHobby(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Hobby hobbyToDelete = getHobby(id);
        if(hobbyToDelete != null){
            em.remove(hobbyToDelete);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Users> usersWithAHobby(String hobby){
        try (EntityManager em = emf.createEntityManager())
        {
            String jpql = "SELECT u FROM Users u JOIN FETCH u.hobbies h WHERE h.name  = :hobby";

            TypedQuery<Users> query = em.createQuery(jpql, Users.class);
            query.setParameter("hobby", hobby);

            return query.getResultList();

        }
    }

    public int totalNumberOfUsersWithHobby(String hobby){
        try (EntityManager em = emf.createEntityManager())
        {
            int size = 0;
            String jpql = "SELECT u FROM Users u JOIN FETCH u.hobbies h WHERE h.name  = :hobby";

            TypedQuery<Users> query = em.createQuery(jpql, Users.class);
            query.setParameter("hobby", hobby);
            size = query.getResultList().size();

            return size;
        }
    }
}
