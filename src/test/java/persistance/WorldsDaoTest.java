package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Worlds dao test.
 */
public class WorldsDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    GenericDao userDao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(World.class);
        userDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    /**
     * gets all success.
     */
    @Test
     void getAllSuccess () {
        List<World> worlds = (List<World>) dao.getAll();
        assertEquals(3, worlds.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        World retrievedWorlds = (World) dao.getById(3);
        assertNotNull(retrievedWorlds);
        assertEquals("Spire", retrievedWorlds.getName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        User newUser = (User) userDao.getById(2);
        World newWorld = new World("Earth", newUser);
        int id = dao.insert(newWorld);
        assertNotEquals(0, id);
        World insertedWorld = (World) dao.getById(id);
        newWorld.equals(insertedWorld);
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
        String newName = "Middle Earth";
        World worldToUpdate = (World) dao.getById(2);
        worldToUpdate.setName(newName);
        dao.saveOrUpdate(worldToUpdate);
        World retrievedWorld = (World) dao.getById(2);
        assertEquals(worldToUpdate, retrievedWorld);
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<World> worlds = dao.getByIdentifierEqual("name", "Ultaria");
        assertEquals(1, worlds.size());
        assertEquals(1, worlds.get(0).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<World> worlds = dao.getByIdentifierLike("name", "ta");
        assertEquals(1, worlds.size());
    }
}
