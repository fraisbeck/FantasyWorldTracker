package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Continents dao test.
 */
public class ContinentsDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    /**
     * The World dao.
     */
    GenericDao worldDao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Continent.class);
        worldDao = new GenericDao(World.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<Continent> continents = (List<Continent>) dao.getAll();
        assertEquals(8, continents.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        Continent retrievedContinent = (Continent) dao.getById(3);
        assertNotNull(retrievedContinent);
        assertEquals("Aeor", retrievedContinent.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        World world = (World) worldDao.getById(2);
        Continent newContinent = new Continent(9,"Utopia", world);
        int id = dao.insert(newContinent);
        assertNotEquals(0, id);
        Continent insertedContinent = (Continent) dao.getById(id);
        newContinent.equals(insertedContinent);
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
        String newName = "SwordCoast";
        Continent continentToUpdate = (Continent) dao.getById(2);
        continentToUpdate.setName(newName);
        dao.saveOrUpdate(continentToUpdate);
        Continent retrievedContinent = (Continent) dao.getById(2);
        assertEquals(continentToUpdate, retrievedContinent);
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Continent> continents = dao.getByIdentifierEqual("name", "Placon");
        assertEquals(1, continents.size());
        assertEquals(5, continents.get(0).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Region> regions = dao.getByIdentifierLike("name", "la");
        assertEquals(2, regions.size());
    }

}
