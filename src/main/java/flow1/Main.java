package flow1;

import flow1.DAO.AddressDAOImpl;
import flow1.DAO.HobbyDAOImpl;
import flow1.DTO.UserAddressDTO;
import flow1.config.HibernateConfig;
import flow1.model.Address;
import flow1.model.Hobby;
import flow1.model.Users;
import flow1.model.Zip;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

        try (EntityManager em = emf.createEntityManager()) {

            AddressDAOImpl DAO = AddressDAOImpl.getInstance();

            List<UserAddressDTO> simpleDTOS = DAO.getFullAddress();


            for (UserAddressDTO simpleDTO : simpleDTOS)
            {
                System.out.println(simpleDTO);
            }
        }

    }
}