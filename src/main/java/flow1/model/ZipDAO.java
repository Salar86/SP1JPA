package flow1.model;

import flow1.config.HibernateConfig;
import flow1.model.ZipDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ZipDAO {

    private static ZipDAO instance;
    private static EntityManagerFactory emf;

    public ZipDAO() {
    }

    public static ZipDAO getInstance() {
        if (instance == null) {
            emf = HibernateConfig.getEntityManagerFactoryConfig();
            instance = new ZipDAO();
        }
        return instance;
    }
    //USER STORY 6 : [US-6] As a user I want to get all persons living in a given city (i.e. 2800 Lyngby)

    public List<Users> getUsersFromCity(String city) {
        try (var em = emf.createEntityManager()) {
            TypedQuery<Users> q = em.createQuery("SELECT u FROM Users u JOIN u.address a JOIN a.zip z WHERE z.city = :city", Users.class);
            q.setParameter("city", city);
            List<Users> users = q.getResultList();
            return users;
        }
    }

    // USER STORY 7 : AS A USER I WANT TO GET A LIST OF ALL POSTCODES AND CITIES IN DENMARK
    public List<ZipDTO> getZipAndCities() {

        try (var em = emf.createEntityManager()) {

            TypedQuery<ZipDTO> q = em.createQuery("SELECT new flow1.model.ZipDTO(zip,city) FROM Zip a", ZipDTO.class);
            List<ZipDTO> cities = q.getResultList();
            return cities;
        }



    }

}