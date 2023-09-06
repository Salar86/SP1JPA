package flow1;

import flow1.config.HibernateConfig;
import flow1.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try (EntityManager em = emf.createEntityManager()) {
            Users u1 = new Users("Preben", "Prebensen", "preben@mail.dk");
            Address address = new Address("Ferskenvej 80");
            Zip zip = new Zip(4700, "Næstved", "Region Sjælland", "Næstved Kommune");
            zip.addAddress(address);
            address.addUser(u1);
            u1.addPhone("+4555774778");
            em.getTransaction().begin();
            em.persist(u1);
            em.getTransaction().commit();


            // USER STORY 6 : [US-6] As a user I want to get all persons living in a given city (i.e. 2800 Lyngby)

            List<Users> users = ZipDAO.getInstance().getUsersFromCity("Næstved");
            for (Users user : users) {
                System.out.println(user.getFirstName() + " " + user.getLastName());
            }


//
////                 USER STORY 7 : [US-7] As a user I want to get a list of all postcodes and city names in Denmark
//            List<ZipDTO> cities = ZipDAO.getInstance().getZipAndCities();
//            for (ZipDTO city : cities) {
//                System.out.println(city);


//            }
        }
    }
}

