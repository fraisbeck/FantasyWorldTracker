package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegionsDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    GenericDao continentDao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Region.class);
        continentDao = new GenericDao(Continent.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<Region> regions = (List<Region>) dao.getAll();
        assertEquals(7, regions.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        Region retrievedRegion = (Region) dao.getById(4);
        assertNotNull(retrievedRegion);
        assertEquals("Prainia", retrievedRegion.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Continent newContinent = (Continent) continentDao.getById(6);
        Region newRegion = new Region("Utopia", newContinent, newContinent.getWorld());
        int id = dao.insert(newRegion);
        assertNotEquals(0, id);
        Region insertedRegion = (Region) dao.getById(id);
        newRegion.equals(insertedRegion);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess () {
        String newName = "Feralos";
        Region regionToUpdate = (Region) dao.getById(2);
        regionToUpdate.setName(newName);
        dao.saveOrUpdate(regionToUpdate);
        Region retrievedRegion = (Region) dao.getById(2);
        assertEquals(regionToUpdate, retrievedRegion);
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Region> regions = dao.getByIdentifierEqual("name", "Butrus");
        assertEquals(1, regions.size());
        assertEquals(6, regions.get(0).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Region> regions = dao.getByIdentifierLike("name", "ra");
        assertEquals(3, regions.size());
    }
}
