package flow1.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ZipTest {

    @Test
    public Boolean validateZipCode(String zip) {
        return zip.matches("[0-9][0-9][0-9][0-9]");

    }
}

//    public class  testValidateZipCodeFromDatabase {
//
//        private EntityManagerFactory entityManagerFactory;
//        private EntityManager entityManager;

//        @Test
//        public void testValidateZipCodeFromDatabase() {
//            TypedQuery<Zip> query = entityManager.createQuery("SELECT z FROM Zip z WHERE z.zip = :zip", Zip.class);
//            query.setParameter("zip", "1000");
//            Zip zip = query.getSingleResult();
//            assertEquals("1000", zip.getZip());
//        }
//
//
//
//
//
//
//    }



