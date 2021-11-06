package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocationsDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    GenericDao regionDao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Location.class);
        regionDao = new GenericDao(Region.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<Location> locations = (List<Location>) dao.getAll();
        assertEquals(7, locations.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        Location retrievedLocation = (Location) dao.getById(5);
        assertNotNull(retrievedLocation);
        assertEquals("Kilburn", retrievedLocation.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        Region newRegion = (Region) regionDao.getById(2);
        Location newLocation = new Location("NewLocation", newRegion);
        int id = dao.insert(newLocation);
        assertNotEquals(0, id);
        Location insertedLocation = (Location) dao.getById(id);
        newLocation.equals(insertedLocation);
    }

    /**
     * Delete success.
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Update success.
     */
    @Test
    void updateSuccess () {
        String newName = "GateKeep";
        Location locationToUpdate = (Location) dao.getById(6);
        locationToUpdate.setName(newName);
        dao.saveOrUpdate(locationToUpdate);
        Location retrievedLocation = (Location) dao.getById(6);
        assertEquals(locationToUpdate, retrievedLocation);
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Location> locations = dao.getByIdentifierEqual("name", "Kilburn");
        assertEquals(1, locations.size());
        assertEquals(5, locations.get(0).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Location> locations = dao.getByIdentifierLike("name", "ay");
        assertEquals(2, locations.size());
    }

}
