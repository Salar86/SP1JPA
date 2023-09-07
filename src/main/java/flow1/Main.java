package flow1;

import flow1.config.HibernateConfig;
import flow1.dao.HobbyDAOImpl;
import flow1.dao.PhoneDAOImpl;
import flow1.dao.UserDAOImpl;
import flow1.dto.UserDTO;
import flow1.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try (EntityManager em = emf.createEntityManager()) {
            UserDAOImpl userDAO = UserDAOImpl.getInstance();
            PhoneDAOImpl phoneDAO = PhoneDAOImpl.getInstance();
            HobbyDAOImpl hobbyDAO = HobbyDAOImpl.getInstance();
            Users u1 = new Users("Preben", "Prebensen", "preben@mail.dk");
            Users u2 = new Users("Lars", "Larsen", "lars@mail.dk");
            Address address = new Address("Ferskenvej 80");
            Address a2 = new Address("Ferskenvej 99");
            Zip zip = new Zip(4700, "Næstved", "Region Sjælland", "Næstved Kommune");
            Zip zip2 = new Zip(2200, "København", "Region Hovedstaden", "Københavns Kommune");
            Hobby h1 = new Hobby("test", "test", "test", "test");
            Hobby h2 = new Hobby("test2", "test2", "test2", "test2");
            zip.addAddress(address);
            zip2.addAddress(a2);
            h1.addUsers(u1);
            h2.addUsers(u2);
            address.addUser(u1);
            a2.addUser(u2);
            u1.addPhone("+4555774778");
            u2.addPhone("+4555771749");
            em.getTransaction().begin();
            em.persist(u1);
            em.persist(u2);
            em.persist(h1);
            em.persist(h2);
//            em.persist(zip2);
            em.getTransaction().commit();
            List<UserDTO> userList = userDAO.getAllUserInfo(1);
            for (UserDTO userDTO : userList) {
                System.out.println(userDTO);
           }
             List<Phone> phoneList = phoneDAO.findPhoneByUserId(1);
            for (Phone phone : phoneList) {
                System.out.println(phone.getPhoneNumber());

            }
            List<UserDTO> userList2 = phoneDAO.getAllUserInfoByPhone("+4555774778");
            for (UserDTO userDTO : userList2) {
                System.out.println(userDTO);

            }

        }

    }
}