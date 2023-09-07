package flow1.DAO;

import flow1.config.HibernateConfig;
import flow1.model.Hobby;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class HobbyDAOImpl implements IHobbyDAO{
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
}
