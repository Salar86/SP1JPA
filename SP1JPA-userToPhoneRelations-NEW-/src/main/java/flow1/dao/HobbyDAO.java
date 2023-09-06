package flow1.dao;

import flow1.model.Address;
import flow1.model.Hobby;
import flow1.model.Phone;
import flow1.model.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class HobbyDAO implements IHobbyDAO{
    private static EntityManagerFactory emf;
    private  static HobbyDAO hobbyDAO;

    public HobbyDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public static  HobbyDAO getInstance(EntityManagerFactory emf)
    {
        if (hobbyDAO == null){
            hobbyDAO = new HobbyDAO(emf);
        }
        return  hobbyDAO;
    }

    @Override
    public void creatHoppy(Hobby hobby) {
        EntityManager em = emf.createEntityManager();
    }

    @Override
    public void FindHobbyById(int id)
    {EntityManager em = emf.createEntityManager();
        Hobby hobby = em.find(Hobby.class, id);
        em.close();
    }

    @Override
    public void DeleteHobby(Hobby hobby) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.remove(hobby);
        em.getTransaction().commit();
        em.close();
    }

    public Hobby UpdatedHobby(Hobby hobby) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Hobby updatedHobby = em.merge(hobby);
        em.getTransaction().commit();
        em.close();
        return updatedHobby;
    }

    @Override
    public List<Hobby> getAllePerson(int id, String users) {
        return null;
    }

    @Override
    public Users getAllUsersInfo(int id, String firstName, String lastname, String email) {
        return null;
    }

    @Override
    public Phone GetAllephone(int id, String phoneNumber, String users) {
        return null;
    }

    @Override
    public long findTotalNumberOfUsersByHobby(Hobby hobby) {
        try (EntityManager em = emf.createEntityManager())
        {
            TypedQuery<Long> query = em.createQuery("SELECT count( ) FROM Hobby sem JOIN hop.users stud WHERE sem.name = :semesterName", Long.class );
            //query.setParameter("Hobbyinf", Hobby);
            return query.getSingleResult();
        }

    }

    @Override
    public Long findTotalNumberOfUsersByaddress(Address address) {
        return null;
    }
}
