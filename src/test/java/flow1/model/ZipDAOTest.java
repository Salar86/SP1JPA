package flow1.model;

import flow1.dao.ZipDAO;
import flow1.dto.ZipDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZipDAOTest {
    @Test
    public void validateZipCode() {
        ZipDAO zipDAO = ZipDAO.getInstance();

        var res = zipDAO.getZipAndCities();

        // Test if the zip code is valid
        for (ZipDTO re : res) {
            // check if zip code is 4 digits
            assertTrue(re.getZip() > 999 && re.getZip() < 10000);
        }


    }

    // Test if city is valid
    @Test
    void getZipAndCities() {
        // Test if city is valid
        for (ZipDTO zip : ZipDAO.getInstance().getZipAndCities()) {
            assertNotNull(zip.getName());
        }
    }

}