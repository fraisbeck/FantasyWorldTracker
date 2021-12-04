package persistance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OwnersDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;
    GenericDao worldDao;

    /**
     * Creating the dao
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Owner.class);
        worldDao = new GenericDao(World.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * gets all success.
     */
    @Test
    void getAllSuccess () {
        List<Owner> owners = (List<Owner>) dao.getAll();
        assertEquals(8, owners.size());
    }

    /**
     * Gets by id success.
     */
    @Test
    void getByIdSuccess () {
        Owner retrievedOwner = (Owner) dao.getById(8);
        assertNotNull(retrievedOwner);
        assertEquals("Jebebnast", retrievedOwner.getFirstName());
    }

    /**
     * Insert success.
     */
    @Test
    void insertSuccess() {
        World newWorld = (World) worldDao.getById(2);
        Owner newOwner = new Owner("Jeffery", "Ozborne", "Tailor", newWorld);
        int id = dao.insert(newOwner);
        assertNotEquals(0, id);
        Owner insertedOwner = (Owner) dao.getById(id);
        newOwner.equals(insertedOwner);
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
        String newName = "Douglass";
        Owner ownerToUpdate = (Owner) dao.getById(2);
        ownerToUpdate.setLastName(newName);
        dao.saveOrUpdate(ownerToUpdate);
        Owner retrievedOwner = (Owner) dao.getById(2);
        assertEquals(ownerToUpdate, retrievedOwner);
    }

    /**
     * Gets by property equal success.
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<Owner> owners = dao.getByIdentifierEqual("profession", "Smith");
        assertEquals(3, owners.size());
        assertEquals(5, owners.get(1).getId());
    }

    /**
     * Gets by property like success.
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<Owner> owners = dao.getByIdentifierLike("lastName", "Zin");
        assertEquals(2, owners.size());
    }
}
